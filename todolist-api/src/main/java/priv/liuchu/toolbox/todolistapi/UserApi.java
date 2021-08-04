package priv.liuchu.toolbox.todolistapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolistapi.dto.UserDTO;

@FeignClient(value = "todolist-user-service")
public interface UserApi {

    @PostMapping("/create")
    void createUser(@RequestBody CreateUserDTO dto);

    @GetMapping("/{userId}")
    UserDTO queryUserById(@PathVariable int userId);
}
