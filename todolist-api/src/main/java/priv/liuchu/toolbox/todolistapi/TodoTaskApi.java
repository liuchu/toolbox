package priv.liuchu.toolbox.todolistapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolistapi.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolistapi.dto.TodoTaskDTO;

import java.util.List;

@FeignClient(value = "todolist", path = "/task")
public interface TodoTaskApi {

    @PostMapping("/create")
    void createTask(@RequestBody CreateTaskDTO dto);

    @GetMapping("/list")
    List<TodoTaskDTO> queryTasks(@RequestParam("userId")int userId, @RequestParam("categoryId")int categoryId);

    @PostMapping("/done")
    void completeTask(@RequestParam("taskId") int taskId);

    @GetMapping("/{taskId}")
    TodoTaskDTO queryTask(@PathVariable int taskId);
}
