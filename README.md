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

bash:
Copiar
https://github.com/AdrielRC05/ProyectoFinalAccDatos.git
Dirígete a la carpeta del proyecto:

bash:
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
Copiar:
-- Crear base de datos y tablas
DROP DATABASE IF EXISTS rallys;
CREATE DATABASE rallys;
USE rallys;

-- Definición de las tablas...
Endpoints
Campeonato
GET /campeonatos
Obtiene todos los campeonatos.

GET /campeonatos?nombre=Mun
Obtiene campeonatos que coinciden con el nombre "Mun".

Query Params:

nombre: "Mun"
GET /campeonatos?id=1
Obtiene un campeonato por su ID.

Query Params:

id: 1
POST /campeonatos
Crea un nuevo campeonato.

Body (JSON):

json
Copiar
{
    "nombre": "A",
    "localizacion": "¿?"
}
PUT /campeonatos/11
Actualiza un campeonato por su ID.

Body (JSON):

json
Copiar
{
    "nombre": "Super Campeonato Español de Rally",
    "localizacion": "España"
}
DELETE /campeonatos/3
Elimina un campeonato por su ID.

Clasificación Campeonato
GET /clasificacion_campeonatos
Obtiene todas las clasificaciones de los campeonatos.

GET /clasificacion_campeonatos/1
Obtiene una clasificación de campeonato por su ID.

GET /clasificacion_campeonatos?pilotoId=1&campeonatoID=1
Obtiene la clasificación de un campeonato por el ID del piloto y del campeonato.

Query Params:

pilotoId: 1
campeonatoID: 1
GET /clasificacion_campeonatos?campeonatoID=1
Obtiene la clasificación de un campeonato por el ID del campeonato.

Query Params:

campeonatoID: 1
GET /clasificacion_campeonatos?pilotoId=1
Obtiene la clasificación de un piloto en todos los campeonatos.

Query Params:

pilotoId: 1
POST /clasificacion_campeonatos
Crea una nueva clasificación de campeonato.

PUT /clasificacion_campeonatos/1
Actualiza una clasificación de campeonato por su ID.

DELETE /clasificacion_campeonatos/1
Elimina una clasificación de campeonato por su ID.

Clasificación Rally
GET /clasificacion_rallys
Obtiene todas las clasificaciones de los rallys.

GET /clasificacion_rallys/1
Obtiene la clasificación de un rally por su ID.

GET /clasificacion_rallys?rallyId=1&pilotoId=1
Obtiene la clasificación de un rally por el ID del rally y del piloto.

Query Params:

rallyId: 1
pilotoId: 1
GET /clasificacion_rallys?rallyId=1
Obtiene la clasificación de un rally por el ID del rally.

Query Params:

rallyId: 1
GET /clasificacion_rallys?pilotoId=1
Obtiene la clasificación de un piloto en todos los rallys.

Query Params:

pilotoId: 1
POST /clasificacion_rallys
Crea una nueva clasificación de rally.

PUT /clasificacion_rallys/1
Actualiza una clasificación de rally por su ID.

DELETE /clasificacion_rallys/1
Elimina una clasificación de rally por su ID.

Copiloto
GET /copilotos
Obtiene todos los copilotos.

GET /copilotos?id=1
Obtiene un copiloto por su ID.

Query Params:

id: 1
GET /copilotos?nombre=a
Obtiene copilotos que coinciden con el nombre "a".

Query Params:

nombre: "a"
GET /copilotos?id=1&nombre=a
Obtiene un copiloto por su ID y nombre.

Query Params:

id: 1
nombre: "a"
POST /copilotos
Crea un nuevo copiloto.

PUT /copilotos/1
Actualiza un copiloto por su ID.

DELETE /copilotos/1
Elimina un copiloto por su ID.

Participación
GET /participaciones
Obtiene todas las participaciones.

GET /participaciones/1
Obtiene una participación por su ID.

GET /participaciones?rallyId=1&pilotoId=1&copilotoId=1
Obtiene una participación por los ID de rally, piloto y copiloto.

Query Params:

rallyId: 1
pilotoId: 1
copilotoId: 1
GET /participaciones?rallyId=1&pilotoId=1
Obtiene una participación por el ID de rally y piloto.

Query Params:

rallyId: 1
pilotoId: 1
GET /participaciones?rallyId=1&copilotoId=1
Obtiene una participación por el ID de rally y copiloto.

Query Params:

rallyId: 1
copilotoId: 1
GET /participaciones?copilotoId=1&pilotoId=1
Obtiene una participación por el ID de copiloto y piloto.

Query Params:

copilotoId: 1
pilotoId: 1
GET /participaciones?rallyId=1
Obtiene todas las participaciones de un rally.

Query Params:

rallyId: 1
GET /participaciones?pilotoId=1
Obtiene todas las participaciones de un piloto.

Query Params:

pilotoId: 1
GET /participaciones?copilotoId=1
Obtiene todas las participaciones de un copiloto.

Query Params:

copilotoId: 1
POST /participaciones
Crea una nueva participación.

PUT /participaciones/1
Actualiza una participación por su ID.

DELETE /participaciones/1
Elimina una participación por su ID.

Piloto
GET /pilotos
Obtiene todos los pilotos.

GET /pilotos?id=1
Obtiene un piloto por su ID.

Query Params:

id: 1
GET /pilotos?nombre=a
Obtiene pilotos que coinciden con el nombre "a".

Query Params:

nombre: "a"
GET /pilotos?nombre=a&id=1
Obtiene un piloto por su nombre y ID.

Query Params:

nombre: "a"
id: 1
POST /pilotos
Crea un nuevo piloto.

PUT /pilotos/1
Actualiza un piloto por su ID.

DELETE /pilotos/1
Elimina un piloto por su ID.

GET /pilotos/1/rallys
Obtiene todos los rallys en los que un piloto ha participado.

Rally
GET /rallys
Obtiene todos los rallys.

GET /rallys?nombre=a
Obtiene rallys que coinciden con el nombre "a".

Query Params:

nombre: "a"
GET /rallys?id=1
Obtiene un rally por su ID.

Query Params:

id: 1
GET /rallys/campeonato/1
Obtiene los rallys de un campeonato específico.

POST /rallys
Crea un nuevo rally.

PUT /rallys/1
Actualiza un rally por su ID.

DELETE /rallys/1
Elimina un rally por su ID.

Cómo Importar la Colección en Postman
Descarga el archivo de la colección de Postman desde el repositorio o desde un enlace proporcionado.
Abre Postman y ve a "Importar".
Selecciona el archivo .json de la colección y haz clic en "Importar".
Carpeta documentacion/
En la carpeta documentacion/ encontrarás la documentación técnica en PDF y el modelo EER en formato de imagen que describe las entidades y las relaciones de la base de datos.

Contribuciones
Si deseas contribuir al proyecto, puedes mandarme un email a:
aarrcc2727@gmail.com
