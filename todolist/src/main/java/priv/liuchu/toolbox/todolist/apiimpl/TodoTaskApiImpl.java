package priv.liuchu.toolbox.todolist.apiimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.liuchu.toolbox.todolist.service.TodoTaskService;
import priv.liuchu.toolbox.todolistapi.TodoTaskApi;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;

@RestController
@RequestMapping("/api/task")
public class TodoTaskApiImpl implements TodoTaskApi {

    @Autowired
    private TodoTaskService todoTaskService;

    @Override
    public void createTask(@RequestBody CreateTaskDTO dto) {
        todoTaskService.createTask(dto);
    }
}
