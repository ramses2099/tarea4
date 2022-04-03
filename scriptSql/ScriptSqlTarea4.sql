

/* create Base de datos dbtarea4 */
CREATE DATABASE dbtarea4;


/* create table usuarios */
CREATE TABLE usuarios(
       id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
       nombre_usuario VARCHAR(100),
       contrasena_usuario VARCHAR(100),
       nombre VARCHAR(200),
       apellido VARCHAR(200),
       telefono VARCHAR(100),
       email VARCHAR(500),
       fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)

/* insert usuarios */
INSERT INTO `usuarios`(`nombre_usuario`, `contrasena_usuario`, `nombre`, `apellido`, `telefono`, `email`)
 VALUES ('root','123456','juan','perez','809-591-2369','jaun.perez@gmail.com')
 INSERT INTO `usuarios`(`nombre_usuario`, `contrasena_usuario`, `nombre`, `apellido`, `telefono`, `email`)
 VALUES ('late','123456','juana','perez','809-581-2369','jauna.perez@gmail.com')
 INSERT INTO `usuarios`(`nombre_usuario`, `contrasena_usuario`, `nombre`, `apellido`, `telefono`, `email`)
 VALUES ('jhonyb','123456','jhony','bravo','809-581-2669','jhony.bravo@gmail.com')
 
 /* consulta usuarios */
 SELECT * FROM `usuarios` WHERE 1
 SELECT * FROM `usuarios` WHERE id =3
 
 /* delete usuarios */
  DELETE FROM `usuarios` WHERE id =4