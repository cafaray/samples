-- MySQL Script generated by CAFARAY@GMAIL.COM
-- Apr 12 20:06:58 2014
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wfengine
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS wfengine ;
CREATE SCHEMA IF NOT EXISTS wfengine DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE wfengine ;

-- -----------------------------------------------------
-- Table wfengine.FlujoTrabajo
-- 'Identifica un elemento del tipo Workflow que es el contenedor de los procesos.'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm00t (
  identificador VARCHAR(32) NOT NULL,
  version INT NOT NULL,
  nombre VARCHAR(250) NOT NULL,
  publicado CHAR(1) NOT NULL,
  archivo VARCHAR(120) NULL,
  fechaInicio DATETIME NOT NULL,
  fechaTermino DATETIME NOT NULL,
  estatus VARCHAR(2) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador, version)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table wfengine.Proceso
-- 'Elemento que concentra las transiciones entre actividades.'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm10t (
  identificador VARCHAR(32) NOT NULL,
  nombre VARCHAR(120) NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  idsesion VARCHAR(45) NOT NULL,
  tmstmp DATETIME NOT NULL,
  PRIMARY KEY (identificador)
)ENGINE = InnoDB;

CREATE UNIQUE INDEX NOMBRE_UNIQUE ON wfengine.kwfm10t (nombre ASC);


-- -----------------------------------------------------
-- Table wfengine.FlujoProcesos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm01t (
  identificador VARCHAR(32) NOT NULL,
  idflujo VARCHAR(32) NOT NULL,
  version INT NOT NULL,
  idproceso VARCHAR(32) NOT NULL,
  posicion INT NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT FLUJOTRABAJO
    FOREIGN KEY (idflujo, version)
    REFERENCES wfengine.kwfm00t (identificador, version)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT PROCESO
    FOREIGN KEY (idproceso)
    REFERENCES wfengine.kwfm10t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE UNIQUE INDEX FLUJO_PROCESOS ON wfengine.kwfm01t(idflujo,version,idproceso);


-- -----------------------------------------------------
-- Table wfengine.Actividad
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm30t (
  identificador VARCHAR(32) NOT NULL,
  nombre VARCHAR(120) NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  tipoAccion VARCHAR(2) NOT NULL,
  tiempostd INT NULL,
  tiempolmt INT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table wfengine.Transicion
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm20t (
  identificador VARCHAR(32) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  tipodestino VARCHAR(2) NULL,
  tmstmp DATETIME NULL,
  idsesion VARCHAR(32) NULL,
  PRIMARY KEY (identificador) 
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table wfengine.TransicionActividad
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm23t (
  identificador VARCHAR(32) NOT NULL,
  idtransicion VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY(identificador),
  CONSTRAINT TRANSICION
    FOREIGN KEY (idtransicion)
    REFERENCES wfengine.kwfm20t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT ACTIVIDAD
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION  
)ENGINE=InnoDB;

CREATE UNIQUE INDEX TRANSICION_INICIO ON wfengine.kwfm23t(idtransicion,idactividad); 

-- -----------------------------------------------------
-- Table wfengine.TransicionDestino
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm24t (
  identificador VARCHAR(32) NOT NULL,
  idtransicion VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT TRANSICIONACTIVIDAD
    FOREIGN KEY (idtransicion)
    REFERENCES wfengine.kwfm20t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT ACTIVIDADDESTINO
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION    
) ENGINE = InnoDB;

CREATE INDEX ACTIVIDAD_idx ON wfengine.kwfm23t (idactividad ASC);

CREATE INDEX TRANSICION_idx ON wfengine.kwfm23t (idtransicion ASC);


-- -----------------------------------------------------
-- Table wfengine.ProcesoTransiciones
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm12t (
  identificador VARCHAR(32) NOT NULL,
  idproceso VARCHAR(32) NOT NULL,
  idtransicion VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT TRANSICIONES
    FOREIGN KEY (idtransicion)
    REFERENCES wfengine.kwfm20t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT EL_PROCESO
    FOREIGN KEY (idproceso)
    REFERENCES wfengine.kwfm10t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE UNIQUE INDEX PROCESO_TRANSICION ON wfengine.kwfm12t (idtransicion);


-- -----------------------------------------------------
-- Table wfengine.Parametro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm60t (
  identificador VARCHAR(32) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  tipoDato VARCHAR(3) NOT NULL,
  tmstmp DATETIME NULL,
  idsesion VARCHAR(32) NULL,
  PRIMARY KEY (identificador))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table wfengine.ActividadParametros
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm63t (
  identificador VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  idparametro VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT LA_ACTIVIDAD
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT EL_PARAMETRO
    FOREIGN KEY (idparametro)
    REFERENCES wfengine.kwfm60t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table wfengine.TransicionDestionoParametro
-- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS wfengine.kwfm62t (
--   identificador VARCHAR(32) NOT NULL,
--   idtransicion VARCHAR(32) NOT NULL,
--   idparametro VARCHAR(32) NOT NULL,
--   tmstmp DATETIME NULL,
--   idsesion VARCHAR(32) NULL,
--   PRIMARY KEY (identificador),
--   CONSTRAINT TRANSICION_PARAM
--     FOREIGN KEY (idtransdest)
--     REFERENCES wfengine.kwfm24t (identificador)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION,
--   CONSTRAINT PARAM_TRANSICION
--     FOREIGN KEY (idparametro)
--     REFERENCES wfengine.kwfm60t (identificador)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION
-- )ENGINE = InnoDB;

-- CREATE INDEX PARAMETRO_idx ON wfengine.kwfm62t (idparametro ASC);


-- -----------------------------------------------------
-- Table wfengine.Rol
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm90t (
  identificador VARCHAR(32) NOT NULL,
  idborol VARCHAR(32) NOT NULL,
  prefijo VARCHAR(5) NOT NULL,
  descripcion VARCHAR(120) NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table wfengine.ActividadRoles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm93t (
  identificador VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  idrol VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT ROL_ACTIVIDAD
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT LOS_ROLES
    FOREIGN KEY (idrol)
    REFERENCES wfengine.kwfm90t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table wfengine.Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm80t (
  identificador VARCHAR(32) NOT NULL,
  idbousuario VARCHAR(32) NOT NULL,
  bocuenta VARCHAR(16) NOT NULL,
  bonombre VARCHAR(120) NOT NULL,
  boiniciales VARCHAR(9) NOT NULL,
  idrol VARCHAR(32) NOT NULL,
  ultimaActualizacion DATETIME NULL,
  esActivo CHAR(1) NOT NULL DEFAULT 'S',
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT USUARIO_ROL
    FOREIGN KEY (idrol)
    REFERENCES wfengine.kwfm90t(identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE UNIQUE INDEX idusuario_UNIQUE ON wfengine.kwfm80t (idbousuario ASC);
CREATE UNIQUE INDEX idusuario_cuenta_UNIQUE ON wfengine.kwfm80t (bocuenta ASC);
CREATE UNIQUE INDEX idusuario_iniciales_UNIQUE ON wfengine.kwfm80t (boiniciales ASC);

-- -----------------------------------------------------
-- Table wfengine.ActividadUsusarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm83t (
  identificador VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  idusuario VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT ACTIVIDAD_USUARIO
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT USUARIOS
    FOREIGN KEY (idusuario)
    REFERENCES wfengine.kwfm80t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE INDEX USUARIO_idx ON wfengine.kwfm83t (idusuario ASC);

-- -----------------------------------------------------
-- Table wfengine.Tramite
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm70t (
  identificador VARCHAR(32) NOT NULL,
  idflujo VARCHAR(32) NOT NULL,
  version INT NOT NULL,
  idbotramite VARCHAR(32) NOT NULL,
  estatus VARCHAR(2) NOT NULL,
  idusuario VARCHAR(32) NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT FLUJOSTRABAJO
    FOREIGN KEY (idflujo,version)
    REFERENCES wfengine.kwfm00t (identificador,version)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE INDEX FLUJOTRABAJO_idx ON wfengine.kwfm70t (idflujo ASC);


-- -----------------------------------------------------
-- Table wfengine.Tarea
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm73t (
  identificador VARCHAR(32) NOT NULL,
  idtramite VARCHAR(32) NOT NULL,
  idactividad VARCHAR(32) NOT NULL,
  estatus VARCHAR(2) NOT NULL,
  idusuario VARCHAR(32) NOT  NULL,
  idsesion VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT TRAMITES
    FOREIGN KEY (idtramite)
    REFERENCES wfengine.kwfm70t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT TAREAS
    FOREIGN KEY (idactividad)
    REFERENCES wfengine.kwfm30t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE INDEX TRAMITE_idx ON wfengine.kwfm73t (idtramite ASC);
CREATE INDEX ACTIVIDAD_idx ON wfengine.kwfm73t (idactividad ASC);

-- -----------------------------------------------------
-- Table wfengine.TareaParamteros
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm76t (
  identificador VARCHAR(32) NOT NULL,
  idtarea VARCHAR(32) NOT NULL,
  idparametro VARCHAR(32) NOT NULL,
  valparametro VARCHAR(255) NOT NULL,
  idsesion VARCHAR(32) NOT NULL,
  tmstmp DATETIME NOT NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT TAREA
    FOREIGN KEY (idtarea)
    REFERENCES wfengine.kwfm73t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT PARAMETRO_TAREA
    FOREIGN KEY (idparametro)
    REFERENCES wfengine.kwfm60t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE INDEX PARAMETRO_idx ON wfengine.kwfm76t (idparametro ASC);


-- -----------------------------------------------------
-- Table wfengine.Comentario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS wfengine.kwfm50t (
  identificador VARCHAR(32) NOT NULL,
  idtarea VARCHAR(32) NULL,
  idusuario VARCHAR(32) NULL,
  fecha DATETIME NULL,
  comentario VARCHAR(500) NULL,
  idsesion VARCHAR(32) NULL,
  tmstmp DATETIME NULL,
  PRIMARY KEY (identificador),
  CONSTRAINT LA_TAREA
    FOREIGN KEY (idtarea)
    REFERENCES wfengine.kwfm73t (identificador)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX TAREA_idx ON wfengine.kwfm50t (idtarea ASC);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
