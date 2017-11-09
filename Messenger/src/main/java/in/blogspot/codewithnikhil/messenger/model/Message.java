package in.blogspot.codewithnikhil.messenger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message
{

    private long id;
    private String message;
    private Date created;
    private Authors Messageauthors;

    public Message()
    {
    }

    public Message(long id, String message, Authors Messageauthor)
    {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.Messageauthors = Messageauthor;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Authors getMessageauthors()
    {
        return Messageauthors;
    }

    public void setMessageauthors(Authors Messageauthors)
    {
        this.Messageauthors = Messageauthors;
    }

}
