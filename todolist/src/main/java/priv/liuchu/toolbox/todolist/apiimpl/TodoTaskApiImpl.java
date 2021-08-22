package priv.liuchu.toolbox.todolist.apiimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.liuchu.toolbox.todolist.service.TodoTaskService;
import priv.liuchu.toolbox.todolistapi.TodoTaskApi;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolistapi.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolistapi.dto.TodoTaskDTO;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TodoTaskApiImpl implements TodoTaskApi {

    @Autowired
    private TodoTaskService todoTaskService;

    @Override
    public void createTask(@RequestBody CreateTaskDTO dto) {
        todoTaskService.createTask(dto);
    }

    @Override
    public void completeTask(int taskId) {
        todoTaskService.completeTask(taskId);
    }

    @Override
    public List<TodoTaskDTO> queryTasks(int userId, int categoryId) {
        return todoTaskService.queryTasks(
                new QueryTasksDTO().setUserId(userId).setCategoryId(categoryId));
    }

    @Override
    public TodoTaskDTO queryTask(int taskId) {
        return todoTaskService.queryTask(taskId);
    }
}
