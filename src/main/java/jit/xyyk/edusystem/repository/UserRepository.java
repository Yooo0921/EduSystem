package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserRepository {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int register(User user);


    /**
     * 通过用户邮箱查找用户是否
     * @param user_email
     * @return
     */
    public User getUserByEmail(String user_email);


    /**
     * 用户登录
     * @param user
     * @return
     */
    public List<User> login(User user);

}
