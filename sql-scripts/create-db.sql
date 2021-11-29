DROP SCHEMA IF EXISTS `techm_swagger`;

CREATE SCHEMA `techm_swagger`;

use `techm_swagger`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(128) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `playerid` int(11) NOT NULL AUTO_INCREMENT,
  `playerName` varchar(45) DEFAULT NULL,
  `teamid` int(11) DEFAULT NULL,
  PRIMARY KEY (`playerid`),
  KEY `FK_DETAIL_idx` (`teamid`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`teamid`) 
  REFERENCES `team` (`teamid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `teamid` int(11) NOT NULL AUTO_INCREMENT,
  `teamName` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`teamid`),
  UNIQUE KEY `TITLE_UNIQUE` (`teamName`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;