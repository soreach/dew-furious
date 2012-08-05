CREATE TABLE [dbo].[Cliente](
	[Persona_Id] [int] NOT NULL,
	[Nombres] [varchar](60) NOT NULL,
	[apellido_paterno] [varchar](50) NOT NULL,
	[apellido_materno] [varchar](50) NOT NULL,
	[email] [varchar](60) NOT NULL,
	[telefono] [varchar](15) NOT NULL,
	[tipo_persona] [char](1) NOT NULL,
	[direccion] [varchar](200) NOT NULL,
	[imagen] [varchar](200) NOT NULL,
	[celular] [varchar](15) NOT NULL,
	estado char(1) not null,
 CONSTRAINT [PK_Persona] PRIMARY KEY CLUSTERED 
(
	[Persona_Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]


CREATE TABLE [dbo].[Doctor](
	[doctorID] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[paterno] [varchar](100) NULL,
	[materno] [varchar](100) NULL,
	[email] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[username] [nchar](100) NULL
) ON [PRIMARY]

GO


CREATE TABLE [dbo].[Paciente](
	[Paciente_id] [int] NOT NULL,
	[Persona_id] [int] NOT NULL,
	[especie] [varchar](50) NULL,
	[raza] [varchar](100) NULL,
	[genero] [char](1) NULL,
	[tipo_sangre] [varchar](5) NULL,
	[esterilizado] [char](2) NULL,
	[tamaño] [varchar](50) NULL,
	[actividad] [varchar](50) NULL,
	[peso] [decimal](18, 2) NULL,
	[fecha_nacimiento] [varchar](10) NULL,
	[nombre] [varchar](50) NULL
)


create TABLE FacturaCab
(
codFactura int not null primary key,
idCliente int not null,
idPaciente int not null,
feRegistro varchar(10),
status char(1)
)

create table FacturaDet(
codFactura int not null references FacturaCab(codFactura),
codProducto int not null,
qtCantidad decimal(18,2) not null,
precio decimal(18,2) not null,
)

create table Producto(
idproducto int,
nombreproducto varchar(200),
precio decimal(18,2)
)

insert into Producto values(1,'Champu',10.50)
insert into Producto values(2,'Locion Antipulgas',40.00)
insert into Producto values(3,'Rico Can',45.00)
insert into Producto values(4,'Correa',8.00)

ALTER TABLE dbo.FacturaCab
ADD RUC VARCHAR(20)

insert into [Paciente]([Paciente_id],Persona_id,nombre) values (3,2,'sultan')