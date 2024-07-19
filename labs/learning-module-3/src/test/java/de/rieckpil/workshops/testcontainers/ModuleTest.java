package de.rieckpil.workshops.testcontainers;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.utility.DockerImageName;

class ModuleTest {

  private PostgreSQLContainer<?> postgresModule =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
      .withInitScript("init.sql")
      .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("postgres")))
      .withDatabaseName("postgres")
      .withPassword("changeme")
      .withUsername("duke");

  @Test
  void containerModuleTest() {
    postgresModule.start();

    System.out.println(postgresModule.getJdbcUrl());

    postgresModule.stop();
  }
}
