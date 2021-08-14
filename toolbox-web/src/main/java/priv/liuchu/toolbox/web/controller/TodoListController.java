package priv.liuchu.toolbox.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.liuchu.toolbox.common.Result;
import priv.liuchu.toolbox.todolistapi.UserApi;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolistapi.dto.UserDTO;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    private UserApi userApi;

    @PostMapping("/user/create")
    public Result createUser(@RequestBody CreateUserDTO dto) {
        userApi.createUser(dto);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .build();
    }

    @RequestMapping("/user/{userId}")
    public Result queryUser(@PathVariable int userId){
        UserDTO userDTO = userApi.queryUserById(userId);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .result(userDTO)
                .build();
    }
}
