DROP TABLE IF EXISTS `bank`.`codes`;
CREATE  TABLE `bank`.`codes` (

  `id` INT NOT NULL AUTO_INCREMENT,

  `confirmation_codes` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `confirmation_codes_UNIQUE` (`confirmation_codes` ASC) );