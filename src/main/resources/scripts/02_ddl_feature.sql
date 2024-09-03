create table feature (
    id uuid primary key,
    info_group_id uuid,
    name varchar(50) not null,
    description varchar(7000),
    constraint fk_feature_info_group_id foreign key (info_group_id) references info_group(id) ON DELETE CASCADE
);

INSERT INTO feature (id, info_group_id, name, description)
VALUES (gen_random_uuid(),'ac350017-26a9-441f-8e51-97f7b13aeefa','value1', 'value1');


INSERT INTO feature (id, info_group_id, name, description)
VALUES (gen_random_uuid(),'ac350017-26a9-441f-8e51-97f7b13aeefa','value2', 'value2');