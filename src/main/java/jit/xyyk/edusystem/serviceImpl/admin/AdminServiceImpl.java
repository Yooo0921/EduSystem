package jit.xyyk.edusystem.serviceImpl.admin;

import jit.xyyk.edusystem.bean.Auser;
import jit.xyyk.edusystem.repository.admin.AdminRepository;
import jit.xyyk.edusystem.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public String login(Auser auser, Model model, HttpSession session) {
        //1.查询数据库是否存在
        List<Auser> list = adminRepository.login(auser);
        //2.判断查询结果,进行业务跳转
        if (list != null && list.size() > 0) {
            session.setAttribute("auser", auser);
            return "admin/main";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "admin/login";
    }
}
