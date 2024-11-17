package top.atluofu.ssmp.unit;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import top.atluofu.ssmp.mybatis.TUser;
import top.atluofu.ssmp.mybatis.TUserDao;

/**
 * @ClassName: MockMybatisTests
 * @description: TODO
 * @author: 有罗敷的马同学
 * @datetime: 2024Year-11Month-17Day-14:32
 * @Version: 1.0
 */
@SpringBootTest
public class MockMybatisTests {

    @Resource
    private TUserDao tUserDao;

    @Test
    @Sql(scripts = "/sql/create_tables.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "INSERT INTO `t_user`(`id`, `username`, `password`) VALUES (1, 'atluofu', '123456');", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void selectById() {
        // 调用 userMapper 查询你用户，这里查到的并不是 MySQL中的数据，而是 @Sql 注解插入的数据
        TUser user = tUserDao.selectByPrimaryKey(1);

        System.out.println(user);
        // 使用 JUnit 提供的 断言 校验结果
        Assertions.assertEquals(1, user.getId(), "编号不匹配");
        Assertions.assertEquals("atluofu", user.getUsername(), "用户名不匹配");
        Assertions.assertEquals("123456", user.getPassword(), "密码不匹配");
    }


}
