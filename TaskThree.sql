SELECT * FROM category;
SELECT * FROM film
RIGHT JOIN film_category ON film_category.film_id WHERE film_category.category_id = 11;
