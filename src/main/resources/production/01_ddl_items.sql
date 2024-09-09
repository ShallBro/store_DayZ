CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table dayz.items (
    id bigint primary key,
    name varchar,
    description varchar,
    amount integer,
    price integer,
    config varchar,
    category varchar,
    image varchar
)