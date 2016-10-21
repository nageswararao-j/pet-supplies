CREATE TABLE `pet_supplies`.`category` (
CAT_ID INT NOT NULL,
NAME VARCHAR(40),
CODE VARCHAR(20),
PRIMARY KEY (CAT_ID)
);

CREATE TABLE `pet_supplies`.`image` (
IMG_ID INT NOT NULL,
NAME VARCHAR(20),
URL VARCHAR(40),
`product_id` int(11) NOT NULL,
PRIMARY KEY (IMG_ID),
KEY `fk_product` (`product_id`),
  CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);


CREATE TABLE `pet_supplies`.`product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(512) NOT NULL,
  `price` float NOT NULL,
  `currency` varchar(10),
  `status` boolean,
  `quantity` int NOT NULL,
  `cat_id` int(11) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_category` (`cat_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
);

commit;

INSERT INTO `pet_supplies`.`category` (`CAT_ID`, `NAME`, `CODE`) VALUES ('100', 'Cats', 'CAT');
INSERT INTO `pet_supplies`.`product` (`product_id`, `name`, `description`, `price`, `currency`, `status`, `quantity`, `cat_id`) VALUES ('1000', 'BENGAL', 'Bengal cat', '2500', 'EUR', '1', '1', '100');
INSERT INTO `pet_supplies`.`images` (`IMG_ID`, `NAME`, `URL`, `product_id`) VALUES ('2', 'Cats', '/images/cats/himalayan.jpg', '1000');

