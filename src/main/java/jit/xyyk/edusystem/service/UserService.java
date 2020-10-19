package jit.xyyk.edusystem.service;

import jit.xyyk.edusystem.bean.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int register(User user);

    /**
     * 通过用户邮箱判断用户是否存在
     * @param user_emial
     * @return
     */
    public boolean ifExistUser(String user_email);
}
