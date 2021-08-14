package priv.liuchu.toolbox.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"priv.liuchu.toolbox.todolistapi"})
public class ToolboxWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolboxWebApplication.class, args);
    }

}
