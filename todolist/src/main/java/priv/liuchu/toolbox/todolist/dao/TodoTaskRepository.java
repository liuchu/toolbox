package priv.liuchu.toolbox.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import priv.liuchu.toolbox.todolist.entity.TodoTaskEntity;

public interface TodoTaskRepository extends JpaRepository<TodoTaskEntity, Integer>, JpaSpecificationExecutor<TodoTaskEntity> {

}