ALTER TABLE auto_post
    ADD COLUMN IF NOT EXISTS car_id int REFERENCES car (id);