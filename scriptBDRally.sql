DROP DATABASE IF EXISTS rallys;
CREATE DATABASE rallys;
USE rallys;

-- Tabla campeonato
CREATE TABLE campeonato (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    localizacion VARCHAR(255) NOT NULL
);

-- Tabla rally
CREATE TABLE rally (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    localizacion VARCHAR(255) NOT NULL,
    fecha_celebracion DATE NOT NULL,
    listado_participantes VARCHAR(255),
    campeonato_id BIGINT,
    FOREIGN KEY (campeonato_id) REFERENCES campeonato(id)
);

-- Tabla piloto
CREATE TABLE piloto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    nacionalidad VARCHAR(255) NOT NULL,
    coche VARCHAR(255) NOT NULL,
    titulos INT NOT NULL
);

CREATE TABLE copiloto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    nacionalidad VARCHAR(255) NOT NULL,
    coche VARCHAR(255) NOT NULL,
    titulos INT NOT NULL
);

CREATE TABLE participacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rally_id BIGINT,
    piloto_id BIGINT,
    copiloto_id BIGINT,
    posicion_final INT CHECK (posicion_final > 0),
    tiempo_total TIME CHECK (tiempo_total > '00:00:00'),
    FOREIGN KEY (rally_id) REFERENCES rally(id),
    FOREIGN KEY (piloto_id) REFERENCES piloto(id),
    FOREIGN KEY (copiloto_id) REFERENCES copiloto(id)
);

CREATE TABLE clasificacionCampeonato (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    campeonato_id BIGINT,
    piloto_id BIGINT,
    puntos INT DEFAULT 0,
    FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
    FOREIGN KEY (piloto_id) REFERENCES piloto(id)
);

-- Tabla clasificacionRally
CREATE TABLE clasificacionRally (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rally_id BIGINT,
    piloto_id BIGINT,
    posicion_final INT,
    FOREIGN KEY (rally_id) REFERENCES rally(id),
    FOREIGN KEY (piloto_id) REFERENCES piloto(id)
);

-- Función para calcular puntos
DELIMITER $$

CREATE PROCEDURE calcular_puntos (IN posicion INT, OUT puntos INT)
BEGIN
    CASE posicion
        WHEN 1 THEN SET puntos = 25;
        WHEN 2 THEN SET puntos = 18;
        WHEN 3 THEN SET puntos = 15;
        WHEN 4 THEN SET puntos = 12;
        WHEN 5 THEN SET puntos = 10;
        WHEN 6 THEN SET puntos = 8;
        WHEN 7 THEN SET puntos = 6;
        WHEN 8 THEN SET puntos = 4;
        WHEN 9 THEN SET puntos = 2;
        WHEN 10 THEN SET puntos = 1;
        ELSE SET puntos = 0;
    END CASE;
END $$

DELIMITER ;

-- Procedimiento para actualizar clasificación
DELIMITER $$

CREATE PROCEDURE actualizar_clasificacion()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE r_piloto_id BIGINT;
    DECLARE r_rally_id BIGINT;
    DECLARE r_posicion_final INT;
    DECLARE r_copiloto_id BIGINT;
    DECLARE cur CURSOR FOR
        SELECT piloto_id, copiloto_id, rally_id, posicion_final FROM participacion;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO r_piloto_id, r_copiloto_id, r_rally_id, r_posicion_final;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SET @puntos = 0;
        CALL calcular_puntos(r_posicion_final, @puntos);

        UPDATE clasificacion
        SET puntos = puntos + @puntos
        WHERE piloto_id = r_piloto_id;

        UPDATE clasificacion
        SET puntos = puntos + @puntos
        WHERE piloto_id = r_copiloto_id;

    END LOOP;

    CLOSE cur;
END $$

DELIMITER ;
