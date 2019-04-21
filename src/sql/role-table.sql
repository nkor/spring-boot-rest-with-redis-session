CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `spring_boot_rest_with_redis_session`.`role` (`name`) VALUES ('ADMIN');
INSERT INTO `spring_boot_rest_with_redis_session`.`role` (`name`) VALUES ('USER');
INSERT INTO `spring_boot_rest_with_redis_session`.`role` (`name`) VALUES ('GUEST');
