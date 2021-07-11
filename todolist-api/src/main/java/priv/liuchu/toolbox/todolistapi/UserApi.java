package priv.liuchu.toolbox.todolistapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;

@FeignClient("todolist-service")
public interface UserApi {

    @PostMapping("/create")
    void createUser(@RequestBody CreateUserDTO dto);
}
