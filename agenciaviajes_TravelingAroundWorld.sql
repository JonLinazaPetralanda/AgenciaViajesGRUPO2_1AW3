create database agenciaviaje_TAW CHARACTER SET utf8 COLLATE utf8_bin;
use agenciaviaje_TravelingAroundWorld;

create table cliente(
    id_cliente int(6) not null,
    nombre varchar(20),
    apellidos varchar(35),
    telefono varchar(15),
    primary key(id_cliente)
);

create table socio(
    id_cliente int(6) not null,
    nombre varchar(20),
    apellidos varchar(35),
    telefono varchar(15),
    descuento varchar(200),
    primary key(id_cliente),
    foreign key (id_cliente) references cliente(id_cliente)
);

create table cliente_estandar(
    id_cliente int(6) not null,
    nombre varchar(20),
    apellidos varchar(35),
    telefono varchar(15),
    promocion varchar(30),
    primary key(id_cliente),
    foreign key (id_cliente) references cliente(id_cliente)
);

create table estancia (
    id_estancia int(5) not null,
    direccion varchar(50),
    ciudad varchar(25),
    pais varchar(20),
    estrella int(1),
    precio int(4),s
    primary key (id_estancia)
);

create table vuelo  (
    id_vuelo int(5) not null,
    hora_salida varchar(5),
    hora_llegada varchar(5),
    ciudad_salida varchar(30),
    ciudad_llegada varchar(30),
    primary key (id_vuelo)
);

create table reserva(
    id_reserva int(4) not null,
    id_estancia int(5) not null,
    id_vuelo int(5) not null,
    precio int(4),
    dia_inicio date/*tipo Fecha*/,
    dia_fin date/*tipo Fecha*/,
    primary key (id_reserva),
    foreign key (id_vuelo) references vuelo(id_vuelo),
    foreign key (id_estancia) references estancia(id_estancia)
);

create table cliente_hace_reserva  (
    id_reserva int(4) not null,
    id_cliente int(6) not null,
    primary key(id_reserva,id_cliente),
    foreign key (id_reserva) references reserva(id_reserva),
    foreign key (id_cliente) references cliente(id_cliente)
);

