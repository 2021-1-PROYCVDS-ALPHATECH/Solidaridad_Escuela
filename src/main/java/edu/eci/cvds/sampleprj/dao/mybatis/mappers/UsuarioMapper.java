package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioMapper {
    public List<Usuario> consultarClientes();
}
