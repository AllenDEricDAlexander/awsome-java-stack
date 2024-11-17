package top.atluofu.ssmp.unit;

import lombok.SneakyThrows;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import top.atluofu.ssmp.domain.TUser;
import top.atluofu.ssmp.service.impl.TUserServiceImpl;

/**
 * @ClassName: MockMvcTests
 * @description: TODO
 * @author: 有罗敷的马同学
 * @datetime: 2024Year-11Month-17Day-15:37
 * @Version: 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TUserServiceImpl userService;

    @SneakyThrows
    @Test
    void get() {
        TUser user = new TUser().setId(1).setUsername("atluofu").setPassword("123456");
        Mockito.when(userService.getById(1)).thenReturn(user);
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/user/get?id=1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andDo(result -> System.out.println("请求响应:" + result.getResponse().getContentAsString()));

        resultActions.andExpect(MockMvcResultMatchers.jsonPath("id", IsEqual.equalTo(1)));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("username", IsEqual.equalTo("atluofu")));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("password", IsEqual.equalTo("123456")));
    }
}
