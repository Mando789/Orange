CREATE TABLE DIALS (
    ID INT auto_increment primary key,
    MSISDN LONG,
    GROUP_ID INT DEFAULT NULL
);

CREATE TABLE GIFT(
   ID INT primary key,
   NAME VARCHAR(25)
);

CREATE TABLE GROUPS (
    ID INT primary key,
    GIFT_ID INT
);

CREATE TABLE COUNTER(
 ID INT auto_increment primary key,
 MSISDN LONG,
 GIFT_ID INT,
 COUNTER INT
);

CREATE TABLE HREDEMPTION(
    ID INT auto_increment primary key,
    MSISDN LONG,
    GIFT_ID INT,
    GROUP_ID INT,
    REDEMPTION_DATE DATE

);