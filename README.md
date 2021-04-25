# QuizAppBackend
Java Backend for the QuizApp. It uses the Spring-Framework. It can register/login Users and save incoming questions into an h2 database. 
This Backend has several REST-Endpoints to save and get data out of the h2 database. 


## How to Start

To start this Spring-Boot Server just run the main function inside the `BackendApplication.java` file. 

If you want to use the REST-Endpoints you can use Postman to send the HTTP Requests. There is a Postman-Collection stored inside the Projekt. 
Currently, there are seven Endpoints. These Endpoints are: 

HTTP-POST-Request

`/quizapp/insertQuestion`

`/quizapp/login`

`/quizapp/register`

HTTP-GET-Request

`/quizapp/update-score`

`/quizapp/get-question`

`/quizapp/get-all-questions`

`/quizapp/get-all-users`

You need to set the HTTP Header fields `Content-Type` and `Accept` to `application/json`. 
