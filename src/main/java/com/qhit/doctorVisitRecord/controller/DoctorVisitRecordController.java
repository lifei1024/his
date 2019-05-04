package com.qhit.doctorVisitRecord.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.doctorVisitRecord.pojo.DoctorVisitRecord;
import com.qhit.doctorVisitRecord.service.IDoctorVisitRecordService; 
import com.qhit.doctorVisitRecord.service.impl.DoctorVisitRecordServiceImpl;
import com.qhit.doctorVisitRecordinfo.pojo.DoctorVisitRecordinfo;
import com.qhit.doctorVisitRecordinfo.service.IDoctorVisitRecordinfoService;
import com.qhit.doctorVisitRecordinfo.service.impl.DoctorVisitRecordinfoServiceImpl;
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
* Created by GeneratorCode on 2018/12/27
*/ 

@Controller 
@RequestMapping("/doctorVisitRecord") 
public class DoctorVisitRecordController { 

    @Resource 
    IDoctorVisitRecordService doctorVisitRecordService;
    @Resource
    IDoctorVisitRecordinfoService doctorVisitRecordinfoService;

    @RequestMapping("/insert") 
    public String insert(Integer registerId,DoctorVisitRecord doctorVisitRecord, HttpServletRequest request, HttpSession session) {
        String[] codeIds = request.getParameterValues("codeId");
        String[] amts = request.getParameterValues("amt");
        doctorVisitRecordService.updateReId(registerId);
        List<DoctorVisitRecord> list = doctorVisitRecordService.findByPid(doctorVisitRecord.getPatientId());
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        doctorVisitRecord.setDoctorId(sessionUser.getUserId());
        doctorVisitRecord.setVisitDate(CommonUtil.dateToStr(new Date()));
        doctorVisitRecord.setStatus(1);
        if (list!=null && list.size()>0){
            doctorVisitRecord.setTimes(list.size()+1);
        }else {
            doctorVisitRecord.setTimes(1);
        }
        doctorVisitRecordService.insert(doctorVisitRecord);
        DoctorVisitRecordinfo doctorVisitRecordinfo = new DoctorVisitRecordinfo();
        DoctorVisitRecord doctorVisit =  doctorVisitRecordService.findSort();
        int a = 0;
        for (String codeId:codeIds){
            for (int i = a; i < amts.length; i++) {
                    doctorVisitRecordinfo.setVrId(doctorVisit.getVrId());
                    doctorVisitRecordinfo.setAmt(Integer.valueOf(amts[i]));
                    doctorVisitRecordinfo.setCodeId(Integer.valueOf(codeId));
                    doctorVisitRecordinfoService.insert(doctorVisitRecordinfo);
                    break;
                }
            a++;
        }
        return "forward:list.action";
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer vrId, HttpServletResponse response) throws IOException { 
        doctorVisitRecordService.delete(vrId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.update(doctorVisitRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.updateSelective(doctorVisitRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer vrId, Model model) { 
        DoctorVisitRecord doctorVisitRecord = doctorVisitRecordService.findById(vrId); 
        model.addAttribute("doctorVisitRecord",doctorVisitRecord); 
        return "doctorVisitRecord/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.findAll(); 
        model.addAttribute("list",list); 
        return "doctorVisitRecord/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(DoctorVisitRecord doctorVisitRecord,Model model) { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.search(doctorVisitRecord); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",doctorVisitRecord); 
        return "doctorVisitRecord/list"; 
    } 
 
} 
