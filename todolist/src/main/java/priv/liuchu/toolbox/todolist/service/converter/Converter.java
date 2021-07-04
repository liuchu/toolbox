package priv.liuchu.toolbox.todolist.service.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import priv.liuchu.toolbox.todolist.entity.TodoTaskEntity;
import priv.liuchu.toolbox.todolist.entity.UserEntity;
import priv.liuchu.toolbox.todolist.service.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolist.service.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolist.service.dto.TodoTaskDTO;

import java.util.List;

@Mapper
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

    UserEntity dtoToEntity(CreateUserDTO dto);
    TodoTaskEntity dtoToEntity(CreateTaskDTO dto);

    List<TodoTaskDTO> entityToDtoList(List<TodoTaskEntity> list);
    TodoTaskDTO entityToDto(TodoTaskEntity dto);
}
