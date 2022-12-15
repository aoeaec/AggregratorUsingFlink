# Info about the Aggregator project

1. It is written in Java using Spring Boot.

Functionality

1. Accept the input parameters
2. Validate the input and then perform operation on them
3. Data is fetched from REST endpoint and fed into flink api to provide input based average
4. Error is handled using ControllerAdvice and a meaning ful msg is sent to the end user.


To Do
1. At present chunks created every nth minute of hour, n is the number mentioned in the request. It has to be changed to nth minute starting from start of stream.



Steps to run app
1. Go to the app folder and run command:: `mvn install`, this will build the jar for the project
2. Run command to build docker image :: `docker build -t spring-boot .`
3. If you want to run command from outside the app folder, please change last dor (.) with appropriate folder where you could see Dockerfile for this project
4. Once the image is built, run ::`docker run -d -p 8080:8080 -t spring-boot `

