package top.atluofu.ssmp.contriller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.atluofu.ssmp.domain.TUser;
import top.atluofu.ssmp.service.impl.TUserServiceImpl;

/**
 * @ClassName: SsmpController
 * @description: SsmpController
 * @author: 有罗敷的马同学
 * @datetime: 2024Year-11Month-17Day-15:22
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class SsmpController {
    @Resource
    private TUserServiceImpl tUserService;

    @GetMapping("/get")
    public TUser get(@RequestParam("id") int id) {
        return tUserService.getById(id);
    }


}
