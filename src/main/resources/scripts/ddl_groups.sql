create table group_stalker (
    id serial primary key,
    name varchar(70) not null,
    imageUrl varchar(150) not null,
    pathUrl varchar(70) not null
);

INSERT INTO group_stalker (name, imageUrl, pathUrl)
VALUES ('test2', 'test2', 'test2');


INSERT INTO group_stalker (name, imageUrl, pathUrl)
VALUES ('test2', 'test2', 'test2');