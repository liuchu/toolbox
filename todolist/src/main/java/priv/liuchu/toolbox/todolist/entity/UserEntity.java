package priv.liuchu.toolbox.todolist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表
 */
@Data
@Entity
@Table(name = "user")
@Accessors(chain = true)
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 邮箱
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name", nullable = false)
    private String nickName;

}
