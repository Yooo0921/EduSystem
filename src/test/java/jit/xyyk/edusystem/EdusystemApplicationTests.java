package jit.xyyk.edusystem;

import jit.xyyk.edusystem.bean.User;
import jit.xyyk.edusystem.repository.UserRepository;
import jit.xyyk.edusystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EdusystemApplicationTests {



    @Autowired
    private UserService service;


    @Test
    public void contextLoads() {
//        UserBean userBean = userService.loginIn("a", "a");
        User user = service.getInfo("a");
        System.out.println("该用户ID为：");
        System.out.println(user.getUser_email());
    }


}
