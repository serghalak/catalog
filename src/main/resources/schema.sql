create table author (id bigint not null AUTO_INCREMENT, first_name varchar(255), last_name varchar(255), primary key (id));
create table publisher (id bigint not null AUTO_INCREMENT, name varchar(255), address varchar(255), primary key (id));
create table jenre (id bigint not null AUTO_INCREMENT, name varchar(255), primary key (id));