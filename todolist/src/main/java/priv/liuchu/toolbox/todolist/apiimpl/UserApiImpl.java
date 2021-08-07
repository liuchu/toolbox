package priv.liuchu.toolbox.todolist.apiimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.liuchu.toolbox.todolist.service.UserService;
import priv.liuchu.toolbox.todolistapi.UserApi;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolistapi.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public void createUser(CreateUserDTO dto) {
        userService.createUser(dto);
    }

    @Override
    public UserDTO queryUserById(int userId) {
        return userService.queryById(userId);
    }
}
