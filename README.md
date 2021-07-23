How to run the application

The application is started using maven. To run the application:

1) Start it up
On Windows: ./mvnw.cmd spring-boot:run

On Linux or MacOs ./mvnw spring-boot:run

2) Send post request for endpoint http://localhost:8080/game/play with JSON body, example:
{
“words”: [
“fish”,
“horse”,
“egg”’,
“goose”,
“eagle”
]
}

3) The input and output will be JSON.

How the application works:
1) It’s simple project that consists of two main classes "WordsController" and "WordService".

2) This application read JSON array and output only those words that start with the last letter of the previous word.

3) The application uses JUnit be covered with tests, the command "mvn package" automatically runs tests.

