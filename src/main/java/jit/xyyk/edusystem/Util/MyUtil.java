package jit.xyyk.edusystem.Util;

import jit.xyyk.edusystem.bean.User;

import javax.servlet.http.HttpSession;

public class MyUtil {

    /**
     * 从session中获取用户ID
     *
     * @param session
     * @return
     */
    public static Integer getUserId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user.getUser_id();
    }
}
