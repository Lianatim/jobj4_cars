ALTER TABLE auto_post
    ADD COLUMN IF NOT EXISTS file_id int REFERENCES file (id);