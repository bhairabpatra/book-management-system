package bookapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Books management app",
				version = "1.0.0",
				description = "This is books management app",
				contact = @Contact(
							name = "Mr Bhairab",
							email = "test@gmail.com"
				),
				license = @License(
							name = "Test@123",
							url = "test@gmail.com"
				)
		)
)
public class BookappApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookappApplication.class, args);
	}

}
