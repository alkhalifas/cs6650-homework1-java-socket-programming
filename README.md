# CS6650 Homework 1
## Java Socket Programming


#### Instructions to Run:

    # Go to src directory
    cd src

    # Compile the two classes
    javac Server.java 
    javac Client.java

    # Run Server
    java Server 32000

    # Run Client
    java Client 127.0.0.1 32000

    # Once running, enter text

    # Example:
    # Client Sends: "Game of Thrones"
    # Server Returns: "SENORHt FO EMAg"

#### Backlog:
- [X] Implement a TCP client and server.
- [X] You can use Java
- [X] The server will start in passive mode listening for a transmission from the client. 
- [X] The client will then start and contact the server
- [X] The client will pass the server a string up to 80 characters
- [X] reverse all the characters
- [X] reverse the capitalization of the strings
- [X] The server should then send the string back to the client
- [X] The client will display the received string and exit.