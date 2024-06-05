-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for car_rentals
DROP DATABASE IF EXISTS `car_rentals`;
CREATE DATABASE IF NOT EXISTS `car_rentals` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `car_rentals`;

-- Dumping structure for table car_rentals.car
DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `car_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `brand` varchar(30) NOT NULL,
  `model` varchar(50) NOT NULL,
  `type` enum('LUXURY','SPORT','ELECTRIC','SUV','CONVERTIBLE') NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `number_of_seats` int(2) unsigned NOT NULL,
  `hp` int(4) unsigned NOT NULL,
  `description` text NOT NULL,
  `price_per_day` double unsigned NOT NULL,
  `img_path` varchar(255) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rentals.car: ~15 rows (approximately)
INSERT INTO `car` (`car_id`, `brand`, `model`, `type`, `year`, `number_of_seats`, `hp`, `description`, `price_per_day`, `img_path`, `updated_at`, `deleted_at`) VALUES
	(1, 'Volkswagen', 'Golf 8 GTI', 'SPORT', 2020, 5, 245, 'The Volkswagen Golf 8 GTI is a high-performance compact car known for its sporty handling and impressive acceleration. It features a 2.0-liter engine producing 241 horsepower, paired with advanced driving technology for an enhanced driving experience.', 50, 'https://s1.cdn.autoevolution.com/images/news/here-s-what-the-vw-golf-gti-mk8-will-look-like-138526_1.jpg', NULL, NULL),
	(2, 'Audi', 'Q5', 'SUV', 2021, 5, 204, 'The Audi Q5 is a luxury compact SUV known for its stylish design, comfortable ride, and advanced technology features. It offers a balance of performance and utility.', 60, 'https://edgecast-img.yahoo.net/mysterio/api/24E7B2F39C778E69D0454D24FB1DB328D353E227AF3DB0216C341338979F5D83/autoblog/resizefill_w660_h372;quality_80;format_webp;cc_31536000;/https://s.aolcdn.com/commerce/autodata/images/USD10AUS081A021001.jpg', NULL, NULL),
	(3, 'BMW', 'M3 Competition', 'SPORT', 2021, 5, 510, 'The BMW M3 Competition is a high-performance sports sedan. Known for its exceptional handling and advanced driving technology, it offers a thrilling yet comfortable driving experience', 100, 'https://images.carprices.com/pricebooks_data/usa/colorized/2024/BMW/View2/M3_Competition_Sedan/xDrive/24TQ_300.png', NULL, NULL),
	(4, 'Tesla', 'Model S Plaid', 'ELECTRIC', 2022, 5, 1020, 'The Tesla Model S Plaid is an electric luxury sedan that boasts incredible acceleration and cutting-edge technology, making it one of the fastest cars in the world.', 120, 'https://www.tesla.com/sites/default/files/modelsx-new/social/model-s-hero-social.jpg', NULL, NULL),
	(5, 'Mercedes-Benz', 'S-Class', 'LUXURY', 2016, 5, 258, 'The Mercedes-Benz S-Class is a full-size luxury sedan offering the ultimate in comfort, technology, and performance. It is known for its elegant design and advanced features.', 150, 'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/vhs/Mercedes-Benz-S-Class_0.png', NULL, NULL),
	(6, 'Porsche', '911 Carrera 4S', 'SPORT', 2022, 4, 443, 'The Porsche 911 Carrera 4S is a legendary sports car, celebrated for its iconic design, superior performance, and thrilling driving dynamics.', 180, 'https://edgecast-img.yahoo.net/mysterio/api/46EC413FD771D8B8EAD03FC0C54BC6445E051F7FDCEBB88E7F0BE3102A89478E/autoblog/resizefill_w660_h372;quality_80;format_webp;cc_31536000;/https://s.aolcdn.com/commerce/autodata/images/USD00PRC013A021001.jpg', NULL, NULL),
	(7, 'Range Rover', 'Velar', 'SUV', 2021, 5, 247, 'The Range Rover Velar is a luxury mid-size SUV known for its sleek design, advanced technology, and off-road capabilities.', 80, 'https://platform.cstatic-images.com/xlarge/in/v2/stock_photos/97ab5fcb-91e3-4274-a995-bbaf13cec0fe/18f06129-1450-41fb-88ff-461c30c32e2a.png', NULL, NULL),
	(8, 'Ford', 'Mustang Mach-E', 'ELECTRIC', 2021, 5, 346, 'The Ford Mustang Mach-E is an electric SUV that combines iconic Mustang design elements with modern electric performance and technology.', 70, 'https://media.ford.com/content/fordmedia/fna/us/en/products/evs/mustang-mach-e/mustang-mach-e/jcr:content/content/media-section-parsys/textimage_f597/image.img.951.535.jpg/1608221793793.jpg', NULL, NULL),
	(9, 'Lamborghini', 'Huracan Evo', 'SPORT', 2020, 2, 640, 'The Lamborghini Huracan Evo is a supercar with a powerful V10 engine and aerodynamic design, offering an exhilarating driving experience.', 250, 'https://www.theluxurycollectionwc.com/imagetag/99/7/l/Used-2020-Lamborghini-Huracan-EVO-1698492785.jpg', NULL, NULL),
	(10, 'Chevrolet', 'Corvette Stingray', 'SPORT', 2021, 2, 495, 'The Chevrolet Corvette Stingray is a high-performance sports car with a mid-engine layout, known for its striking design and impressive speed.', 110, 'https://di-sitebuilder-assets.s3.amazonaws.com/GMimages/gmMLP/chevrolet/Corvette/1LT+Coupe.jpg', NULL, NULL),
	(11, 'Lexus', 'RX 350', 'SUV', 2021, 5, 295, 'The Lexus RX 350 is a luxury SUV that offers a comfortable ride, stylish design, and advanced safety features.', 90, 'https://edgecast-img.yahoo.net/mysterio/api/722E9AD8E14A97D02F808C7C9F7C172DCF9C9A9C4155E33CB46D4FA248B42BB1/autoblog/resizefill_w660_h372;quality_80;format_webp;cc_31536000;/https://s.aolcdn.com/commerce/autodata/images/USD00LES122C021001.jpg', NULL, NULL),
	(12, 'Ferrari', 'Portofino M', 'CONVERTIBLE', 2022, 2, 612, 'The Ferrari Portofino M is a convertible grand tourer that combines elegance, power, and comfort, making it perfect for open-top driving experiences.', 300, 'https://editorial.pxcrush.net/carsales/general/editorial/2022_ferrari_portofino_m-51.jpg?width=1024&height=682', NULL, NULL),
	(13, 'Jaguar', 'F-Type', 'CONVERTIBLE', 2021, 2, 444, 'The Jaguar F-Type is a sleek and stylish convertible sports car, offering a thrilling drive with its powerful engine and refined handling.', 160, 'https://images.pistonheads.com/nimg/43525/FType_00.jpg', NULL, NULL),
	(14, 'BMW', '750i xDrive', 'LUXURY', 2022, 5, 523, 'The BMW 7 Series Limo is the epitome of luxury and performance, offering an unmatched driving experience with advanced technology and a spacious, comfortable interior.', 180, 'https://images.carprices.com/pricebooks_data/usa/colorized/2022/BMW/View2/7_Series/750i_xDrive/227I_300.png', NULL, NULL),
    (15, 'Audi', 'A8', 'LUXURY', 2020, 5, 335, 'The Audi A8 is a luxury sedan that combines cutting-edge technology, a comfortable ride, and elegant design, making it one of the top choices in its class.', 170, 'https://i.pinimg.com/736x/2e/48/da/2e48da807d436ca00306acf0b34e67b2.jpg', NULL, NULL),
	(16, 'Maserati', 'Levante', 'SUV', 2023, 5, 345, 'The Maserati Levante is a luxury SUV that combines Maserati\'s signature style with off-road capabilities and powerful performance. It offers a unique blend of comfort and agility.', 150, 'https://vehicle-images.dealerinspire.com/stock-images/chrome/8c9e690927aedb050ecc52270d9353cf.png', NULL, NULL),
    (17, 'Porsche', 'Cayenne', 'SUV', 2022, 5, 335, 'The Porsche Cayenne is a luxury SUV known for its sporty performance, refined handling, and advanced technology. It delivers a dynamic driving experience while maintaining the versatility of an SUV.', 170, 'https://i.gaw.to/vehicles/photos/40/27/402762-2022-porsche-cayenne.jpg', NULL, NULL),
	(18, 'Lamborghini', 'SVJ Roadster', 'CONVERTIBLE', 2022, 2, 759, 'The Lamborghini SVJ Roadster is an open-top supercar that combines extreme performance with the thrill of convertible driving. It offers an exhilarating experience with its powerful V12 engine.', 500, 'https://www.supercars.net/blog/wp-content/uploads/2023/04/DSC_7396-94288.jpg', NULL, NULL),
	(19, 'Lamborghini', 'Urus', 'SUV', 2022, 5, 641, 'The Lamborghini Urus is a high-performance luxury SUV that combines the power and style of a supercar with the practicality and comfort of an SUV. It offers unmatched performance and cutting-edge technology.', 250, 'https://imgcdn.oto.com/large/gallery/color/21/2034/lamborghini-urus-color-946463.jpg', NULL, NULL),
	(20, 'Bugatti', 'Chiron', 'SPORT', 2019, 2, 1500, 'The Bugatti Chiron is a hypercar that represents the pinnacle of automotive engineering. It boasts an astonishing 1500 horsepower and a top speed that exceeds 260 mph, providing an unparalleled driving experience.', 3000, 'https://i.pinimg.com/736x/e9/34/ac/e934ac022c9ecf2dadf6954610176627.jpg', NULL, NULL);

-- Dumping structure for table car_rentals.reservation
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `start_at` datetime NOT NULL,
  `end_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `fk_reservation_car_id` (`car_id`),
  KEY `fk_reservation_user_id` (`user_id`),
  CONSTRAINT `fk_reservation_car_id` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_reservation_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rentals.reservation: ~19 rows (approximately)
INSERT INTO `reservation` (`reservation_id`, `car_id`, `user_id`, `start_at`, `end_at`, `deleted_at`) VALUES
	(1, 1, 1, '2024-05-15 10:00:00', '2024-05-20 10:00:00', NULL),
	(2, 1, 5, '2024-05-20 10:00:00', '2024-05-21 10:00:00', NULL),
	(3, 2, 2, '2024-05-17 12:00:00', '2024-05-19 12:00:00', NULL),
	(4, 3, 3, '2024-05-18 09:00:00', '2024-05-20 09:00:00', NULL),
	(5, 4, 4, '2024-05-21 14:00:00', '2024-05-22 14:00:00', NULL),
	(6, 5, 5, '2024-05-22 10:00:00', '2024-05-23 10:00:00', NULL),
	(7, 6, 6, '2024-05-23 11:00:00', '2024-05-25 11:00:00', NULL),
	(8, 7, 7, '2024-05-24 15:00:00', '2024-05-26 15:00:00', NULL),
	(9, 8, 8, '2024-05-25 09:00:00', '2024-05-27 09:00:00', NULL),
	(10, 9, 9, '2024-05-26 13:00:00', '2024-05-27 13:00:00', NULL),
	(11, 11, 1, '2024-05-28 08:00:00', '2024-05-29 08:00:00', NULL),
	(12, 12, 2, '2024-05-29 10:00:00', '2024-05-30 10:00:00', NULL),
	(13, 14, 4, '2024-06-01 14:00:00', '2024-06-02 14:00:00', NULL),
	(14, 15, 5, '2024-06-02 09:00:00', '2024-06-03 09:00:00', NULL),
	(15, 3, 6, '2024-06-03 10:00:00', '2024-06-04 10:00:00', NULL),
	(16, 4, 7, '2024-06-04 11:00:00', '2024-06-07 11:00:00', NULL),
	(17, 5, 8, '2024-06-05 12:00:00', '2024-06-06 12:00:00', NULL),
	(18, 6, 9, '2024-06-06 13:00:00', '2024-06-09 13:00:00', NULL),
	(19, 7, 10, '2024-06-07 14:00:00', '2024-06-08 14:00:00', NULL),
	(20, 17, 5, '2024-06-07 18:00:00', '2024-06-10 18:00:00', NULL),
	(21, 18, 8, '2024-06-10 08:00:00', '2024-06-12 08:00:00', NULL),
	(22, 18, 9, '2024-06-11 10:00:00', '2024-06-12 10:00:00', NULL),
	(23, 19, 10, '2024-06-12 12:00:00', '2024-06-14 12:00:00', NULL),
	(24, 20, 1, '2024-06-14 07:00:00', '2024-06-15 07:00:00', NULL),
	(25, 20, 2, '2024-06-14 17:00:00', '2024-06-18 17:00:00', NULL);
	

-- Dumping structure for table car_rentals.review
DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `review_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `comment` text NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `fk_review_car_id` (`car_id`),
  KEY `fk_review_user_id` (`user_id`),
  CONSTRAINT `fk_review_car_id` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_review_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rentals.review: ~20 rows (approximately)
INSERT INTO `review` (`review_id`, `car_id`, `user_id`, `comment`, `deleted_at`) VALUES
	(1, 1, 1, 'This car is excellent for daily driving. It provides a smooth and comfortable ride.', NULL),
	(2, 3, 2, 'The BMW M3 Competition is an amazing sports car. The acceleration and handling are outstanding.', NULL),
	(3, 1, 5, 'I loved driving the Volkswagen Golf 8 GTI. It has a sporty feel and great performance.', NULL),
	(4, 2, 2, 'The Audi Q5 is a luxury SUV with a stylish design. It offers a very comfortable ride.', NULL),
	(5, 3, 3, 'The BMW M3 Competition delivers an exhilarating driving experience. It\'s perfect for speed enthusiasts.', NULL),
	(6, 4, 4, 'The Tesla Model S Plaid is incredibly fast. The technology inside is cutting-edge.', NULL),
	(7, 5, 5, 'The Mercedes-Benz S-Class is the epitome of luxury. The comfort and features are top-notch.', NULL),
	(8, 6, 6, 'Driving the Porsche 911 Carrera 4S was a dream come true. The handling and power are unmatched.', NULL),
	(9, 7, 7, 'The Range Rover Velar combines luxury and off-road capability. It\'s perfect for any terrain.', NULL),
	(10, 8, 8, 'The Ford Mustang Mach-E is a great electric SUV. It has a modern design and impressive range.', NULL),
	(11, 9, 9, 'The Lamborghini Huracan Evo is a supercar like no other. The V10 engine sounds amazing.', NULL),
	(12, 11, 1, 'The Lexus RX 350 offers a smooth and quiet ride. It is very reliable and well-built.', NULL),
	(13, 12, 2, 'The Ferrari Portofino M is a stunning convertible. It\'s perfect for a weekend drive.', NULL),
	(14, 14, 4, 'The BMW 750i xDrive offers unparalleled luxury and performance.', NULL),
	(15, 15, 5, 'The Audi A8 is a top-tier luxury sedan. It combines elegance and comfort.', NULL),
	(16, 3, 6, 'The BMW M3 Competition offers a thrilling driving experience. It handles corners like a dream.', NULL),
	(17, 4, 7, 'The Tesla Model S Plaid is insanely fast. The autopilot feature is very impressive.', NULL),
	(18, 5, 8, 'The Mercedes-Benz S-Class is pure luxury. The interior is incredibly comfortable.', NULL),
	(19, 6, 9, 'The Porsche 911 Carrera 4S is an iconic sports car. The driving dynamics are superb.', NULL),
	(20, 7, 10, 'The Range Rover Velar is both luxurious and capable. It\'s great for both city and off-road driving.', NULL),
	(21, 16, 6, 'The Maserati Levante combines luxury and performance in an SUV format. It\'s great for both city driving and off-road adventures.', NULL),
    (22, 17, 5, 'The Porsche Cayenne offers a thrilling driving experience with the practicality of an SUV.', NULL),
	(23, 18, 8, 'The Lamborghini SVJ Roadster is an absolute beast. Driving it with the top down is an unmatched experience.', NULL),
    (24, 18, 9, 'Incredible performance and stunning looks. The SVJ Roadster is a dream car for any supercar enthusiast.', NULL),
	(25, 19, 10, 'The Lamborghini Urus is the ultimate SUV, delivering supercar performance with the versatility of an SUV. Perfect for any terrain.', NULL),
	(26, 20, 1, 'The Bugatti Chiron is a masterpiece of engineering. Driving it is like nothing else on earth.', NULL),
    (27, 20, 2, 'Unmatched speed and luxury. The Chiron is in a league of its own.', NULL);



-- Dumping structure for table car_rentals.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uq_user_username` (`username`),
  UNIQUE KEY `uq_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rentals.user: ~10 rows (approximately)
INSERT INTO `user` (`user_id`, `username`, `password`, `email`, `first_name`, `last_name`, `phone_number`, `updated_at`, `deleted_at`) VALUES
	(1, 'johndoe', 'john123', 'john@gmail.com', 'John', 'Doe', '+1 252 5520', NULL, NULL),
	(2, 'janesmith', 'jane123', 'jane@gmail.com', 'Jane', 'Smith', '+381 64 123 654', NULL, NULL),
	(3, 'alexjohnson', 'alex123', 'alex@gmail.com', 'Alex', 'Johnson', '+44 7911 123456', NULL, NULL),
	(4, 'emilybrown', 'emily123', 'emily@gmail.com', 'Emily', 'Brown', '+33 612 345678', NULL, NULL),
	(5, 'michaelwilliams', 'michael123', 'michael@gmail.com', 'Michael', 'Williams', '+49 170 1234567', NULL, NULL),
	(6, 'sarahjones', 'sarah123', 'sarah@gmail.com', 'Sarah', 'Jones', '+1 408 555 1234', NULL, NULL),
	(7, 'davismiller', 'davis123', 'davis@gmail.com', 'Davis', 'Miller', '+61 412 345 678', NULL, NULL),
	(8, 'lauragarcia', 'laura123', 'laura@gmail.com', 'Laura', 'Garcia', '+34 612 345678', NULL, NULL),
	(9, 'robertmartinez', 'robert123', 'robert@gmail.com', 'Robert', 'Martinez', '+52 1 55 1234', NULL, NULL),
	(10, 'lindawilson', 'linda123', 'linda@gmail.com', 'Linda', 'Wilson', '+81 90 1234 57', NULL, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
