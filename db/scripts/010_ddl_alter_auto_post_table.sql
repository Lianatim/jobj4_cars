ALTER TABLE auto_post ADD COLUMN photo BYTEA;
comment on column auto_post.photo is 'Фотография';