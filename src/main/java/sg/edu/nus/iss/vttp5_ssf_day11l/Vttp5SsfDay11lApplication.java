package sg.edu.nus.iss.vttp5_ssf_day11l;

import java.util.Collections;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Vttp5SsfDay11lApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Vttp5SsfDay11lApplication.class, args);

		SpringApplication app = new SpringApplication(Vttp5SsfDay11lApplication.class);

		String port = "3000";
		DefaultApplicationArguments argsOptions = new DefaultApplicationArguments(args);

		if (argsOptions.containsOption("port")) {
			port = argsOptions.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		// read file name 
		String dirFile = "";
		if (argsOptions.containsOption("file")) {
			dirFile = argsOptions.getOptionValues("file").get(0);

			System.out.println("Directory file: " + dirFile);
		}

		app.run(args);

	}

	@Bean
	public CommonsRequestLoggingFilter logging() {

		CommonsRequestLoggingFilter crlf = new CommonsRequestLoggingFilter(); 
		crlf.setIncludeClientInfo(true);
		crlf.setIncludeQueryString(true);
		return crlf; 

	}

}
