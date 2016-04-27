package org.teonit.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataConfig.class, TestConfig.class})
public class RootConfig {

}
