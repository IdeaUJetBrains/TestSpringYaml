import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration (exclude={DataSourceAutoConfiguration.class})
public class ExampleController {

    @Autowired
    private Environment env;

    @Value("${section2.key1}")
    private String valueYml;



    @RequestMapping("/ExampleController/{id}")
    String home(@PathVariable String id ) {

        return "Hello World!"
                + '\n' + " id = " + id
                + ", env.getProperty(\"section2.key1\") = " + env.getProperty("${section2.key1}")
                // + new Config().getServers()
                + ", EnvironmentValue = " + valueYml;



    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
}
