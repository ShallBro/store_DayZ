create table items (
    id bigint primary key,
    name varchar(150) not null,
    description varchar(1000),
    amount integer not null,
    price integer not null,
    config varchar(100) not null,
    category varchar(100) not null,
    image varchar(200) not null
)