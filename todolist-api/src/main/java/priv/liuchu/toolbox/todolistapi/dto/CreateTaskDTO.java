package priv.liuchu.toolbox.todolistapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class CreateTaskDTO implements Serializable {
    private static final long serialVersionUID = 8214829421781022922L;

    /**
     * 标题
     */
    private String summary;

    /**
     * 详细备注
     */
    private String comment;

    /**
     * 优先级，1-非常重要，2-重要，3-普通
     */
    private Integer priority;

    /**
     * 任务是否完成
     */
    private Boolean completed;

    /**
     * 是否需要通知
     */
    private Boolean needNotify;

    /**
     * 通知日期
     */
    private LocalDate notifyDate;

    /**
     * 通知时间
     */
    private LocalTime notifyTime;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 所属列表类别
     */
    private Integer categoryId;
}
