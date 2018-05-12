package app.init;

import app.repositories.ItemRepository;
import app.repositories.UserRepository;
import app.services.ItemService;
import app.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "app")
@EnableWebMvc
public class AppConfig  extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = jndi.lookup("java:comp/env/jdbc/callboard", DataSource.class);
        } catch (NamingException e) {
            //logger.error("NamingException for java:comp/env/jdbc/yourname", e);
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbctempl(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



    @Bean
    public UserRepository userRepository(){return new UserRepository(jdbctempl(dataSource()));}

    @Bean
    public UserService userService(){return new UserService(userRepository());}

    @Bean
    public ItemRepository itemRepository(){return new ItemRepository(jdbctempl(dataSource()));}

    @Bean
    public ItemService itemService(){return new ItemService(itemRepository());}
}
