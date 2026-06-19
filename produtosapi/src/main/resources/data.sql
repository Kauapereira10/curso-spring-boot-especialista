CREATE TABLE products (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(300),
    price numeric(18, 2)
);