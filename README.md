# Info about the Aggregator project

1. It is written in Java using Spring Boot.

Functionality

1. Accept the input parameters
2. Validate the input and then perform operation on them
3. Data is fetched from REST endpoint and fed into flink api to provide input based average
4. Error is handled using ControllerAdvice and a meaning ful msg is sent to the end user.


To Do
1. At present chunks created every nth minute of hour, n is the number mentioned in the request. It has to be changed to nth minute starting from start of stream.



