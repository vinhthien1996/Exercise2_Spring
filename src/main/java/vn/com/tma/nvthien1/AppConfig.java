package vn.com.tma.nvthien1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "vn.com.tma.nvthien1")
public class AppConfig {
	@Bean
	@Scope("singleton")
	public Student student() {
	    return new Student();
	}
}
