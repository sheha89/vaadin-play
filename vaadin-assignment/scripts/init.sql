create database custom_item;
use custom_item;

CREATE TABLE CUSTOM_ITEM(
    id INT NOT NULL auto_increment,
    NAME VARCHAR(50) NOT NULL,
    PRICE VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);