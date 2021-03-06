INSERT INTO `watch` (`watch_id`, `watch_name`, `unit_price`) VALUES ('001', 'Rolex', 100);
INSERT INTO `watch` (`watch_id`, `watch_name`, `unit_price`) VALUES ('002', 'Michael Kors', 80);
INSERT INTO `watch` (`watch_id`, `watch_name`, `unit_price`) VALUES ('003', 'Swatch', 50);
INSERT INTO `watch` (`watch_id`, `watch_name`, `unit_price`) VALUES ('004', 'Casio', 30);

INSERT INTO `discount` (`min_units`, `price_for_min_units`, `watch`)
SELECT 3, 200, id
FROM `watch`
WHERE watch_name = 'Rolex'
LIMIT 1;

INSERT INTO `discount` (`min_units`, `price_for_min_units`, `watch`)
SELECT 2, 120, id
FROM `watch`
WHERE watch_name = 'Michael Kors'
LIMIT 1;