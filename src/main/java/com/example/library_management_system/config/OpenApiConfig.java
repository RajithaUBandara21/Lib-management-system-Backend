import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI libraryManagementSystemOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library Management System API")
                        .description("API documentation for Library Management System")
                        .version("1.0"));
    }
}