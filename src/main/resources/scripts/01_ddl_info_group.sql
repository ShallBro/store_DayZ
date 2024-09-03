create table info_group (
    id uuid primary key,
    name varchar not null,
    value varchar not null,
    founder varchar not null,
    description varchar not null,
    motto varchar not null,
    quote varchar not null,
    goals varchar not null,
    lifeInside varchar not null,
    structure varchar not null,
    image varchar not null,
    caruselImg varchar not null
);

INSERT INTO info_group (id, name, value, founder, description, motto, quote, goals, lifeInside, structure)
VALUES (gen_random_uuid(), 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test');


INSERT INTO info_group (id, name, value, founder, description, motto, quote, goals, lifeInside, structure)
VALUES (gen_random_uuid(), 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2');