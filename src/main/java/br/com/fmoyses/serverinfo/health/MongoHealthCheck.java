package br.com.fmoyses.serverinfo.health;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.MongoClient;

/**
 * Created by Fernando on 22/09/2014.
 */
public class MongoHealthCheck extends HealthCheck {

    private MongoClient mongoClient;

    public MongoHealthCheck(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public Result check() throws Exception {
        mongoClient.getDatabaseNames();
        return Result.healthy();
    }

}
