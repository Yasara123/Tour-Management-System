-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2015 at 09:34 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tourcomfinal3`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `address_ID` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `street` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`address_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`address_ID`, `num`, `street`, `city`) VALUES
(1, 121, 'temple Rd', 'Piliyandala');

-- --------------------------------------------------------

--
-- Table structure for table `availblebalance`
--

CREATE TABLE IF NOT EXISTS `availblebalance` (
  `ID` int(11) NOT NULL,
  `UpdatedDate` date NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `availblebalance`
--

INSERT INTO `availblebalance` (`ID`, `UpdatedDate`, `Amount`) VALUES
(1, '0000-00-00', 98000);

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE IF NOT EXISTS `coach` (
  `coach_ID` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) DEFAULT '20',
  `date_of_last_service` date DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `isAvailable` tinyint(1) NOT NULL DEFAULT '1',
  `inService` tinyint(1) NOT NULL DEFAULT '0',
  `Last_Travel_Mileage` double DEFAULT NULL,
  PRIMARY KEY (`coach_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=124 ;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`coach_ID`, `capacity`, `date_of_last_service`, `mileage`, `isAvailable`, `inService`, `Last_Travel_Mileage`) VALUES
(123, 10, '2015-06-04', 94, 0, 0, 5);

-- --------------------------------------------------------

--
-- Table structure for table `companybugect`
--

CREATE TABLE IF NOT EXISTS `companybugect` (
  `entryCode` int(11) NOT NULL AUTO_INCREMENT,
  `entryDate` date DEFAULT NULL,
  `billRef` int(11) DEFAULT NULL,
  `Income` int(11) DEFAULT NULL,
  `Paid` int(11) DEFAULT NULL,
  PRIMARY KEY (`entryCode`),
  KEY `billRef` (`billRef`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12347 ;

--
-- Dumping data for table `companybugect`
--

INSERT INTO `companybugect` (`entryCode`, `entryDate`, `billRef`, `Income`, `Paid`) VALUES
(123, NULL, 123, 0, 1000),
(1089, '2015-06-10', NULL, 100000, 0),
(10089, '2015-06-12', 10089, 0, 1000);

--
-- Triggers `companybugect`
--
DROP TRIGGER IF EXISTS `After_Buject_Inser`;
DELIMITER //
CREATE TRIGGER `After_Buject_Inser` AFTER INSERT ON `companybugect`
 FOR EACH ROW BEGIN
Update availblebalance set Amount=(SELECT SUM(Income)- SUM(Paid)FROM companybugect) where id='1';
Update availblebalance set UpdatedDate=new.entryDate where id='1';

END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE IF NOT EXISTS `driver` (
  `driver_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `address_ID` int(11) DEFAULT NULL,
  `telNo_ID` int(11) DEFAULT NULL,
  `isAvailable` tinyint(1) NOT NULL DEFAULT '1',
  `hours_worked` time NOT NULL DEFAULT '00:00:00',
  PRIMARY KEY (`driver_ID`),
  KEY `address_ID` (`address_ID`),
  KEY `telNo_ID` (`telNo_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10011 ;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driver_ID`, `name`, `address_ID`, `telNo_ID`, `isAvailable`, `hours_worked`) VALUES
(10010, 'Saman Perera', 1, 1, 0, '00:00:11');

--
-- Triggers `driver`
--
DROP TRIGGER IF EXISTS `before_driver_update`;
DELIMITER //
CREATE TRIGGER `before_driver_update` BEFORE UPDATE ON `driver`
 FOR EACH ROW BEGIN
IF new.hours_worked > 40 THEN
SET NEW.isAvailable = 0,        
    new.hours_worked = 0;
  END IF; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `driver_route`
--

CREATE TABLE IF NOT EXISTS `driver_route` (
  `driver_ID` int(11) DEFAULT NULL,
  `route_ID` int(11) DEFAULT NULL,
  KEY `driver_ID` (`driver_ID`),
  KEY `route_ID` (`route_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver_route`
--

INSERT INTO `driver_route` (`driver_ID`, `route_ID`) VALUES
(10010, 10);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `town_ID` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(20) DEFAULT NULL,
  `available_capacity` int(11) NOT NULL DEFAULT '10',
  `email` varchar(30) NOT NULL DEFAULT '',
  `hotel_num` varchar(10) NOT NULL,
  `ChargePerDay` int(11) NOT NULL,
  `bookings` int(11) NOT NULL,
  PRIMARY KEY (`town_ID`,`email`),
  UNIQUE KEY `town_ID` (`town_ID`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `hotel_name` (`hotel_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`town_ID`, `hotel_name`, `available_capacity`, `email`, `hotel_num`, `ChargePerDay`, `bookings`) VALUES
(1, 'Hotel-Piliyandala', 10, 'pili@gmail.com', '1112223334', 10000, 9),
(2, 'Hotel Colombo', 10, 'colombo@gmail.com', '0112615808', 800, 0),
(3, 'Kurunegala-Hotel', 10, 'kuru@gmail.com', '1212315678', 5000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hotelbill`
--

CREATE TABLE IF NOT EXISTS `hotelbill` (
  `billRef` int(11) NOT NULL AUTO_INCREMENT,
  `billDate` date DEFAULT NULL,
  `town_ID` int(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `no_of_DatesUsed` int(11) DEFAULT NULL,
  `noOfpersons` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`billRef`),
  KEY `town_ID` (`town_ID`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12346 ;

--
-- Dumping data for table `hotelbill`
--

INSERT INTO `hotelbill` (`billRef`, `billDate`, `town_ID`, `email`, `no_of_DatesUsed`, `noOfpersons`, `Amount`) VALUES
(123, NULL, 3, NULL, 3, 3, 1000),
(10089, '2015-06-12', 2, NULL, 2, 2, 1000);

--
-- Triggers `hotelbill`
--
DROP TRIGGER IF EXISTS `after_HotelBill_insert`;
DELIMITER //
CREATE TRIGGER `after_HotelBill_insert` AFTER INSERT ON `hotelbill`
 FOR EACH ROW BEGIN
INSERT INTO `companybugect`(entryCode, entryDate, billRef, 	Income, Paid) VALUES (new.billRef,new.billDate,new.billRef,'',new.amount);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `hotel_possible_tour`
--
CREATE TABLE IF NOT EXISTS `hotel_possible_tour` (
`hotel_name` varchar(20)
,`tour_ID` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `individual`
--

CREATE TABLE IF NOT EXISTS `individual` (
  `individualNIC` varchar(11) NOT NULL,
  `ContactNo` varchar(10) DEFAULT NULL,
  `contactEmail` varchar(50) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  PRIMARY KEY (`individualNIC`),
  KEY `telNo_ID` (`ContactNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `individual`
--

INSERT INTO `individual` (`individualNIC`, `ContactNo`, `contactEmail`, `CustomerName`) VALUES
('111222338v', '1112223385', 'AN@gmail.com', 'Amandage '),
('114455667v', '1144556677', 'rrt@gmail.com', 'ssd'),
('123456758v', '1115553345', 'AN@gmail.com', 'Amanda');

-- --------------------------------------------------------

--
-- Table structure for table `newentryforbooking`
--

CREATE TABLE IF NOT EXISTS `newentryforbooking` (
  `tour_ID` int(11) DEFAULT NULL,
  `bookingconformed` tinyint(4) NOT NULL DEFAULT '0',
  KEY `tour_ID` (`tour_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `newentryforbooking`
--

INSERT INTO `newentryforbooking` (`tour_ID`, `bookingconformed`) VALUES
(100, 1),
(101, 1),
(102, 1),
(101, 1),
(100, 1),
(456, 0),
(188, 0),
(102, 0),
(101, 0),
(334, 0);

-- --------------------------------------------------------

--
-- Table structure for table `newentryforschedulig`
--

CREATE TABLE IF NOT EXISTS `newentryforschedulig` (
  `tour_ID` int(11) DEFAULT NULL,
  `schedulingconformed` tinyint(4) NOT NULL DEFAULT '0',
  KEY `tour_ID` (`tour_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `newentryforschedulig`
--

INSERT INTO `newentryforschedulig` (`tour_ID`, `schedulingconformed`) VALUES
(102, 1),
(2234, 0),
(456, 0),
(789, 0),
(189, 0),
(188, 1),
(334, 1),
(555, 0),
(364, 0),
(288, 0),
(882, 0);

-- --------------------------------------------------------

--
-- Table structure for table `onlinebooking`
--

CREATE TABLE IF NOT EXISTS `onlinebooking` (
  `tour_ID` int(11) NOT NULL AUTO_INCREMENT,
  `start_Date` date DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL,
  `no_of_passengers` int(11) DEFAULT NULL,
  `individualNIC` varchar(10) DEFAULT NULL,
  `ContactNo` varchar(10) DEFAULT NULL,
  `contactEmail` varchar(30) DEFAULT NULL,
  `Enter_Date` date NOT NULL,
  `Route_ID` int(11) NOT NULL,
  `Comit_Rollback` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tour_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Triggers `onlinebooking`
--
DROP TRIGGER IF EXISTS `after_insert_OnlineBooking`;
DELIMITER //
CREATE TRIGGER `after_insert_OnlineBooking` AFTER INSERT ON `onlinebooking`
 FOR EACH ROW BEGIN
        INSERT INTO newentryforschedulig(tour_ID)VALUES (new.tour_ID);
    END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `onlinecustomer`
--
CREATE TABLE IF NOT EXISTS `onlinecustomer` (
`tour_ID` int(11)
,`start_Date` date
,`Duration` int(11)
,`no_of_passengers` int(11)
,`individualNIC` varchar(10)
,`ContactNo` varchar(10)
,`contactEmail` varchar(30)
,`Enter_Date` date
,`Route_ID` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `route_ID` int(11) NOT NULL AUTO_INCREMENT,
  `towns_of_route_ID` int(11) DEFAULT NULL,
  `distance` double DEFAULT NULL,
  `RouteName` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  PRIMARY KEY (`route_ID`),
  KEY `towns_of_route_ID` (`towns_of_route_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_ID`, `towns_of_route_ID`, `distance`, `RouteName`, `Price`) VALUES
(10, 10, 15, 'Colombo-Piliyandala', 800);

-- --------------------------------------------------------

--
-- Table structure for table `telephone`
--

CREATE TABLE IF NOT EXISTS `telephone` (
  `telNo_ID` int(11) NOT NULL DEFAULT '0',
  `telephonNum` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`telNo_ID`,`telephonNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `telephone`
--

INSERT INTO `telephone` (`telNo_ID`, `telephonNum`) VALUES
(1, '0771645787');

-- --------------------------------------------------------

--
-- Stand-in structure for view `tourbookentryupdate`
--
CREATE TABLE IF NOT EXISTS `tourbookentryupdate` (
`bookings` int(11)
,`tour_ID` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `tourentry`
--

CREATE TABLE IF NOT EXISTS `tourentry` (
  `tour_ID` int(11) NOT NULL AUTO_INCREMENT,
  `start_Date` date DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL,
  `individualNIC` varchar(11) DEFAULT NULL,
  `no_of_passengers` int(11) DEFAULT NULL,
  `Comit_Rollback` tinyint(1) NOT NULL DEFAULT '1',
  `Enter_Date` date NOT NULL,
  `Route_ID` int(11) NOT NULL,
  PRIMARY KEY (`tour_ID`),
  UNIQUE KEY `individualNIC` (`individualNIC`),
  KEY `tour_ID` (`tour_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2235 ;

--
-- Dumping data for table `tourentry`
--

INSERT INTO `tourentry` (`tour_ID`, `start_Date`, `Duration`, `individualNIC`, `no_of_passengers`, `Comit_Rollback`, `Enter_Date`, `Route_ID`) VALUES
(100, '2015-06-11', 2, '12', 5, 1, '2015-06-11', 10),
(101, '2015-06-16', 3, '123456788v', 3, 1, '2015-06-16', 10),
(102, '2015-06-16', 2, '123456758v', 6, 1, '2015-06-16', 10),
(188, '2015-04-19', 2, '111222334v', 2, 1, '2015-04-18', 10),
(189, '2015-04-19', 2, '111222333v', 2, 1, '2015-04-18', 10),
(288, '2015-04-19', 2, '111222338v', 2, 1, '2015-04-18', 10),
(334, '2015-04-19', 2, '111222356v', 2, 1, '2015-04-18', 10),
(364, '2015-04-19', 2, '111555334v', 3, 1, '2015-04-18', 10),
(456, '2015-04-20', 2, '555666777v', 2, 1, '2015-04-18', 10),
(555, '2015-04-19', 2, '356456789v', 2, 1, '2015-04-18', 10),
(789, '2015-06-12', 2, '876543219v', 2, 1, '2015-06-15', 10),
(882, '2015-04-18', 2, '114455667v', 3, 1, '2015-04-18', 10),
(2234, '2015-04-19', 2, '123123123v', 3, 1, '2015-04-19', 10);

--
-- Triggers `tourentry`
--
DROP TRIGGER IF EXISTS `after_tourEntry_insert`;
DELIMITER //
CREATE TRIGGER `after_tourEntry_insert` AFTER INSERT ON `tourentry`
 FOR EACH ROW begin
INSERT INTO newentryforschedulig(tour_ID)VALUES (new.tour_ID);


END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tourforbooking`
--

CREATE TABLE IF NOT EXISTS `tourforbooking` (
  `tour_ID` int(11) NOT NULL DEFAULT '0',
  `overnight_stop` int(11) DEFAULT NULL,
  `bookingConformed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tour_ID`),
  KEY `overnight_stop` (`overnight_stop`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tourforbooking`
--

INSERT INTO `tourforbooking` (`tour_ID`, `overnight_stop`, `bookingConformed`) VALUES
(101, 1, 0),
(102, 1, 0);

--
-- Triggers `tourforbooking`
--
DROP TRIGGER IF EXISTS `after_tourForBooking_update`;
DELIMITER //
CREATE TRIGGER `after_tourForBooking_update` AFTER UPDATE ON `tourforbooking`
 FOR EACH ROW begin
IF (SELECT bookingConformed From tourForBooking WHERE tourForBooking.tour_ID=new.tour_ID) !=0 THEN
	UPDATE tourEntry SET Comit_Rollback=0 WHERE tour_ID=new.tour_ID;
	UPDATE hotel SET available_capacity=available_capacity-(SELECT no_of_passengers From tourEntry WHERE hotel.town_IDD=new.tour_ID) WHERE tour_ID=new.tour_ID;
END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tourforscheduling`
--

CREATE TABLE IF NOT EXISTS `tourforscheduling` (
  `tour_ID` int(11) NOT NULL DEFAULT '0',
  `driver_ID` int(11) DEFAULT NULL,
  `coach_ID` int(11) DEFAULT NULL,
  `shedulingConformed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tour_ID`),
  KEY `driver_ID` (`driver_ID`),
  KEY `coach_ID` (`coach_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tourforscheduling`
--

INSERT INTO `tourforscheduling` (`tour_ID`, `driver_ID`, `coach_ID`, `shedulingConformed`) VALUES
(101, 10010, 123, 1),
(102, 10010, 123, 0),
(188, 10010, 123, 1),
(334, 10010, 123, 1);

--
-- Triggers `tourforscheduling`
--
DROP TRIGGER IF EXISTS `Befor_Insert_sheduling`;
DELIMITER //
CREATE TRIGGER `Befor_Insert_sheduling` BEFORE INSERT ON `tourforscheduling`
 FOR EACH ROW begin
IF (SELECT no_of_passengers from tourEntry where tourEntry.tour_ID=new.tour_ID )>(select capacity from coach where coach.coach_ID=new.coach_ID) THEN  
UPDATE tourforscheduling SET shedulingConformed='0' where tour_ID=new.tour_ID;
 END IF;
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `after_tourForScheduling_insert`;
DELIMITER //
CREATE TRIGGER `after_tourForScheduling_insert` AFTER INSERT ON `tourforscheduling`
 FOR EACH ROW begin
update coach set coach.isAvailable = 0 where new.coach_id = coach.coach_id;
update coach set coach.mileage=coach.mileage+(select distance 
        from route, tourEntry where new.tour_ID = tourEntry.tour_ID
        and tourEntry.route_id = route.route_id);
update driver set driver.isAvailable = 0 where driver.driver_id=new.driver_id;
update driver set hours_worked = hours_worked + (select duration from tourEntry where  new.tour_id = tourentry.tour_id) where new.driver_id = driver.driver_id;
INSERT INTO newEntryForBooking(tour_ID)VALUES (new.tour_ID);
update newentryforschedulig set schedulingconformed=1 where newentryforschedulig.tour_id=new.tour_id;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `town`
--

CREATE TABLE IF NOT EXISTS `town` (
  `town_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`town_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `town`
--

INSERT INTO `town` (`town_ID`, `name`) VALUES
(1, 'Piliyandala'),
(2, 'Colombo'),
(3, 'Kurunegala');

-- --------------------------------------------------------

--
-- Table structure for table `towns_of_route`
--

CREATE TABLE IF NOT EXISTS `towns_of_route` (
  `towns_of_route_ID` int(11) NOT NULL DEFAULT '0',
  `town_ID` int(11) NOT NULL DEFAULT '0',
  `order_of_route` int(11) DEFAULT NULL,
  PRIMARY KEY (`towns_of_route_ID`,`town_ID`),
  KEY `town_ID` (`town_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `towns_of_route`
--

INSERT INTO `towns_of_route` (`towns_of_route_ID`, `town_ID`, `order_of_route`) VALUES
(10, 1, 1),
(10, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `officer_ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `userName` varchar(80) NOT NULL DEFAULT '',
  `pass_Word` varchar(80) DEFAULT NULL,
  `loged_in` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`officer_ID`,`userName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1005 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`officer_ID`, `name`, `userName`, `pass_Word`, `loged_in`) VALUES
(1001, 'Admin', 'admin', 'adminPW', 0),
(1002, 'Scheduling Manager', 'Smanager', 'schedulPW', 0),
(1003, 'Reception', 'reception', 'receptionPW', 0),
(1004, 'clerk', 'clerk', 'clerkPW', 0);

--
-- Triggers `users`
--
DROP TRIGGER IF EXISTS `before_users_update`;
DELIMITER //
CREATE TRIGGER `before_users_update` BEFORE UPDATE ON `users`
 FOR EACH ROW BEGIN
	IF (SELECT userName,pass_Word   FROM users WHERE userName=new.userName AND 	pass_Word=new.pass_Word ) > 0 THEN
		UPDATE users SET loged_in= 1;  
	END IF; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure for view `hotel_possible_tour`
--
DROP TABLE IF EXISTS `hotel_possible_tour`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hotel_possible_tour` AS select distinct `hotel`.`hotel_name` AS `hotel_name`,`tourentry`.`tour_ID` AS `tour_ID` from (((`hotel` join `tourentry`) join `towns_of_route`) join `route`) where `hotel`.`town_ID` in (select `towns_of_route`.`town_ID` from ((`tourentry` join `towns_of_route`) join `route`) where ((`tourentry`.`Route_ID` = `route`.`route_ID`) and (`route`.`towns_of_route_ID` = `towns_of_route`.`towns_of_route_ID`)));

-- --------------------------------------------------------

--
-- Structure for view `onlinecustomer`
--
DROP TABLE IF EXISTS `onlinecustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER VIEW `onlinecustomer` AS select `onlinebooking`.`tour_ID` AS `tour_ID`,`onlinebooking`.`start_Date` AS `start_Date`,`onlinebooking`.`Duration` AS `Duration`,`onlinebooking`.`no_of_passengers` AS `no_of_passengers`,`onlinebooking`.`individualNIC` AS `individualNIC`,`onlinebooking`.`ContactNo` AS `ContactNo`,`onlinebooking`.`contactEmail` AS `contactEmail`,`onlinebooking`.`Enter_Date` AS `Enter_Date`,`onlinebooking`.`Route_ID` AS `Route_ID` from `onlinebooking` WITH LOCAL CHECK OPTION;

-- --------------------------------------------------------

--
-- Structure for view `tourbookentryupdate`
--
DROP TABLE IF EXISTS `tourbookentryupdate`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tourbookentryupdate` AS select `hotel`.`bookings` AS `bookings`,`tourentry`.`tour_ID` AS `tour_ID` from ((`hotel` join `tourentry`) join `tourforbooking`) where ((`hotel`.`town_ID` = `tourforbooking`.`overnight_stop`) and (`tourentry`.`tour_ID` = `tourforbooking`.`tour_ID`));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `companybugect`
--
ALTER TABLE `companybugect`
  ADD CONSTRAINT `billRef` FOREIGN KEY (`billRef`) REFERENCES `hotelbill` (`billRef`) ON DELETE CASCADE;

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`address_ID`) REFERENCES `address` (`address_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `driver_ibfk_2` FOREIGN KEY (`telNo_ID`) REFERENCES `telephone` (`telNo_ID`) ON DELETE SET NULL;

--
-- Constraints for table `driver_route`
--
ALTER TABLE `driver_route`
  ADD CONSTRAINT `driver_route_ibfk_1` FOREIGN KEY (`driver_ID`) REFERENCES `driver` (`driver_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `driver_route_ibfk_2` FOREIGN KEY (`route_ID`) REFERENCES `route` (`route_ID`) ON DELETE CASCADE;

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`town_ID`) REFERENCES `town` (`town_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hotelbill`
--
ALTER TABLE `hotelbill`
  ADD CONSTRAINT `hotelbill_ibfk_1` FOREIGN KEY (`town_ID`, `email`) REFERENCES `hotel` (`town_ID`, `email`) ON DELETE CASCADE,
  ADD CONSTRAINT `town_ID` FOREIGN KEY (`town_ID`) REFERENCES `hotel` (`town_ID`) ON DELETE CASCADE;

--
-- Constraints for table `individual`
--
ALTER TABLE `individual`
  ADD CONSTRAINT `individual_ibfk_1` FOREIGN KEY (`individualNIC`) REFERENCES `tourentry` (`individualNIC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `newentryforbooking`
--
ALTER TABLE `newentryforbooking`
  ADD CONSTRAINT `newentryforbooking_ibfk_1` FOREIGN KEY (`tour_ID`) REFERENCES `tourentry` (`tour_ID`) ON DELETE SET NULL;

--
-- Constraints for table `newentryforschedulig`
--
ALTER TABLE `newentryforschedulig`
  ADD CONSTRAINT `newentryforschedulig_ibfk_1` FOREIGN KEY (`tour_ID`) REFERENCES `tourentry` (`tour_ID`) ON DELETE SET NULL;

--
-- Constraints for table `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `route_ibfk_1` FOREIGN KEY (`towns_of_route_ID`) REFERENCES `towns_of_route` (`towns_of_route_ID`) ON DELETE CASCADE;

--
-- Constraints for table `tourforbooking`
--
ALTER TABLE `tourforbooking`
  ADD CONSTRAINT `tourforbooking_ibfk_1` FOREIGN KEY (`tour_ID`) REFERENCES `tourentry` (`tour_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `tourforbooking_ibfk_2` FOREIGN KEY (`overnight_stop`) REFERENCES `hotel` (`town_ID`) ON DELETE SET NULL;

--
-- Constraints for table `tourforscheduling`
--
ALTER TABLE `tourforscheduling`
  ADD CONSTRAINT `tourforscheduling_ibfk_1` FOREIGN KEY (`driver_ID`) REFERENCES `driver` (`driver_ID`) ON DELETE SET NULL,
  ADD CONSTRAINT `tourforscheduling_ibfk_2` FOREIGN KEY (`coach_ID`) REFERENCES `coach` (`coach_ID`) ON DELETE SET NULL,
  ADD CONSTRAINT `tourforscheduling_ibfk_3` FOREIGN KEY (`tour_ID`) REFERENCES `tourentry` (`tour_ID`) ON DELETE CASCADE;

--
-- Constraints for table `towns_of_route`
--
ALTER TABLE `towns_of_route`
  ADD CONSTRAINT `towns_of_route_ibfk_1` FOREIGN KEY (`town_ID`) REFERENCES `town` (`town_ID`) ON DELETE CASCADE;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `delete_tourEntry_data` ON SCHEDULE EVERY 365 DAY STARTS '2015-06-03 21:34:35' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM `tourEntry` where tourEntry.Comit_Rollback=true$$

CREATE DEFINER=`root`@`localhost` EVENT `update_working_hours` ON SCHEDULE EVERY 7 DAY STARTS '2015-06-03 21:34:51' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE tourComFinal.driver SET hours_worked=0$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
