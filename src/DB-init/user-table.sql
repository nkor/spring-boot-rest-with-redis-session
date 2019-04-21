CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(72) NOT NULL,
  `is_locked` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `spring_boot_rest_with_redis_session`.`user` (`email`, `password`) VALUES ('admin@mail.com', '$2a$12$2yng1.yTG4HWFZ3qHQ2hFu0hHmaSOYLzxrIQwCT5Fk0o0rFCHX9k2');
INSERT INTO `spring_boot_rest_with_redis_session`.`user` (`email`, `password`) VALUES ('nkor@mail.com', '$2a$12$TUWGGA1lpNW6cvQRYuR68edKnv6MnxhO7dYaT39jemWHbW3iwXvaS');
INSERT INTO `spring_boot_rest_with_redis_session`.`user` (`email`, `password`) VALUES ('anon@mail.com', '$2a$12$QokNl7DuO0r8LgZipAaO/.JapUcMUEOJqe0C8laQZ.faQ.x4kXArK');
