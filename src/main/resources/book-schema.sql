DROP TABLE IF EXISTS `book` CASCADE;
CREATE TABLE `book` (
                     `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                     `name` VARCHAR(255) NOT NULL UNIQUE,
                     `genre` VARCHAR(255),
                     `rating` INTEGER,
                     `price` INTEGER CHECK (price >= 1 AND price <= 100)
                    );