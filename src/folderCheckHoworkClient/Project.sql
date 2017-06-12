
/* Drop Tables */

DROP TABLE househost CASCADE CONSTRAINTS;
DROP TABLE payment CASCADE CONSTRAINTS;
DROP TABLE housemanagement CASCADE CONSTRAINTS;
DROP TABLE houseinformation CASCADE CONSTRAINTS;
DROP TABLE housememer CASCADE CONSTRAINTS;
DROP TABLE MainBoard CASCADE CONSTRAINTS;
DROP TABLE MBITinformation CASCADE CONSTRAINTS;
DROP TABLE photoboard CASCADE CONSTRAINTS;
DROP TABLE schedule CASCADE CONSTRAINTS;
DROP TABLE webmanager CASCADE CONSTRAINTS;
DROP TABLE webMember CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE househost
(
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	membertype varchar2(15) NOT NULL
);


CREATE TABLE houseinformation
(
	housename varchar2(50) NOT NULL,
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	houseinformation varchar2(2000),
	availableroom number,
	PRIMARY KEY (housename)
);


CREATE TABLE housemanagement
(
	housename varchar2(50) NOT NULL,
	memberid varchar2(15) NOT NULL UNIQUE
);


CREATE TABLE housememer
(
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	membertype varchar2(3) NOT NULL
);


CREATE TABLE MainBoard
(
	boardnum number NOT NULL UNIQUE,
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	MainBoardtitle varchar2(1000),
	MainBoardcontent varchar2(2000),
	memberid varchar2(100),
	inputdate date,
	PRIMARY KEY (boardnum)
);


CREATE TABLE MBITinformation
(
	MBITnum number NOT NULL UNIQUE,
	MBITtype varchar2(200),
	PRIMARY KEY (MBITnum)
);


CREATE TABLE payment
(
	paynum number NOT NULL,
	memberid varchar2(15) NOT NULL UNIQUE,
	paytitle varchar2(500) NOT NULL,
	paymonth varchar2(25) NOT NULL,
	payrate number NOT NULL,
	PRIMARY KEY (paynum)
);


CREATE TABLE photoboard
(
	photonum number NOT NULL UNIQUE,
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	phototext varchar2(2000),
	phototitle varchar2(200),
	photouploadname varchar2(500),
	photosavename varchar2(500),
	PRIMARY KEY (photonum)
);


CREATE TABLE schedule
(
	schedulenum number NOT NULL UNIQUE,
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	schedulename varchar2(100),
	schedulecontent varchar2(1000),
	PRIMARY KEY (schedulenum)
);


CREATE TABLE webmanager
(
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	membertype varchar2(3) NOT NULL
);


CREATE TABLE webMember
(
	-- 사용자아이디
	id varchar2(15) NOT NULL UNIQUE,
	password varchar2(25) NOT NULL,
	membertype varchar2(15),
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE housemanagement
	ADD FOREIGN KEY (housename)
	REFERENCES houseinformation (housename)
;


ALTER TABLE payment
	ADD FOREIGN KEY (memberid)
	REFERENCES housemanagement (memberid)
;


ALTER TABLE househost
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE houseinformation
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE housememer
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE MainBoard
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE photoboard
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE schedule
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;


ALTER TABLE webmanager
	ADD FOREIGN KEY (id)
	REFERENCES webMember (id)
;



