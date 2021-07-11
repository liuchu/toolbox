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

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepo;
    @Resource
    private TodoTaskCategoryRepository categoryRepo;

    @Override
    public void createUser(CreateUserDTO dto) {

        UserEntity user = userRepo.saveAndFlush(
                Converter.INSTANCE.dtoToEntity(dto));

        categoryRepo.save(
                new TodoTaskCategoryEntity()
                        .setUserId(user.getId())
                        .setCategoryName(AppConst.DEFAULT_CATEGORY));
    }
}
