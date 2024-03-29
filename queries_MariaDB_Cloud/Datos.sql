/*
insert into FOUNDER(NAME, LAST_NAME, SUMMARY, EMAIL, ALIAS, PHOTO) VALUES 
('Abigail','Ortega','Hola, soy Aby, me gusta estudiar','ABIGAILORTEGA31@GMAIL.COM','aby',null),
('Sebastian','Cuatepotzo','Hola, soy Sebas, me gusta flojear','SSTSACM@GMAIL.COM','sebas', null)
;
UPDATE FOUNDER SET FOUNDER_ID = 0 WHERE NAME = 'Sebastian'
;
insert into STATUS(NAME , DESCRIPTION) VALUES
  ('APPROVED', 'APPROVED POST TO BE PUBLISHED ')
, ('REVISION','REVISION POST')
, ('EDITION','EDITION COURSE')
, ('PUBLIAPPR','PUBLISHED AND APPROVED')
, ('PUBLIREV','PUBLISHED AND REVISION')
, ('PUBLIEDIT','PUBLISHED AND EDIT VERSION')
, ('PUBLISHED','PUBLISHED POST')
;
UPDATE STATUS SET STATUS_ID = 0 WHERE NAME = 'PUBLISHED'
;
insert into IMAGE_OPTION(NAME) VALUES
  ('BLACK')
, ('ORANGE')
, ('ORANGES')
, ('MINT')
, ('BLUE')
, ('BLUEK')
, ('BLUES')
, ('BROWN')
, ('GREEN')
, ('PINK')
;
UPDATE IMAGE_OPTION SET IMAGE_ID = 0 WHERE NAME = 'PINK'
;
insert into TYPE_POST(NAME, DESCRIPTION) VALUES 
  ('POST','TECNOLOGY POST')
, ('EXPERIENCE', 'FOUNDER EXPERIENCE')
, ('FOUNDER','FOUNDER BIOGRAPHY')
, ('PHILOSOPHY','GUTS & CODE PHILOSOPHY')
, ('FUTURE','GUTS & CODE FUTURE')
, ('NEW','TECNOLOGY NEW')
; 
UPDATE TYPE_POST SET TYPE_POST_ID = 0 WHERE NAME = 'NEW'
;
insert into TYPE_TEXT (NAME, DESCRIPTION) VALUES  
  ('BODY','BODY')
, ('FOOTER', 'FOOTER')
, ('ANOTATION','ANOTATION')
, ('HEADER','HEADER')
;
UPDATE TYPE_TEXT SET TYPE_TEXT_ID = 0 WHERE NAME = 'HEADER'
; 
-- 
-- 
-- /*Entries for Post*/
-- /*Entries for News*/
-- /*Entries for Guts N Code*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, LOCATION, IMAGE_ID) VALUES
/*
--   (1 ,'Java 01'   , 0,0, 'java'   , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 1)
-- , (2 ,'Docker 02' , 0,0, 'docker' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 2)
-- , (3 ,'Centos 03' , 0,0, 'centos' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 3)
-- , (4 ,'Python 04' , 0,0, 'python' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 4)
-- , (5 ,'Spring 01' , 0,0, 'spring' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 5)
-- , (6 ,'Devops 02' , 0,0, 'devops' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 6)
-- , (7 ,'Kotlin 03' , 0,0, 'kotlin' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 7)
-- , (8 ,'Angular 04', 0,0, 'angular', '2020-12-31', 1,0,' 2020-12-31', 0, 'CDMX', 8),
*/
  (1 ,'ACERCA DE NOSOTROS', 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 4, 'CDMX',0)
, (2,'FUNDADORES'         , 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 3, 'CDMX',4)
, (3,'EXPERIENCIAS'       , 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 2, 'CDMX',1)
, (4,'FUTURO'             , 0,0,'gutsncode','2020-12-31', 0,1, '2020-12-31', 5, 'CDMX',2)
, (5,'FILOSOFIA'          , 0,0,'gutsncode','2020-12-31', 0,1, '2020-12-31', 4, 'CDMX',3)
;
/**/
/*
-- update POST set                CHILD_ID = 2 where POST_ID = 1;
-- update POST set PARENT_ID = 1, CHILD_ID = 3 where POST_ID = 2;
-- update POST set PARENT_ID = 2, CHILD_ID = 4 where POST_ID = 3;
-- update POST set PARENT_ID = 3               where POST_ID = 4;
-- update POST set                CHILD_ID = 6 where POST_ID = 5;
-- update POST set PARENT_ID = 5, CHILD_ID = 7 where POST_ID = 6;
-- update POST set PARENT_ID = 6, CHILD_ID = 8 where POST_ID = 7;
-- update POST set PARENT_ID = 7               where POST_ID = 8;
*/
/**/
/*Text for Post*/
/*
-- insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES 
--   (1,1,1,'',
--   	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
-- , (2,0,1,'','¿Quienes somos?')
-- , (3,2,1,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (4,3,1,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (5,1,2,'',
-- 	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
-- , (6,0,2,'','¿Quienes somos?')
-- , (7,2,2,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (8,3,2,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (9 ,1,3,'',
-- 	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
-- , (10,0,3,'','¿Quienes somos?')
-- , (11,2,3,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (12,3,3,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (13,1,4,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
-- , (14,0,4,'','¿Quienes somos?')
-- , (15,2,4,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (16,3,4,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- /*Text for News*/
-- /*insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES*/
-- , (17,1,5,'',
--   	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
-- , (18,0,5,'','¿Quienes somos?')
-- , (19,2,5,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (20,3,5,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (21,1,6,'',
-- 	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
-- , (22,0,6,'','¿Quienes somos?')
-- , (23,2,6,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (24,3,6,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (25,1,7,'',
-- 	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
-- , (26,0,7,'','¿Quienes somos?')
-- , (27,2,7,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (28,3,7,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- 
-- , (29,1,8,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
-- , (30,0,8,'','¿Quienes somos?')
-- , (31,2,8,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- , (32,3,8,'','Nos despendimos, y recuerden, Sebas es un flojo')
-- */
/*Text for Acerca de Nosotros*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES
  (1,1,1,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (2,0,1,'','¿Quienes somos?')
, (3,2,1,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (4,3,1,'','Nos despendimos, y recuerden, Sebas es un flojo')

/*Text for Fundadores*/
, (5,1,2,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (6,0,2,'','¿Quienes somos?')
, (7,2,2,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (8,3,2,'','Nos despendimos, y recuerden, Sebas es un flojo')

/*Text for Experiencias*/
, (9,1,3,'','Antes trabajabamos 20 horas al día, ahora solo 19, pues descubrimos que si existe la vida despues del trabajo')
, (10,0,3,'','De esclavos a Rockstars')
, (11,2,3,'','A rockear bebes')
, (12,3,3,'','A rockear bebes')

/*Text for Futuro*/
/*insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES*/
, (13,1,4,'','Esperamos que nuestra pagina se llene de contenido de todo tipo, a modo que podamos ser un referente de conocimientos')
, (14,0,4,'','¿Quienes somos?')
, (15,2,4,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (16,3,4,'','Nos despendimos, y recuerden, Sebas es un flojo')

/*Text for Filosofia*/
, (17,1,5,'',
'Guts & Code nade del deseo de poder tener contenido de calidad de diferentes tecnologías en nuestra lengua materna, el Español. Creemos que las barreras del idioma no deben ser limitante para poder seguir desarrollandose dentro del mundo de la programación, en nuestro caso, más cercano a Java y las tecnologías que girán en torno a ella, aunque no nos limitamos solo a ella.
G&C se representa por un gato (que sobra decir que nos gustan los gatos) del cual compartimos estas cualidades y similitudes:
Agilidad
Curiosidad
Grandes cazadores.
Esperamos que podamos llegar a muchas personas deseosas como nosotros de apreder sobre el mundo de la programación con Java
')
, (18,0,5,'','Filosofia')
, (19,2,5,'','Conocenos')
, (20,3,5,'','Conocenos')
;

insert into USERS(USERNAME, PASSWORD, EMAIL, ENABLED, NUMBER_TRIES) values
('admin', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'ADMIN', true,0),
('sebas', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'SSTSACM@GMAIL.COM',true, 0),
('aby'  , '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'ABIGAILORTEGA31@GMAIL.COM',true, 0)
;
insert into AUTHORITIES(USERNAME, AUTHORITY) values
('admin','ROLE_ADMIN'),
('sebas', 'ROLE_ADMIN'),
('aby'  , 'ROLE_ADMIN')
;
*/
