/*
insert into FOUNDER(FOUNDER_ID, NAME, LAST_NAME, SUMMARY, EMAIL, ALIAS) VALUES 
(0,'Sebastian','Cuatepotzo','Hola, soy Sebas, me gusta flojear','SSTSACM@GMAIL.COM','sebas'),
(1,'Abigail','Ortega','Hola, soy Aby, me gusta estudiar','ABIGAILORTEGA31@GMAIL.COM','aby')
;

insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES
  (0 ,'PUBLISHED','PUBLISHED POST')
, (1 ,'APPROVED', 'APPROVED POST TO BE PUBLISHED ')
, (2 ,'REVISION','REVISION POST')
, (3 ,'EDITION','EDITION COURSE')
, (4 ,'PUBLIEDIT','PUBLISHED AND EDIT VERSION')
;
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES 
  (0,'NEW','TECNOLOGY NEW')
, (1,'POST','TECNOLOGY POST')
, (2,'EXPERIENCE', 'FOUNDER EXPERIENCE')
, (3,'FOUNDER','FOUNDER BIOGRAPHY')
, (4,'PHILOSOPHY','GUTS & CODE PHILOSOPHY')
, (5,'FUTURE','GUTS & CODE FUTURE')
; 
insert into TYPE_TEXT (TYPE_TEXT_ID, NAME, DESCRIPTION) VALUES 
  (0,'HEADER','HEADER')
, (1,'BODY','BODY')
, (2,'FOOTER', 'FOOTER')
, (3,'ANOTATION','ANOTATION')
; 
insert into IMAGE_OPTION(IMAGE_ID, NAME) VALUES
  (1,'BLACK')
, (2,'ORANGE')
, (3,'ORANGES')
, (4,'YELLOW')
, (5,'BLUE')
, (6,'BLUEK')
, (7,'BLUES')
, (8,'BROWN')
, (9,'GREEN')
, (10,'MINT')
, (11,'PINK')
;
/*Entries for Post*/
/*Entries for News*/
/*Entries for Guts N Code*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, LOCATION, IMAGE_ID) VALUES
  (1 ,'Java 01'   , 0,0, 'java'   , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 1)
, (2 ,'Docker 02' , 0,0, 'docker' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 2)
, (3 ,'Centos 03' , 0,0, 'centos' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 3)
, (4 ,'Python 04' , 0,0, 'python' , '2020-12-31', 0,1, '2020-12-31', 1, 'CDMX', 4)
, (5 ,'Spring 01' , 0,0, 'spring' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 5)
, (6 ,'Devops 02' , 0,0, 'devops' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 6)
, (7 ,'Kotlin 03' , 0,0, 'kotlin' , '2020-12-31', 1,0, '2020-12-31', 0, 'CDMX', 7)
, (8 ,'Angular 04', 0,0, 'angular', '2020-12-31', 1,0,' 2020-12-31', 0, 'CDMX', 8)
, (9 ,'ACERCA DE NOSOTROS', 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 4, 'CDMX',9)
, (10,'FUNDADORES'        , 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 3, 'CDMX',10)
, (11,'EXPERIENCIAS'      , 0,0,'gutsncode','2020-12-31', 1,0, '2020-12-31', 2, 'CDMX',1)
, (12,'FUTURO'            , 0,0,'gutsncode','2020-12-31', 0,1, '2020-12-31', 5, 'CDMX',2)
, (13,'FILOSOFIA'         , 0,0,'gutsncode','2020-12-31', 0,1, '2020-12-31', 4, 'CDMX',3)
;
update POST set                CHILD_ID = 2 where POST_ID = 1;
update POST set PARENT_ID = 1, CHILD_ID = 3 where POST_ID = 2;
update POST set PARENT_ID = 2, CHILD_ID = 4 where POST_ID = 3;
update POST set PARENT_ID = 3               where POST_ID = 4;
update POST set                CHILD_ID = 6 where POST_ID = 5;
update POST set PARENT_ID = 5, CHILD_ID = 7 where POST_ID = 6;
update POST set PARENT_ID = 6, CHILD_ID = 8 where POST_ID = 7;
update POST set PARENT_ID = 7               where POST_ID = 8;

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES
  (1,1,1,'',
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
, (2,0,1,'','¿Quienes somos?')
, (3,2,1,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (4,3,1,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (5,1,2,'',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
, (6,0,2,'','¿Quienes somos?')
, (7,2,2,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (8,3,2,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (9 ,1,3,'',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
, (10,0,3,'','¿Quienes somos?')
, (11,2,3,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (12,3,3,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (13,1,4,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (14,0,4,'','¿Quienes somos?')
, (15,2,4,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (16,3,4,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (17,1,5,'',
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
, (18,0,5,'','¿Quienes somos?')
, (19,2,5,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (20,3,5,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (21,1,6,'',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
, (22,0,6,'','¿Quienes somos?')
, (23,2,6,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (24,3,6,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (25,1,7,'',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
, (26,0,7, '','¿Quienes somos?')
, (27,2,7, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (28,3,7, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (29,1,8, '','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (30,0,8, '','¿Quienes somos?')
, (31,2,8, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (32,3,8, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (33,1,9, '','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (34,0,9, '','¿Quienes somos?')
, (35,2,9, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (36,3,9, '','Nos despendimos, y recuerden, Sebas es un flojo')
, (37,1,10,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code; creamos esta pagina para regañar a Sebas por flojo')
, (38,0,10,'','¿Quienes somos?')
, (39,2,10,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (40,3,10,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (41,1,11,'','Antes trabajabamos 20 horas al día, ahora solo 19, pues descubrimos que si existe la vida despues del trabajo')
, (42,0,11,'','De esclavos a Rockstars')
, (43,2,11,'','A rockear bebes')
, (44,3,11,'','A rockear bebes')
, (45,1,12,'','Esperamos que nuestra pagina se llene de contenido de todo tipo, a modo que podamos ser un referente de conocimientos')
, (46,0,12,'','¿Quienes somos?')
, (47,2,12,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (48,3,12,'','Nos despendimos, y recuerden, Sebas es un flojo')
, (49,1,13,'',
'Guts & Code nade del deseo de poder tener contenido de calidad de diferentes tecnologías en nuestra lengua materna, el Español. Creemos que las barreras del idioma no deben ser limitante para poder seguir desarrollandose dentro del mundo de la programación, en nuestro caso, más cercano a Java y las tecnologías que girán en torno a ella, aunque no nos limitamos solo a ella.
G&C se representa por un gato (que sobra decir que nos gustan los gatos) del cual compartimos estas cualidades y similitudes:
Agilidad
Curiosidad
Grandes cazadores.
Esperamos que podamos llegar a muchas personas deseosas como nosotros de apreder sobre el mundo de la programación con Java
')
, (50,0,13,'','Filosofia')
, (51,2,13,'','Conocenos')
, (52,3,13,'','Conocenos')
;

INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES
/*  
  (1, 'Java.png', 'Javas logo', null, 1, 'java', 'top')
, (2, 'Java.png', 'Javas logo', null, 4, 'java', 'top')
, (3, 'Java.png', 'Javas logo', null, 7, 'java', 'top')
, (4, 'Spring.png', 'Springs logo',null, 2, 'spring', 'top')
*/

  (1, 'Java.png', 'Javas logo', FILE_READ('C:/opt/bbva.png'), 1, 'java', 'top')
, (2, 'Java.png', 'Javas logo', FILE_READ('C:/opt/bbva.png'), 4, 'java', 'top')
, (3, 'Java.png', 'Javas logo', FILE_READ('C:/opt/bbva.png'), 7, 'java', 'top')
, (4, 'Spring.png', 'Springs logo', FILE_READ('C:/opt/bbva.png'), 2, 'spring', 'top')

;
insert into USERS(USERNAME, PASSWORD, EMAIL, ENABLED, NUMBER_TRIES) values
('admin', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'ADMIN', true,0),
('sebas', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'SSTSACM@GMAIL.COM',true, 0),
('aby'  , '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'ABIGAILORTEGA31@GMAIL.COM',true, 0)
;
insert into AUTHORITIES(USERNAME,AUTHORITY) values
('admin','ROLE_ADMIN'),
('sebas', 'ROLE_ADMIN'),
('aby'  , 'ROLE_ADMIN')
;
*/