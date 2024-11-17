package top.atluofu.ssmp.mybatis;

import java.io.Serializable;
import lombok.Data;

/**
 * t_user
 */
@Data
public class TUser implements Serializable {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 1L;
}