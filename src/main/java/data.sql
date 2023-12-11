CREATE TABLE product
(
    id  SERIAL PRIMARY KEY,
    name VARCHAR(255)  NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);


CREATE TABLE customer
(
    id  SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE customer_order
(
    id     SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);

INSERT INTO customer (name)
VALUES ('John Smith'),
       ('Alice Johnson'),
       ('Bob Davis'),
       ('Eve Wilson'),
       ('Michael Jones'),
       ('Emily Williams'),
       ('David Miller'),
       ('Sarah Taylor'),
       ('Mary Brown'),
       ('James Anderson');

INSERT INTO product (name, price)
VALUES ('iPhone 13 Smartphone', 999.99),
       ('Dell XPS 15 Laptop', 1499.99),
       ('Samsung Galaxy Tab S7 Tablet', 499.99),
       ('Apple MacBook Air Laptop', 1299.99),
       ('Google Pixel 6 Smartphone', 799.99),
       ('HP Spectre x360 Laptop', 1199.99),
       ('Sony PlayStation 5 Console', 549.99),
       ('Microsoft Xbox Series X Console', 499.99),
       ('Nintendo Switch Console', 299.99),
       ('Sony WH-1000XM4 Wireless Headphones', 349.99);

INSERT INTO customer_order (customer_id, product_id)
VALUES (1, 1),
       (2, 2),
       (1, 3),
       (3, 4),
       (4, 2),
       (2, 3),
       (3, 1),
       (1, 5),
       (2, 4),
       (3, 6),
       (5, 7),
       (6, 8),
       (7, 9),
       (8, 10);