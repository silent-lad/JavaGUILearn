package server;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * This class handles all Database related connections
 * @author Ahmed & Kiri
 */

public class DBConnection
{
    // The URL of the server
    private String URL;
    // The username to authenticate to the MariaDB server
    private String username;
    // The password to allow authentication to the MariaDB server
    private String password;
    // The name of the database
    private String databaseName;

    // The main connection handle
    private Connection mainConnection = null;

    /**
     * Creates an instance of DBConnection
     * @param URL The URL of the MariaDB server
     * @param username The username to authenticate with
     * @param password The password associated with the username
     * @param databaseName The name of the database
     */
    public DBConnection(String URL, String username, String password, String databaseName)
    {
        this.URL = URL;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
    }

    /**
     * Attempts to connect to the MariaDB server
     * @return whether or not a connection was able to be established
     */
    public boolean Connect()
    {
        try
        {
            mainConnection = DriverManager.getConnection(URL + "/" + databaseName + "?user=" + username + "&password=" + password);
        }
        catch (Exception e)
        {
            System.out.println("Server Error: Unable to connect to Database, Exception states: " + e);
            return false;
        }
        return true;
    }

    /**
     * Attempts to close the connection
     */
    public void Disconnect()
    {
        try
        {
            mainConnection.close();
        }
        catch (Exception e)
        {
            System.out.println("Server Error: Unable to close MariaDB Connection");
        }
    }

    public void IsConnected()
    {
        //return !mainConnection.isClosed();
    }

    public void SendQuery()
    {

    }
}
