--Run the server by using the command below, remember to be inside the hsqldb's 
--folder and check if you see the lib folder with a 'ls' command!
--java -cp lib/hsqldb.jar org.hsqldb.Server -database.0 file:data/demo_db -dbname.0 xdb
--the database user is SA and has no password
--the name of the database will be xdb
--all the tables will be created in the public schema




CREATE TABLE PUBLIC.ROOM        (ROOMNUM IDENTITY,FLOOR INTEGER,
				  CAPACITY INTEGER, PRICE DOUBLE);

CREATE TABLE PUBLIC.CLIENT   (IDCLIENT  IDENTITY, NAME VARCHAR(45), 
			      LASTNAME VARCHAR(45));

CREATE TABLE PUBLIC.MEETTING     (IDMEETTING IDENTITY,ROOMNUM INTEGER,IDCLIENT INTEGER, STARTMEETING TIMESTAMP,FINISHMEETING TIMESTAMP
				  STATUS BOOLEAN);
 
 --The Status column in table meetting refers to, if the meetting is cancel by false and active by true
 


--CONSTRAINT
ALTER TABLE PUBLIC.MEETTING ADD FOREIGN KEY (IDCLIENT) REFERENCES PUBLIC.CLIENT(IDCLIENT);

ALTER TABLE PUBLIC.MEETTING ADD FOREIGN KEY (ROOMNUM) REFERENCES PUBLIC.ROOM(ROOMNUM)


--Some random data for room and client

INSERT INTO PUBLIC.ROOM  (ROOMNUM,FLOOR,CAPACITY,PRICE) VALUES  (1,1,5,100) , (2,1,5,450), 
(3,1,5,200), (4,1,10,1000);
-- 
insert into public.CLIENT (name,lastname) values ('Elida','Mckillip'),
('Hermila','Blazier'),
('Vanda','Niemi'),
('Kori','Penrod'),
('Mirian','Depasquale'),
('Issac','Bachman'),
('Fausto','Welle'),
('Elroy','Hixson'),
('Rosendo','Jelks'),
('Nola','Caywood'),
('Danny','Rine'),
('Franklyn','Marotz'),
('Heath','Haught'),
('Mitzie','Wurtz'),
('Rochell','Litchford'),
('Gail','Drye'),
('Leo','Banas'),
('Linwood','Whitfield'),
('Emory','Buttars'),
('Sybil','Ricken');
