-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2017 at 08:09 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iqueue`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ClearExpiredSessions` (IN `seconds` INT)  NO SQL
BEGIN
	DELETE FROM `sessions` WHERE TIMESTAMPDIFF(SECOND, `sessions`.`timestamp`, NOW()) >= seconds;
    CALL ReturnSuccess();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateAccount` (IN `username` CHAR(60), IN `password` CHAR(60), IN `name` VARCHAR(128))  NO SQL
BEGIN
    IF ((SELECT COUNT(*) FROM `accounts` WHERE `accounts`.`username` = username) = 0) THEN
    	BEGIN
            INSERT INTO `accounts`(`username`, `password`, `name`) VALUES(username, password, name);
            CALL ReturnSuccess();
        END;
	ELSE
    	CALL ReturnError(1001, 'Account creation failed. Account already exists.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateBranch` (IN `brand` VARCHAR(30), IN `name` VARCHAR(60), IN `category` VARCHAR(30), IN `type` CHAR(8), IN `latitude` FLOAT(10,6), IN `longitude` FLOAT(10,6), IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
    	BEGIN
            IF ((SELECT COUNT(*) FROM `branches` WHERE `branches`.`name` = name) = 0) THEN
                BEGIN
                    INSERT INTO `branches`(brand, name, category, type, latitude, longitude, serving) VALUES(brand, name, category, type, latitude, longitude, DEFAULT);
                    CALL ReturnSuccess();
                END;
            ELSE
            	CALL ReturnError(1003, 'Branch creation failed. Branch already exists.');
        	END IF;
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EditAccount` (IN `username` CHAR(60), IN `password` CHAR(60), IN `name` VARCHAR(128), IN `session` CHAR(64))  MODIFIES SQL DATA
BEGIN
	DECLARE account_id CHAR(64);
    SET account_id = (SELECT `sessions`.`account` FROM `sessions` WHERE `sessions`.`session` = session);
    IF (account_id != 0 AND account_id IS NOT NULL) THEN
    	UPDATE `accounts` SET
        `accounts`.`username` = COALESCE(username, `accounts`.`username`),
        `accounts`.`password` = COALESCE(password, `accounts`.`password`),
        `accounts`.`name` = COALESCE(name, `accounts`.`name`)
        WHERE `accounts`.`id` = account_id;
        CALL ReturnSuccess();
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EditBranch` (IN `id` INT, IN `brand` VARCHAR(30), IN `name` VARCHAR(60), IN `category` VARCHAR(30), IN `type` CHAR(8), IN `latitude` FLOAT(10,6), IN `longitude` FLOAT(10,6), IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		UPDATE `branches` SET
        `branches`.`brand` = COALESCE(brand, `branches`.`brand`),
        `branches`.`name` = COALESCE(name, `branches`.`name`),
        `branches`.`category` = COALESCE(category, `branches`.`category`),
        `branches`.`type` = COALESCE(type, `branches`.`type`),
        `branches`.`latitude` = COALESCE(latitude, `branches`.`latitude`),
        `branches`.`longitude` = COALESCE(longitude, `branches`.`longitude`)
        WHERE `branches`.`id` = id;
        CALL ReturnSuccess();
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllBranches` (IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		SELECT * FROM `branches`;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllQueues` (IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		SELECT `queues`.`id`, `accounts`.`username`, `branches`.`name`, `queues`.`entry`, `queues`.`number` FROM `queues` INNER JOIN `accounts` ON `queues`.`account` = `accounts`.`id` INNER JOIN `branches` ON `queues`.`branch` = `branches`.`id` ORDER BY `queues`.`id` ASC;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetBranchesFromBrand` (IN `brand` VARCHAR(30), IN `session` CHAR(64))  NO SQL
BEGIN
    DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
	SELECT * FROM `branches` WHERE `branches`.`brand` = brand;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetBranchesFromCategory` (IN `category` VARCHAR(30), IN `session` CHAR(64))  NO SQL
BEGIN
    DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
	SELECT * FROM `branches` WHERE `branches`.`category` = category;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetServingNumber` (IN `branch` INT, IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		SELECT `branches`.`serving` FROM `branches` WHERE `branches`.`id` = branch;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `JoinQueue` (IN `branch` INT, IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE account_id CHAR(64);
    SET account_id = (SELECT `sessions`.`account` FROM `sessions` WHERE `sessions`.`session` = session);
    IF (account_id != 0 AND account_id IS NOT NULL) THEN
    	BEGIN
            DECLARE already_lined INT;
            SET already_lined = (SELECT COUNT(*) FROM `queues` WHERE `queues`.`account` = account_id);
            IF (already_lined = 0) THEN
            	BEGIN
                    DECLARE last_number INT;
                    SET last_number = COALESCE((SELECT MAX(`queues`.`number`) FROM `queues` WHERE `queues`.`branch` = branch), 0);
                    INSERT INTO `queues`(`queues`.`account`, `queues`.`branch`, `queues`.`entry`, `queues`.`number`) VALUES(account_id, branch, DEFAULT, last_number + 1);
                    CALL ReturnSuccess();
                END;
            ELSE
                CALL ReturnError(1005, 'Account is already in line.');
            END IF;
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LeaveQueue` (IN `branch` INT, IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE account_id CHAR(64);
    SET account_id = (SELECT `sessions`.`account` FROM `sessions` WHERE `sessions`.`session` = session);
    IF (account_id != 0 AND account_id IS NOT NULL) THEN
    	BEGIN
    		DELETE FROM `queues` WHERE `queues`.`account` = account_id AND `queues`.`branch` = branch;
            CALL ReturnSuccess();
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Login` (IN `username` CHAR(60), IN `password` CHAR(60))  NO SQL
BEGIN
	DECLARE user_id INT;
    SET user_id = (SELECT `accounts`.`id` FROM `accounts` WHERE `accounts`.`username` = username AND `accounts`.`password` = password);
	IF (user_id = 0) THEN
    	CALL ReturnError(1002, 'Login failed. Account does not exist.');
    ELSE
    	INSERT INTO `sessions`(`sessions`.`account`, `sessions`.`session`, `sessions`.`timestamp`) VALUES(user_id, SHA2(CONCAT(DATE_FORMAT(NOW(), '%Y-%m-%dT%T.%f'), ABS(RAND() * 100000)), 256), DEFAULT);
        SELECT `sessions`.`session`, `accounts`.`username`, `accounts`.`name` FROM `accounts` INNER JOIN `sessions` ON `accounts`.`id` = `sessions`.`account` WHERE `accounts`.`id` = user_id ORDER BY `sessions`.`timestamp` DESC LIMIT 1;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Logout` (IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE account_id CHAR(64);
    SET account_id = (SELECT `sessions`.`account` FROM `sessions` WHERE `sessions`.`session` = session);
    IF (account_id != 0 AND account_id IS NOT NULL) THEN
    	BEGIN
            DELETE FROM `sessions` WHERE `sessions`.`session` = session;
            CALL ReturnSuccess();
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReturnError` (IN `error_id` INT, IN `error_msg` VARCHAR(255))  NO SQL
CALL ReturnStatus(1, error_id, error_msg)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReturnStatus` (IN `status` INT, IN `status_id` INT, IN `status_msg` VARCHAR(255))  NO SQL
SELECT status, status_id, status_msg$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReturnSuccess` ()  NO SQL
CALL ReturnStatus(0, 1000, 'Success!')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ServeComplete` (IN `branch` INT, IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		BEGIN
        	DECLARE serving INT;
            SET serving = (SELECT `branches`.`serving` FROM `branches` WHERE `branches`.`id` = branch);
            IF (serving IS NOT NULL) THEN
            	BEGIN
            		DELETE FROM `queues` WHERE `queues`.`branch` = branch AND `queues`.`number` = serving;
                    UPDATE `branches` SET `branches`.`serving` = NULL WHERE `branches`.`id` = branch;
                END;
            END IF;
            CALL ReturnSuccess();
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ServeNext` (IN `branch` INT, IN `session` CHAR(64))  NO SQL
BEGIN
	DECLARE valid INT;
    CALL VerifySession(session, valid);
    IF (valid = 1) THEN
		BEGIN
        	DECLARE serving INT;
            SET serving = (SELECT `branches`.`serving` FROM `branches` WHERE `branches`.`id` = branch);
            IF (serving IS NULL) THEN
            	BEGIN
                    DECLARE number INT;
                    SET number = (SELECT MIN(`queues`.`number`) FROM `queues` WHERE `queues`.`branch` = branch);
                    IF (number IS NOT NULL) THEN
                    	UPDATE `branches` SET `branches`.`serving` = number WHERE `branches`.`id` = branch;
                    END IF;
                END;
            END IF;
            CALL ReturnSuccess();
        END;
    ELSE
    	CALL ReturnError(1004, 'Session is invalid. Please login again to access this feature.');
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VerifySession` (IN `session` CHAR(64), OUT `valid` INT)  NO SQL
SET valid = (SELECT COUNT(*) FROM `sessions` WHERE `sessions`.`session` = session)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` char(60) NOT NULL,
  `password` char(60) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `name`) VALUES
(1, 'admin', 'admin', 'Administrator'),
(2, 'user1', 'user1', 'User1'),
(3, 'user2', 'user2', 'User2');

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `id` int(11) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `name` varchar(60) NOT NULL,
  `category` varchar(30) NOT NULL,
  `type` char(8) NOT NULL,
  `latitude` float(10,6) DEFAULT NULL,
  `longitude` float(10,6) DEFAULT NULL,
  `serving` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`id`, `brand`, `name`, `category`, `type`, `latitude`, `longitude`, `serving`) VALUES
(1, 'Apple', 'Trinoma', 'Tech and Gadgets Store', 'BASIC', NULL, NULL, 0),
(2, 'Apple', 'Glorietta', 'Tech and Gadgets Store', 'BASIC', NULL, NULL, 0),
(3, 'Samsung', 'SM North', 'Tech and Gadgets Store', 'BASIC', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `queues`
--

CREATE TABLE `queues` (
  `id` int(11) NOT NULL,
  `account` int(11) NOT NULL,
  `branch` int(11) NOT NULL,
  `entry` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `id` int(11) NOT NULL,
  `account` int(11) NOT NULL,
  `session` char(64) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sessions`
--

INSERT INTO `sessions` (`id`, `account`, `session`, `timestamp`) VALUES
(34, 1, 'b167b2e9944c60ae5cd1e3ab9373f8cf455e470e6ca1319e3ef58425a63a36bb', '2017-06-08 22:56:27'),
(48, 2, '17ffa4c4e3c73911b4ddc5cf6ddc2f55caefb412a6a1a1a19976cd1a4adb08f9', '2017-06-09 00:49:38');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`id`),
  ADD KEY `name` (`name`);

--
-- Indexes for table `queues`
--
ALTER TABLE `queues`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_endpoints` (`branch`),
  ADD KEY `FK_accounts` (`account`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `session` (`session`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `queues`
--
ALTER TABLE `queues`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `sessions`
--
ALTER TABLE `sessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `queues`
--
ALTER TABLE `queues`
  ADD CONSTRAINT `FK_accounts` FOREIGN KEY (`account`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_endpoints` FOREIGN KEY (`branch`) REFERENCES `branches` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
