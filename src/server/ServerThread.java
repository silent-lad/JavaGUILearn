package server;

import common.networking.Message;
import common.networking.Request;
import common.networking.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class handles all incoming clients and is executed in a Thread on its own for each client
 */
public class ServerThread extends Thread
{
    // The client's socket
    Socket serverClient;

    /**
     * Constructor of ServerThread
     * @param socket the Socket of the client
     */
    ServerThread(Socket socket)
    {
        serverClient = socket;
    }

    @Override
    public void run()
    {
       try
       {
           //Get output and input streams
           ObjectOutputStream outputStream = new ObjectOutputStream(serverClient.getOutputStream());
           ObjectInputStream inputStream = new ObjectInputStream(serverClient.getInputStream());

           // Retrieve Request from client
           Request receivedMessage = (Request) inputStream.readObject();

           // Handle Message
           Response response = new Response();
           switch(receivedMessage.requestType)
           {
               case Login:
               {
                   // Handle Login request
                   break;
               }
               case Create_Edit_Billboard:
               {
                   // Handle Create/Edit Billboard
                   break;
               }
               // ...
               default:
               {
                    // Invalid Request
                   response.responseType = Response.Type.Bad_Request;
                   response.content = "ERROR, bad request";
               }
           }

           // Send back a Response to the client
           outputStream.writeObject(response);

           // Close socket and end communication
           outputStream.close();
           inputStream.close();
           serverClient.close();

       } catch (Exception e)
       {
            System.out.println(e);
       }
    }

}
