API REST para Gestión de Rallys
Esta API REST está desarrollada en Java utilizando Spring Boot y conecta con una base de datos MySQL para gestionar datos relacionados con rallys. Permite realizar operaciones CRUD sobre los datos de pilotos, copilotos, rallys, campeonatos y clasificaciones.

Descripción del Proyecto
El propósito de esta API es gestionar la información de eventos de rally, incluyendo los datos de los pilotos y copilotos, los campeonatos, los rallys en los que participan, y sus clasificaciones en diferentes competiciones. Además, se permite calcular puntos en base a la posición final de los participantes, actualizando las clasificaciones tanto a nivel de campeonato como de rally.

Tecnologías Utilizadas:
Java 23
Spring Boot 3.4.3
Spring Data JPA para el acceso a datos
MySQL como sistema de base de datos
Swagger/OpenAPI para la documentación de los endpoints
Pasos para Instalar y Ejecutar la API

Requisitos previos:
Java 17+ instalado en tu máquina.
Maven instalado para gestionar las dependencias.
MySQL configurado y corriendo en tu máquina o un servicio de base de datos similar.
Instalación
Clona este repositorio en tu máquina local:

bash
Copiar
git clone https://github.com/tuusuario/rally-api.git
Dirígete a la carpeta del proyecto:

bash
Copiar
cd rally-api
Instala las dependencias con Maven:

bash
Copiar
mvn clean install
Configura tu base de datos en el archivo src/main/resources/application.properties:

properties
Copiar
spring.datasource.url=jdbc:mysql://localhost:3306/rallys
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.hibernate.ddl-auto=update
Ejecuta la aplicación:

bash
Copiar
mvn spring-boot:run
La API estará disponible en http://localhost:8080.

Modelo de Datos
La base de datos se estructura con las siguientes tablas:

campeonato: Almacena información sobre los campeonatos.
rally: Detalles de los rallys, con una relación a la tabla campeonato.
piloto: Información de los pilotos, con su nombre, edad, coche, etc.
copiloto: Información de los copilotos, similar a la tabla piloto.
participacion: Relaciona a los pilotos y copilotos con un rally específico, junto con su posición final y tiempo total.
clasificacionCampeonato: Almacena los puntos de los pilotos en los campeonatos.
clasificacionRally: Almacena la clasificación de los pilotos en cada rally.
El script de creación de la base de datos y las tablas es el siguiente:

sql
Copiar
-- Crear base de datos y tablas
DROP DATABASE IF EXISTS rallys;
CREATE DATABASE rallys;
USE rallys;

-- Definición de las tablas...
Endpoints
La API expone los siguientes endpoints para interactuar con los datos:

Pilotos
GET /pilotos: Obtiene todos los pilotos.
POST /pilotos: Crea un nuevo piloto.
GET /pilotos/{id}: Obtiene detalles de un piloto por su ID.
PUT /pilotos/{id}: Actualiza la información de un piloto.
DELETE /pilotos/{id}: Elimina un piloto.
Copilotos
GET /copilotos: Obtiene todos los copilotos.
POST /copilotos: Crea un nuevo copiloto.
GET /copilotos/{id}: Obtiene detalles de un copiloto por su ID.
PUT /copilotos/{id}: Actualiza la información de un copiloto.
DELETE /copilotos/{id}: Elimina un copiloto.
Rallys
GET /rallys: Obtiene todos los rallys.
POST /rallys: Crea un nuevo rally.
GET /rallys/{id}: Obtiene detalles de un rally por su ID.
PUT /rallys/{id}: Actualiza la información de un rally.
DELETE /rallys/{id}: Elimina un rally.
Participaciones
GET /participaciones: Obtiene todas las participaciones.
POST /participaciones: Crea una nueva participación (vincula un piloto y copiloto a un rally).
GET /participaciones/{id}: Obtiene detalles de una participación.
PUT /participaciones/{id}: Actualiza la participación (incluye la posición y tiempo).
DELETE /participaciones/{id}: Elimina una participación.
Clasificación
GET /clasificacion/campeonato/{campeonatoId}: Obtiene la clasificación de un campeonato.
GET /clasificacion/rally/{rallyId}: Obtiene la clasificación de un rally.
Cómo Importar la Colección en Postman
Descarga el archivo de la colección de Postman desde el repositorio o desde un enlace proporcionado.
Abre Postman y ve a "Importar".
Selecciona el archivo .json de la colección y haz clic en "Importar".
Carpeta documentacion/
En la carpeta documentacion/ encontrarás la documentación técnica en PDF y el modelo EER en formato de imagen que describe las entidades y las relaciones de la base de datos.

Contribuciones
Si deseas contribuir al proyecto, puedes mandarme un email a:
aarrcc2727@gmail.com
