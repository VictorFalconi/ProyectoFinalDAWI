create database if not exists mascotas;
use mascotas;

CREATE TABLE cliente (
idcliente INT NOT NULL PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombrecliente VARCHAR(30) NULL,
apellidocliente VARCHAR(30) NULL
);

CREATE TABLE veterinario (
idveterinario INT NOT NULL PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombreveterinario VARCHAR(30) NULL,
apellidoveterinario VARCHAR(30) NULL
);

CREATE TABLE mascota (
idmascota INT NOT NULL PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombremascota VARCHAR(30) NOT NULL,
edad INT NOT NULL,
idcliente INT not null,
FOREIGN KEY (idcliente) REFERENCES cliente(idcliente)
);

CREATE TABLE cita (
idcita int not null primary key auto_increment,
fechahoracita datetime null,
idmascota int not null,
idveterinario int not null,
FOREIGN KEY (idmascota) REFERENCES mascota(idmascota),
FOREIGN KEY (idveterinario) REFERENCES veterinario(idveterinario)
);

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);

CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);

CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol),
	CONSTRAINT user_role_FK FOREIGN KEY (idusuario) REFERENCES bdventas.usuario(idusuario),
	CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES bdventas.rol(idrol)
);