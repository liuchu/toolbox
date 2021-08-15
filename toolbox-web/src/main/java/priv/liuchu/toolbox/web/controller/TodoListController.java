package priv.liuchu.toolbox.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.liuchu.toolbox.common.Result;
import priv.liuchu.toolbox.todolistapi.TodoTaskApi;
import priv.liuchu.toolbox.todolistapi.UserApi;
import priv.liuchu.toolbox.todolistapi.dto.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    private UserApi userApi;

    @Autowired
    private TodoTaskApi taskApi;

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


    @PostMapping("/task/create")
    public Result createTask(@RequestBody CreateTaskDTO dto){
        taskApi.createTask(dto);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .result(true)
                .build();
    }

    @GetMapping("/task/list")
    public Result queryTasks(QueryTasksDTO dto){
        List<TodoTaskDTO> dtos = taskApi.queryTasks(dto);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .result(dtos)
                .build();
    }

    @PostMapping("/task/done")
    public Result completeTask(@RequestParam("taskId") int taskId){

        taskApi.completeTask(taskId);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .result(true)
                .build();
    }

    @GetMapping("/task/{taskId}")
    public Result queryTask(@PathVariable int taskId){

        TodoTaskDTO dto = taskApi.queryTask(taskId);

        return Result.builder()
                .code("1000")
                .msg("ok")
                .result(dto)
                .build();
    }
}
