package edu.eci.cvds.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.imageio.ImageIO;

import com.google.inject.Inject;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import edu.eci.cvds.samples.services.ServiciosSolidaridad;

@ManagedBean(name = "ExportBean")
@SessionScoped
public class ExportBean extends BasePageBean{

    @Inject

    protected ServiciosSolidaridad servicios;

    public void preProcessPDFOfertas(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        generateCharPNG(getPieChart("Ofertas"), "Ofertas");
        pdf.add(Image.getInstance("Ofertas.png"));
        pdf.newPage();
    }

    public void preProcessPDFNecesidades(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        generateCharPNG(getPieChart("Necesidades"), "Necesidades");
        pdf.add(Image.getInstance("Necesidades.png"));
        pdf.newPage();
    }

    public void preProcessPDFCategorias(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        generateCharPNG(getPieChart("Categorias"), "Categorias");
        pdf.add(Image.getInstance("Categorias.png"));
        pdf.newPage();
    }

    public void postProcessXLSOfertas(Object document) throws IOException, BadElementException, DocumentException {
        HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
        generateCharPNG(getPieChart("Ofertas"), "Ofertas");
        InputStream inputStream = new FileInputStream("Ofertas.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        Drawing drawing = sheet.createDrawingPatriarch();
        CreationHelper helper = wb.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(10);
        anchor.setRow1(10);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();
    }

    public void postProcessXLSNecesidades(Object document) throws IOException, BadElementException, DocumentException {
        HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
        generateCharPNG(getPieChart("Necesidades"), "Necesidades");
        InputStream inputStream = new FileInputStream("Necesidades.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        Drawing drawing = sheet.createDrawingPatriarch();
        CreationHelper helper = wb.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(10);
        anchor.setRow1(10);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();
    }

    public void postProcessXLSCategorias(Object document) throws IOException, BadElementException, DocumentException {
        HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
        generateCharPNG(getPieChart("Categorias"), "Categorias");
        InputStream inputStream = new FileInputStream("Categorias.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        Drawing drawing = sheet.createDrawingPatriarch();
        CreationHelper helper = wb.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(10);
        anchor.setRow1(10);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();
    }

    public void generateCharPNG(JFreeChart chart, String name){
        try{
            BufferedImage bufferedImage = chart.createBufferedImage(520,700);
            File image = new File(name + ".png");
            ImageIO.write(bufferedImage, "png", image);
        }catch(Exception e){}
    }

    public JFreeChart getPieChart(String name){
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            HashMap<String, Integer> estadisticas = null;
            switch (name.toLowerCase()){
                case "necesidades":
                    estadisticas = servicios.consultarNecesidadesEstado();
                    break;
                case "ofertas":
                    estadisticas = servicios.consultarOfertasEstado();
                    break;
                case "categorias":
                    estadisticas = servicios.consultarCantidadPorCategorias();
                    break;
            }
            for(String key: estadisticas.keySet()){
                dataset.setValue(key, estadisticas.get(key));
            }
        } catch (Exception e) {}
        return ChartFactory.createPieChart("Distribucion de " + name, dataset, true, true, false);
    }
}
