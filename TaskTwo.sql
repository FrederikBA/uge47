INSERT INTO actor(first_name,last_name) VALUES ("Frederik","Andersen");
INSERT INTO film_actor(actor_id,film_id) VALUES (201,627);
INSERT INTO film_actor(actor_id,film_id) VALUES (201,835);
INSERT INTO film_actor(actor_id,film_id) VALUES (201,123);
INSERT INTO film_actor(actor_id,film_id) VALUES (201,5);
INSERT INTO film_actor(actor_id,film_id) VALUES (201,94);
SELECT * FROM film_actor WHERE actor_id LIKE 201;
UPDATE actor SET first_name = 'Frederick', last_name = 'Nietzsche' WHERE actor_id = 201;
DELETE FROM film_actor WHERE actor_id=201;
DELETE FROM actor WHERE actor_id=201;