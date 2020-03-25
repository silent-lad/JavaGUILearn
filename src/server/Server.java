/***
 * Server class
 * CAB302 QUT 2020
 */

package server;

import common.networking.Message;
import common.networking.Response;
import javax.swing.*;
import java.sql.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * The Server class contains the logic for passing data between the
 * database and the control panel as well as between the control
 * panel and the viewer.
 */
public class Server {
    // This is the default username & password for when the database is empty
    // and the server has to populate it with the appropriate tables
    private static final String defaultUsername = "admin";
    private static final String defaultPassword = "password";

    // The main handle to the Database connection
    private static DBConnection dbConnection;

    public static void main(String[] args)
    {
        // 1 Attempt to connect to Database
        // 1.1 Gather required data to connect to database from db.props

        PropsParser parser = new PropsParser("./resources/db.props");

        if(parser.ExtractData())
        {
            String url = parser.GetValue("jdbc.url");
            String dbName = parser.GetValue("jdbc.schema");
            String username = parser.GetValue("jdbc.username");
            String password = parser.GetValue("jdbc.password");

            dbConnection = new DBConnection(url, username, password, dbName);

            if(dbConnection.Connect())
            {
                try
                {
                    ServerSocket serverSocket = new ServerSocket(7777);
                    System.out.println("Server awaiting connections...");

                    while (true)
                    {
                        try
                        {
                            // Accept client
                            Socket socket = serverSocket.accept();
                            System.out.println("New client connected: " + socket);

                            // Create new Thread for client
                            System.out.println("Creating thread for client...");
                            ServerThread newThread = new ServerThread(socket);
                            newThread.start();

                        } catch (Exception e)
                        {
                            throw e;
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

                // Close the database connection once the server finishes
                dbConnection.Disconnect();
            }
            else
            {
                System.out.println("Server Error: Unable to connect to Database Server\nServer exiting...");
            }
        }
        else
        {
            System.out.println("Server Error: Unable to parse db.props file\nServer exiting...");
        }
    }
}

