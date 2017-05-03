# Remote-method-invocation-chat-system

Step1: Open first command prompt. Provide the path of the project. Run the server side by giving the command “rmic”.

Step 2: In the same command prompt provide the client side information by again giving the rmic command "rmic chatClient.Client"

Step 3: In the same command prompt run the registry by giving the command "rmiregistry".

Step 4: Open second command prompt and enter the path again. Give the server side path to run ServerMain "java chatServer.ServerMain"

Step 5: Open third command prompt. Provide the path and enter the client’s name, location (X and Y axis) and age. 
        "java chatClient.ClientMain XYZ 30 55 23"

Step 6: Open the fourth command prompt. Provide path and enter second client’s information like in step 5. 
        "java chatClient.ClientMain ABC 78 49 20"

Step 7: Next step is implement “go” and “get location” feature of the program. As an example “go -50 30“ will shift its current location of client from 50m south and 30m east.

Step 8: “list 30” command will get all the clients available within the range of 30 m. 
