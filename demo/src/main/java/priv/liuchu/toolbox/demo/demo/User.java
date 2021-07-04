package priv.liuchu.toolbox.demo.demo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -2502124878611544224L;

    private String name;
}
