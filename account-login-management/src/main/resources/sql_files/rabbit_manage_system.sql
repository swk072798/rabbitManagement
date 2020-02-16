/*
Navicat MySQL Data Transfer

Source Server         : rabbit
Source Server Version : 50646
Source Host           : 116.62.150.116:3306
Source Database       : rabbit_manage_system

Target Server Type    : MYSQL
Target Server Version : 50646
File Encoding         : 65001

Date: 2020-02-15 09:38:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for farm_infomation
-- ----------------------------
DROP TABLE IF EXISTS `farm_infomation`;
CREATE TABLE `farm_infomation` (
  `farmUuid` varchar(255) DEFAULT NULL,
  `farmName` varchar(255) DEFAULT NULL,
  `ownUser` varchar(255) DEFAULT NULL,
  `farmAddress` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farm_infomation
-- ----------------------------
INSERT INTO `farm_infomation` VALUES ('jiwoeuriowue', '哈哈兔场', 'lqc', '中国');

-- ----------------------------
-- Table structure for rabbit_breeding
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_breeding`;
CREATE TABLE `rabbit_breeding` (
  `breedingInformationId` int(11) NOT NULL AUTO_INCREMENT,
  `femaleRabbitNo` varchar(255) DEFAULT NULL,
  `maleRabbitNo` varchar(255) DEFAULT NULL,
  `breedingTime` datetime DEFAULT NULL,
  `twelveDayMoldTire` varchar(255) DEFAULT NULL,
  `birthTime` datetime DEFAULT NULL,
  `nestLittersNumber` int(11) DEFAULT NULL,
  `nestLiveRabbitsNumber` int(11) DEFAULT NULL,
  `nestLiveRabbitsRate` double DEFAULT NULL,
  `nestWeakDeadRabbitsNumber` int(11) DEFAULT NULL,
  `nestWeakDeadRabbitsRate` double DEFAULT NULL,
  `nestWeakRabbitsNumber` int(11) DEFAULT NULL,
  `nestWeakRabbitsRate` double DEFAULT NULL,
  `nestDeathRabbitRate` double DEFAULT NULL,
  `deathRabbitRate` double DEFAULT NULL,
  `newbornNestWeight` double DEFAULT NULL,
  `newbornAverageWeight` double DEFAULT NULL,
  `sucklingRabbitsNumber` int(11) DEFAULT NULL,
  `twentyOneDaysOldNestWeight` double DEFAULT NULL,
  `weaningNestWeight` double DEFAULT NULL,
  `lactationAverageDailyGain` double DEFAULT NULL,
  `lactationConsumption` double DEFAULT NULL,
  `lactationAverageMaterialWeightRatio` double DEFAULT NULL,
  `tiresNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`breedingInformationId`),
  KEY `femaleRabbitNo` (`femaleRabbitNo`) USING BTREE,
  KEY `maleRabbitNo` (`maleRabbitNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rabbit_breeding
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_change_record
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_change_record`;
CREATE TABLE `rabbit_change_record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `rabbitNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `oldCageNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `oldRabbitHouseNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `newCageNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `newRabbitHouseNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `actionUser` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `changeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_change_record
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_death
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_death`;
CREATE TABLE `rabbit_death` (
  `rabbitNo` varchar(255) CHARACTER SET utf8 NOT NULL,
  `deathDate` date DEFAULT NULL,
  `rabbitHouseNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `cageNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `deathReason` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`rabbitNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_death
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_dynamic_information
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_dynamic_information`;
CREATE TABLE `rabbit_dynamic_information` (
  `dynamicInformationId` int(11) NOT NULL,
  `rabbitNo` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `bodyLength` double DEFAULT NULL,
  `bust` double DEFAULT NULL,
  `backRoughLength` double DEFAULT NULL,
  `bodySideHairLength` double DEFAULT NULL,
  `abdominalThickHairLength` double DEFAULT NULL,
  `hipRoughLength` double DEFAULT NULL,
  `longBackHairLength` double DEFAULT NULL,
  `bellyHairLength` double DEFAULT NULL,
  `hipVelvetLength` double DEFAULT NULL,
  `longSideHairsLength` double DEFAULT NULL,
  `backCrudeHairDensity` double DEFAULT NULL,
  `abdominalCrudeHairDensity` double DEFAULT NULL,
  `hipCrudeHairDensity` double DEFAULT NULL,
  `thickSideHairDensity` double DEFAULT NULL,
  `backFineHairDensity` double DEFAULT NULL,
  `abdominalFineHairDensity` double DEFAULT NULL,
  `hipFineHairDensity` double DEFAULT NULL,
  `bodySideFineHairDensity` double DEFAULT NULL,
  `backHairFineness` double DEFAULT NULL,
  `abdominalCapillary` double DEFAULT NULL,
  `hipHairFineness` double DEFAULT NULL,
  `bodyDideCapillary` double DEFAULT NULL,
  `roughnessRate` double DEFAULT NULL,
  `singleHairProduction` double DEFAULT NULL,
  `estimateAnnualShear` double DEFAULT NULL,
  `loosenessRate` double DEFAULT NULL,
  `strong` double DEFAULT NULL,
  `elongation` double DEFAULT NULL,
  `hairFlatness` double DEFAULT NULL,
  `coatElasticity` double DEFAULT NULL,
  `coatAdhesion` double DEFAULT NULL,
  `period` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dynamicInformationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rabbit_dynamic_information
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_eliminate
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_eliminate`;
CREATE TABLE `rabbit_eliminate` (
  `rabbitNo` varchar(255) CHARACTER SET utf8 NOT NULL,
  `eliminateDate` date DEFAULT NULL,
  `rabbitHouseNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `cageNo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eliminateReason` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`rabbitNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_eliminate
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_health
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_health`;
CREATE TABLE `rabbit_health` (
  `healRecordId` varchar(255) NOT NULL,
  `farmUuid` varchar(255) DEFAULT NULL,
  `cageNo` varchar(255) DEFAULT NULL,
  `rabbitHouseNo` varchar(255) DEFAULT NULL,
  `rabbitNo` varchar(255) DEFAULT NULL,
  `bodyCondition` varchar(255) DEFAULT NULL,
  `mentalCondition` varchar(255) DEFAULT NULL,
  `feeding` varchar(255) DEFAULT NULL,
  `drinking` varchar(255) DEFAULT NULL,
  `eyelid` int(11) DEFAULT NULL,
  `conjunctiva` varchar(255) DEFAULT NULL,
  `secretion` varchar(255) DEFAULT NULL,
  `externalEar` varchar(255) DEFAULT NULL,
  `innerEar` varchar(255) DEFAULT NULL,
  `nose` varchar(255) DEFAULT NULL,
  `nasalFluid` int(11) DEFAULT NULL,
  `nasalMucosa` varchar(255) DEFAULT NULL,
  `mouth` varchar(255) DEFAULT NULL,
  `abdomen` varchar(255) DEFAULT NULL,
  `anus` varchar(255) DEFAULT NULL,
  `odor` varchar(255) DEFAULT NULL,
  `fecalMorphology` varchar(255) DEFAULT NULL,
  `stoolColor` varchar(255) DEFAULT NULL,
  `urineColor` varchar(255) DEFAULT NULL,
  `urineVolume` varchar(255) DEFAULT NULL,
  `coat` varchar(255) DEFAULT NULL,
  `skin` varchar(255) DEFAULT NULL,
  `joint` varchar(255) DEFAULT NULL,
  `limbs` varchar(255) DEFAULT NULL,
  `suspectedDisease` varchar(255) DEFAULT NULL,
  `medication` varchar(255) DEFAULT NULL,
  `initialTreatmentEffect` varchar(255) DEFAULT NULL,
  `muscle` varchar(255) DEFAULT NULL,
  `brain` varchar(255) DEFAULT NULL,
  `cerebellum` varchar(255) DEFAULT NULL,
  `throat` varchar(255) DEFAULT NULL,
  `organ` varchar(255) DEFAULT NULL,
  `abdominalCavity` varchar(255) DEFAULT NULL,
  `thoracicCavity` varchar(255) DEFAULT NULL,
  `lymphNode` varchar(255) DEFAULT NULL,
  `heart` varchar(255) DEFAULT NULL,
  `lung` varchar(255) DEFAULT NULL,
  `liver` varchar(255) DEFAULT NULL,
  `liverColor` varchar(255) DEFAULT NULL,
  `gallbladder` varchar(255) DEFAULT NULL,
  `bileDuct` varchar(255) DEFAULT NULL,
  `kidneySurface` varchar(255) DEFAULT NULL,
  `renalParenchyma` varchar(255) DEFAULT NULL,
  `spleen` varchar(255) DEFAULT NULL,
  `gastricMucosa` varchar(255) DEFAULT NULL,
  `stomachContents` varchar(255) DEFAULT NULL,
  `duodenalMucosa` varchar(255) DEFAULT NULL,
  `duodenalContents` varchar(255) DEFAULT NULL,
  `jejunalMucosa` varchar(255) DEFAULT NULL,
  `jejunalContents` varchar(255) DEFAULT NULL,
  `ilealMucosa` varchar(255) DEFAULT NULL,
  `ilealContents` varchar(255) DEFAULT NULL,
  `cecumMucosa` varchar(255) DEFAULT NULL,
  `cecumContents` varchar(255) DEFAULT NULL,
  `appendix` varchar(255) DEFAULT NULL,
  `colonicMucosa` varchar(255) DEFAULT NULL,
  `colonContents` varchar(255) DEFAULT NULL,
  `rectalMucosa` varchar(255) DEFAULT NULL,
  `rectalContents` varchar(255) DEFAULT NULL,
  `vaginalMucosa` varchar(255) DEFAULT NULL,
  `vaginalDischarge` varchar(255) DEFAULT NULL,
  `uterus` varchar(255) DEFAULT NULL,
  `ovaryAndFallopianTubes` varchar(255) DEFAULT NULL,
  `breast` varchar(255) DEFAULT NULL,
  `penis` varchar(255) DEFAULT NULL,
  `testis` varchar(255) DEFAULT NULL,
  `scrotum` varchar(255) DEFAULT NULL,
  `anatomicalDiagnosis` varchar(255) DEFAULT NULL,
  `microscopicExaminationResult` varchar(255) DEFAULT NULL,
  `bacterialCultureConclusion` varchar(255) DEFAULT NULL,
  `diagnosisConclusion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`healRecordId`),
  KEY `farmUuid` (`farmUuid`) USING BTREE,
  KEY `cageNo` (`cageNo`) USING BTREE,
  KEY `rabbitHouseNo` (`rabbitHouseNo`) USING BTREE,
  KEY `rabbitNo` (`rabbitNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rabbit_health
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_house
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_house`;
CREATE TABLE `rabbit_house` (
  `rabbitHouseNo` varchar(255) NOT NULL,
  `outdoorTemperature` double DEFAULT NULL,
  `outdoorUmidity` double DEFAULT NULL,
  `indoorTemperature` double DEFAULT NULL,
  `indoorUmidity` double DEFAULT NULL,
  `indoorWindSpeed` double DEFAULT NULL,
  `ammonia` double DEFAULT NULL,
  `hydrogenSulfide` double DEFAULT NULL,
  `carbonMonoxideConcentration` double DEFAULT NULL,
  `fanOperation` varchar(255) DEFAULT NULL,
  `wetCurtainOperation` varchar(255) DEFAULT NULL,
  `lightingControl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rabbitHouseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rabbit_house
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_house_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_house_basic_info`;
CREATE TABLE `rabbit_house_basic_info` (
  `rabbitHouseNo` varchar(255) CHARACTER SET utf8 NOT NULL,
  `rabbitHouseType` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `principal` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `farmUuid` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`rabbitHouseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_house_basic_info
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_illness
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_illness`;
CREATE TABLE `rabbit_illness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `illnessName` varchar(255) DEFAULT NULL,
  `pathogen` varchar(255) DEFAULT NULL,
  `drugResistance` varchar(255) DEFAULT NULL,
  `infectionTime` datetime DEFAULT NULL,
  `medicine` varchar(255) DEFAULT NULL,
  `farmUuid` varchar(255) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_illness
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_illness_record
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_illness_record`;
CREATE TABLE `rabbit_illness_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rabbitNo` varchar(255) DEFAULT NULL,
  `illnessName` varchar(255) DEFAULT NULL,
  `medicine` varchar(255) DEFAULT NULL,
  `effect` varchar(255) DEFAULT NULL,
  `reuse` varchar(255) DEFAULT NULL,
  `farm_Uuid` varchar(255) DEFAULT NULL,
  `rabbitHouse` varchar(255) DEFAULT NULL,
  `cageNo` varchar(255) DEFAULT NULL,
  `uploadUser` varchar(255) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_illness_record
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_info
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_info`;
CREATE TABLE `rabbit_info` (
  `rabbitNo` varchar(20) NOT NULL,
  `cageNo` varchar(255) DEFAULT NULL,
  `rabbitHouseNo` varchar(255) DEFAULT NULL,
  `farmUuid` varchar(255) DEFAULT NULL,
  `birthParity` int(11) DEFAULT NULL,
  `initialWeight` double DEFAULT NULL,
  `coatGloss` varchar(255) DEFAULT NULL,
  `identicalRabbits` int(11) DEFAULT NULL,
  `economiType` varchar(255) DEFAULT NULL,
  `photo` text,
  `sex` varchar(255) DEFAULT NULL,
  `initialAge` varchar(255) DEFAULT NULL,
  `fineHairType` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `mainCoatColor` varchar(255) DEFAULT NULL,
  `paternalNo` varchar(255) DEFAULT NULL,
  `coatFeature` varchar(255) DEFAULT NULL,
  `maternalNo` varchar(255) DEFAULT NULL,
  `roughType` varchar(255) DEFAULT NULL,
  `age` double DEFAULT NULL,
  `coatColor` varchar(255) DEFAULT NULL,
  `bornDate` datetime DEFAULT NULL,
  `nipplesNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`rabbitNo`),
  KEY `sex` (`sex`) USING HASH,
  KEY `paternalNo` (`paternalNo`) USING HASH,
  KEY `maternalNo` (`maternalNo`) USING HASH,
  KEY `age` (`age`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rabbit_info
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_ingredients
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_ingredients`;
CREATE TABLE `rabbit_ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedType` varchar(255) DEFAULT NULL,
  `ingredientDates` datetime DEFAULT NULL,
  `ingredientNumber` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_ingredients
-- ----------------------------
INSERT INTO `rabbit_ingredients` VALUES ('2', 'ceshi', '2018-09-06 15:03:48', '1', null);
INSERT INTO `rabbit_ingredients` VALUES ('3', 'ceshi', '2018-09-06 15:03:48', '1', null);
INSERT INTO `rabbit_ingredients` VALUES ('4', 'ceshi', '2018-09-06 07:03:48', '1', null);
INSERT INTO `rabbit_ingredients` VALUES ('5', 'ceshi', '2018-09-06 07:03:48', '1', null);
INSERT INTO `rabbit_ingredients` VALUES ('6', 'ceshi', '2018-09-06 07:03:48', '1', null);
INSERT INTO `rabbit_ingredients` VALUES ('7', 'ceshi', '2018-09-06 07:03:48', '1', '222');
INSERT INTO `rabbit_ingredients` VALUES ('8', 'ceshi', '2018-09-06 07:03:48', '1', '333');
INSERT INTO `rabbit_ingredients` VALUES ('9', 'ceshi', '2018-09-08 07:03:48', '1', '2333');
INSERT INTO `rabbit_ingredients` VALUES ('10', 'ceshi', '2018-09-06 07:03:48', '1', '333');

-- ----------------------------
-- Table structure for rabbit_materials_record
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_materials_record`;
CREATE TABLE `rabbit_materials_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedType` varchar(255) DEFAULT NULL,
  `outboundDate` datetime DEFAULT NULL,
  `outboundNumber` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `uploadUser` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_materials_record
-- ----------------------------

-- ----------------------------
-- Table structure for rabbit_sale_record
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_sale_record`;
CREATE TABLE `rabbit_sale_record` (
  `rabbitNo` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `farmUuid` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `rabbitHouseNo` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `cageNo` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `saleDate` date DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `client` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `executive` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`rabbitNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rabbit_sale_record
-- ----------------------------
