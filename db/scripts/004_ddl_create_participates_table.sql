CREATE TABLE participates
(
    id      serial PRIMARY KEY,
    auto_post_id int not null REFERENCES auto_post (id),
    auto_user_id int not null REFERENCES auto_user (id)
);