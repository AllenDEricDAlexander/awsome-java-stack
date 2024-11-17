package top.atluofu.ssmp.unit;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import top.atluofu.ssmp.domain.TUser;
import top.atluofu.ssmp.mapper.TUserMapper;
import top.atluofu.ssmp.service.impl.TUserServiceImpl;

/**
 * @ClassName: MockUserServiceTests
 * @description: TODO
 * @author: 有罗敷的马同学
 * @datetime: 2024Year-11Month-17Day-15:28
 * @Version: 1.0
 */
@SpringBootTest
public class MockUserServiceTests {

    @MockBean
    private TUserMapper userMapper;

    @Resource
    private TUserServiceImpl userService;

    @Test
    void get() {
        TUser user = new TUser().setId(1).setUsername("atluofu").setPassword("123456");

        Mockito.when(userMapper.selectById(1)).thenReturn(user);

        // 调用 service
        TUser entity = userService.getById(1);
        System.out.println("查询结果：" + entity);

        // 使用 JUnit 提供的 断言 校验结果
        Assertions.assertEquals(1, entity.getId(), "编号不匹配");
        Assertions.assertEquals("atluofu", entity.getUsername(), "用户名不匹配");
        Assertions.assertEquals("123456", entity.getPassword(), "密码不匹配");
    }

}
