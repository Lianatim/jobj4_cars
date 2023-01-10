CREATE TABLE auto_post
(
    id           SERIAL PRIMARY KEY,
    text         TEXT      NOT NULL,
    created      TIMESTAMP NOT NULL,
    auto_user_id INT       NOT NULL REFERENCES auto_user (id)
);

comment on table auto_post is 'Таблица с объявлениями';
comment on column auto_post.id is 'Идентификатор';
comment on column auto_post.description is 'Описание';
comment on column auto_post.created is 'Дата создания';
comment on column auto_post.auto_user_id is 'Идентификатор пользователя';
