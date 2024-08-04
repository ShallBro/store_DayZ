create schema com_example_store_dayz;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table com_example_store_dayz.items (
                                              id bigint primary key,
                                              name varchar,
                                              description varchar,
                                              amount integer,
                                              price integer,
                                              config varchar,
                                              category varchar,
                                              image varchar
)

