# Thought Process

# Core Components:

1. **Core Rest Service**:
   I have used java spark framework for rest service that handles each request.Spark is a lightweight framework which made it a good choice for our simplistic rest service.
   To track unique requests, i have used an in-memory concurrent set.If scope of project becomes bigger, i will use a distributed storage solution like redis.
2. **Scheduler Service:**

   Each minute,Scheduler can write count of unique requests to a standard logger or streaming service based on requirements.
   To tackle this, i have used **strategy pattern** to implement strategies for StandardLogger and Streaming.
   For Logging, i am using **log4j**.
   For streaming, i am using **redis streams** as it is easy to get started with and looks like a good choice considering the limited scope of the project at this stage.If scope of the project increases,i will go for streaming solutions like Kafka/RabbitMQ.

   I have used docker to package this project by using Dockerfile and docker-compose.

   You can run this project by navigating to project directory and run following commands:
   `docker build -t verve-service:latest .
   docker-compose up`