package common.networking;

public class Request extends Message
{
    // The type of Request that can be sent
    public enum Type
    {
        // Viewer
        Get_Current_Bill_Board,

        // Control Panel
        Login,
        List_Billboards,
        Get_Billboard_Info,
        Create_Edit_Billboard,
        Delete_Billboard,
        View_Schedule,
        Schedule_Billboard,
    }
    // The security token to go along with the message
    // this is used for authentication purposes
    private String token;
    // The type of Request this is (e.g. is it a Login Request?)
    public Type requestType;

    /**
     *
     * @param type The Type of Request that is going to be sent
     * @param content The content (body) that is going to be sent
     */
    public Request(Type type, String content)
    {
        requestType = type;
        super.content = content;
    }

    /**
     * Sets the Token of the Request, in case authorisation is required
     * @param token The security Token given by the Server
     */
    public void SetToken(String token)
    {
        this.token = token;
    }
}
