package com.qhit.baseUser.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.baseDept.pojo.BaseDept;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUser.service.IBaseUserService;
import com.qhit.baseUser.service.impl.BaseUserServiceImpl;
import com.qhit.utils.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/11/26.
 */
@Controller
@RequestMapping("/baseUser")
public class BaseUserController {
    private IBaseUserService baseUserService = new BaseUserServiceImpl();
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model){
        List<BaseUser> list = baseUserService.findAll();
//        request.setAttribute("list",list);
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.addObject("url","baseUser/list");
        return modelAndView;*/
        model.addAttribute("list",list);
        return "baseUser/list";
    }
    @RequestMapping("/ajaxList")
    public void ajaxList(HttpServletResponse response) throws IOException {
        List<BaseUser> list = baseUserService.findAll();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
    @RequestMapping("/ajaxLists")
    public void ajaxLists(HttpServletResponse response,Integer deptId) throws IOException {
        List<BaseUser> list = baseUserService.findDept(deptId);
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
    @RequestMapping("/insert")
    public String insert(BaseUser baseUser){
        MD5 md5 = new MD5();
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        baseUserService.insert(baseUser);
        return "forward:list.action";
    }
    @RequestMapping("/update")
    public String update(BaseUser baseUser){
        baseUserService.updateSelective(baseUser);
        return "forward:list.action";
    }
    @RequestMapping("/del")
    public String delete(BaseUser baseUser){
        baseUserService.delete(baseUser.getUserId());
        return "forward:list.action";
    }
    @RequestMapping("/load")
    public String load(BaseUser baseUser,HttpServletRequest request,Model model){
        baseUser = baseUserService.findById(baseUser.getUserId());
//        request.setAttribute("baseUser",baseUser);
        model.addAttribute("baseUser",baseUser);
        return "baseUser/edit";
    }
    @RequestMapping("/search")
    public String search(BaseUser baseUser,Model model){
        List<BaseUser> list = baseUserService.search(baseUser);
        model.addAttribute("list",list);
        model.addAttribute("searchObjcet",baseUser);
        return "baseUser/list";
    }
    @RequestMapping("/login")
    public String login(BaseUser baseUser, HttpSession session,Model model){
        baseUser = baseUserService.login(baseUser);
        if(baseUser!=null){
            session.setAttribute("sessionUser",baseUser);
            return "index/home";
        }else{
            model.addAttribute("error","用户名或者密码不正确");
            return "index/login";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("sessionUser");
        return "redirect:/jsp/index/login.jsp";
    }
    @RequestMapping("/oldPassword")
    public void oldPassword(BaseUser baseUser,HttpServletResponse response) throws IOException {
        boolean flag = baseUserService.findOldPassword(baseUser);
        response.getWriter().write(flag?"Y":"N");
    }
    @RequestMapping("/updatePassword")
    public void updatePassword(BaseUser baseUser,HttpServletResponse response) throws IOException {
        MD5 md5 = new MD5();
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        boolean flag = baseUserService.updateSelective(baseUser);
        response.getWriter().write(flag?"Y":"N");
    }
    @RequestMapping("/distributeLoad")
    public String distributeLoad(BaseUser baseUser,Model model) throws IOException {
        List<BaseRole> leftList = baseUserService.findLeftRole(baseUser.getUserId());
        List<BaseRole> rightList = baseUserService.findRightRole(baseUser.getUserId());
        model.addAttribute("leftList",leftList);
        model.addAttribute("rightList",rightList);
        model.addAttribute("userId",baseUser.getUserId());
        return "baseUser/distribute";
    }
    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(BaseUser baseUser,HttpServletRequest request){
        String rids = request.getParameter("rids");
        baseUserService.distributeUpdate(baseUser.getUserId(),rids);
        return "forward:list.action";


    }

}
