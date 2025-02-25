# API REST para Gestión de Rallys

Esta API REST está desarrollada en **Java** utilizando **Spring Boot** y se conecta con una base de datos **MySQL** para gestionar datos relacionados con rallys. Permite realizar operaciones CRUD sobre los datos de **pilotos**, **copilotos**, **rallys**, **campeonatos** y **clasificaciones**.

## Descripción del Proyecto

El propósito de esta API es gestionar la información de eventos de rally, incluyendo los datos de los pilotos y copilotos, los campeonatos, los rallys en los que participan, y sus clasificaciones en diferentes competiciones. Además, se permite calcular puntos en base a la posición final de los participantes, actualizando las clasificaciones tanto a nivel de campeonato como de rally.

## Tecnologías Utilizadas

- **Java 23**
- **Spring Boot 3.4.3**
- **Spring Data JPA** para el acceso a datos
- **MySQL** como sistema de base de datos
- **Swagger/OpenAPI** para la documentación de los endpoints

## Pasos para Instalar y Ejecutar la API

### Requisitos previos:

- **Java 17+** instalado en tu máquina.
- **Maven** instalado para gestionar las dependencias.
- **MySQL** configurado y corriendo en tu máquina o un servicio de base de datos similar.

### Instalación

### Copie el link e introdúzcalo mediante cmd en la carpeta donde quiera descargar el proyecto:
- **git clone** https://github.com/AdrielRC05/ProyectoFinalAccDatos.git

### Configure la base de datos en el archivo `src/main/resources/application.properties`:

- **spring.datasource.url**: jdbc:mysql://localhost:3306/rallys  
- **spring.datasource.username**: usuario  
- **spring.datasource.password**: contraseña  
- **spring.jpa.hibernate.ddl-auto**: update  

### Ejecute la aplicación con:
- mvn spring-boot:run

### La API estará disponible en http://localhost:8080.

## Modelo de Datos
- La base de datos se estructura con las siguientes tablas:

- **campeonato**: Almacena información sobre los campeonatos.
- **rally**: Detalles de los rallys, con una relación a la tabla campeonato.
- **piloto**: Información de los pilotos, con su nombre, edad, coche, etc.
- **copiloto**: Información de los copilotos, similar a la tabla piloto.
- **participacion**: Relaciona a los pilotos y copilotos con un rally específico, junto con su posición final y tiempo total.
- **clasificacionCampeonato**: Almacena los puntos de los pilotos en los campeonatos.
- **clasificacionRally**: Almacena la clasificación de los pilotos en cada rally.

### Ejecute el script adjunto llamado "scriptBDRally.sql" en MySQL. Para rellenar la base de datos, ejecute el archivo scriptDatosEjemplo.sql en MySQL

## Endpoints:

- **GET /campeonatos?nombre=Mun**: Obtiene campeonatos que coinciden con el nombre "Mun".
- **GET /campeonatos?id=1**: Obtiene un campeonato por su ID.
- **POST /campeonatos**: Crea un nuevo campeonato.
- **PUT /campeonatos/11**: Actualiza un campeonato por su ID.
- **DELETE /campeonatos/3**: Elimina un campeonato por su ID.

### Clasificación Campeonato
- **GET /clasificacion_campeonatos**: Obtiene todas las clasificaciones de los campeonatos.
- **GET /clasificacion_campeonatos/1**: Obtiene una clasificación de campeonato por su ID.
- **GET /clasificacion_campeonatos?pilotoId=1&campeonatoID=1**: Obtiene la clasificación de un campeonato por el ID del piloto y del campeonato.
- **POST /clasificacion_campeonatos**: Crea una nueva clasificación de campeonato.
- **PUT /clasificacion_campeonatos/1**: Actualiza una clasificación de campeonato por su ID.
- **DELETE /clasificacion_campeonatos/1**: Elimina una clasificación de campeonato por su ID.

### Clasificación Rally
- **GET /clasificacion_rallys**: Obtiene todas las clasificaciones de los rallys.
- **GET /clasificacion_rallys/1**: Obtiene la clasificación de un rally por su ID.
- **GET /clasificacion_rallys?rallyId=1&pilotoId=1**: Obtiene la clasificación de un rally por el ID del rally y del piloto.
- **POST /clasificacion_rallys**: Crea una nueva clasificación de rally.
- **PUT /clasificacion_rallys/1**: Actualiza una clasificación de rally por su ID.
- **DELETE /clasificacion_rallys/1**: Elimina una clasificación de rally por su ID.

### Participación
- **GET /participaciones**: Obtiene todas las participaciones.
- **GET /participaciones/1**: Obtiene una participación por su ID.
- **POST /participaciones**: Crea una nueva participación.
- **PUT /participaciones/1**: Actualiza una participación por su ID.
- **DELETE /participaciones/1**: Elimina una participación por su ID.

### Copiloto
- **GET /copilotos**: Obtiene todos los copilotos.
- **GET /copilotos?id=1**: Obtiene un copiloto por su ID.
- **POST /copilotos**: Crea un nuevo copiloto.
- **PUT /copilotos/1**: Actualiza un copiloto por su ID.
- **DELETE /copilotos/1**: Elimina un copiloto por su ID.

### Piloto
- **GET /pilotos**: Obtiene todos los pilotos.
- **GET /pilotos?id=1**: Obtiene un piloto por su ID.
- **POST /pilotos**: Crea un nuevo piloto.
- **PUT /pilotos/1**: Actualiza un piloto por su ID.
- **DELETE /pilotos/1**: Elimina un piloto por su ID.

### Rally
- **GET /rallys**: Obtiene todos los rallys.
- **GET /rallys?nombre=a**: Obtiene rallys que coinciden con el nombre "a".
- **POST /rallys**: Crea un nuevo rally.
- **PUT /rallys/1**: Actualiza un rally por su ID.
- **DELETE /rallys/1**: Elimina un rally por su ID.

## Cómo Importar la Colección en Postman:
- **Descarga el archivo de la colección de Postman** desde el repositorio o desde un enlace proporcionado.
- **Abre Postman** y ve a "Importar".
- **Selecciona el archivo .json de la colección** y haz clic en "Importar".

## Carpeta documentacion/:
- En la carpeta **documentacion/** encontrarás la **documentación técnica en PDF** y el **modelo EER** en formato de imagen que describe las entidades y las relaciones de la base de datos.


## Contribuciones
Si deseas contribuir al proyecto, puedes mandarme un email a:
aarrcc2727@gmail.com
