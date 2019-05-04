package com.qhit.doctorMenu.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.doctorMenu.service.IDoctorMenuService; 
import com.qhit.doctorMenu.service.impl.DoctorMenuServiceImpl;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
import com.qhit.patientRegisterRecord.service.IPatientRegisterRecordService;
import com.qhit.patientRegisterRecord.service.impl.PatientRegisterRecordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/19
*/
@Controller 
@RequestMapping("/doctorMenu") 
public class DoctorMenuController { 

    IDoctorMenuService doctorMenuService = new DoctorMenuServiceImpl();; 

    @RequestMapping("/Loads")
    public String Loads(HttpSession session,Model model){
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        //查寻病人
        IPatientRegisterRecordService patientService = new PatientRegisterRecordServiceImpl();
        List<PatientRegisterRecord> patient = patientService.findPatient(sessionUser);
        //查询套餐
        List<DoctorMenu> doctorMenus = doctorMenuService.findMenu(sessionUser);
        model.addAttribute("patient",patient);
        model.addAttribute("doctorMenus",doctorMenus);
        return "Visit/visit";
    }
    @RequestMapping("/insert") 
    public String insert(DoctorMenu doctorMenu, HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        boolean flag =  doctorMenuService.findByname(doctorMenu.getMenuName());
        if (!flag){
            doctorMenu.setUserId(sessionUser.getUserId());
            doctorMenuService.insert(doctorMenu);
            return "forward:list.action";
        }
        return "error/tipsDept";
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer menuId, HttpServletResponse response) throws IOException { 
        doctorMenuService.delete(menuId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(DoctorMenu doctorMenu) { 
        doctorMenuService.update(doctorMenu); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(DoctorMenu doctorMenu) { 
        doctorMenuService.updateSelective(doctorMenu); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer menuId, Model model) { 
        DoctorMenu doctorMenu = doctorMenuService.findById(menuId); 
        model.addAttribute("doctorMenu",doctorMenu); 
        return "doctorMenu/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model,HttpSession session) throws IOException {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        List<DoctorMenu> list1 = doctorMenuService.find1(sessionUser.getUserId());
        List<DoctorMenu> list2 = doctorMenuService.find2(sessionUser);
        List<DoctorMenu> list3 = doctorMenuService.find3();
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        return "doctorMenu/list";
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<DoctorMenu> list = doctorMenuService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(DoctorMenu doctorMenu,Model model) { 
        List<DoctorMenu> list = doctorMenuService.search(doctorMenu); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",doctorMenu); 
        return "doctorMenu/list"; 
    }
    @RequestMapping("/distributeLoad")
    public String distributeLoad(DoctorMenu doctorMenu,Model model) throws IOException {

        return "";
    }
 
} 
