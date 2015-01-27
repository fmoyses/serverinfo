package br.com.fmoyses.serverinfo.resources;

import br.com.fmoyses.serverinfo.core.ServerInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Fernando on 21/09/2014.
 */
@Path("/server-info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServerInfoPostResource {

    private JacksonDBCollection<ServerInfo, String> collection;

    public ServerInfoPostResource(JacksonDBCollection<ServerInfo, String> collection) {
        this.collection = collection;
    }

    @POST
    public Response post(ServerInfo serverInfo) {
        DBObject nameIndex = new BasicDBObject();
        nameIndex.put("customer",1);
        nameIndex.put("server",1);
        nameIndex.put("collectionDate",1);
        nameIndex.put("sendDate",1);
        DBObject nameIndexOptions = new BasicDBObject("unique", true);
        collection.createIndex(nameIndex, nameIndexOptions);
        WriteResult<ServerInfo, String> result = collection.save(serverInfo);
        return Response.ok(result.getSavedObject()).build();
    }
}
