package in.blogspot.codewithnikhil.messenger.resources;

import in.blogspot.codewithnikhil.messenger.model.Message;
import in.blogspot.codewithnikhil.messenger.service.MessageService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/messages")
public class MessageResource
{

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessageForYear(@QueryParam("year") int ye,
            @QueryParam("start") int start,
            @QueryParam("size") int size)
    {
        if (ye > 0)
        {
            return messageService.getAllMessagesForYear(ye);
        }
        else if (start > 0 && size > 0)
        {
            return messageService.getAllMessagesPaginated(start - 1, size);
        }
        else
        {
            return messageService.getAllMessages();
        }
    }

    @DELETE
    @Path("{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") long id)
    {
        messageService.removeMessage(id);
    }

    @PUT
    @Path("{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message)
    {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException
    {
        Message newMessage = messageService.addMessage(message);
        return Response.created(new URI(uriInfo.getAbsolutePath().toString() + newMessage.getId()))
                .entity(newMessage)
                .build();
//        return messageService.addMessage(message);
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        System.out.println(messageService.getMessage(messageId));
        return messageService.getMessage(messageId);
    }
}
