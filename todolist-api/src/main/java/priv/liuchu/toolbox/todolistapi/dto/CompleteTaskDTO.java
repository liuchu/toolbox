package priv.liuchu.toolbox.todolistapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CompleteTaskDTO implements Serializable {

    private static final long serialVersionUID = 3398112191123058265L;

    private Integer todoTaskId;
}
