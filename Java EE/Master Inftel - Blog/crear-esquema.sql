-- Generado por Oracle SQL Developer Data Modeler 4.0.3.853
--   en:        2014-12-12 19:50:57 CET
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE COMENTARIO
  (
    ID             INTEGER NOT NULL ,
    TEXTO          VARCHAR2 (4000 CHAR) ,
    FECHA_CREACION DATE ,
    POST_ID        INTEGER NOT NULL ,
    USUARIO_ID     INTEGER NOT NULL
  ) ;
ALTER TABLE COMENTARIO ADD CONSTRAINT COMENTARIO_PK PRIMARY KEY ( ID ) ;

CREATE TABLE ETIQUETA
  ( ID INTEGER NOT NULL , NOMBRE VARCHAR2 (255 CHAR)
  ) ;
ALTER TABLE ETIQUETA ADD CONSTRAINT ETIQUETA_PK PRIMARY KEY ( ID ) ;

CREATE TABLE IMAGEN
  (
    ID INTEGER NOT NULL ,
    FOTO BLOB ,
    POST_ID INTEGER NOT NULL
  ) ;
ALTER TABLE IMAGEN ADD CONSTRAINT IMAGEN_PK PRIMARY KEY ( ID ) ;

CREATE TABLE MAPA
  (
    ID INTEGER NOT NULL ,
    LONGITUD FLOAT ,
    LATITUD FLOAT ,
    POST_ID INTEGER NOT NULL
  ) ;
ALTER TABLE MAPA ADD CONSTRAINT MAPA_PK PRIMARY KEY ( ID ) ;

CREATE TABLE POST
  (
    ID     INTEGER NOT NULL ,
    TITULO VARCHAR2 (255 CHAR) ,
    TEXTO CLOB ,
    FECHA_CREACION     DATE ,
    FECHA_MODIFICACION DATE ,
    USUARIO_ID         INTEGER NOT NULL
  ) ;
ALTER TABLE POST ADD CONSTRAINT POST_PK PRIMARY KEY ( ID ) ;

CREATE TABLE POST_ETIQUETA
  (
    POST_ID     INTEGER NOT NULL ,
    ETIQUETA_ID INTEGER NOT NULL
  ) ;

CREATE TABLE USUARIO
  (
    ID       INTEGER NOT NULL ,
    USERNAME VARCHAR2 (40 CHAR) ,
    PASSWORD VARCHAR2 (40 CHAR) ,
    TIPO     INTEGER ,
    EMAIL    VARCHAR2 (255 CHAR) ,
    AVATAR BLOB
  ) ;
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY ( ID ) ;

ALTER TABLE COMENTARIO ADD CONSTRAINT COMENTARIO_POST_FK FOREIGN KEY ( POST_ID ) REFERENCES POST ( ID ) ;

ALTER TABLE COMENTARIO ADD CONSTRAINT COMENTARIO_USUARIO_FK FOREIGN KEY ( USUARIO_ID ) REFERENCES USUARIO ( ID ) ;

ALTER TABLE IMAGEN ADD CONSTRAINT IMAGEN_POST_FK FOREIGN KEY ( POST_ID ) REFERENCES POST ( ID ) ;

ALTER TABLE MAPA ADD CONSTRAINT MAPA_POST_FK FOREIGN KEY ( POST_ID ) REFERENCES POST ( ID ) ;

ALTER TABLE POST_ETIQUETA ADD CONSTRAINT POST_ETIQUETA_ETIQUETA_FK FOREIGN KEY ( ETIQUETA_ID ) REFERENCES ETIQUETA ( ID ) ;

ALTER TABLE POST_ETIQUETA ADD CONSTRAINT POST_ETIQUETA_POST_FK FOREIGN KEY ( POST_ID ) REFERENCES POST ( ID ) ;

ALTER TABLE POST ADD CONSTRAINT POST_USUARIO_FK FOREIGN KEY ( USUARIO_ID ) REFERENCES USUARIO ( ID ) ;

CREATE SEQUENCE COMENTARIO_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER COMENTARIO_ID_TRG BEFORE
  INSERT ON COMENTARIO FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := COMENTARIO_ID_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE ETIQUETA_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER ETIQUETA_ID_TRG BEFORE
  INSERT ON ETIQUETA FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := ETIQUETA_ID_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE IMAGEN_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER IMAGEN_ID_TRG BEFORE
  INSERT ON IMAGEN FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := IMAGEN_ID_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE POST_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER POST_ID_TRG BEFORE
  INSERT ON POST FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := POST_ID_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE USUARIO_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER USUARIO_ID_TRG BEFORE
  INSERT ON USUARIO FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := USUARIO_ID_SEQ.NEXTVAL;
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           5
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          5
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
