package jit.xyyk.edusystem.serviceImpl.before;

import jit.xyyk.edusystem.Util.MyUtil;
import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.repository.before.UserFocusRepository;
import jit.xyyk.edusystem.service.before.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFocusServiceImpl implements UserFocusService {

    @Autowired
    private UserFocusRepository userFocusRepository;

    @Override
    public List<Course> getAllFocusByUserId(int user_id) {
        return userFocusRepository.getAllFocusByUserId(user_id);

    }

    @Override
    public String focus(Model model, Integer id, HttpSession session) {
        if (MyUtil.getUserId(session) == 0) {
            model.addAttribute("msg", "请完成登陆！");
            return "/before/login";
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("cid", id);
        List<Map<String, Object>> list = userFocusRepository.isFocus(map);
        if (list.size() > 0) {
            model.addAttribute("msg", "已关注该商品！");
        } else {
            int n = userFocusRepository.focus(map);
            if (n > 0)
                model.addAttribute("msg", "成功关注该商品！");
            else
                model.addAttribute("msg", "关注失败！");
        }
        return "forward:/user/coursedetail?course_id" + id;
    }

    @Override
    public String cancelFocus(HttpSession session, Model model, Integer course_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", MyUtil.getUserId(session));
        map.put("course_id", course_id);
        int n = userFocusRepository.cancelFocus(map);
        if (n > 0) {
            return "forward:/focus";
        } else {
            return "/index";
        }
    }
}
