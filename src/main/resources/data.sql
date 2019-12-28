insert into Founder(NAME, LAST_NAME, SECOND_LAST_NAME, SUMMARY, EMAIL, PASSWORD, PHOTO) VALUES 
  ('SEBAS','CUATEPOTZO','MARTINEZ','Hola, soy Sebas, me gusta flojear','SSTSACM@GMAIL.COM','123456789', FILE_READ('/opt/java.png'))
, ('ABIGAIL','ORTEGA','VALDIVIA','Hola, soy Aby, me gusta estudiar','ABIGAILORTEGA31@GMAIL.COM','987654321', FILE_READ('/opt/spring.png'))
;
insert into STATUS(STATUS_ID, NAME , DESCRIPTION) VALUES
  (0 ,'PUBLISHED','PUBLISHED POST')
, (1 ,'APPROVED', 'APPROVED POST TO BE PUBLISHED ')
, (2 ,'REVISION','REVISION POST')
, (3 ,'EDITION','EDITION COURSE')
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
/*Entries for Post*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  (1, 'JAVA POST 01',0,0,'java','3000-01-01',1,1,'3000-12-31', 1, 'JAVA POST 01', 'CDMX', FILE_READ('/opt/java.png'))
, (2, 'JAVA POST 02',0,0,'java','3000-01-01',1,1,'3000-12-31', 1, 'JAVA POST 02', 'CDMX', FILE_READ('/opt/java.png'))
, (3, 'JAVA POST 03',0,0,'java','3000-01-01',1,1,'3000-12-31', 1, 'JAVA POST 03', 'CDMX', FILE_READ('/opt/java.png'))
;
/**/
update POST set CHILD_ID = 2 where POST_ID = 1;
update POST set PARENT_ID = 1, CHILD_ID = 3 where POST_ID = 2;
update POST set PARENT_ID = 2 where POST_ID = 3;
/**/
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  ('POST13',0,0,'spring','2019-11-03',1,1,'2019-11-03', 1, 'POST 13', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST14',0,0,'spring','2019-11-04',1,1,'2019-11-04', 1, 'POST 14', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST15',0,0,'java'  ,'2019-11-05',1,1,'2019-11-05', 1, 'POST 15', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST16',0,0,'spring','2019-11-06',1,1,'2019-11-06', 1, 'POST 16', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST17',0,0,'spring','2019-11-07',1,1,'2019-11-07', 1, 'POST 17', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST18',0,0,'spring','2019-11-08',1,1,'2019-11-08', 1, 'POST 18', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST19',0,0,'spring','2019-11-09',1,1,'2019-11-09', 1, 'POST 19', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST20',0,0,'spring','2019-11-10',1,1,'2019-11-10', 1, 'POST 20', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST21',0,0,'spring','2019-11-11',1,1,'2019-11-11', 1, 'POST 21', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST22',0,0,'spring','2019-11-12',1,1,'2019-11-12', 1, 'POST 22', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST23',0,0,'spring','2019-11-13',1,1,'2019-11-13', 1, 'POST 23', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST24',0,0,'spring','2019-11-14',1,1,'2019-11-14', 1, 'POST 24', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST25',0,0,'spring','2019-11-15',1,1,'2019-11-15', 1, 'POST 25', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST26',0,0,'spring','2019-11-16',1,1,'2019-11-16', 1, 'POST 26', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST27',0,0,'spring','2019-11-17',1,1,'2019-11-17', 1, 'POST 27', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST28',0,0,'spring','2019-11-18',1,1,'2019-11-18', 1, 'POST 28', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST29',0,0,'spring','2019-11-19',1,1,'2019-11-19', 1, 'POST 29', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST30',0,0,'spring','2019-11-20',1,1,'2019-11-20', 1, 'POST 30', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST31',0,0,'java'  ,'2019-11-21',1,1,'2019-11-21', 1, 'POST 31', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST32',0,0,'java'  ,'2019-11-22',1,1,'2019-11-22', 1, 'POST 32', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST33',0,0,'java'  ,'2019-11-23',1,1,'2019-11-23', 1, 'POST 33', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST34',0,0,'java'  ,'2019-11-24',1,1,'2019-11-24', 1, 'POST 34', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST35',0,0,'devops','2019-11-25',1,1,'2019-11-25', 1, 'POST 35', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST36',0,0,'devops','2019-11-26',1,1,'2019-11-26', 1, 'POST 36', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST37',0,0,'devops','2019-11-27',1,1,'2019-11-27', 1, 'POST 37', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST38',0,0,'devops','2019-11-28',1,1,'2019-11-28', 1, 'POST 38', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST39',0,0,'devops','2019-11-29',1,1,'2019-11-29', 1, 'POST 39', 'CDMX', FILE_READ('/opt/spring.png'))
, ('POST40',0,0,'devops','2019-11-30',1,1,'2019-11-30', 1, 'POST 40', 'CDMX', FILE_READ('/opt/spring.png'))
;
/*Entries for News*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  (45,'Spring 01',0,0,'spring','3000-01-01',1,1,'3000-01-01', 0, 'Spring 01', 'CDMX', FILE_READ('/opt/spring.png'))
, (46,'Spring 02',0,0,'spring','3000-01-01',1,1,'3000-01-01', 0, 'Spring 02', 'CDMX', FILE_READ('/opt/spring.png'))
, (47,'Spring 03',0,0,'spring','3000-01-01',1,1,'3000-01-01', 0, 'Spring 03', 'CDMX', FILE_READ('/opt/spring.png'))
;
/**/
update POST set CHILD_ID = 46 where POST_ID = 45;
update POST set PARENT_ID = 45, CHILD_ID = 47 where POST_ID = 46;
update POST set PARENT_ID = 46 where POST_ID = 47;
/**/
insert into POST (NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  ('NEWS02',0,0,'kotlin','2019-11-03',1,1,'2019-11-03', 0, 'NEWS 02', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS03',0,0,'graalvm','2019-11-04',1,1,'2019-11-04', 0, 'NEWS 03', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS04',0,0,'apache','2019-11-05',1,1,'2019-11-05', 0, 'NEWS 04', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS05',0,0,'java','2019-11-06',1,1,'2019-11-06', 0, 'NEWS 05', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS06',0,0,'spring','2019-11-07',1,1,'2019-11-07', 0, 'NEWS 06', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS07',0,0,'kotlin','2019-11-08',1,1,'2019-11-08', 0, 'NEWS 07', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS08',0,0,'graalvm','2019-11-09',1,1,'2019-11-09', 0, 'NEWS 08', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS09',0,0,'apache','2019-11-10',1,1,'2019-11-10', 0, 'NEWS 09', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS10',0,0,'java','2019-11-11',1,1,'2019-11-11', 0, 'NEWS 10', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS11',0,0,'spring','2019-11-12',1,1,'2019-11-12', 0, 'NEWS 11', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS12',0,0,'kotlin','2019-11-13',1,1,'2019-11-13', 0, 'NEWS 12', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS13',0,0,'graalvm','2019-11-14',1,1,'2019-11-14', 0, 'NEWS 13', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS14',0,0,'apache','2019-11-15',1,1,'2019-11-15', 0, 'NEWS 14', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS15',0,0,'java','2019-11-16',1,1,'2019-11-16', 0, 'NEWS 15', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS16',0,0,'spring','2019-11-17',1,1,'2019-11-17', 0, 'NEWS 16', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS17',0,0,'kotlin','2019-11-18',1,1,'2019-11-18', 0, 'NEWS 17', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS18',0,0,'graalvm','2019-11-19',1,1,'2019-11-19', 0, 'NEWS 18', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS19',0,0,'apache','2019-11-20',1,1,'2019-11-20', 0, 'NEWS 19', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS20',0,0,'java','2019-11-21',1,1,'2019-11-21', 0, 'NEWS 20', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS21',0,0,'spring','2019-11-22',1,1,'2019-11-22', 0, 'NEWS 21', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS22',0,0,'kotlin','2019-11-23',1,1,'2019-11-23', 0, 'NEWS 22', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS23',0,0,'graalvm','2019-11-24',1,1,'2019-11-24', 0, 'NEWS 23', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS24',0,0,'apache','2019-11-25',1,1,'2019-11-25', 0, 'NEWS 24', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS25',0,0,'java','2019-11-26',1,1,'2019-11-26', 0, 'NEWS 25', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS26',0,0,'spring','2019-11-27',1,1,'2019-11-27', 0, 'NEWS 26', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS27',0,0,'kotlin','2019-11-28',1,1,'2019-11-28', 0, 'NEWS 27', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS28',0,0,'graalvm','2019-11-29',1,1,'2019-11-29', 0, 'NEWS 28', 'CDMX', FILE_READ('/opt/spring.png'))
, ('NEWS29',0,0,'apache','2019-11-30',1,1,'2019-11-30', 0, 'NEWS 29', 'CDMX', FILE_READ('/opt/spring.png'))
;
/*Text for Post*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES 
  (1,1,1,
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today',
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
, (2,0,1,'','¿Quienes somos?')
, (3,2,1,'','Nos despendimos, y recuerden, Sebas es un flojo')

, (4,1,2,
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
, (5,0,2,'','¿Quienes somos?')
, (6,2,2,'','Nos despendimos, y recuerden, Sebas es un flojo')

, (7,1,3,
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
, (8,0,3,'','¿Quienes somos?')
, (9,2,3,'','Nos despendimos, y recuerden, Sebas es un flojo')
;
/*Text for News*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES
  (10,1,45,
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today',
  	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Slip inside the eye of your mind <br> Dont you know you might find <br> A better place to play <br> You said that youd never been <br> But all the things that youve seen <br> Will slowly fade away <br> So I start a revolution from my bed <br> Cause you said the brains I had went to my head. <br> Step outside, summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> You aint ever gonna burn my heart out <br> And so Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> Take me to the place where you go <br> Where nobody knows if its night or day <br> But please dont put your life in the hands <br> Of a Rock n Roll band <br> Wholl throw it all away <br> Im gonna start a revolution from my bed <br> Cause you said the brains I had went to my head <br> Step outside cause summertimes in bloom <br> Stand up beside the fireplace <br> Take that look from off your face <br> Cause you aint ever gonna burn my heart out <br> So Sally can wait, she knows its too late as shes walking on by <br> My soul slides away, but dont look back in anger I heard you say <br> So Sally can wait, she knows its too late as were walking on by <br> Her soul slides away, but dont look back in anger I heard you say <br> So Sally can wait <br> She knows its too late as shes walking on by <br> My soul slides away <br> But dont look back in anger <br> Dont look back in anger <br> I heard you say <br> At least not today')
, (11,0,45,'','¿Quienes somos?')
, (12,2,45,'','Nos despendimos, y recuerden, Sebas es un flojo')

, (13,1,46,
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Because of saving myself the hairdresser, <br>They cut wrong my hair today. <br>What am I going to do now? <br>This aint getting any better <br>My friends will make fun of me <br>I cant go back to school again <br>Not even with a different hairdo <br>This has not any improvement <br>Because of saving myself the hairdresser <br>Now I must wear a hat forever <br>My friens will make fun of me <br>I cant go to school anymore <br>His friends, we will make fun of him <br>He cant go back to school again <br>Theres just one comfort left for me <br>Wait for my hair to grow long again')
, (14,0,46,'','¿Quienes somos?')
, (15,2,46,'','Nos despendimos, y recuerden, Sebas es un flojo')

, (16,1,47,
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo, ahora una cancion <br><br>Hay perros que no ladran<br>Pero te lamen los huesos<br>Hay gatos que mahullan<br>Hasta exprimir su vientre<br>Hay gente que no ladra<br>Pero te exprime el alma<br>Hay gente que te odia<br>Pero te lame las manos así<br>Hay gente que no arriesga<br>Le tiene miedo a la muerte<br>Hay gatos que no mueren<br>Le dan la vuelta al cielo así<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Hay perros que defienden<br>Hasta clavar colmillos<br>Perro que ladra<br>Perro que ladra no muerde<br>De noche todos los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>De noche todoso los gatos son pardos<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño<br>Pardo me duermo, pardo te sueño')
, (17,0,47,'','¿Quienes somos?')
, (18,2,47,'','Nos despendimos, y recuerden, Sebas es un flojo')
;
/*Entries for Guts N Code*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  (101,'ACERCA DE NOSOTROS',0,0,'gutsncode','2019-12-31',1,1,'2019-12-31',4,'ACERCA DE NOSOTROS','CDMX', FILE_READ('/opt/spring.png'))
, (102,'FUNDADORES',0,0,'gutsncode','2019-12-31',1,1,'2019-12-31',3,'FUNDADORES','CDMX', FILE_READ('/opt/spring.png'))
, (103,'EXPERIENCIAS',0,0,'gutsncode','2019-12-31',1,1,'2019-12-31',2,'EXPERIENCIAS','CDMX', FILE_READ('/opt/spring.png'))
;

insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES
/*Text for Acerca de Nosotros*/
  (107,1,101,
  'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo',
  'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo')
, (108,0,101,'','¿Quienes somos?')
, (109,2,101,'','Nos despendimos, y recuerden, Sebas es un flojo')
/*Text for Fundadores*/
, (110,1,102,
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo',
	'Hola, somos Aby y Sebas y somos los fundadores de Guts & Code, y creamos esta pagina para regañar a Sebas por flojo')
, (111,0,102,'','¿Quienes somos?')
, (112,2,102,'','Nos despendimos, y recuerden, Sebas es un flojo')
/*Text for Experiencias*/
, (113,1,103,
	'Antes trabajabamos 20 horas al día, ahora solo 19, pues descubrimos que si existe la vida despues del trabajo',
	'Antes trabajabamos 20 horas al día, ahora solo 19, pues descubrimos que si existe la vida despues del trabajo')
, (114,0,103,'','De esclavos a Rockstars')
, (115,2,103,'','A rockear bebes')
;

/*Entries for Guts N Code*/
insert into POST (POST_ID, NAME, NUMBER_VIEW, STATUS_ID, TOPIC, LAST_UPDATE, WRITTER_ID, REVIEWER_ID, DATE_REVIEWER, TYPE_POST_ID, TITLE, LOCATION, IMAGE) VALUES
  (104,'FUTURO',0,0,'gutsncode','2019-12-31',1,1,'2019-12-31',5,'FUTURO','CDMX', FILE_READ('/opt/spring.png'))
, (105,'FILOSOFIA',0,0,'gutsncode','2019-12-31',1,1,'2019-12-31',4,'FILOSOFIA','CDMX', FILE_READ('/opt/spring.png'))
;

/*Text for Fundadores*/
insert into TEXT (TEXT_ID,TYPE_TEXT_ID,POST_ID,TEXT_BETA,TEXT_REALIZE) VALUES
  (116,1,104,'','Esperamos que nuestra pagina se llene de contenido de todo tipo, a modo que podamos ser un referente de conocimientos')
, (117,0,104,'','¿Quienes somos?')
, (118,2,104,'','Nos despendimos, y recuerden, Sebas es un flojo')
/*Text for Experiencias*/
, (119,1,105,
'Guts & Code nade del deseo de poder tener contenido de calidad de diferentes tecnologías en nuestra lengua materna, el Español. Creemos que las barreras del idioma no deben ser limitante para poder seguir desarrollandose dentro del mundo de la programación, en nuestro caso, más cercano a Java y las tecnologías que girán en torno a ella, aunque no nos limitamos solo a ella.
G&C se representa por un gato (que sobra decir que nos gustan los gatos) del cual compartimos estas cualidades y similitudes:
Agilidad
Curiosidad
Grandes cazadores.
Esperamos que podamos llegar a muchas personas deseosas como nosotros de apreder sobre el mundo de la programación con Java
',
'Guts & Code nade del deseo de poder tener contenido de calidad de diferentes tecnologías en nuestra lengua materna, el Español. Creemos que las barreras del idioma no deben ser limitante para poder seguir desarrollandose dentro del mundo de la programación, en nuestro caso, más cercano a Java y las tecnologías que girán en torno a ella, aunque no nos limitamos solo a ella.
G&C se representa por un gato (que sobra decir que nos gustan los gatos) del cual compartimos estas cualidades y similitudes:
Agilidad
Curiosidad
Grandes cazadores.
Esperamos que podamos llegar a muchas personas deseosas como nosotros de apreder sobre el mundo de la programación con Java
')
, (120,0,105,'','Filosofia')
, (121,2,105,'','Conocenos')
;

INSERT INTO IMAGE (IMAGE_ID,IMAGE_NAME,DESCRIPTION,IMAGE,TEXT_ID,FOOTER,CARDINALITY) VALUES
/**/
  (1, 'Java.png', 'Javas logo', FILE_READ('/opt/java.png'), 1, 'java', 'top')
, (2, 'Java.png', 'Javas logo', FILE_READ('/opt/java.png'), 4, 'java', 'top')
, (3, 'Java.png', 'Javas logo', FILE_READ('/opt/java.png'), 7, 'java', 'top')
, (4, 'Spring.png', 'Springs logo', FILE_READ('/opt/spring.png'), 2, 'spring', 'top')
/*
  (1, 'Java.png', 'Javas logo', FILE_READ('C:/opt/java.png'), 1, 'java', 'top')
, (2, 'Java.png', 'Javas logo', FILE_READ('C:/opt/java.png'), 4, 'java', 'top')
, (3, 'Java.png', 'Javas logo', FILE_READ('C:/opt/java.png'), 7, 'java', 'top')
, (4, 'Spring.png', 'Springs logo', FILE_READ('C:/opt/spring.png'), 2, 'spring', 'top')
*/
;