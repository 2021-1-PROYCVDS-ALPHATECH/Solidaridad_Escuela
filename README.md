# PLATAFORMA SOLIDARIDAD ESCUELA
# ESCUELA COLOMBIANA DE INGENIERIA JULIO GARAVITO
# CICLOS DE VIDA DEL DESARROLLO DE SOFTWARE - CVDS
# 2021 - 1
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/d40482e9dfe747598c7bd25a705ff265)](https://www.codacy.com/gh/2021-1-PROYCVDS-ALPHATECH/Solidaridad_Escuela/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2021-1-PROYCVDS-ALPHATECH/Solidaridad_Escuela&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/2021-1-PROYCVDS-ALPHATECH/Solidaridad_Escuela.svg?style=svg)](https://circleci.com/gh/2021-1-PROYCVDS-ALPHATECH/Solidaridad_Escuela)
## INTEGRANTES Y ROLES EN EL EQUIPO
 * ***Luis Gerardo Amaya:*** *Programador y Tester*
 * ***Angie Tatiana Medina:*** *Scrum Master*
 * ***Juan Sebastian Mina:*** *Programador y Diseñador*
 * ***Jose Ricardo Perez:*** *Programador y Diseñador*
 
## PROFESOR
 * ***Oscar David Ospina:*** *Product Owner*

## Descripción del producto
### Descripción general
*La Plataforma Solidaridad Escuela, es  una  herramienta  para  generar  un entorno de  comunicación  y ayuda dentro de la comunidad de la Escuela Colombiana de Ingeniería Julio Garavito. El sistema permite que  los  estudiantes  puedan  expresar  las  necesidades  que  puedan  tener  de  algún  elemento  para  poder desarrollar sus actividades de forma correcta, y que los demás miembros de la comunidad puedan facilitar estos elementos a quienes lo necesitan. De igual manera los miembros de la comunidad pueden ofrecer diferentes elementos que sean de interés para los estudiantes sin que exista alguna solicitud específica. Adicionalmente  el  sistema  cuenta  con  diferentes  funcionalidades  de  reportería  y  administración  que permite llevar un control del funcionamiento de la plataforma y del alcance que se está logrando.*
### Manual de usuario
## Arquitectura y Diseño detallado
### Modelo E-R  
![ModeloER](./img/ModeloER.PNG)
### Diagrama de clases
### Arquitectura y Stack de tecnologías utilizado
Se contruyo la aplicación con 3 capas:
* ***Capa de Aplicación:*** En esta capa fue utilizado el lenguaje *Java*, el framework de inyección de dependencias *Google Guice* y el framework para la autenticación  *Apache Shiro*.
* ***Capa de Presentación:*** En esta capa se utilizó un framework que simplifica el desarrollo de interfaces de usuario en aplicaciones Java JavaServer Faces (JSF) y asi mismo su biblioteca de componentes *PrimeFaces*.
* ***Capa de Persistencia:*** Para lograr una persistencia sobre los datos se uso el motor de base de datos *PostgreSQL* y la herramienta para persistencia Java para mapear sentencias SQL *myBatis*.
### Enlace a la aplicación en Heroku
### Enlace al sistema de integración continua. 
## Descripción del proceso
### Descripción de la Metodologia
Durante el desarrollo del proyecto se aplico la metodolo *Scrum* en la cual se realizan entregas parciales y regulares del producto final con reunionen diarias donde se realizar preguntas como ¿Qué se realizó el día anterior? ¿Qué impedimentos se han tenido? y ¿Qué se hará en el día?
### Enlace Taiga
![Backlock](./img/Backlock.PNG)
https://tree.taiga.io/project/j-382-solidaridad-escuela/backlog
### Sprints
Para el proyecto se manejaron 3 Sprints de aproximadamente 2 semanas cada uno
* **Sprint 1**  
    *El principal problema que se tuvo fue con el tema de la autenticación, los ejemplos para la configuración de shiro no eran muy claros y se presentaron varios inconvenientes con los servicios default para la comparación de contraseñas.*
    * ***Sprint-backlog***  
    ![Sprint1Backlog](./img/Sprint1Backlog.PNG)
    * ***Sprint-burndown chart***  
    ![Sprint1](./img/Sprint1.PNG)
* **Sprint 2**  
    *A pesar de que primefaces cuenta con un dataexporter para la información de las tablas, esta se quedaba corta para la funcionalidad requerida, por lo que se tuvieron que programar métodos auxiliares que permitieran adjuntar las gráficas generadas al archivo pdf y excel.*
    *Adicional, para el manejo de las respuestas como se plantea en la especificación del proyecto se consideró necesario hacer un remodelamiento en la base de datos.*
    * ***Sprint-backlog***  
    ![Sprint2Backlog](./img/Sprint2Backlog.PNG)
    * ***Sprint-burndown chart***  
    ![Sprint2](./img/Sprint2.PNG)
* **Sprint 3**  
    *Al principio de sprint no se tenia muy claro segun lo que se podia intuir de la especificación el como realizar la implmentación de la historia de usuario para el manejo de las categorias invalidas.*
    *Además se tuvo que cambiar la forma en la que se tenía implemantada la gestión del número de solicitudes*
    * ***Sprint-backlog***  
    ![Sprint3Backlog](./img/Sprint3Backlog.PNG)  
    * ***Sprint-burndown chart***  
    ![Sprint3](./img/Sprint3.PNG)
### Reporte de pruebas
![Pruebas](./img/Pruebas.PNG)

