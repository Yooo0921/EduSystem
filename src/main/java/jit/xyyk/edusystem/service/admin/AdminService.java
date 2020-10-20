package jit.xyyk.edusystem.service.admin;

import jit.xyyk.edusystem.bean.Auser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public String login(Auser auser, Model model, HttpSession session);
}
