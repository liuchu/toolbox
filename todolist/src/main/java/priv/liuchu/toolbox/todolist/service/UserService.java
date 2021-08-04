package priv.liuchu.toolbox.todolist.service;

import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolistapi.dto.UserDTO;

public interface UserService {

    void createUser(CreateUserDTO dto);

    UserDTO queryById(int id);
}
