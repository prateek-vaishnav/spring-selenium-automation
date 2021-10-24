DROP TABLE if EXISTS user;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:tables/user_visa.csv');