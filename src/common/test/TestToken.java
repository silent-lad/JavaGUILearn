package common.test;

import common.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestToken
{
    Token mainToken;

    @BeforeEach
    public void ConstructToken()
    {
        mainToken = new Token("");
    }

    @Test
    public void TestSetTokenThroughConstructor()
    {
        mainToken = new Token("test value");

        assertEquals("test value", mainToken.GetToken());
    }

    @Test
    public void TestSetToken()
    {
        mainToken.SetToken("some token");

        assertEquals("some token", mainToken.GetToken());
    }

    @Test
    public void TestSetTokenTwoObjects()
    {
        mainToken = new Token("my main token!");
        Token secondToken = new Token("my second token!");

        assertEquals("my main token!", mainToken.GetToken());
        assertEquals("my second token!", secondToken.GetToken());
    }
}
