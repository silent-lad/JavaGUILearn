package common.networking.test;

import common.networking.Request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRequest
{
    @Test
    public void TestConstructor()
    {
        Request myRequest = new Request(Request.Type.Login, "my content!");

        assertEquals(Request.Type.Login, myRequest.requestType);

        assertEquals("my content!", myRequest.content);
    }

    @Test
    public void TestSettingContentAndType()
    {
        Request mainRequest = new Request(Request.Type.Login, "");

        mainRequest.content = "some content!";

        assertEquals("some content!", mainRequest.content);

        mainRequest.requestType = Request.Type.Create_Edit_Billboard;

        assertEquals(Request.Type.Create_Edit_Billboard, mainRequest.requestType);
    }

}
