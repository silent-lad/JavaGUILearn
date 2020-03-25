package common.networking;

public class Response extends Message
{
    // The type of Response that can be sent
    public enum Type
    {
        // Server
        User_Authorised,
        Invalid_Credentials,
        Invalid_Token,
        Bad_Request
    }

    // The Type of Response this is (e.g. was the login Request successful? Then, User_Authorised)
    public Type responseType;

    public Response()
    {

    }
    /**
     *
     * @param type The Type of Response this is
     * @param content The body of the Response
     */
    public Response(Type type, String content)
    {
        this.responseType = type;
        super.content = content;
    }
}
