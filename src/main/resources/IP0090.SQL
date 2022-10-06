* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  S3316AM
 * Created: 22-sep-2020
 */

DROP TABLE IP0090;

CREATE TABLE IP0090(
IP0090_ID           BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
DATEFILE            VARCHAR(10),
CODACT              VARCHAR(01),
TABLA               VARCHAR(08),
RANMEN              VARCHAR(19),
BUSEARTYPRICO       DECIMAL(2),
BUSEARTY            VARCHAR(1),
BUSEIDCODE          VARCHAR(6),    
ACBRPRIO            DECIMAL(2),
ACEPBRAND           VARCHAR(3),
RANMAY              VARCHAR(19),
LIFECYCLE           VARCHAR(1),
PRIMARY KEY(IP0090_ID)
);

CREATE INDEX IP0090_IX ON IP0090(RANMEN,ACBRPRIO,ACEPBRAND,BUSEARTYPRICO,BUSEIDCODE);
