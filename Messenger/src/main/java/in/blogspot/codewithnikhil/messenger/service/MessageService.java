package in.blogspot.codewithnikhil.messenger.service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import in.blogspot.codewithnikhil.messenger.database.DatabaseClass;
import in.blogspot.codewithnikhil.messenger.model.Authors;
import in.blogspot.codewithnikhil.messenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService
{

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService()
    {
        List<String> temp = new ArrayList();
        temp.add("Nikhil");
        temp.add("Aakash");

        Message m1 = new Message(1, "Hi how r u ", new Authors(temp));
        Message m2 = new Message(2, "Hi Jersey ", new Authors(temp));
        messages.put(m1.getId(), m1);
        messages.put(m2.getId(), m2);
    }

    public List<Message> getAllMessages()
    {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year)
    {
        List<Message> messageForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message msg : messages.values())
        {
            cal.setTime(msg.getCreated());
            if (cal.get(Calendar.YEAR) == year)
            {
                messageForYear.add(msg);
            }
        }
        return messageForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size)
    {
        ArrayList<Message> list = new ArrayList<>(messages.values());
        return list.subList(start, start + size);
    }

    public Message getMessage(long id)
    {
        return messages.get(id);
    }

    public Message addMessage(Message msg)
    {
        msg.setId(messages.size() + 1);
        messages.put(msg.getId(), msg);
        return msg;
    }

    public Message updateMessage(Message msg)
    {
        if (msg.getId() <= 0)
        {
            return null;
        }
        messages.put(msg.getId(), msg);
        return msg;
    }

    public Message removeMessage(long id)
    {
        if (messages.containsKey(id))
        {
            return messages.remove(id);
        }
        else
        {
            return null;
        }
    }
}
