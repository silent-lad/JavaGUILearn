package common.networking;

import java.io.Serializable;

/**
 * This is the Message class, which could be thought of as a Packet that gets sent between two hosts.
 * The Message may be of type Request or Response.
 * This class is also serializable as it gets sent over the network between hosts.
 */
public class Message implements Serializable
{
    // The content, or body, of the Message
    public String content;
}
