create table com_example_store_dayz.feature (
    id uuid primary key,
    info_group_id uuid REFERENCES com_example_store_dayz.info_group(id) ON DELETE SET NULL,
    name varchar,
    description varchar
);

INSERT INTO com_example_store_dayz.feature (id, info_group_id, name, description)
VALUES
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Долг') ,'Чувство товарищества', 'Несмотря на строгую дисциплину, в «Долге» царит атмосфера взаимопомощи и братства. Общие цели и опасности сплачивают членов группировки.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Долг') , 'Постоянная борьба', '«Долг» постоянно противостоит как угрозам Зоны, так и другим группировкам, что делает жизнь в группировке полную вызовов и требует готовности к непрерывной борьбе.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Долг') , 'Стратегическое планирование', 'Каждая операция и патруль тщательно планируются с целью минимизации рисков и максимизации эффективности, что позволяет «Долгу» успешно противостоять угрозам.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Долг') , 'Жертвенность ради большой цели', 'Идеология «Долга» подразумевает, что любые жертвы оправданы, если они ведут к защите человечества от опасностей Зоны. Это порождает высокий уровень самоотдачи у членов группировки.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Свобода') , 'Свобода и независимость', 'Основной принцип «Свободы» — право на свободу передвижения и исследование Зоны, противодействие любым формам контроля.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Свобода') , 'Взаимопомощь и поддержка', 'Несмотря на анархистские взгляды, в «Свободе» ценятся взаимопомощь и поддержка между членами группировки.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Свобода') , 'Развитие и обучение', 'В «Свободе» большое внимание уделяется развитию и обучению, членам группировки активно изучают Зону и делятся знаниями.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Свобода') , 'Гибкость и адаптивность', 'Децентрализованная структура и коллективное принятие решений позволяют «Свободе» быстро адаптироваться к изменяющимся условиям.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Монолит') , 'Религиозный фанатизм', 'Фанатическая преданность культу Монолита. Члены группы готовы защищать его до последнего.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Монолит') , 'Жесткая дисциплина', 'Строгая дисциплина и иерархия, бойцы беспрекословно подчиняются приказам лидеров.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Монолит') , 'Ритуалы и обряды', 'Жизнь наполнена религиозными ритуалами и обрядами, подчеркивающими веру и преданность Монолиту.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Монолит') , 'Агрессивная защита', 'Агрессивная защита территорий и тайн от посторонних. Члены готовы идти на любые меры для сохранения священных знаний.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Наемники') , 'Профессионализм', 'Высокий уровень профессионализма и эффективность в выполнении заданий. Наемники известны своей надежностью.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Наемники') , 'Гибкость', 'Гибкая структура и возможность выбирать заказы по собственному усмотрению. Работа с различными клиентами и группировками.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Наемники') , 'Независимость', 'Работа на условиях клиентов без долгосрочных обязательств. Наемники ценят свою независимость и свободу выбора.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Наемники') , 'Репутация', 'Сохранение высокой репутации и доверия среди клиентов. Быстрое и качественное выполнение заказов помогает поддерживать положительный имидж.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Учёные') ,'Научное исследование', 'Основное направление деятельности — исследование аномалий и артефактов Зоны. Сбор и анализ данных для научных целей.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Учёные') , 'Развитие технологий', 'Создание новых технологий на основе изученных материалов и данных из Зоны. Работы по улучшению существующих технологий.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Учёные') , 'Интеллектуальный обмен', 'Обмен результатами исследований и развитие интеллектуального потенциала группы. Участие в конференциях и симпозиумах.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Учёные') , 'Соблюдение этики', 'Важность соблюдения этических норм при проведении исследований и экспериментов. Члены группы обязаны следовать научным стандартам и принципам.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Чистое Небо'), 'Научный подход', 'Чистое Небо" придерживается научного подхода к изучению Зоны. Они проводят исследования и эксперименты, чтобы лучше понять её природу и феномены.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Чистое Небо'), 'Экспедиции и исследования', 'Члены "Чистого Неба" часто отправляются в экспедиции и исследования, рискуя своей жизнью ради получения новых знаний и данных о Зоне.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Чистое Небо'), 'Интеллект и любопытство', 'В "Чистом Небе" ценятся интеллект, любопытство и стремление к знаниям. Члены группировки постоянно учатся и обмениваются опытом друг с другом.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Чистое Небо'), 'Защита и безопасность', '"Чистое Небо" уделяет большое внимание защите и безопасности своих членов. Командиры и лидеры координируют действия группировки и обеспечивают безопасность во время экспедиций.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Грех'), 'Оккультные практики', '"Грех" занимается оккультными практиками и ритуалами, стремясь раскрыть тайны Зоны и использовать её силу для достижения своих целей.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Грех'), 'Исследование аномалий', 'Члены "Греха" активно исследуют аномалии и артефакты Зоны, пытаясь понять их природу и использовать их силы в своих интересах.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Грех'), 'Мистицизм и таинственность', 'Внутри "Греха" царит атмосфера мистики и таинственности. Члены группировки стремятся к личной силе и могуществу, следуя строгим правилам и ритуалам.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Грех'), 'Скрытность и секретность', '"Грех" действует скрытно и секретно, избегая внимания других группировок и сталкеров. Их цели и методы остаются загадкой для большинства обитателей Зоны.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Ренегаты'), 'Полная свобода', 'Ренегаты отвергают все формы контроля и подчинения, живя по своим собственным законам и правилам.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Ренегаты'), 'Мародёрство и бандитизм', 'Ренегаты часто действуют как мародёры и бандиты, нападая на других сталкеров и группировки ради ресурсов и выживания.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Ренегаты'), 'Отсутствие иерархии', 'Внутри ренегатов нет строгой иерархии или структуры. Каждый член действует самостоятельно или в небольших группах.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Ренегаты'), 'Сила и выживание', 'Только сила и умение выживать определяют место ренегата в группе. Лидеры возникают естественным образом, на основе их способностей.'),

    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Люди Бармена'), 'Взаимопомощь и поддержка', 'Люди Бармена объединяются под принципами взаимопомощи и поддержки, помогая друг другу выживать в Зоне.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Люди Бармена'), 'Торговля и обмен информацией', 'Группа занимается торговлей и обменом информацией, обеспечивая себя необходимыми ресурсами и сведениями о Зоне.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Люди Бармена'), 'Единство и доверие', 'Внутри группы царит атмосфера единства и доверия, где каждый готов прийти на помощь другому.'),
    (gen_random_uuid(), (SELECT id FROM com_example_store_dayz.info_group WHERE name = 'Люди Бармена'), 'Руководство Бармена', 'Бармен играет ключевую роль в группе, координируя её действия и обеспечивая безопасность и выживание св)