package com.qhit.baseFunction.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseFunction.service.IBaseFunctionService;
import com.qhit.baseFunction.service.impl.BaseFunctionServiceImpl;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/11/29.
 */
@Controller
@RequestMapping("/baseFunction")
public class BaseFunctionController {
    private IBaseFunctionService baseFunctionService = new BaseFunctionServiceImpl();
    @RequestMapping("/list")
    public String list(Model model){
        List list = baseFunctionService.findAll();
        model.addAttribute("list",list);
        return "baseFunction/list";
    }
    @RequestMapping("/insert")
    public String insert(BaseFunction baseFunction){
        baseFunctionService.insert(baseFunction);
        return "forward:list.action";
    }
    @RequestMapping("/delete")
    public String delete(Integer fid, HttpServletResponse response) throws IOException {
        baseFunctionService.delete(fid);
        return "forward:list.action";
    }

    @RequestMapping("/update")
    public String update(BaseFunction baseFunction) {
        baseFunctionService.update(baseFunction);
        return "forward:list.action";
    }

    @RequestMapping("/updateSelective")
    public String updateSelective(BaseFunction baseFunction) {
        baseFunctionService.updateSelective(baseFunction);
        return "forward:list.action";
    }

    @RequestMapping("/load")
    public String load(Integer fid, Model model) {
        BaseFunction baseFunction = baseFunctionService.findById(fid);
        model.addAttribute("baseFunction",baseFunction);
        return "baseFunction/edit";
    }
    @RequestMapping("/search")
    public String search(BaseFunction baseFunction,Model model) {
        List<BaseFunction> list = baseFunctionService.search(baseFunction);
        model.addAttribute("list",list);
        model.addAttribute("searchObject",baseFunction);
        return "baseFunction/list";
    }
    @RequestMapping("/ajaxList")
    public void ajaxList(Model model, HttpServletResponse response,Integer mid) throws IOException {
       /* List list = baseFunctionService.findByMid(mid);
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);*/
    }
    @RequestMapping("/findByMid")
    public String findByMid(Model model, HttpServletResponse response, Integer mid, HttpSession session) throws IOException {
        BaseUser baseUser = (BaseUser) session.getAttribute("sessionUser");
        List list = baseFunctionService.findByMid(mid,baseUser.getUserId());
        model.addAttribute("list",list);
        return "index/left";
    }
}
