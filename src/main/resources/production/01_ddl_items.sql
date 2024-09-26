CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table dayz.items (
    id uuid primary key,
    name varchar,
    description varchar,
    amount integer,
    price integer,
    config varchar,
    category varchar,
    image varchar
);

INSERT INTO dayz.items (id, name, description, amount, price, config, category, image)
VALUES
    (gen_random_uuid(), 'test1', 'test1', 1, 1, 'test1', 'test1', 'test1'),
    (gen_random_uuid(), 'test2', 'test2', 2, 2, 'test2', 'test2', 'test2')