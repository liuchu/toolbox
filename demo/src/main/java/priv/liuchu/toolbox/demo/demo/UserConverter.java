package priv.liuchu.toolbox.demo.demo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User dtoToEntity(UserDTO dto);
}
