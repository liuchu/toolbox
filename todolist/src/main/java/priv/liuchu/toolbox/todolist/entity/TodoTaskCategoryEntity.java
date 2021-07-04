package priv.liuchu.toolbox.todolist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 待办事项类型表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "todo_task_category")
public class TodoTaskCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 列表类别
     */
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    /**
     * 此类别，所属的用户ID
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;

}
