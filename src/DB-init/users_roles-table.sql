CREATE TABLE `spring_boot_rest_with_redis_session`.`users_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `users_roles_role_id_idx` (`role_id` ASC),
  CONSTRAINT `users_roles_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `spring_boot_rest_with_redis_session`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `users_roles_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `spring_boot_rest_with_redis_session`.`role` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

INSERT INTO `spring_boot_rest_with_redis_session`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `spring_boot_rest_with_redis_session`.`users_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `spring_boot_rest_with_redis_session`.`users_roles` (`user_id`, `role_id`) VALUES ('3', '3');
