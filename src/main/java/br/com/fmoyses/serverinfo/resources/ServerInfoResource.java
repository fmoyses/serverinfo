package br.com.fmoyses.serverinfo.resources;

import br.com.fmoyses.serverinfo.core.ServerInfo;
import br.com.fmoyses.serverinfo.utils.ResourceHelper;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Fernando on 22/09/2014.
 */
@Path("/server-info/{id}")
public class ServerInfoResource {

    private JacksonDBCollection<ServerInfo, String> collection;

    public ServerInfoResource(JacksonDBCollection<ServerInfo, String> collection) {
        this.collection = collection;
    }

    @GET
    public ServerInfo getServerInfo(@PathParam("id") String id) {
        DBCursor<ServerInfo> cursor = collection.find().is("id", id);
        ResourceHelper.notFoundIfNull(cursor);

        return cursor.next();
    }
}
