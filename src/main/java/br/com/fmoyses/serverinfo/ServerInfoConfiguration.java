package br.com.fmoyses.serverinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Fernando on 21/09/2014.
 */
public class ServerInfoConfiguration extends Configuration {

    @NotEmpty
    private String mongohost = "localhost";

    @Min(1)
    @Max(65535)
    private int mongoport = 27017;

    private String mongodb = "serverinfo";
    private String mongouser = "admin";
    private String mongopass = null;

    @JsonProperty
    public String getMongohost() {
        return mongohost;
    }

    @JsonProperty
    public void setMongohost(String mongohost) {
        this.mongohost = mongohost;
    }

    @JsonProperty
    public int getMongoport() {
        return mongoport;
    }

    @JsonProperty
    public void setMongoport(int mongoport) {
        this.mongoport = mongoport;
    }

    @JsonProperty
    public String getMongodb() {
        return mongodb;
    }

    @JsonProperty
    public void setMongodb(String mongodb) {
        this.mongodb = mongodb;
    }

    @JsonProperty
	public String getMongouser() {
		return mongouser;
	}

    @JsonProperty
	public void setMongouser(String mongouser) {
		this.mongouser = mongouser;
	}

    @JsonProperty
	public String getMongopass() {
		return mongopass;
	}

    @JsonProperty
	public void setMongopass(String mongopass) {
		this.mongopass = mongopass;
	}
    
    
}
