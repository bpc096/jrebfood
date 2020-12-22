-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 22, 2020 at 04:20 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jrebfood`
--

-- --------------------------------------------------------

--
-- Table structure for table `Chef`
--

CREATE TABLE `Chef` (
  `ChefID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Chef`
--

INSERT INTO `Chef` (`ChefID`, `Name`, `Email`, `Password`) VALUES
(1, 'chef123', 'chef123@mail.com', 'chef123');

-- --------------------------------------------------------

--
-- Table structure for table `Driver`
--

CREATE TABLE `Driver` (
  `DriverID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Profit` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Driver`
--

INSERT INTO `Driver` (`DriverID`, `Name`, `Email`, `Password`, `Profit`) VALUES
(1, 'driver123', 'driver123@mail.com', 'driver123', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Food`
--

CREATE TABLE `Food` (
  `FoodID` int(11) NOT NULL,
  `ChefID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Price` int(11) NOT NULL DEFAULT 0,
  `Available` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Manager`
--

CREATE TABLE `Manager` (
  `ManagerID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Manager`
--

INSERT INTO `Manager` (`ManagerID`, `Name`, `Email`, `Password`) VALUES
(1, 'manager123', 'manager123@mail.com', 'manager123');

-- --------------------------------------------------------

--
-- Table structure for table `TransactionDetail`
--

CREATE TABLE `TransactionDetail` (
  `TransactionID` int(11) NOT NULL,
  `FoodID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `TransactionHeader`
--

CREATE TABLE `TransactionHeader` (
  `TransactionID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `DriverID` int(11) DEFAULT NULL,
  `Status` varchar(30) NOT NULL,
  `Date-Time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `PhoneNum` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`UserID`, `Name`, `Email`, `Password`, `PhoneNum`) VALUES
(2, 'John Smith', 'John@mail.com', 'john123', '123456'),
(3, 'user123', 'user123@mail.com', 'user123', '654321');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Chef`
--
ALTER TABLE `Chef`
  ADD PRIMARY KEY (`ChefID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `Driver`
--
ALTER TABLE `Driver`
  ADD PRIMARY KEY (`DriverID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `Food`
--
ALTER TABLE `Food`
  ADD PRIMARY KEY (`FoodID`),
  ADD KEY `FoodChefIDForeignKey` (`ChefID`);

--
-- Indexes for table `Manager`
--
ALTER TABLE `Manager`
  ADD PRIMARY KEY (`ManagerID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `TransactionDetail`
--
ALTER TABLE `TransactionDetail`
  ADD PRIMARY KEY (`TransactionID`,`FoodID`),
  ADD KEY `TransactionDetailFoodIDForeignKey` (`FoodID`);

--
-- Indexes for table `TransactionHeader`
--
ALTER TABLE `TransactionHeader`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `TransactionHeaderUserIDForeignKey` (`UserID`),
  ADD KEY `TransactionHeaderDriverIDForeignKey` (`DriverID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Chef`
--
ALTER TABLE `Chef`
  MODIFY `ChefID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Driver`
--
ALTER TABLE `Driver`
  MODIFY `DriverID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Food`
--
ALTER TABLE `Food`
  MODIFY `FoodID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Manager`
--
ALTER TABLE `Manager`
  MODIFY `ManagerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `TransactionHeader`
--
ALTER TABLE `TransactionHeader`
  MODIFY `TransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Food`
--
ALTER TABLE `Food`
  ADD CONSTRAINT `FoodChefIDForeignKey` FOREIGN KEY (`ChefID`) REFERENCES `Chef` (`ChefID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TransactionDetail`
--
ALTER TABLE `TransactionDetail`
  ADD CONSTRAINT `TransactionDetailFoodIDForeignKey` FOREIGN KEY (`FoodID`) REFERENCES `Food` (`FoodID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `TransactionDetailTransactionIDForeignKey` FOREIGN KEY (`TransactionID`) REFERENCES `TransactionHeader` (`TransactionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `TransactionHeader`
--
ALTER TABLE `TransactionHeader`
  ADD CONSTRAINT `TransactionHeaderDriverIDForeignKey` FOREIGN KEY (`DriverID`) REFERENCES `Driver` (`DriverID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
