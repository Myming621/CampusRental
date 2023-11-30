package com.mym.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.mym.sys.constant.SysConstant;
import com.mym.sys.domain.User;
import com.mym.sys.domain.UserVo;
import com.mym.sys.service.IUserService;
import com.mym.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }


    /**
     * 生成验证码
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request , HttpServletResponse response , HttpSession session) throws IOException {
        //定义图形的长度宽度和符号和干扰线
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        //生成的验证码放到了session
        session.setAttribute("code",lineCaptcha.getCode());
        //获取输出流
        ServletOutputStream  outputStream = response.getOutputStream();
        //将数据以图片的方式输出
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }

    /**
     * 登录方法
     */
    @RequestMapping("login")
    public String login(UserVo userVo , Model model){
        //1.获取验证码
        String code = WebUtils.getHttpSession().getAttribute("code").toString();
        //2.判断用户输入的验证码和session中的验证码是否一致
        if(userVo.getCode().equals(code)){
            //3.如果验证码一样,就要验证用户名或密码是否正确
            User user = userService.login(userVo);
            if(null != user){
                //4.如果用户存在,说明登陆成功,需要跳转到index页面,同时将用户信息放到session中
                WebUtils.getHttpSession().setAttribute("user",user);
                return "system/main/index";
            }else {
                //没有查到用户,说明用户名或密码错误
                model.addAttribute("error", SysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else{
            model.addAttribute("error",SysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }
}
