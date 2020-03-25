/***
 * PropsParser class
 * CAB302 QUT 2020
 */

package server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * The PropsParser class is used by server Main class.
 */
public class PropsParser
{
    // The "names" found in the db.props file
    // Remember the file follows the following structure:
    // name = value
    // This is inspired from the structure of an INI file
    Properties properties;

    // The location of the props file in the filesystem
    private String fileLocation;

    // Data found in db.props file
    private String URL, Database, Username, Password;

    // The regular expression used to extract data from the props file
    // This will typically be what a key looks like and will select
    // the name and value
    // Example:
    // jdbc.url = 127.0.0.1
    // the ip address is the value that we want to extract and so
    // will be targeted using the regular expression as well as
    // the jdbc.url, which is the name
    // [a-z]+.[a-z]+[ ]*=[ ]*([\S]+)
    private static final Pattern dataPattern = Pattern.compile("([a-z]+[.]*[a-z]+)[ ]*=[ ]*([\\S]+)");

    /***
     *
     * @param fileLocation The location of the props file to be parsed
     * @throws IOException If the file is not accessible due to insufficient user privileges, the file does not exist, insufficient RAM, etc...
     */
    PropsParser(String fileLocation)
    {
        this.fileLocation = fileLocation;

        properties = new Properties();
    }

    /*****
     * Retrieves the data from the props file
     * @throws IOException
     */
    public boolean ExtractData()
    {
        try
        {
            // Attempt to open the file and extract data
            List<String> propsFile = Files.readAllLines(Paths.get(this.fileLocation));

            // Loop through all the lines and extract the data
            for(String line : propsFile)
            {
                // Skip comments
                if(line.charAt(0) == '#' || line.charAt(0) == '!')
                    continue;

                Matcher matches = dataPattern.matcher(line);

                if(line != null && matches.find())
                {
                    // Check if the property contains both the key and value
                    if(matches.groupCount() != 2)
                    {
                        // Corrupt property, warn user and skip
                        System.out.println("Parser Error: The following property in file "+ fileLocation +" appears to be corrupt: " + line);
                        continue;
                    }

                    // Place the property (key & value) in the properties Map
                    properties.put(matches.group(1), matches.group(2));
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Parser Error: The Parser has encountered an Exception, which states: " + e);
            return false;
        }
        return true;
    }

    /*****
     *
     * @param name the name of the key
     * @return the value of the name
     */
    public String GetValue(String name)
    {
        // TODO: make sure that properties is not NULL!
        return properties.getProperty(name);
    }


}
