package br.com.fmoyses.serverinfo.core;

import com.mongodb.MongoClient;
import io.dropwizard.lifecycle.Managed;

/**
 * Created by Fernando on 21/09/2014.
 */
public class MongoClientManager implements Managed {

    private MongoClient mongoClient;

    public MongoClientManager(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongoClient.close();
    }
}
