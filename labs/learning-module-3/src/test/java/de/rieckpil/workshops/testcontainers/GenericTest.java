package de.rieckpil.workshops.testcontainers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

class GenericTest {

  private GenericContainer<?> genericContainer = new GenericContainer<>(DockerImageName.parse("postgres:16.3"))
    .waitingFor(new LogMessageWaitStrategy()
      .withRegEx(".*database system is ready to accept connections.*\\s")
      .withTimes(2)
      .withStartupTimeout(Duration.of(60, ChronoUnit.SECONDS)))
    .withExposedPorts(5432)
    .withEnv(Map.of(
      "POSTGRES_PASSWORD", "changeme",
      "POSTGRES_USERNAME", "duke",
      "POSTGRES_DATABASE", "postgres"
    ));

  @Test
  void basicContainer() {
    genericContainer.start();

    System.out.println("PostgreSQL database port is mapped to ephemeral port " + genericContainer.getMappedPort(5432));

    genericContainer.stop();
  }

}
