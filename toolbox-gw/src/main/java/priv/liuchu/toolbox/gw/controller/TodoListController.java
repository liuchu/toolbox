package priv.liuchu.toolbox.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.liuchu.toolbox.common.Result;
import priv.liuchu.toolbox.todolistapi.UserApi;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;

@RestController
@RequestMapping("/dodolist")
public class TodoListController {

    private final UserApi userApi;

    public TodoListController(UserApi userApi) {
        this.userApi = userApi;
    }

    @RequestMapping
    public Result createUser(@RequestBody CreateUserDTO dto) {
        userApi.createUser(dto);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .build();
    }
}
