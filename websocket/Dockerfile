FROM java:8
# Make port 8080 available to the world outside this container
EXPOSE 8080
ADD target/websocket.jar websocket.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","websocket.jar"]