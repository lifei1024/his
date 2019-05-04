package com.qhit.medicineInstock.controller; 

import com.qhit.medicineInstock.pojo.MedicineInstock; 
import com.qhit.medicineInstock.service.IMedicineInstockService; 
import com.qhit.medicineInstock.service.impl.MedicineInstockServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/12
*/
@Controller 
@RequestMapping("/medicineInstock") 
public class MedicineInstockController { 

    IMedicineInstockService medicineInstockService = new MedicineInstockServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(MedicineInstock medicineInstock) { 
        medicineInstockService.insert(medicineInstock); 
        return "forward:list.action"; 
    }
 
    @RequestMapping("/delete") 
    public String delete(Integer instockId, HttpServletResponse response) throws IOException { 
        medicineInstockService.delete(instockId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineInstock medicineInstock) { 
        medicineInstockService.update(medicineInstock); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineInstock medicineInstock) { 
        medicineInstockService.updateSelective(medicineInstock); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer instockId, Model model) { 
        MedicineInstock medicineInstock = medicineInstockService.findById(instockId); 
        model.addAttribute("medicineInstock",medicineInstock); 
        return "medicineInstock/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<MedicineInstock> list = medicineInstockService.find();
        model.addAttribute("list",list); 
        return "medicineInstock/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineInstock> list = medicineInstockService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineInstock medicineInstock,Model model) { 
        List<MedicineInstock> list = medicineInstockService.search(medicineInstock); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineInstock); 
        return "medicineInstock/list"; 
    }
//    @RequestMapping("/instock")
//    public String instock(HttpSession session){
//        medicineInstockService.instock(session);
//
//        return "forward:list.action";
//    }
} 
