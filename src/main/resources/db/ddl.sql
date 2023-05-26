DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS shopping_carts CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;


CREATE TABLE roles(
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE users (
    id VARCHAR PRIMARY KEY,
    username VARCHAR NOT null UNIQUE,
    password VARCHAR NOT NULL,
    role_id VARCHAR NOT null,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE shopping_carts (
    id VARCHAR PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE categories (
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE products (
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL,
    price INTEGER NOT NULL,
    category_id VARCHAR NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE reviews (
    id VARCHAR NOT NULL,
    rating INTEGER NOT NULL,
    comments VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE cart_items(
    id VARCHAR PRIMARY KEY,
    price INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    shopping_cart_id VARCHAR NOT NULL,
    product_id VARCHAR NOT null,
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_carts (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE orders(
    id VARCHAR PRIMARY KEY,
    created_at TIMESTAMP NOT NULL, 
    total_cost INTEGER NOT NULL,
    user_id VARCHAR NOT null,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_items(
    id VARCHAR PRIMARY KEY,
    quantity INTEGER NOT NULL,
    price INTEGER NOT NULL,
    order_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);