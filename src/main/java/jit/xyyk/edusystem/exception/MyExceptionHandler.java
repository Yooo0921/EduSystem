package jit.xyyk.edusystem.exception;

import jit.xyyk.edusystem.bean.Auser;
import jit.xyyk.edusystem.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice(basePackages = {"jit.xyyk.controller"})
public class MyExceptionHandler implements HandlerExceptionResolver {

    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Override
//    @ExceptionHandler
    public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                                         Exception arg3) {
        logger.error("日志全局拦截,本次拦截的日志为:{}", arg3.getMessage(), arg3);
        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("ex", arg3);
        // 根据不同错误转向不同页面
        if (arg3 instanceof AdminLoginNoException) {
            //登录页面需要auser对象
            arg0.setAttribute("auser", new Auser("admin",""));
            arg0.setAttribute("msg", "没有登录，请登录！");
            model.put("auser",new Auser());
            model.put("msg","没有登录，请登录！");
            logger.error("日志全局拦截,跳转页面:{}", "/admin/login");
            return new ModelAndView("/admin/login", model);
        } else if (arg3 instanceof UserLoginNoException) {
            arg0.setAttribute("user", new User());
            arg0.setAttribute("msg", "没有登录，请登录！");
            model.put("user",new User());
            model.put("msg","没有登录，请登录！");
            logger.error("日志全局拦截,跳转页面:{}", "/before/login");
            return new ModelAndView("/before/login", model);
        } else {
            //TODO 修改
            logger.error("日志全局拦截,跳转页面:{}", "/error/error");
            return new ModelAndView("/error/error", model);
        }
    }
}
