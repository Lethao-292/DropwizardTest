package org.example;

import io.dropwizard.jdbi3.JdbiFactory;
import org.example.controller.EmployeeRESTController;
import io.dropwizard.core.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application extends io.dropwizard.core.Application<DBConfiguration> {
  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @Override
  public void run(DBConfiguration configuration, Environment environment) throws Exception {
    LOGGER.info("Registering REST resources");
    final JdbiFactory factory = new JdbiFactory();
    final Jdbi jdbi = factory.build(environment, configuration.getDatasourceFactory(), "postgresql");
    environment.jersey().register(new EmployeeRESTController(environment.getValidator(), jdbi));
  }

  public static void main(String[] args) throws Exception {
    new Application().run(args);
  }
}