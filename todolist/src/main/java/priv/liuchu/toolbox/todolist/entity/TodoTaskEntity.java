package priv.liuchu.toolbox.todolist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 待办事项表
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "todo_task")
public class TodoTaskEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "summary", nullable = false)
    private String summary;

    /**
     * 详细备注
     */
    @Column(name = "comment", nullable = false)
    private String comment;

    /**
     * 优先级，1-非常重要，2-重要，3-普通
     */
    @Column(name = "priority", nullable = false)
    private Integer priority;

    /**
     * 任务是否完成
     */
    @Column(name = "completed", nullable = false)
    private Boolean completed;

    /**
     * 是否需要通知
     */
    @Column(name = "need_notify", nullable = false)
    private Boolean needNotify;

    /**
     * 通知日期
     */
    @Column(name = "notify_date")
    private LocalDate notifyDate;

    /**
     * 通知时间
     */
    @Column(name = "notify_time")
    private LocalTime notifyTime;

    /**
     * 用户ID
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    /**
     * 所属列表类别
     */
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

}
