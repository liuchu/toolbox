package priv.liuchu.toolbox.todolist.service;

import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolistapi.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolistapi.dto.TodoTaskDTO;

import java.util.List;

public interface TodoTaskService {

    void createTask(CreateTaskDTO dto);

    void completeTask(Integer taskId);

    List<TodoTaskDTO> queryTasks(QueryTasksDTO dto);

    TodoTaskDTO queryTask(Integer taskId);
}
