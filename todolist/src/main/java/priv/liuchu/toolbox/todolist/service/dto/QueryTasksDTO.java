package priv.liuchu.toolbox.todolist.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class QueryTasksDTO implements Serializable {
    private static final long serialVersionUID = -8919397783587678431L;

    private Integer userId;

    private Integer categoryId;
}
