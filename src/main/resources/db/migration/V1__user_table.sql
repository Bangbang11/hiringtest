CREATE TABLE IF NOT EXISTS t_user (
    id  bigserial primary key,
    name varchar(255),
    address varchar(255),
    phone varchar(12),
    age INT
);