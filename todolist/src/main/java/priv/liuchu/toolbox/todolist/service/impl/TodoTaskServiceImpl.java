package priv.liuchu.toolbox.todolist.service.impl;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import priv.liuchu.toolbox.todolist.dao.TodoTaskRepository;
import priv.liuchu.toolbox.todolist.entity.TodoTaskEntity;
import priv.liuchu.toolbox.todolist.service.TodoTaskService;
import priv.liuchu.toolbox.todolist.service.converter.Converter;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolistapi.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolistapi.dto.TodoTaskDTO;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoTaskServiceImpl implements TodoTaskService {

    @Resource
    private TodoTaskRepository taskRepository;

    @Override
    public void createTask(CreateTaskDTO dto) {
        taskRepository.save(Converter.INSTANCE.dtoToEntity(dto));
    }

    @Override
    public void completeTask(Integer taskId) {

        taskRepository.save(
                taskRepository.findById(taskId).orElseThrow(IllegalStateException::new)
                        .setCompleted(true));
    }

    @Override
    public List<TodoTaskDTO> queryTasks(QueryTasksDTO dto) {

        List<TodoTaskEntity> entityList = taskRepository.findAll(
                Example.of(
                        new TodoTaskEntity()
                                .setCategoryId(dto.getCategoryId())
                                .setCompleted(false)));

        return Converter.INSTANCE.entityToDtoList(entityList);
    }

    @Override
    public TodoTaskDTO queryTask(Integer taskId) {
        TodoTaskEntity byId = taskRepository.findById(taskId).orElseThrow(IllegalStateException::new);

        return Converter.INSTANCE.entityToDto(byId);
    }
}
