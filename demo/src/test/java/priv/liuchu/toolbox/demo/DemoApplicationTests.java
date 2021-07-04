package priv.liuchu.toolbox.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import priv.liuchu.toolbox.demo.demo.User;
import priv.liuchu.toolbox.demo.demo.UserConverter;
import priv.liuchu.toolbox.demo.demo.UserDTO;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Test
    void contextLoads() {
        UserDTO user = new UserDTO().setName("hi");
        User user1 = UserConverter.INSTANCE.dtoToEntity(user);
        log.info("user: {}", user1);
    }

}
