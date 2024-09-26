create table dayz.available_servers (
    id uuid primary key,
    item_id uuid,
    name varchar,
    constraint fk_available_servers_item_id foreign key (item_id) references dayz.items(id) ON DELETE CASCADE
);

INSERT INTO dayz.available_servers (id, item_id, name)
VALUES
    (gen_random_uuid(), (SELECT id FROM dayz.items WHERE name = 'test1'), 'server1.1'),
    (gen_random_uuid(), (SELECT id FROM dayz.items WHERE name = 'test1'), 'server1.2'),
    (gen_random_uuid(), (SELECT id FROM dayz.items WHERE name = 'test2'), 'server2')