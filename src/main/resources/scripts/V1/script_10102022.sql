start transaction ;
CREATE TABLE `microservice_product`.`products` ( `id` INT NOT NULL AUTO_INCREMENT , `title` VARCHAR(100) NOT NULL , `exit_date` DATETIME NOT NULL , `price` FLOAT NOT NULL , `image` VARCHAR(100) NOT NULL , `format` VARCHAR(100) NOT NULL , `status` VARCHAR(100) NOT NULL , `summary` TEXT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

INSERT INTO `products` (`id`, `title`, `exit_date`, `price`, `image`, `format`, `status`, `summary`) VALUES (NULL, 'La guerra de los mundos', '2005-03-12 00:00:00', '200', 'https://pics.filmaffinity.com/La_guerra_de_los_mundos-956978195-large.jpg', 'DVD', 'USADO', 'Cuando la Tierra es invadida por los alienígenas, Ray Ferrier se ve obligado a luchar por sobrevivir y salvar la vida de su familia.');
INSERT INTO `products` (`id`, `title`, `exit_date`, `price`, `image`, `format`, `status`, `summary`) VALUES (NULL, 'Alicia en el país de las maravillas', '2010-09-07 00:00:00', '500', 'https://www.cinemascomics.com/wp-content/uploads/2017/08/vqwzy2hjB9POw413sW5CwrcW0m9.jpg', 'DVD', 'USADO', 'Alicia, ahora una joven de 19 años de edad, regresa al País de las Maravillas para encontrar su verdadero destino y terminar con el gobierno de terror de la malvada reina Roja.');

CREATE TABLE `microservice_product`.`genders` ( `id` INT NOT NULL AUTO_INCREMENT , `description` VARCHAR(200) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
ALTER TABLE `products` ADD `gender_id` INT NOT NULL AFTER `summary`;

INSERT INTO `genders` (`id`, `description`) VALUES (NULL, 'Ciencia ficción'), (NULL, 'Aventura');
ALTER TABLE `products` ADD CONSTRAINT `genderRestrict` FOREIGN KEY (`gender_id`) REFERENCES `genders`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE `microservice_product`.`persons` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , `lastname` VARCHAR(100) NOT NULL , `person_type` VARCHAR(20) NOT NULL , `product_id` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
INSERT INTO `persons` (`id`, `name`, `lastname`, `person_type`, `product_id`) VALUES (NULL, 'Tom', 'Cruise', 'ACTOR', '1');

CREATE TABLE `microservice_product`.`persons` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `description` varchar(200) NOT NULL,
    `amount` float NOT NULL,
    `end_date` datetime(6) DEFAULT NULL,
    `start_date` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB;

INSERT INTO `discounts` (`id`, `name`, `description`, `amount`, `end_date`, `start_date`) VALUES (NULL, 'descuento 1', 'esto es un descuento 1', '200', '2022-09-12 00:00:00.000000', '2022-09-06 00:00:00.000000');


CREATE TABLE`microservice_product`.`products_discounts` (
                                    `product_id` int(11) NOT NULL,
                                    `discount_id` int(11) NOT NULL,
                                    PRIMARY KEY (`product_id`,`discount_id`),
                                    KEY `discount_id` (`discount_id`)
                                  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `products_discounts` (`product_id`, `discount_id`) VALUES ('1', '1');


commit ;