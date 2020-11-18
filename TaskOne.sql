USE sakila;
SELECT * FROM actor;
SELECT * FROM actor WHERE last_name LIKE '%CAGE%';
SELECT * FROM actor WHERE first_name NOT LIKE '%ZERO%'
AND first_name NOT LIKE '%Nick%';
SELECT * FROM actor WHERE first_name IN ('NICK', 'JOHNNY', 'JAMES', 'MORGAN', 'WHOOPI');
SELECT * FROM actor WHERE actor_id BETWEEN 50 AND 150;
SELECT * FROM actor WHERE first_name LIKE 'C%';
SELECT * FROM actor ORDER BY first_name;
SELECT * FROM actor ORDER BY last_name DESC;
SELECT COUNT(*) FROM actor;
SELECT COUNT(DISTINCT first_name) FROM actor;
SELECT * from film_category WHERE category_id IN(11);