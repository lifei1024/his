package com.qhit.baseClass.controller; 

import com.qhit.baseClass.pojo.BaseClass; 
import com.qhit.baseClass.service.IBaseClassService; 
import com.qhit.baseClass.service.impl.BaseClassServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/** 
* Created by GeneratorCode on 2019/01/14
*/ 

@Controller 
@RequestMapping("/baseClass") 
public class BaseClassController { 

    @Resource 
    IBaseClassService baseClassService; 

    @RequestMapping("/insert") 
    public String insert(BaseClass baseClass) { 
        baseClassService.insert(baseClass); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer classId, HttpServletResponse response) throws IOException { 
        baseClassService.delete(classId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(BaseClass baseClass) { 
        baseClassService.update(baseClass); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(BaseClass baseClass) { 
        baseClassService.updateSelective(baseClass); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer classId, Model model) { 
        BaseClass baseClass = baseClassService.findById(classId); 
        model.addAttribute("baseClass",baseClass); 
        return "baseClass/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<BaseClass> list = baseClassService.findAll(); 
        model.addAttribute("list",list); 
        return "baseClass/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<BaseClass> list = baseClassService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(BaseClass baseClass,Model model) { 
        List<BaseClass> list = baseClassService.search(baseClass); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",baseClass); 
        return "baseClass/list"; 
    }
    @RequestMapping("/searchs1")
    public String searchs1(BaseClass baseClass,Model model) {
        List<BaseClass> list = baseClassService.findAlls();
        model.addAttribute("list",list);
        return "baseClass/list";
    }
    @RequestMapping("/searchs2")
    public String searchs2(BaseClass baseClass,Model model) {
        List<BaseClass> list = baseClassService.findAllj();
        model.addAttribute("list",list);
        return "baseClass/list";
    }

} 
