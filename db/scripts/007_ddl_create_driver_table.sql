CREATE TABLE IF NOT EXISTS driver
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL,
    auto_user_id INT REFERENCES auto_user (id)
);

comment on table driver is 'Таблица с водителями';
comment on column driver.id is 'Идентификатор';
comment on column driver.name is 'Имя';
comment on column driver.auto_user_id is 'Идентификатор пользователя';