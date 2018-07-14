package com.web.messenger.config;

import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class Mustache {
	@Bean
	public com.samskivert.mustache.Mustache.Compiler mustacheCompiler(
			com.samskivert.mustache.Mustache.TemplateLoader templateLoader,
			Environment environment) {

		MustacheEnvironmentCollector collector
				= new MustacheEnvironmentCollector();
		collector.setEnvironment(environment);

		return com.samskivert.mustache.Mustache.compiler()
				.defaultValue("Some Default Value")
				.withLoader(templateLoader)
				.withCollector(collector);
	}
}
