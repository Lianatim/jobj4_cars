CREATE TABLE transmission
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table transmission is 'Таблица с коробкой передач';
comment on column transmission.id is 'Идентификатор';
comment on column transmission.name is 'Название';