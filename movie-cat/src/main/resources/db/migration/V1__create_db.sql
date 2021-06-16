CREATE DATABASE movies;
USE movies;

create table movie (id bigint not null auto_increment, date date, description longtext, image_url varchar(255), name varchar(255), short_description varchar(255), user_id bigint, primary key (id));
create table movie_comments (id bigint not null auto_increment, comments varchar(255), date date, rating integer, movie_id bigint, user_id bigint, primary key (id));
create table user (id bigint not null auto_increment, login varchar(255), password varchar(255), user_name varchar(255), primary key (id));
alter table movie add constraint FKnvsn9b9a8fok8dh383pspnxlq foreign key (user_id) references user(id);
alter table movie_comments add constraint FK96sfs80ga99a5d3lv2krya48g foreign key (movie_id) references movie(id);
alter table movie_comments add constraint FKjmb1mugjm9oivpxyd56ome82i foreign key (user_id) references user(id);

--CREATE USER 'movie_user'@'%' IDENTIFIED BY 'password';

--GRANT ALL PRIVILEGES ON movies.* TO 'movie_user'@'%';