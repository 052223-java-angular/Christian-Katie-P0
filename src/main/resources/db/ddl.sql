DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS shopping_cart CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS order_history CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;

--- Creating Tables ---
CREATE TABLE roles(
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE users (
    id VARCHAR PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role_id VARCHAR NOT NULL
    --FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE reviews (
    id VARCHAR NOT NULL,
    rating INT NOT NULL,
    comments VARCHAR NOT NULL,
    user_id VARCHAR NOT NULL,
    product_id VARCHAR NOT NULL
    --FOREIGN KEY (user_id) REFERENCES users (id),
    --FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE cart_items(
    id VARCHAR PRIMARY KEY,
    price DECIMAL (8,2) NOT NULL,
    quantity INT NOT NULL,
    shpc_id VARCHAR NOT NULL
    --FOREIGN KEY (shpc_id) REFERENCES shopping_cart (id)
);

CREATE TABLE order_history(
    id VARCHAR PRIMARY KEY,
    created_at DATE NOT NULL, 
    time_stamp TIME NOT NULL,
    user_id VARCHAR NOT NULL
    --FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_items(
    id VARCHAR PRIMARY KEY,
    order_history_id VARCHAR NOT NULL
    --FOREIGN KEY (order_history_id) REFERENCES order_history (id)
);

CREATE TABLE products (
    id VARCHAR PRIMARY KEY,
    name VARCHAR NOT NULL,
    price DECIMAL (8,2) NOT NULL,
    category VARCHAR NOT NULL,
    cart_id VARCHAR NOT NULL,
    order_item_id VARCHAR NOT NULL
    --FOREIGN KEY (cart_id) REFERENCES cart_items (id),
    --FOREIGN KEY (order_item_id) REFERENCES order_items (id)
);

CREATE TABLE shopping_cart (
    id VARCHAR PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    quantity INT NOT NULL
    --FOREIGN KEY (user_id) REFERENCES users (id)
);





--- Adding Foreign Keys ---
alter table reviews
	add foreign key (user_id) references users (id);
	
alter table reviews
	add foreign key (product_id) references products (id);

alter table products 
	add foreign key (cart_id) references cart_items (id);

alter table products
	add foreign key (order_item_id) references order_items (id);

alter table cart_items
	add foreign key (shpc_id) references shopping_cart (id); 

alter table order_history
	add foreign key (user_id) references users (id);

alter table order_items
	add foreign key (order_history_id) references order_history (id);

alter table shopping_cart 
	add foreign key (user_id) references users (id);


