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

    @JsonProperty
    @NotEmpty
    public String mongohost = "localhost";

    @Min(1)
    @Max(65535)
    @JsonProperty
    public int mongoport = 27017;

    @JsonProperty @NotEmpty
    public String mongodb = "serverinfo";
}
