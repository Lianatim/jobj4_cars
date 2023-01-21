CREATE TABLE body
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table body is 'Таблица с типом кузова';
comment on column body.id is 'Идентификатор';
comment on column body.name is 'Название';