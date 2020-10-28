package jit.xyyk.edusystem.controller.before;


import jit.xyyk.edusystem.bean.History;
import jit.xyyk.edusystem.bean.User;
import jit.xyyk.edusystem.repository.before.UserHistoryRepository;
import jit.xyyk.edusystem.service.before.UserHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;


@Controller
public class UserHistoryController extends UserBaseController{
    @Autowired
    private UserHistoryService userHistoryService;

    private final static Logger logger = LoggerFactory.getLogger(UserHistoryController.class);


    @RequestMapping( value = "/addHistory")
    public void addHistory(String course_id, HttpSession session){
        /*int course_id = Integer.parseInt(request.getParameter("course_id"));*/
        logger.info("course_id:{}",course_id);
        int courseId = Integer.parseInt(course_id);
        User user = (User) session.getAttribute("user");
        logger.info("user:{}",user);
        if(user!=null){
            int user_id = user.getUser_id();
            if (userHistoryService.selectHistory(user_id ,courseId)>0){
                userHistoryService.updateHistory(user_id,courseId);
            }else {
                userHistoryService.addHistory(user_id,courseId);
            }
        }

    }

    @RequestMapping( value = "/history")
    public String showHistory(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        List<History> historyList = userHistoryService.showHistory(user.getUser_id());
        Collections.reverse(historyList);
        model.addAttribute("historyList",historyList);
        return "before/history";
    }

}
