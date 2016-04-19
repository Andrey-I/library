package org.teonit.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TestApplicationConfig extends ApplicationConfig {
	
	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
	   config
	       .driverConfiguration()
	       .setDriverClassName("org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver");
	   return config;
	}


}
