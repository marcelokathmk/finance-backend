package pt.com.financebackend.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pt.com.financebackend.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo())
                .tags(new Tag("Product", "Endpoints related to manage products"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Documentation to help to manage products").version("1.0.0").build();
    }
}
