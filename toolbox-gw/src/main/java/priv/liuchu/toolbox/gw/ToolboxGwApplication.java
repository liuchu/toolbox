package priv.liuchu.toolbox.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"priv.liuchu.toolbox.todolistapi"})
public class ToolboxGwApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolboxGwApplication.class, args);
    }

}
