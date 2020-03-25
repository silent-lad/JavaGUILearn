package common.networking;

import java.io.*;
import java.net.Socket;

/**
 * The Connection class is a sort of abstraction layer that provides easy access to necessary Network functionality.
 * These include being able to send and receive Messages, without having to worry about other details.
 */

public class Connection
{
    // The IP address of the host that we are connecting to
    private String ipAddress;
    // The port of the host that we are connecting to
    private int port;

    // The last response given by the host
    private Response lastResponse = null;

    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    /**
     *
     * @param ipAddress The IPv4 Address of the host
     * @param port The port of the host
     */
    public Connection(String ipAddress, int port)
    {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    /**
     * Attempts to connect to the host
     * @throws Exception When unable to connect to host
     */
    public void Connect() throws Exception
    {
        try
        {
            socket = new Socket(ipAddress, port);

            // Get the output stream, so we can write to it
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            // Get the input stream, so we can accept the incoming data
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    /**
     * Disconnects from host
     * @throws Exception If unable to disconnect from host
     */
    public void Disconnect() throws Exception
    {
        if(socket.isConnected())
        {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }
        else throw new Exception("No socket established, Network.Close failed");
    }

    /**
     * Checks if the host is alive or not
     * @return whether host is alive or not
     */
    public boolean IsAlive()
    {
        return socket.isConnected();
    }

    /**
     * Sends a Request (Message)
     * @param request The Request to send
     * @throws Exception If unable to send Request to host
     */
    public void SendRequest(Request request) throws Exception
    {
        if(socket.isConnected())
        {
            // Write the serialised object to the output stream
            objectOutputStream.writeObject(request);

            // Get back response
            Response response = (Response) objectInputStream.readObject();
            // Set the last response to the current response
            lastResponse = response;
        }
        else throw new Exception("There is no socket established, please make sure to call Network.Connect first");
    }

    /**
     * Retrieves the last Response given by the host
     * @return Last Response given by host
     */
    public Response GetLastResponse()
    {
        return lastResponse;
    }

}
