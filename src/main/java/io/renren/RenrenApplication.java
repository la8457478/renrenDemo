package io.renren;

import io.renren.datasources.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan(basePackages={"io.renren.modules.mapper","io.renren.modules.oss.dao"})
@Import({DynamicDataSourceConfig.class})
public class RenrenApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RenrenApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RenrenApplication.class);
	}
}
