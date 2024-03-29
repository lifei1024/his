package com.qhit.patientRegisterRecord.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
import com.qhit.patientRegisterRecord.service.IPatientRegisterRecordService; 
import com.qhit.patientRegisterRecord.service.impl.PatientRegisterRecordServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/23
*/
@Controller 
@RequestMapping("/patientRegisterRecord") 
public class PatientRegisterRecordController { 

    IPatientRegisterRecordService patientRegisterRecordService = new PatientRegisterRecordServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(PatientRegisterRecord patientRegisterRecord, HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        patientRegisterRecord.setRegisterDate(CommonUtil.dateToStr(new Date()));
        patientRegisterRecord.setRecordUser(sessionUser.getUserId());
        patientRegisterRecord.setStatus(1);
        patientRegisterRecordService.insert(patientRegisterRecord);
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer registerId, HttpServletResponse response) throws IOException { 
        patientRegisterRecordService.delete(registerId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(PatientRegisterRecord patientRegisterRecord) { 
        patientRegisterRecordService.update(patientRegisterRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(PatientRegisterRecord patientRegisterRecord) { 
        patientRegisterRecordService.updateSelective(patientRegisterRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer registerId, Model model) { 
        PatientRegisterRecord patientRegisterRecord = patientRegisterRecordService.findById(registerId); 
        model.addAttribute("patientRegisterRecord",patientRegisterRecord); 
        return "patientRegisterRecord/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<PatientRegisterRecord> list = patientRegisterRecordService.findAll(); 
        model.addAttribute("list",list); 
        return "patientRegisterRecord/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<PatientRegisterRecord> list = patientRegisterRecordService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(PatientRegisterRecord patientRegisterRecord,Model model) { 
        List<PatientRegisterRecord> list = patientRegisterRecordService.search(patientRegisterRecord); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",patientRegisterRecord); 
        return "patientRegisterRecord/list"; 
    } 
 
} 
