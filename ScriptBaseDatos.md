CREATE TABLE [dbo](dbo.md).[Cliente](Cliente.md)(
> [Persona\_Id](Persona_Id.md) [int](int.md) NOT NULL,
> [Nombres](Nombres.md) [varchar](varchar.md)(60) NOT NULL,
> [apellido\_paterno](apellido_paterno.md) [varchar](varchar.md)(50) NOT NULL,
> [apellido\_materno](apellido_materno.md) [varchar](varchar.md)(50) NOT NULL,
> [email](email.md) [varchar](varchar.md)(60) NOT NULL,
> [telefono](telefono.md) [varchar](varchar.md)(15) NOT NULL,
> [tipo\_persona](tipo_persona.md) [char](char.md)(1) NOT NULL,
> [direccion](direccion.md) [varchar](varchar.md)(200) NOT NULL,
> [imagen](imagen.md) [varchar](varchar.md)(200) NOT NULL,
> [celular](celular.md) [varchar](varchar.md)(15) NOT NULL,
> estado char(1) not null,
> CONSTRAINT [PK\_Persona](PK_Persona.md) PRIMARY KEY CLUSTERED
(
> [Persona\_Id](Persona_Id.md) ASC
)WITH (PAD\_INDEX  = OFF, STATISTICS\_NORECOMPUTE  = OFF, IGNORE\_DUP\_KEY = OFF, ALLOW\_ROW\_LOCKS  = ON, ALLOW\_PAGE\_LOCKS  = ON) ON [PRIMARY](PRIMARY.md)
) ON [PRIMARY](PRIMARY.md)

CREATE TABLE [dbo](dbo.md).[Doctor](Doctor.md)(
> [doctorID](doctorID.md) [int](int.md) IDENTITY(1,1) NOT NULL,
> [nombre](nombre.md) [varchar](varchar.md)(100) NULL,
> [paterno](paterno.md) [varchar](varchar.md)(100) NULL,
> [materno](materno.md) [varchar](varchar.md)(100) NULL,
> [email](email.md) [varchar](varchar.md)(50) NULL,
> [telefono](telefono.md) [varchar](varchar.md)(50) NULL,
> [username](username.md) [nchar](nchar.md)(100) NULL
) ON [PRIMARY](PRIMARY.md)

GO

CREATE TABLE [dbo](dbo.md).[Paciente](Paciente.md)(
> [Paciente\_id](Paciente_id.md) [int](int.md) NOT NULL,
> [Persona\_id](Persona_id.md) [int](int.md) NOT NULL,
> [especie](especie.md) [varchar](varchar.md)(50) NULL,
> [raza](raza.md) [varchar](varchar.md)(100) NULL,
> [genero](genero.md) [char](char.md)(1) NULL,
> [tipo\_sangre](tipo_sangre.md) [varchar](varchar.md)(5) NULL,
> [esterilizado](esterilizado.md) [char](char.md)(2) NULL,
> [tamaño] [varchar](varchar.md)(50) NULL,
> [actividad](actividad.md) [varchar](varchar.md)(50) NULL,
> [peso](peso.md) [decimal](decimal.md)(18, 2) NULL,
> [fecha\_nacimiento](fecha_nacimiento.md) [varchar](varchar.md)(10) NULL,
> [nombre](nombre.md) [varchar](varchar.md)(50) NULL
)


DROP TABLE [dbo](dbo.md).[Cita](Cita.md);

CREATE TABLE [dbo](dbo.md).[Cita](Cita.md)(
> [cita\_id](cita_id.md) [int](int.md) NOT NULL,
> [persona\_id](persona_id.md) [int](int.md) NOT NULL,
> [paciente\_id](paciente_id.md) [int](int.md) NOT NULL,
> [doctor\_id](doctor_id.md) [int](int.md) NOT NULL,
> [tipo\_cita](tipo_cita.md) [char](char.md)(1) NOT NULL,
> [descripcion\_cita](descripcion_cita.md) [varchar](varchar.md)(300)  NULL,
> [nombre\_vacuna](nombre_vacuna.md) [varchar](varchar.md)(100)  NULL,
> [fecha\_cita](fecha_cita.md) [varchar](varchar.md)(10) NOT NULL
> CONSTRAINT [PK\_Cita](PK_Cita.md) PRIMARY KEY CLUSTERED
(
> [cita\_id](cita_id.md) ASC
)WITH (PAD\_INDEX  = OFF, STATISTICS\_NORECOMPUTE  = OFF, IGNORE\_DUP\_KEY = OFF, ALLOW\_ROW\_LOCKS  = ON, ALLOW\_PAGE\_LOCKS  = ON) ON [PRIMARY](PRIMARY.md)
) ON [PRIMARY](PRIMARY.md)