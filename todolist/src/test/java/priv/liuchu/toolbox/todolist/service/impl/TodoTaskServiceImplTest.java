package priv.liuchu.toolbox.todolist.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import priv.liuchu.toolbox.todolist.dao.TodoTaskCategoryRepository;
import priv.liuchu.toolbox.todolist.entity.TodoTaskCategoryEntity;
import priv.liuchu.toolbox.todolist.service.TodoTaskService;
import priv.liuchu.toolbox.todolist.service.UserService;
import priv.liuchu.toolbox.todolist.service.enums.TaskPriorityEnum;
import priv.liuchu.toolbox.todolistapi.dto.CreateTaskDTO;
import priv.liuchu.toolbox.todolistapi.dto.QueryTasksDTO;
import priv.liuchu.toolbox.todolistapi.dto.TodoTaskDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class TodoTaskServiceImplTest {

    @Autowired
    private TodoTaskService taskService;

    @Autowired
    private TodoTaskCategoryRepository categoryRepository;

    @Test
    void createTask() {

        int userId = 1;

        List<TodoTaskCategoryEntity> cates = categoryRepository.findAll(
                Example.of(
                        new TodoTaskCategoryEntity()
                                .setUserId(userId))
        );

        Assert.notEmpty(cates, "cates is empty");

        TodoTaskCategoryEntity cate = cates.get(0);

        taskService.createTask(
                new CreateTaskDTO()
                        .setUserId(1)
                        .setCategoryId(cate.getId())
                        .setSummary("星巴克活动")
                        .setComment("0816，18:00优惠活动")
                        .setPriority(TaskPriorityEnum.LOW.getPriority())
                        .setCompleted(false)
                        .setNeedNotify(false)
        );

        taskService.createTask(
                new CreateTaskDTO()
                        .setUserId(1)
                        .setCategoryId(cate.getId())
                        .setSummary("洗衣服")
                        .setComment("衣服")
                        .setPriority(TaskPriorityEnum.MIDDLE.getPriority())
                        .setCompleted(false)
                        .setNeedNotify(false)
        );

        taskService.createTask(
                new CreateTaskDTO()
                        .setUserId(1)
                        .setCategoryId(cate.getId())
                        .setSummary("妈妈生日")
                        .setComment("生日")
                        .setPriority(TaskPriorityEnum.HIGH.getPriority())
                        .setCompleted(false)
                        .setNeedNotify(true)
                        .setNotifyDate(LocalDate.of(2021, 8, 17))
                        .setNotifyTime(LocalTime.of(9, 0, 0))
        );

    }

    @Test
    void completeTask() {
        TodoTaskDTO task =
                taskService.queryTasks(
                        new QueryTasksDTO().setCategoryId(1))
                        .stream()
                        .filter(s -> "星巴克活动".equals(s.getSummary()))
                        .findAny()
                        .orElseThrow(IllegalStateException::new);

        Assert.notNull(task, "task is null, which is not allowed");

        taskService.completeTask(task.getId());

    }

    @Test
    void queryTasks() {

        List<TodoTaskDTO> list = taskService.queryTasks(new QueryTasksDTO()
                .setUserId(1)
                .setCategoryId(1));

        Assert.notEmpty(list, "list is null, which is not allowed");
    }

    @Test
    void queryTask() {
        TodoTaskDTO item = taskService.queryTask(1);

        Assert.notNull(item, "list is null, which is not allowed");
    }
}