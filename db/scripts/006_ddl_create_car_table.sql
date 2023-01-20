CREATE TABLE car
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL,
    created   TIMESTAMP NOT NULL,
    engine_id INT       NOT NULL REFERENCES engine (id),
    transmission_id INT       NOT NULL REFERENCES transmission (id),
    body_id INT       NOT NULL REFERENCES body (id)
);

comment on table car is 'Таблица с автомобилями';
comment on column car.id is 'Идентификатор';
comment on column car.name is 'Название';
comment on column car.engine_id is 'Идентификатор двигателя';
comment on column car.transmission_id is 'Идентификатор коробки передач';
comment on column car.body_id is 'Идентификатор кузова';