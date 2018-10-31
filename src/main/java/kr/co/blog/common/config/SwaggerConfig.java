package kr.co.blog.common.config;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer{
	@Bean
  public Docket api() {
      Docket docket = new Docket(DocumentationType.SWAGGER_2);
          docket
          .apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //@ApiOperation Annotation으로 설정된 메소드 참조
          .paths(PathSelectors.any())
          .build();

      // TODO 특정 운영환경에서만 스웨거 노출시 사용
//      if(env == null || (!"local".equals(env) && !"dev".equals(env)) ) {
//          docket.enable(false);
//      }
      return docket;
  }
	
	private ApiInfo apiInfo() {
      return new ApiInfo(
              "BLOG API Document",									//제목
              "BLOG",												//설명
              "1.0",												//버전
              null,													//termsOfServiceUrl
              new Contact("Dennis", null, "seidin1@naver.com"),		//담당자 정보(name,url,email)
              null,													//license 
              null,													//licenseUrl
              Collections.emptyList()								//vendorExtensions
              );
  }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");
      
      registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addRedirectViewController("/document", "/swagger-ui.html");
	}
	
}