package priv.liuchu.toolbox.todolist.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class TodoTaskDTO implements Serializable {
    private static final long serialVersionUID = -6601498049044084072L;
}
