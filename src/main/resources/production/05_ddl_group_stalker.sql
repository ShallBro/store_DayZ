create table dayz.group_stalker (
                                                      id serial primary key,
                                                      name varchar,
                                                      imageUrl varchar,
                                                      pathUrl varchar
);

INSERT INTO dayz.group_stalker (name, imageUrl, pathUrl)
VALUES
    ('Нейтралы', 'https://i.ibb.co/xSYTpvB/neutrals-logo.png', 'neutrals'),
    ('Люди Бармена', 'https://i.ibb.co/cXg3bxd/lb-logo.png', 'lb'),
    ('Чистое Небо', 'https://i.ibb.co/D1d8FdM/rassvet-logo.png', 'rassvet'),
    ('ОКСОП', 'https://i.ibb.co/XXBYC6G/oksop-logo.png', 'oksop'),
    ('Грех', 'https://i.ibb.co/3k2ZSfd/greh-logo.png', 'greh'),
    ('Ренегаты', 'https://i.ibb.co/hVMbLwh/renegati-logo.png', 'renegati'),
    ('Монолит', 'https://i.ibb.co/QnzLHD6/monolit-logo.png', 'monolit'),
    ('Охрана Деревни', 'https://i.ibb.co/zNcWRzb/odinochki-logo.png', 'odinochki'),
    ('Ученые', 'https://i.ibb.co/zsZfm2m/ychenie-logo.png', 'nayka'),
    ('Наемники', 'https://i.ibb.co/2nxD54Z/naemniki-logo.png', 'naemniki'),
    ('Братва', 'https://i.ibb.co/t85RLXX/bratva-logo.png', 'bratva'),
    ('Свобода', 'https://i.ibb.co/hB8sdY9/svoboda-logo.png', 'svoboda'),
    ('Долг', 'https://i.ibb.co/Fnr4dVZ/dolg-logo.png', 'dolg'),
    ('Военные сталкеры', 'https://i.ibb.co/4870kNR/voenstalker-logo.png', 'voenstalker');