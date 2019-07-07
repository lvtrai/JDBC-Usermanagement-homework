CREATE DATABASE jsp03 CHARACTER SET utf8 COLLATE utf8_general_ci;

USE jsp03;

/* CRAETE TABLE */
CREATE TABLE `user`(
	`id` INT AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50),
    `age` INT(100),
    PRIMARY KEY(`id`)
);
INSERT INTO `user` (`username`,`password`,`age`)VALUES('trai','123456',20);

INSERT INTO `user` (`username`,`password`,`age`) VALUES('tri','123457',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('tru','1234a6',19);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('truong','123456e',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('dung','123456g',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('hung','123456',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('trai','123456',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('tri1','123457',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('nga1','1234a6',19);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('in1','123456e',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('han','123456g',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('bun','123456',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('tring','1234e7',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('trai','1234a6',19);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('tro','12345ue',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('quoc','1234l6g',15);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('bao','12wa3456',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('bo','123457',20);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('hu','123q4a6',19);

INSERT INTO `user` (`username`,`password`,`age`)VALUES('tu','12356e',15);
