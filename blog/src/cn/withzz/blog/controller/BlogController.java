package cn.withzz.blog.controller;

import cn.withzz.blog.dao.UserDao;
import cn.withzz.blog.pojos.User;
import cn.withzz.blog.pojos.Words;
import cn.withzz.blog.service.UserService;
import cn.withzz.blog.service.WordsService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@Controller
public class BlogController {
    @Resource(name = "userService")
    UserService userService;
    @Resource(name = "wordsService")
    WordsService wordsService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public @ResponseBody String login(User user,HttpSession httpSession) {
        if(userService.login(user)!=null) {
            httpSession.setAttribute("username", user.getUsername());
            return "success";
        }
        return  "faild";
    }

    @RequestMapping("/register")
    public @ResponseBody String register(User user) {
        return userService.register(user)+"";
    }

    @RequestMapping("/publish")
    public @ResponseBody String publish(Words words, HttpSession httpSession, HttpServletRequest request) {
        Object username=httpSession.getAttribute("username");
        words.setAuther(new User());
        if(username==null){
            words.getAuther().setUsername("游客朋友");
        }
        else
            words.getAuther().setUsername(username.toString());
        return wordsService.publishWords(words)+"";
    }
    @RequestMapping("/getAllWords")
    public @ResponseBody List getAllWords() {
        return wordsService.getAllWords();
    }
}
