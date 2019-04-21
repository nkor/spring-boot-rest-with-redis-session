CREATE TABLE `spring_boot_rest_with_redis_session`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `spring_boot_rest_with_redis_session`.`permission` (`name`) VALUES ('READ');
INSERT INTO `spring_boot_rest_with_redis_session`.`permission` (`name`) VALUES ('WRITE');
INSERT INTO `spring_boot_rest_with_redis_session`.`permission` (`name`) VALUES ('DELETE');
