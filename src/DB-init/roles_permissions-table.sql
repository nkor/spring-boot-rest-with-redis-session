CREATE TABLE `spring_boot_rest_with_redis_session`.`roles_permissions` (
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`),
  INDEX `roles_permissions_permission_id_idx` (`permission_id` ASC),
  CONSTRAINT `roles_permissions_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `spring_boot_rest_with_redis_session`.`role` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `roles_permissions_permission_id`
    FOREIGN KEY (`permission_id`)
    REFERENCES `spring_boot_rest_with_redis_session`.`permission` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('1', '1');
INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('1', '2');
INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('1', '3');
INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('2', '1');
INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('2', '2');
INSERT INTO `spring_boot_rest_with_redis_session`.`roles_permissions` (`role_id`, `permission_id`) VALUES ('3', '1');
