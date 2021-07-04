package priv.liuchu.toolbox.todolist.service;

import priv.liuchu.toolbox.todolist.service.dto.CompleteTaskDTO;
import priv.liuchu.toolbox.todolist.service.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolist.service.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolist.service.dto.TodoTaskDTO;

import java.util.List;

public interface TodoTaskService {

    void createTask(CreateTaskDTO dto);

    void completeTask(Integer taskId);

    List<TodoTaskDTO> queryTasks(QueryTasksDTO dto);

    TodoTaskDTO queryTask(Integer taskId);
}
