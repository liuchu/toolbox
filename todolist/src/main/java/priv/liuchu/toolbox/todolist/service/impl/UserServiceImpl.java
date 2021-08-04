package priv.liuchu.toolbox.todolist.service.impl;

import org.springframework.stereotype.Service;
import priv.liuchu.toolbox.todolist.dao.TodoTaskCategoryRepository;
import priv.liuchu.toolbox.todolist.dao.UserRepository;
import priv.liuchu.toolbox.todolist.entity.TodoTaskCategoryEntity;
import priv.liuchu.toolbox.todolist.entity.UserEntity;
import priv.liuchu.toolbox.todolist.service.UserService;
import priv.liuchu.toolbox.todolist.service.consts.AppConst;
import priv.liuchu.toolbox.todolist.service.converter.Converter;
import priv.liuchu.toolbox.todolistapi.dto.CreateUserDTO;
import priv.liuchu.toolbox.todolistapi.dto.UserDTO;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepo;
    @Resource
    private TodoTaskCategoryRepository categoryRepo;

    public static final Converter CONVERTER = Converter.INSTANCE;

    @Override
    public void createUser(CreateUserDTO dto) {

        UserEntity user = userRepo.saveAndFlush(
                CONVERTER.dtoToEntity(dto));

        categoryRepo.save(
                new TodoTaskCategoryEntity()
                        .setUserId(user.getId())
                        .setCategoryName(AppConst.DEFAULT_CATEGORY));
    }

    @Override
    public UserDTO queryById(int id) {

        UserEntity entity =
                userRepo.findById(id).orElseThrow(IllegalStateException::new);

        return CONVERTER.entityToDto(entity);
    }
}
