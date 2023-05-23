DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS shopping_cart CASCADE;

CREATE TABLE users (
    id VARCHAR PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

CREATE TABLE reviews (
    id VARCHAR NOT NULL,
    rating INT NOT NULL,
    comments VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE products (
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL,
    price DECIMAL (8,2) NOT NULL,
    category VARCHAR NOT NULL,
    shopping_cart_id VARCHAR NOT NULL,
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart (id)
);

CREATE TABLE shopping_cart (
    id VARCHAR PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);