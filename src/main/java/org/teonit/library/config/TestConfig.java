package org.teonit.library.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.teonit.library.test.MyTestClass;


// test config class, it is scanning test package
@Configurable
@ComponentScan("org.teonit.library.test")
public class TestConfig {

	@Bean
	MyTestClass coolBean() {
		return new MyTestClass("Hello!!!!");
	}
}
