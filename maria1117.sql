-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.5-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- goverment 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `goverment` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goverment`;

-- 테이블 goverment.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `visited` int(11) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 테이블 데이터 goverment.notice:~4 rows (대략적) 내보내기
INSERT INTO `notice` (`no`, `title`, `content`, `regdate`, `visited`) VALUES
	(1, '테스트글1 수정본', '공지사항 내용', '2022-11-11 14:12:27', NULL),
	(2, '테스트글2', '공지사항 내용', '2022-11-11 14:12:30', NULL),
	(3, '', '', '2022-11-11 17:58:41', NULL),
	(4, '안녕하세요 공지사항입니다', '방금건 실수임..', '2022-11-11 17:59:52', NULL);

-- 테이블 goverment.pic 구조 내보내기
CREATE TABLE IF NOT EXISTS `pic` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `tourno` varchar(20) DEFAULT NULL,
  `picname` varchar(150) DEFAULT NULL,
  `pos` int(11) DEFAULT 1,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 goverment.pic:~0 rows (대략적) 내보내기

-- 테이블 goverment.test 구조 내보내기
CREATE TABLE IF NOT EXISTS `test` (
  `NAME` varchar(50) DEFAULT NULL,
  `POINT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 goverment.test:~3 rows (대략적) 내보내기
INSERT INTO `test` (`NAME`, `POINT`) VALUES
	('dodo', 100),
	('jojo', 80),
	('도연', 80);

-- 테이블 goverment.tour 구조 내보내기
CREATE TABLE IF NOT EXISTS `tour` (
  `NO` int(11) NOT NULL AUTO_INCREMENT,
  `tourno` varchar(20) DEFAULT NULL,
  `cate` varchar(20) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `COMMENT1` varchar(500) DEFAULT NULL,
  `COMMENT2` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 goverment.tour:~0 rows (대략적) 내보내기

-- 테이블 goverment.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(15) NOT NULL,
  `pw` varchar(1000) NOT NULL,
  `NAME` varchar(10) NOT NULL,
  `addr` varchar(100) NOT NULL,
  `POINT` int(11) DEFAULT 0,
  `RANK` varchar(5) DEFAULT 'Z',
  `visited` int(11) DEFAULT 1,
  `birth` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 goverment.user:~1 rows (대략적) 내보내기
INSERT INTO `user` (`id`, `pw`, `NAME`, `addr`, `POINT`, `RANK`, `visited`, `birth`, `tel`, `regdate`, `email`) VALUES
	('admin', 'oMI/aesg2oc5/noo1OklNi2wJ0RA4+JTNFwx7NgKJicQWkIdjc3FSMEL37qGpZk8h2hQMw==', '관리자', '제주특별자치도 서귀포시 가가로 14<br>김', 0, 'Z', 7, '1999-09-02', '01099999999', '2022-11-15 19:32:45', '99@99.com');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
