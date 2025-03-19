create schema stump_vision;

use stump_vision;

create table team (
id INT primary key auto_increment,
team_name varchar(128) unique not null,
short_name varchar(10) unique not null,
country varchar(50),
created_at timestamp default current_timestamp
);

SELECT * FROM stump_vision.team;

SELECT count(*) FROM stump_vision.team;

desc team;

create table crick_match(
id int primary key
);