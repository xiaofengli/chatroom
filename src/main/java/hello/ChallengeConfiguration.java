package hello;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

class ChallengeConfiguration extends Configuration {
	
	 @Valid
	 @NotNull
	 @JsonProperty("database")
    public DataSourceFactory database = new DataSourceFactory();
    
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
