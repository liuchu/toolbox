package priv.liuchu.toolbox.todolist.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.liuchu.toolbox.todolist.service.UserService;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void createUser() {

        userService.createUser(
                new CreateUserDTO()
                        .setNickName("liuchu")
                        .setEmail("liuchuu@126.com"));
    }
}