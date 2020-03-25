package common;

/**
 * @author Ahmed El-Naggar
 * This class pretains to the security Tokens used in communication between hosts
 */
public class Token
{
    // The security Token
    private String token;

    /**
     * The constructor for the Token object
     * @param token the String to set the Token to
     */
    public Token(String token)
    {
        this.token = token;
    }

    /**
     * Set's the String of the Token object
     * @param token the String to set the Token object to
     */
    public void SetToken(String token)
    {
        this.token = token;
    }

    /**
     * Retrieves the String of the Token object
     * @return the string of the Token object
     */
    public String GetToken()
    {
        return token;
    }
}
