

Create database BDProductos;
Use BDProductos;

Create table tbl_territorio
(
	codigo int AUTO_INCREMENT primary key,
    departamento varchar(50) not null,
    provincia varchar(50) not null,
    distrito varchar(50) not null
);

Create table tbl_proveedor
(
	codigo int AUTO_INCREMENT primary key,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    idterritorio int not null,
    telefono varchar(12),
    email varchar(50),
    
    /*Creando referencia entidad relacion*/
     constraint FK_idterritorio Foreign key (idterritorio) references tbl_territorio (codigo)
);

create table tbl_categoria
(    codigo int AUTO_INCREMENT primary key,
    nombre varchar(50) not null
);

create table tbl_productos
(
codigo int AUTO_INCREMENT primary key,
nombre varchar(50) not null,
idcategoria int not null,
idproveedor int not null,
stock_inicial int not null,
fecha_registro_stock_inicial date not null,
stock_minimo int not null,
codigo_de_barra varchar(15),
fecha_ven date,
precio_unitario numeric(15,3) not null
);

/*Alterando la tabla PRODUCTOS y creando las referencias entidad relacion*/
alter table tbl_productos
add constraint FK_idcategoria foreign key (idcategoria) references tbl_categoria (codigo);
alter table tbl_productos
add constraint FK_idproveedor foreign key (idproveedor) references tbl_proveedor (codigo);



/*Procedimiento almacenados*/
/*Proveedores*/

DELIMITER $
create procedure sp_RegistroProveedor
(var_nombre varchar(50), var_direccion varchar(50), var_idterritorio int, var_telefono varchar(15), var_email varchar(50))
begin

Insert into tbl_proveedor (nombre,direccion,idterritorio,telefono,email)
values (ar_nombre, var_direccion, var_idterritorio, var_telefono, var_email);
end $


DELIMITER $
CREATE PROCEDURE sp_EditarProveedor
(var_codigo int,var_nombre varchar(50), var_direccion varchar(50), var_idterritorio int, var_telefono varchar(15), var_email varchar(50))
BEGIN
UPDATE tbl_proveedor set nombre = var_nombre, direccion = var_direccion,
idterritorio = var_idterritorio, telefono = var_telefono, email = var_email where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_ListarProveedor()
BEGIN
select 
proveedor.codigo, proveedor.nombre, proveedor.direccion, territorio.distrito, proveedor.telefono, proveedor.email
from tbl_proveedor proveedor,tbl_territorio territorio where proveedor.idterritorio = territorio.codigo;
END $


DELIMITER $
CREATE PROCEDURE sp_BuscarTerritorio ( var_codigo int)
BEGIN
SELECT * FROM tbl_territorio where codigo = var_codigo;
END $

call sp_RegistroProveedor('Carlos','Miraflores',1,'9589585','asdasd');

DELIMITER $
CREATE PROCEDURE sp_EliminarProveedor( var_codigo int)
BEGIN
delete from tbl_proveedor where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_BuscarProveedor( var_codigo int)
BEGIN
select * from tbl_proveedor where codigo = var_codigo;
END $

/*Creando los procedimiento para la tabla producto*/
/*Fecha actual y hora*/
Select curdate(); /*Solo fecha*/
Select now(); /*Fecha y hora*/

DELIMITER $
CREATE PROCEDURE sp_RegistroProducto
(var_nombre varchar(50), var_codcategoria int,
var_codproveedor int, var_stock_inicial int, 
var_stock_minimo int, var_codbarra varchar(15), var_fechaven Date, var_precio_unitario numeric (15,3)
 )
BEGIN
insert into tbl_productos 
(nombre,idcategoria,idproveedor,stock_inicial, fecha_registro_stock_inicial,stock_minimo, codigo_de_barra,fecha_ven,precio_unitario)
value(var_nombre,var_codcategoria,var_codproveedor,var_stock_inicial,CURDATE(),
var_stock_minimo,var_codbarra,var_fechaven,var_precio_unitario);
END $

/*Probando procedure registrar*/
call sp_RegistroProducto('',1,16,50,25,'asdasd',curdate(),15.4);

DELIMITER $
CREATE PROCEDURE sp_ListarProductos()
BEGIN
Select producto.codigo, producto.nombre, categoria.nombre as categoria, proveedor.nombre ,
producto.stock_inicial, producto.fecha_registro_stock_inicial, producto.stock_minimo,
producto.codigo_de_barra, producto.fecha_ven, producto.precio_unitario
 from tbl_productos producto, tbl_categoria categoria, tbl_proveedor proveedor where
producto.idcategoria = categoria.codigo and proveedor.codigo = producto.idproveedor ;
END $

DELIMITER $
DROP PROCEDURE IF EXISTS sp_EditarProducto; 
CREATE PROCEDURE sp_EditarProducto
( var_codigo int,var_nombre varchar(50), var_codcategoria int,
var_codproveedor int, var_stock_inicial int, 
var_stock_minimo int, var_codbarra varchar(15), var_fechaven Date, var_precio_unitario numeric (15,3)
 )
BEGIN
update tbl_productos set nombre = var_nombre, idcategoria = var_codcategoria
, idproveedor = var_codproveedor , stock_inicial = var_stock_inicial , stock_minimo = var_stock_minimo ,
 codigo_de_barra =  var_codbarra , fecha_ven = var_fechaven, precio_unitario = var_precio_unitario  where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_EliminarProducto
(var_codigo int)
BEGIN
delete from tbl_productos where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_BuscarProducto
(var_codigo int)
BEGIN
select * from tbl_productos where codigo = var_codigo;
END $


create table tbl_tipo_usuario
(
	codigo int auto_increment primary key,
    tipo varchar(20) not null
);

drop table tbl_usuarios;
create table tbl_usuarios
(
	codigo int auto_increment primary key,
    usuario varchar(20) not null,
    ultima_sesion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*Formato fecha y hora por default*/
    codTipo int not null,
    constraint FK_codTipo foreign key (codTipo) references tbl_tipo_usuario (codigo)
);

/*Alterando la tabla tbl_usaurios y agregando el campo contraseña de tipo blob despues del campo usuario para
almacenar cadenas de caracteres binarias con el metodo AES encriptar */

alter table tbl_usuarios add column contraseña blob not null after usuario;

/*Alterando la tabla, agregando columna correo despues del password*/
alter table tbl_usuarios add column correo varchar(50) not null after contraseña;


DELIMITER $
create procedure sp_RegistrarUsuario
(var_usuario varchar(20), var_contraseña varchar(200), var_correo varchar(50), var_codigo_tipo int)
begin
insert into tbl_usuarios (usuario,contraseña,correo,codTipo)
values(var_usuario,AES_ENCRYPT(var_contraseña,'AES'),var_correo,var_codigo_tipo);
end $


/*Descifrar contraseña tipo bloc encriptado con AES, para esto saber la clave de cifrado*/
select usuario,cast(aes_decrypt(contraseña,'AES') as char) as Contraseña from tbl_usuarios;

DELIMITER $
create procedure sp_ValidarUsuario( var_usuario varchar(20))
begin
	select usuario,cast(aes_decrypt(contraseña,'AES') as char) as Contraseña, codTipo from tbl_usuarios where usuario = var_usuario;
end $


DELIMITER $
CREATE PROCEDURE sp_ListarUsuario()
begin
select usuario.codigo, usuario.usuario, usuario.correo, usuario.ultima_sesion ,tipo.tipo from tbl_usuarios usuario, tbl_tipo_usuario tipo where usuario.codTipo = tipo.codigo;
END $


DELIMITER $
create procedure sp_EditarUsuario( var_codigo int ,var_usuario varchar(20), 
var_password varchar(200), var_correo varchar(50), var_tipo int)
begin
update tbl_usuarios set usuario =  var_usuario, contraseña = AES_ENCRYPT(var_password,'AES'),
correo = var_correo, codTipo = var_tipo where codigo = var_codigo ;
end $

DELIMITER $
create procedure sp_EliminarUsuario
(var_codigo int)
begin
delete from tbl_usuarios where codigo = var_codigo;
end $

DELIMITER $
create procedure sp_BuscarUsuario
(var_codigo int)
BEGIN
select codigo, usuario,cast(aes_decrypt(contraseña,'AES') as char) as contraseña, correo, codtipo from tbl_usuarios where codigo = var_codigo;
END $






