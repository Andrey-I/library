package org.teonit.library.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "org.teonit.library.repositories")
@EnableTransactionManagement
@PropertySource("classpath:library.properties")
public class DataConfig extends Neo4jConfiguration {

	public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL")
			: "http://localhost:7474";

	@Autowired
	Environment env;
	
	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
	   config
	       .driverConfiguration()
	       .setDriverClassName(env.getProperty("library.neo4j.driver","org.neo4j.ogm.drivers.http.driver.HttpDriver"))
	       .setURI(env.getProperty("library.neo4j.URI","http://localhost:7474"))
	       .setCredentials("neo4j","neo");
	   return config;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory(getConfiguration(), "org.teonit.library.domain");
	}

}
