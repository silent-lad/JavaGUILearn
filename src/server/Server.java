/***
 * Server class
 * CAB302 QUT 2020
 */

package server;

/***
 * The Server class contains the logic for passing data between the
 * database and the control panel as well as between the control
 * panel and the viewer.
 */
public class Server
{
    public static void main(String[] args)
    {
        // 1 Attempt to connect to Database
        // 1.1 Gather required data to connect to database from db.props

        PropsParser propsParser;

        try
        {
            propsParser = new PropsParser("./resources/db.props");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
