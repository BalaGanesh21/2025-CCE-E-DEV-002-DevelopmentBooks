#BookOrderPrice Calculator 

Spring boot application to calculates the total price of a collection of books with discount rules applied. 
It takes a list of books and their quantities via a POST API and returns the total discounted price.


#Features

- Accepts a `Map<String, Integer>` of book titles and quantities via POST API.
- Applies a optimized grouping to minimize the total price.
- Removes books that are not listed in the book catalog.
- Calculates discount based on the number of unique books in each group.


#TechStack

- Java 8
- Spring Boot
- Junit


#Discount Rules

|       UniqueBooks     |  Discount    |
------------------------------------
| 2                     | 5%           |
| 3                     | 10%          |
| 4                     | 20%          |
| 5                     | 25%          |
| 1 or others           | No Discount  |


#Book Catalog

Only the following books are eligible:

- Clean Code
- Clean Coder
- Clean Architecture
- Test Driven Development
- Working effectively with Legacy Code


#API EndPoint
#Post request "/books/bookPrice"

#Request
Sample json request----

{
	"books": [
		{
			"name": "Clean Code",
			"count": 2
		},
		{
			"name": "Clean Coder",
			"count": 2
		},
		{
			"name": "Clean Architecture",
			"count": 2
		},
		{
			"name": "Test Driven Development",
			"count": 1
		},
		{
			"name": "Working effectively with Legacy Code",
			"count": 1
		}
	]
}

#Response:(String)

{
    "message": "Total price for the given list of books",
    "price": 320.0
}

#SwaggerAPI
http://localhost:8080/swagger-ui/index.html#/book-controller/calculateBookprice

#SwaggerDoc
http://localhost:8080/v3/api-docs
