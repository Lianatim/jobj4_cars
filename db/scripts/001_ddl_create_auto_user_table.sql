create table auto_user
(
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

comment on table auto_user is 'Таблица с пользователями';
comment on column auto_user.id is 'Идентификатор';
comment on column auto_user.login is 'Логин';
comment on column auto_user.password is 'Пароль';