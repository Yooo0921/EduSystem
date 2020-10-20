package jit.xyyk.edusystem;

import jit.xyyk.edusystem.service.before.UserService;
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
    }


}
