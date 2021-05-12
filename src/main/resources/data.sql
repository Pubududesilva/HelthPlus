INSER INTO user (username,password,enabled) values ('user','pass',true);

INSER INTO user (username,password,enabled) values ('admin','pass',true);

INSER INTO authorities (username,authority) values ('user','ROLE_USER');

INSER INTO authorities (username,authority) values ('admin','ROLE_ADMIN');