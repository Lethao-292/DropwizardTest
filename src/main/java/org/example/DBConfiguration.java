package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.logback.shaded.jsr305.Nonnull;
import jakarta.validation.Valid;

public class DBConfiguration extends Configuration {
  @Valid
  @Nonnull
  private DataSourceFactory database = new DataSourceFactory();

  @JsonProperty("database")
  public DataSourceFactory getDatasourceFactory() {
    return database;
  }

  @JsonProperty("database")
  public void setDatasourceFactory(DataSourceFactory database) {
    this.database = database;
  }
}
