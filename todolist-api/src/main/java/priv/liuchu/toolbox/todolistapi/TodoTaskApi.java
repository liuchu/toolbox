package priv.liuchu.toolbox.todolistapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;

@FeignClient(value = "todolist", path = "/task")
public interface TodoTaskApi {

    @PostMapping("/create")
    void createTask(@RequestBody CreateTaskDTO dto);
}
