package br.com.fmoyses.serverinfo;

import br.com.fmoyses.serverinfo.core.MongoClientManager;
import br.com.fmoyses.serverinfo.core.ServerInfo;
import br.com.fmoyses.serverinfo.health.MongoHealthCheck;
import br.com.fmoyses.serverinfo.resources.ServerInfoPostResource;
import br.com.fmoyses.serverinfo.resources.ServerInfoResource;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.mongojack.JacksonDBCollection;

/**
 * Created by Fernando on 21/09/2014.
 */
public class ServerInfoApplication extends Application<ServerInfoConfiguration>  {

    public static void main(String[] args) throws Exception {
        new ServerInfoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServerInfoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ServerInfoConfiguration configuration,
                    Environment environment) throws Exception {
        MongoClient mongoClient = new MongoClient(configuration.mongohost, configuration.mongoport);
        MongoClientManager mongoManaged = new MongoClientManager(mongoClient);
        environment.healthChecks().register("MongoHealthCheck", new MongoHealthCheck(mongoClient));
        environment.lifecycle().manage(mongoManaged);

        DB db = mongoClient.getDB(configuration.mongodb);
        JacksonDBCollection<ServerInfo, String> serverInfo =
                JacksonDBCollection.wrap(db.getCollection("serverInfo"), ServerInfo.class, String.class);

        environment.jersey().register(new ServerInfoPostResource(serverInfo));
        environment.jersey().register(new ServerInfoResource(serverInfo));
    }
}
