--init  table
CREATE TABLE User (
                      ID VARCHAR(100) NOT NULL PRIMARY KEY,
                      USER_NAME VARCHAR(100) NOT NULL unique ,
                      FULL_NAME VARCHAR(100) NOT NULL,
                      FIRST_NAME VARCHAR(100),
                      PASSWORD VARCHAR(100),
                      MOBILE VARCHAR(20) NOT NULL,
                      EMAIL VARCHAR(100) NOT NULL,
                      PHOTO TEXT,
                      BIRTH_DATE BIGINT,
                      GENDER VARCHAR(100),
                      STATUS VARCHAR(100) NOT NULL
);

CREATE TABLE Role (
                      role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL
);
CREATE TABLE user_role (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           role_id BIGINT NOT NULL,
                           user_id VARCHAR(100) NOT NULL,
                           FOREIGN KEY (role_id) REFERENCES Role(role_id),
                           FOREIGN KEY (user_id) REFERENCES User(ID)
);
CREATE TABLE Product (
                         product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         product_name VARCHAR(255) NOT NULL,
                         description TEXT,
                         cost_Price DOUBLE NOT NULL,
                         current_quantity INT NOT NULL,
                         image VARCHAR(255) NOT NULL,
                         category_id INT NOT NULL,
                         is_deleted BOOLEAN NOT NULL,
                         is_activated BOOLEAN NOT NULL,
                         UNIQUE (product_name, image)
);
CREATE TABLE Category (
                          category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          is_deleted BOOLEAN NOT NULL,
                          is_activated BOOLEAN NOT NULL,
                          UNIQUE (name)
);
CREATE TABLE `Order` (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         order_date TIMESTAMP NOT NULL,
                         total_price DOUBLE NOT NULL,
                         delivery_date TIMESTAMP,
                         shipping_fee DOUBLE NOT NULL,
                         order_status VARCHAR(255) NOT NULL,
                         notes TEXT,
                         customer_id VARCHAR(100) NOT NULL,
                         FOREIGN KEY (customer_id) REFERENCES User(ID)
);
-- Create OrderItem Table
CREATE TABLE OrderItem (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           quantity INT NOT NULL,
                           total_price DOUBLE NOT NULL,
                           order_id BIGINT NOT NULL,
                           product_id BIGINT NOT NULL,
                           FOREIGN KEY (order_id) REFERENCES `Order`(id),
                           FOREIGN KEY (product_id) REFERENCES Product(product_id)
);
CREATE TABLE ShoppingCart (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              user_id VARCHAR(100) NOT NULL,
                                foreign key (user_id) references  User(ID)
);

CREATE TABLE CartItem (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          cart_id BIGINT NOT NULL,
                          product_id BIGINT NOT NULL,
                          quantity INT NOT NULL,
                          FOREIGN KEY (cart_id) REFERENCES ShoppingCart(id),
                          FOREIGN KEY (product_id) REFERENCES Product(product_id)
);


