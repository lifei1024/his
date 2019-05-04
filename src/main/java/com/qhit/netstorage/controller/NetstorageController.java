package com.qhit.netstorage.controller; 

import com.qhit.netstorage.pojo.Netstorage; 
import com.qhit.netstorage.service.INetstorageService; 
import com.qhit.netstorage.service.impl.NetstorageServiceImpl; 
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
* Created by GeneratorCode on 2018/12/24
*/ 

@Controller 
@RequestMapping("/netstorage") 
public class NetstorageController { 

    @Resource 
    INetstorageService netstorageService; 

    @RequestMapping("/insert") 
    public String insert(Netstorage netstorage) { 
        netstorageService.insert(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer fileid, HttpServletResponse response) throws IOException { 
        netstorageService.delete(fileid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Netstorage netstorage) { 
        netstorageService.update(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Netstorage netstorage) { 
        netstorageService.updateSelective(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer fileid, Model model) { 
        Netstorage netstorage = netstorageService.findById(fileid); 
        model.addAttribute("netstorage",netstorage); 
        return "netstorage/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Netstorage> list = netstorageService.findAll(); 
        model.addAttribute("list",list); 
        return "netstorage/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Netstorage> list = netstorageService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Netstorage netstorage,Model model) { 
        List<Netstorage> list = netstorageService.search(netstorage); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",netstorage); 
        return "netstorage/list"; 
    }
    @RequestMapping("/deleteBantch")
    public String deleteBantch(HttpServletRequest request){
        String[] fileids = request.getParameterValues("fileid");
        netstorageService.deleteBantch(fileids);
        return "forward:list.action";
    }
 
} 
