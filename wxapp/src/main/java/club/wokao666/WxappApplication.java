package club.wokao666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
//@ComponentScan(basePackages= "club.wokao666")
public class WxappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxappApplication.class, args);
	}
}
