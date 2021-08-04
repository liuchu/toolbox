package priv.liuchu.toolbox.todolistapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CreateUserDTO implements Serializable {

    private static final long serialVersionUID = -7296547745172825039L;
    private String email;
    private String nickName;
}
