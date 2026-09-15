
CREATE DATABASE parqueadero_iot;
// experimental
USE parqueadero_iot;

CREATE TABLE plaza (
    id INT PRIMARY KEY,
    codigo VARCHAR(10),
    estado VARCHAR(20)
);

CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50),
    plaza_id INT,
    estado VARCHAR(20),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (plaza_id)
    REFERENCES plaza(id)
);

INSERT INTO plaza VALUES
(1, 'P01', 'LIBRE'),
(2, 'P02', 'LIBRE'),
(3, 'P03', 'LIBRE'),
(4, 'P04', 'LIBRE'),
(5, 'P05', 'LIBRE'),
(6, 'P06', 'LIBRE'),
(7, 'P07', 'LIBRE'),
(8, 'P08', 'LIBRE'),
(9, 'P09', 'LIBRE'),
(10, 'P10', 'LIBRE');