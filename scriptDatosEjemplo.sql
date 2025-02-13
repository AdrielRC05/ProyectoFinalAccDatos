-- Insertar 10 datos de ejemplo en la tabla campeonato
INSERT INTO campeonato (nombre, localizacion) VALUES
('Campeonato Mundial', 'Monte Carlo'),
('Campeonato Europeo', 'España'),
('Campeonato de Rallys Nacionales', 'México'),
('Campeonato de Asia', 'Japón'),
('Campeonato de América', 'Argentina'),
('Campeonato de Rallys Internacionales', 'Francia'),
('Campeonato de Rally de América del Norte', 'EE.UU.'),
('Campeonato Mundial de Rallys Eléctricos', 'Alemania'),
('Campeonato de Rally de Invierno', 'Noruega'),
('Campeonato de Rally del Desierto', 'Dubai');

-- Insertar 10 datos de ejemplo en la tabla rally
INSERT INTO rally (nombre, localizacion, fecha_celebracion, campeonato_id) VALUES
('Rally de Monte Carlo', 'Monte Carlo', '2025-01-10', 1),
('Rally de Cataluña', 'España', '2025-04-23', 2),
('Rally de Guanajuato', 'México', '2025-03-15', 3),
('Rally de Japón', 'Tokio', '2025-07-18', 4),
('Rally de Argentina', 'Córdoba', '2025-05-06', 5),
('Rally de Francia', 'Córcega', '2025-10-10', 6),
('Rally de Estados Unidos', 'Colorado', '2025-06-25', 7),
('Rally Eléctrico de Alemania', 'Berlín', '2025-08-15', 8),
('Rally de Invierno en Noruega', 'Oslo', '2025-02-20', 9),
('Rally del Desierto en Dubai', 'Dubái', '2025-11-05', 10);

-- Insertar 10 datos de ejemplo en la tabla piloto
INSERT INTO piloto (nombre, edad, nacionalidad, coche, titulos) VALUES
('Sebastian Loeb', 45, 'Francia', 'Citroen C3 WRC', 9),
('Kimi Räikkönen', 43, 'Finlandia', 'Audi RS Q5', 1),
('Carlos Sainz Jr.', 31, 'España', 'Ford Fiesta WRC', 2),
('Thierry Neuville', 35, 'Bélgica', 'Hyundai i20 WRC', 0),
('Ott Tänak', 36, 'Estonia', 'Toyota Yaris WRC', 1),
('Elfyn Evans', 35, 'Reino Unido', 'Toyota Yaris WRC', 0),
('Jari-Matti Latvala', 39, 'Finlandia', 'Toyota Yaris WRC', 0),
('Dani Sordo', 41, 'España', 'Hyundai i20 WRC', 0),
('Craig Breen', 34, 'Irlanda', 'Ford Fiesta WRC', 0),
('Gus Greensmith', 27, 'Reino Unido', 'Ford Fiesta WRC', 0);

-- Insertar 10 datos de ejemplo en la tabla copiloto
INSERT INTO copiloto (nombre, edad, nacionalidad, coche, titulos) VALUES
('Daniel Elena', 47, 'Francia', 'Citroen C3 WRC', 9),
('Mika Häkkinen', 55, 'Finlandia', 'Audi RS Q5', 1),
('Luis Moya', 56, 'España', 'Ford Fiesta WRC', 2),
('Nicolas Gilsoul', 38, 'Bélgica', 'Hyundai i20 WRC', 0),
('Martin Järveoja', 38, 'Estonia', 'Toyota Yaris WRC', 1),
('Scott Martin', 37, 'Reino Unido', 'Toyota Yaris WRC', 0),
('Miikka Anttila', 39, 'Finlandia', 'Toyota Yaris WRC', 0),
('Marc Martí', 49, 'España', 'Hyundai i20 WRC', 0),
('John Kennard', 48, 'Nueva Zelanda', 'Ford Fiesta WRC', 0),
('Rory McGuire', 30, 'Reino Unido', 'Ford Fiesta WRC', 0);

-- Insertar 10 datos de ejemplo en la tabla participacion
INSERT INTO participacion (rally_id, piloto_id, copiloto_id, posicion_final, tiempo_total) VALUES
(1, 1, 1, 1, '02:30:00'),
(2, 2, 2, 2, '03:00:00'),
(3, 3, 3, 3, '03:15:00'),
(4, 4, 4, 4, '03:45:00'),
(5, 5, 5, 5, '04:00:00'),
(6, 6, 6, 6, '04:30:00'),
(7, 7, 7, 7, '05:00:00'),
(8, 8, 8, 8, '05:30:00'),
(9, 9, 9, 9, '06:00:00'),
(10, 10, 10, 10, '06:30:00');

-- Insertar 10 datos de ejemplo en la tabla clasificacionCampeonato
INSERT INTO clasificacionCampeonato (campeonato_id, piloto_id, puntos) VALUES
(1, 1, 100),
(1, 2, 85),
(2, 3, 90),
(2, 4, 75),
(3, 5, 95),
(3, 6, 80),
(4, 7, 85),
(4, 8, 70),
(5, 9, 100),
(5, 10, 90);

-- Insertar 10 datos de ejemplo en la tabla clasificacionRally
INSERT INTO clasificacionRally (rally_id, piloto_id, posicion_final) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 3, 1),
(2, 4, 2),
(3, 5, 1),
(3, 6, 2),
(4, 7, 1),
(4, 8, 2),
(5, 9, 1),
(5, 10, 2);
