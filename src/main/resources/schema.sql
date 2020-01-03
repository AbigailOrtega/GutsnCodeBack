CREATE TABLE FOUNDER (
   FOUNDER_ID IDENTITY NOT NULL PRIMARY KEY,
   NAME VARCHAR(50) NOT NULL,
   LAST_NAME VARCHAR(20) NOT NULL,
   SECOND_LAST_NAME VARCHAR(20) NOT NULL,
   PHOTO BLOB(1000K),
   SUMMARY VARCHAR(1000) NOT NULL,
   EMAIL VARCHAR(200) NOT NULL,
   PASSWORD VARCHAR(2000) NOT NULL
);

CREATE TABLE MESSAGE(
  MESSAGE_ID IDENTITY NOT NULL PRIMARY KEY,
  MESSAGE_TEXT VARCHAR(100) NOT NULL,
  SENDER_ID INTEGER NOT NULL,
  RECEIVER_ID INTEGER NOT NULL,
  CLASSIFICATION VARCHAR(30) NOT null,
  DATE_RECEIVE DATE NOT NULL,
  STATUS BOOLEAN NOT NULL,
  foreign key (SENDER_ID) references FOUNDER(FOUNDER_ID),
  foreign key (RECEIVER_ID) references FOUNDER(FOUNDER_ID)
);

CREATE TABLE STATUS(
	STATUS_ID IDENTITY NOT NULL PRIMARY KEY,
	NAME VARCHAR(30) NOT NULL,
	DESCRIPTION VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS TYPE_POST(
	TYPE_POST_ID IDENTITY NOT NULL PRIMARY KEY,
	NAME VARCHAR(30) NOT NULL,
	DESCRIPTION VARCHAR(100) NOT NULL
	);

CREATE TABLE IF NOT EXISTS TYPE_TEXT(
	TYPE_TEXT_ID IDENTITY NOT NULL PRIMARY KEY,
	NAME VARCHAR(30) NOT NULL,
	DESCRIPTION VARCHAR(100) NOT NULL
	);


CREATE TABLE IF NOT EXISTS POST(
	POST_ID IDENTITY NOT NULL PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	NUMBER_VIEW INTEGER NOT NULL,
	STATUS_ID INTEGER not null,
	TOPIC VARCHAR(100) NOT NULL,
	LAST_UPDATE DATE NOT NULL,
	WRITTER_ID INTEGER NOT NULL,
	REVIEWER_ID INTEGER NOT NULL,
	DATE_REVIEWER DATE,
	TYPE_POST_ID INTEGER NOT NULL,
	TITLE VARCHAR(120) NOT NULL,
	LOCATION VARCHAR(100) NOT NULL,
	PARENT_ID INTEGER ,
	CHILD_ID INTEGER,
    IMAGE BLOB(200K),
	foreign key (STATUS_ID) references STATUS(STATUS_ID),
	foreign key (WRITTER_ID) references FOUNDER(FOUNDER_ID),
	foreign key (REVIEWER_ID) references  FOUNDER(FOUNDER_ID),
	foreign key (TYPE_POST_ID) references TYPE_POST(TYPE_POST_ID),
	foreign key (PARENT_ID) references POST(POST_ID),
	foreign key (CHILD_ID) references POST(POST_ID)
);

CREATE TABLE IF NOT EXISTS TEXT(
    TEXT_ID IDENTITY NOT NULL PRIMARY KEY,
    TYPE_TEXT_ID INTEGER NOT NULL,
    POST_ID INTEGER NOT NULL,
    TEXT_BETA VARCHAR(10000) NOT NULL,
    TEXT_REALIZE VARCHAR(10000) NOT NULL,
    foreign key (POST_ID) references POST(POST_ID),
    foreign key (TYPE_TEXT_ID) references TYPE_TEXT(TYPE_TEXT_ID)
);

CREATE TABLE IF NOT EXISTS IMAGE(
    IMAGE_ID IDENTITY NOT NULL PRIMARY KEY,
    IMAGE_NAME VARCHAR(30) NOT NULL,
    DESCRIPTION VARCHAR(50),
    IMAGE BLOB(1000K),
    TEXT_ID INTEGER NOT NULL,
    FOOTER VARCHAR(100) NOT NULL,
    CARDINALITY VARCHAR(100) NOT NULL,
    foreign key (TEXT_ID) references TEXT(TEXT_ID)
);

CREATE TABLE IF NOT EXISTS STADISTICS(
    STAT_ID IDENTITY NOT NULL PRIMARY KEY,
    STAT_NAME VARCHAR(30) NOT NULL,
    STAT_VALUE VARCHAR(30) NOT NULL,
    STAT_DATE DATE NOT NULL
);

create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);
create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);