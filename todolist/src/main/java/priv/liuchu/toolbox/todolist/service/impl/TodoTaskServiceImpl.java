package priv.liuchu.toolbox.todolist.service.impl;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import priv.liuchu.toolbox.todolist.dao.TodoTaskRepository;
import priv.liuchu.toolbox.todolist.dao.UserRepository;
import priv.liuchu.toolbox.todolist.entity.TodoTaskEntity;
import priv.liuchu.toolbox.todolist.entity.UserEntity;
import priv.liuchu.toolbox.todolist.service.TodoTaskService;
import priv.liuchu.toolbox.todolist.service.converter.Converter;
import priv.liuchu.toolbox.todolist.service.dto.CompleteTaskDTO;
import priv.liuchu.toolbox.todolist.service.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolist.service.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolist.service.dto.TodoTaskDTO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
                new TodoTaskEntity()
                        .setCategoryId(taskId)
                        .setCompleted(true));
    }

    @Override
    public List<TodoTaskDTO> queryTasks(QueryTasksDTO dto) {

        List<TodoTaskEntity> entityList = taskRepository.findAll(
                Example.of(
                        new TodoTaskEntity()
                                .setUserId(dto.getUserId())
                                .setCategoryId(dto.getCategoryId())));

        return Converter.INSTANCE.entityToDtoList(entityList);
    }

    @Override
    public TodoTaskDTO queryTask(Integer taskId) {
        TodoTaskEntity byId = taskRepository.getById(taskId);


        return  Converter.INSTANCE.entityToDto(byId);
    }
}
