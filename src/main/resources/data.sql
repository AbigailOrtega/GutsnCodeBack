insert into Founder(NAME, LAST_NAME, SECOND_LAST_NAME, SUMMARY, EMAIL, PASSWORD) values ('SEBAS','CUATEPOTZO','MARTINEZ','ASDFADF','SSTSACM@GMAIL.COM','ADFADF');
insert into Founder(NAME, LAST_NAME, SECOND_LAST_NAME, SUMMARY, EMAIL, PASSWORD) values ('ABIGAIL','ORTEGA','VALDIVIA','QWERTY','ABIGAILORTEGA31@GMAIL.COM','ADFADF');

insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES (0 ,'PUBLISHED','PUBLISHED POST');
insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES (1 ,'APPROVED', 'APPROVED POST TO BE PUBLISHED ');
insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES (2 ,'REVISION','REVISION POST');
insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES (3 ,'EDITION','EDITION COURSE');

insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (0,'NEW','TECNOLOGY NEW'); 
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (1,'POST','TECNOLOGY POST'); 
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (2,'EXPERIENCE', 'FOUNDER EXPERIENCE'); 
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (3,'FOUNDER','FOUNDER BIOGRAPHY'); 
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (4,'PHILOSOPHY','GUTS & CODE PHILOSOPHY'); 
insert into TYPE_POST (TYPE_POST_ID, NAME, DESCRIPTION) VALUES (5,'FUTURE','GUTS & CODE FUTURE'); 

insert into TYPE_TEXT (TYPE_TEXT_ID, NAME, DESCRIPTION) VALUES (0,'HEADER','HEADER'); 
insert into TYPE_TEXT (TYPE_TEXT_ID, NAME, DESCRIPTION) VALUES (1,'BODY','BODY');
insert into TYPE_TEXT (TYPE_TEXT_ID, NAME, DESCRIPTION) VALUES (2,'FOOTER', 'FOOTER'); 
insert into TYPE_TEXT (TYPE_TEXT_ID, NAME, DESCRIPTION) VALUES (3,'ANOTATION','ANOTATION'); 

/*Entries for Post*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (1, 'JAVA POST 01',0,0,'java','2009-01-01',1,1,'2019-01-02', 1, 'JAVA POST 01', 'CDMX', FILE_READ('/opt/java.png'));
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (2, 'JAVA POST 02',0,0,'java','2019-02-01',1,1,'2019-02-02', 1, 'JAVA POST 02', 'CDMX', FILE_READ('/opt/java.png'));
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (3, 'JAVA POST 03',0,0,'java','2011-03-01',1,1,'2019-03-02', 1, 'JAVA POST 03', 'CDMX', FILE_READ('/opt/java.png'));
/**/
update POST set CHILD_ID = 2 where POST_ID = 1;
update POST set PARENT_ID = 1, CHILD_ID = 3 where POST_ID = 2;
update POST set PARENT_ID = 2 where POST_ID = 3;
/**/
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST13',0,0,'spring','2012-04-01',1,1,'2019-04-02', 1, 'POST 13', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST14',0,0,'spring','2013-05-01',1,1,'2019-05-02', 1, 'POST 14', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST15',0,0,'java','2009-01-01',1,1,'2019-01-02', 1, 'POST 15', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST16',0,0,'spring','2019-02-01',1,1,'2019-02-02', 1, 'POST 16', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST17',0,0,'spring','2011-03-01',1,1,'2019-03-02', 1, 'POST 17', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST18',0,0,'spring','2012-04-01',1,1,'2019-04-02', 1, 'POST 18', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST19',0,0,'spring','2013-05-01',1,1,'2019-05-02', 1, 'POST 19', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST20',0,0,'spring','2009-01-01',1,1,'2019-01-02', 1, 'POST 20', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST21',0,0,'spring','2019-02-01',1,1,'2019-02-02', 1, 'POST 21', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST22',0,0,'spring','2011-03-01',1,1,'2019-03-02', 1, 'POST 22', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST23',0,0,'spring','2012-04-01',1,1,'2019-04-02', 1, 'POST 23', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST24',0,0,'spring','2013-05-01',1,1,'2019-05-02', 1, 'POST 24', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST25',0,0,'spring','2009-01-01',1,1,'2019-01-02', 1, 'POST 25', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST26',0,0,'spring','2019-02-01',1,1,'2019-02-02', 1, 'POST 26', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST27',0,0,'spring','2011-03-01',1,1,'2019-03-02', 1, 'POST 27', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST28',0,0,'spring','2012-04-01',1,1,'2019-04-02', 1, 'POST 28', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST29',0,0,'spring','2013-05-01',1,1,'2019-05-02', 1, 'POST 29', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST30',0,0,'spring','2009-01-01',1,1,'2019-01-02', 1, 'POST 30', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST31',0,0,'java','2019-02-01',1,1,'2019-02-02', 1, 'POST 31', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST32',0,0,'java','2011-03-01',1,1,'2019-03-02', 1, 'POST 32', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST33',0,0,'java','2012-04-01',1,1,'2019-04-02', 1, 'POST 33', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST34',0,0,'java','2013-05-01',1,1,'2019-05-02', 1, 'POST 34', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST35',0,0,'devops','2019-02-01',1,1,'2019-02-02', 1, 'POST 35', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST36',0,0,'devops','2011-03-01',1,1,'2019-03-02', 1, 'POST 36', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST37',0,0,'devops','2012-04-01',1,1,'2019-04-02', 1, 'POST 37', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST38',0,0,'devops','2013-05-01',1,1,'2019-05-02', 1, 'POST 38', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST39',0,0,'devops','2019-02-01',1,1,'2019-02-02', 1, 'POST 39', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('POST40',0,0,'devops','2011-03-01',1,1,'2019-03-02', 1, 'POST 40', 'CDMX');
/*Entries for News*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (45,'Spring 01',0,0,'spring','2009-01-01',1,1,'2019-01-02', 0, 'Spring 01', 'CDMX', FILE_READ('/opt/spring.png'));
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (46,'Spring 02',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'Spring 02', 'CDMX', FILE_READ('/opt/spring.png'));
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES (47,'Spring 03',0,0,'spring','2011-03-01',1,1,'2019-03-02', 0, 'Spring 03', 'CDMX', FILE_READ('/opt/spring.png'));
/**/
update POST set CHILD_ID = 46 where POST_ID = 45;
update POST set PARENT_ID = 45, CHILD_ID = 47 where POST_ID = 46;
update POST set PARENT_ID = 46 where POST_ID = 47;
/**/
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS3',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 3', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS4',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 4', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS5',0,0,'java','2009-01-01',1,1,'2019-01-02', 0, 'NEWS 5', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS6',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'NEWS 6', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS7',0,0,'kotlin','2011-03-01',1,1,'2019-03-02', 0, 'NEWS 7', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS8',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 8', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS9',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 9', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS10',0,0,'java','2009-01-01',1,1,'2019-01-02', 0, 'NEWS 10', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS11',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'NEWS 11', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS12',0,0,'kotlin','2011-03-01',1,1,'2019-03-02', 0, 'NEWS 12', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS13',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 13', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS14',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 14', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS15',0,0,'java','2009-01-01',1,1,'2019-01-02', 0, 'NEWS 15', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS16',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'NEWS 16', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS17',0,0,'kotlin','2011-03-01',1,1,'2019-03-02', 0, 'NEWS 17', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS18',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 18', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS19',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 19', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS20',0,0,'java','2009-01-01',1,1,'2019-01-02', 0, 'NEWS 20', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS21',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'NEWS 21', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS22',0,0,'kotlin','2011-03-01',1,1,'2019-03-02', 0, 'NEWS 22', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS23',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 23', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS24',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 24', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS25',0,0,'java','2009-01-01',1,1,'2019-01-02', 0, 'NEWS 25', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS26',0,0,'spring','2019-02-01',1,1,'2019-02-02', 0, 'NEWS 26', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS27',0,0,'kotlin','2011-03-01',1,1,'2019-03-02', 0, 'NEWS 27', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS28',0,0,'graalvm','2012-04-01',1,1,'2019-04-02', 0, 'NEWS 28', 'CDMX');
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION) VALUES ('NEWS29',0,0,'apache','2013-05-01',1,1,'2019-05-02', 0, 'NEWS 29', 'CDMX');

/*Text for Post*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (1,1,1,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (2,0,1,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (3,2,1,'','Nos despendimos, y recuerden, Sebas es un flojo');

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (4,1,2,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (5,0,2,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (6,2,2,'','Nos despendimos, y recuerden, Sebas es un flojo');

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (7,1,3,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (8,0,3,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (9,2,3,'','Nos despendimos, y recuerden, Sebas es un flojo');
/*Text for News*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (10,1,45,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (11,0,45,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (12,2,45,'','Nos despendimos, y recuerden, Sebas es un flojo');

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (13,1,46,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (14,0,46,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (15,2,46,'','Nos despendimos, y recuerden, Sebas es un flojo');

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (16,1,47,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (17,0,47,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (18,2,47,'','Nos despendimos, y recuerden, Sebas es un flojo');

/*Entries for Guts N Code*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION,) VALUES (101,'ACERCA DE NOSOTROS',0,0,'gutsncode','2019-11-17',1,1,'2019-11-17',4,'ACERCA DE NOSOTROS','CDMX');
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION,) VALUES (102,'FUNDADORES',0,0,'gutsncode','2019-11-17',1,1,'2019-11-17',3,'FUNDADORES','CDMX');
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION,) VALUES (103,'EXPERIENCIAS',0,0,'gutsncode','2019-11-17',1,1,'2019-11-17',2,'EXPERIENCIAS','CDMX');
/*Text for Acerca de Nosotros*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (107,1,101,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (108,0,101,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (109,2,101,'','Nos despendimos, y recuerden, Sebas es un flojo');
/*Text for Fundadores*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (110,1,102,'','Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (111,0,102,'','¿Quienes somos?');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (112,2,102,'','Nos despendimos, y recuerden, Sebas es un flojo');
/*Text for Experiencias*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (113,1,103,'','Antes trabajabamos 20 horas al día, ahora solo 19, pues descubrimos que si existe la vida despues del trabajo');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (114,0,103,'','De esclavos a Rockstars');
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES (115,2,103,'','A rockear bebes');

INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES('1', 'Java.png', 'Javas logo', FILE_READ('/opt/java.png'), 1, 'java', 'top');
INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES('2', 'Spring.png', 'Springs logo', FILE_READ('/opt/spring.png'), 2, 'spring', 'top');

/*
INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES('1', 'Java.png', 'Javas logo', FILE_READ('C:/opt/java.png'), 1, 'java', 'top');
INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES('2', 'Spring.png', 'Springs logo', FILE_READ('C:/opt/spring.png'), 2, 'spring', 'top');
*/
