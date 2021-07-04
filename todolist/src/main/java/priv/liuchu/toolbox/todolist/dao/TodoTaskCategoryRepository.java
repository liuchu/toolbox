package priv.liuchu.toolbox.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import priv.liuchu.toolbox.todolist.entity.TodoTaskCategoryEntity;

public interface TodoTaskCategoryRepository extends JpaRepository<TodoTaskCategoryEntity, Integer>, JpaSpecificationExecutor<TodoTaskCategoryEntity> {

}