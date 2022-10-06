/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  S3316AM
 * Created: 22-sep-2020
 */

DROP TABLE IP0040;

CREATE TABLE IP0040(
-- DERBY IP0040_ID           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IP0040_ID           INTEGER NOT NULL AUTO_INCREMENT,
DATEFILE            VARCHAR(10),
CODACT              VARCHAR(01),
TABLA               VARCHAR(08),
RANMEN              VARCHAR(19),
IDPROD              VARCHAR(03),
RANMAY              VARCHAR(19),
ACEPBRAND           VARCHAR(03),
ACBRPRIO            DECIMAL(02),
MBRID               DECIMAL(11),
TIPOPROD            DECIMAL(01),
ENDPOINT            DECIMAL(07),
INDFORMAT           VARCHAR(01),
PAISALFA            VARCHAR(03),
PAISNUM             DECIMAL(03),
REGION              VARCHAR(01),
MONEDA              DECIMAL(03),
EXPONENTE           DECIMAL(01),
OCCURS_MONEDAS      VARCHAR(28),
FILLER              VARCHAR(01),
ROUTING             VARCHAR(01),
REASSW              VARCHAR(01),
PAYPASS             VARCHAR(01),
CLASEPROD           VARCHAR(03),
PRIMARY KEY(IP0040_ID)
);

CREATE INDEX IP0040_IX ON IP0040(RANMEN,IDPROD,RANMAY);

SELECT * FROM APP.IP0040 WHERE RANMEN LIKE '535120%';

SELECT * FROM APP.IP0040 WHERE RANMEN LIKE '516097%';