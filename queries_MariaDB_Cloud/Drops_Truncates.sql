select * from GutsNCode.FOUNDER;
select * from GutsNCode.STATUS;
select * from GutsNCode.TYPE_POST;
select * from GutsNCode.TYPE_TEXT;
select * from GutsNCode.IMAGE_OPTION;
select * from GutsNCode.POST;
select * from GutsNCode.TEXT;
select * from GutsNCode.IMAGE;
select * from GutsNCode.USERS;
select * from GutsNCode.AUTHORITIES;
select * from GutsNCode.STADISTICS;
select * from GutsNCode.MESSAGE;

select IF((p.POST_ID != 0 or p.POST_ID != null), true, FALSE) FROm POST p where p.POST_ID = 1
select p.POST_ID from POST p where p.POST_ID = 22

-- TRUNCATE TABLE GutsNCode.IMAGE;
-- TRUNCATE TABLE GutsNCode.STADISTICS;
-- TRUNCATE TABLE GutsNCode.MESSAGE;
-- TRUNCATE TABLE GutsNCode.TEXT;
-- TRUNCATE TABLE GutsNCode.POST;
-- TRUNCATE TABLE GutsNCode.IMAGE_OPTION;
-- TRUNCATE TABLE GutsNCode.TYPE_TEXT;
-- TRUNCATE TABLE GutsNCode.TYPE_POST;
-- TRUNCATE TABLE GutsNCode.STATUS;
-- TRUNCATE TABLE GutsNCode.AUTHORITIES;
-- TRUNCATE TABLE GutsNCode.USERS;
-- TRUNCATE TABLE GutsNCode.FOUNDER;
-- 
-- DROP TABLE GutsNCode.IMAGE;	
-- DROP TABLE GutsNCode.TEXT;
-- DROP TABLE GutsNCode.POST;
-- DROP TABLE GutsNCode.TYPE_TEXT;
-- DROP TABLE GutsNCode.TYPE_POST;
-- DROP TABLE GutsNCode.IMAGE_OPTION;
-- DROP TABLE GutsNCode.STATUS;
-- DROP TABLE GutsNCode.STADISTICS;
-- DROP TABLE GutsNCode.MESSAGE;
-- DROP TABLE GutsNCode.FOUNDER;
-- DROP TABLE GutsNCode.AUTHORITIES;
-- DROP TABLE GutsNCode.USERS;

-- delete from GutsNCode.IMAGE;
-- delete from GutsNCode.TEXT;
-- delete from GutsNCode.POST;
-- delete from GutsNCode.FOUNDER;
-- delete from GutsNCode.STATUS;
-- delete from GutsNCode.TYPE_POST;
-- delete from GutsNCode.TYPE_TEXT;
-- delete from GutsNCode.IMAGE_OPTION;
-- delete from GutsNCode.STADISTICS;
-- delete from GutsNCode.MESSAGE;
-- delete from GutsNCode.AUTHORITIES;
-- delete from GutsNCode.USERS;
