package in.blogspot.codewithnikhil.messenger.model;

import java.util.List;

public class Authors
{

    private List<String> author;

    public Authors()
    {
    }

    public Authors(List<String> author)
    {
        this.author = author;
    }

    public List<String> getAuthor()
    {
        return author;
    }

    public void setAuthor(List<String> author)
    {
        this.author = author;
    }

}
