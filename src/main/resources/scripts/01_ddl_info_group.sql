create schema if not exists dayz;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table dayz.info_group (
    id uuid primary key,
    name varchar ,
    value varchar ,
    founder varchar ,
    description varchar,
    motto varchar ,
    quote varchar ,
    goals varchar ,
    lifeInside varchar ,
    structure varchar ,
    image varchar ,
    caruselImg varchar
);

INSERT INTO dayz.info_group (id, name, value, founder, description, motto, quote, goals, lifeInside, structure)
VALUES ('ac350017-26a9-441f-8e51-97f7b13aeefa', 'test', 'test', 'test', 'test', 'neutrals', 'test', 'test', 'test', 'test');

INSERT INTO dayz.info_group (id, name, value, founder, description, motto, quote, goals, lifeInside, structure)
VALUES (gen_random_uuid(), 'test2', 'test2', 'test2', 'test2', 'rassvet', 'test2', 'test2', 'test2', 'test2');