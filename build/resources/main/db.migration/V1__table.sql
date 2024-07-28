CREATE TABLE products(
    id uuid primary key ,
    name varchar,
    description varchar,
    quantity int,
    cost int,
    delivery boolean,
    date timestamp
)