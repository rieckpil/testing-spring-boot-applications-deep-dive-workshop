package de.rieckpil.workshops.testcontainers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
class LifecycleTest {

  @Container
  private static final PostgreSQLContainer<?> CONTAINER_PER_CLASS =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.3"))
      .withPassword("changeme")
      .withUsername("duke");


  @Container
  private PostgreSQLContainer<?> containerPerTest =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.3"))
      .withPassword("changeme")
      .withUsername("duke");

  @Test
  void firstTest() {
    System.out.println(CONTAINER_PER_CLASS.getJdbcUrl());
    System.out.println(containerPerTest.getJdbcUrl());
  }

  @Test
  void secondTest() {
    System.out.println(CONTAINER_PER_CLASS.getJdbcUrl());
    System.out.println(containerPerTest.getJdbcUrl());
  }
}
