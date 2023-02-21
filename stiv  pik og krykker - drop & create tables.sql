DROP TABLE IF EXISTS kunde , ordrelinje, ordre, vare;
CREATE TABLE kunde (KundeID VARCHAR(45) not NULL PRIMARY KEY, Navn VARCHAR(45), Adr VARCHAR(45), Landekode VARCHAR(45), Salgsmaal INTEGER);
CREATE TABLE ordre (OrdreID INTEGER not NULL PRIMARY KEY, KundeID VARCHAR(45), Dato VARCHAR(45), Fragt DOUBLE);
CREATE TABLE ordrelinje (LinieID INTEGER not NULL PRIMARY KEY, OrdreID INTEGER, VareNr VARCHAR(45), Subtotal DOUBLE);
CREATE TABLE vare (VareNr VARCHAR(45) not NULL PRIMARY KEY, Navn VARCHAR(45), ListePris DOUBLE);