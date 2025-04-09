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

create table cricket_match(
id bigint primary key auto_increment,
venue varchar(256),
match_date date not null,
overs int,
match_type varchar(10) not null,
series_name varchar(256),
team_a_id bigint not null,
team_b_id bigint not null
);