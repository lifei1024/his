package com.qhit.medicineReqPlan.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineReqPlan.service.IMedicineReqPlanService; 
import com.qhit.medicineReqPlan.service.impl.MedicineReqPlanServiceImpl; 
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
* Created by GeneratorCode on 2018/12/05
*/
@Controller 
@RequestMapping("/medicineReqPlan") 
public class MedicineReqPlanController { 

    IMedicineReqPlanService medicineReqPlanService = new MedicineReqPlanServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(MedicineReqPlan medicineReqPlan,HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        medicineReqPlan.setAppUserid(sessionUser.getUserId());
        medicineReqPlan.setAppDate(CommonUtil.dateToStr(new Date()));
        boolean flag = CommonUtil.isRoleExists(session,4);
        String url = "";
        if(flag){
            medicineReqPlan.setStatus(2);
            medicineReqPlan.setApprvUserid(sessionUser.getUserId());
            medicineReqPlan.setApprvDate(CommonUtil.dateToStr(new Date()));
            url="forward:apprvlist.action";
        }else{
            medicineReqPlan.setStatus(1);
            url="forward:list.action";
        }
        medicineReqPlanService.insert(medicineReqPlan); 
        return url;
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer reqplnno, HttpServletResponse response) throws IOException { 
        medicineReqPlanService.delete(reqplnno); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineReqPlan medicineReqPlan) { 
        medicineReqPlanService.update(medicineReqPlan); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective")
    public String updateSelective(MedicineReqPlan medicineReqPlan) {
        medicineReqPlanService.updateSelective(medicineReqPlan);
        return "forward:list.action";
    }
    @RequestMapping("/updateBantch")
    public String updateBantch(HttpServletRequest request,HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        String[] reqplnnos = request.getParameterValues("reqplnno");
        if (reqplnnos!=null){
            MedicineReqPlan medicineReqPlan = new MedicineReqPlan();
            for (String reqplnno:reqplnnos){
                MedicineReqPlan reqPlan = medicineReqPlanService.findById(reqplnno);
                if (reqPlan.getStatus()==1){
                    medicineReqPlan.setReqplnno(Integer.parseInt(reqplnno));
                    medicineReqPlan.setStatus(2);
                    medicineReqPlan.setApprvUserid(sessionUser.getUserId());
                    medicineReqPlan.setApprvDate(CommonUtil.dateToStr(new Date()));
                    medicineReqPlanService.updateSelective(medicineReqPlan);
                }
            }
        }

        return "forward:apprvlist.action";
    }

    @RequestMapping("/load") 
    public String load(Integer reqplnno, Model model) { 
        MedicineReqPlan medicineReqPlan = medicineReqPlanService.findById(reqplnno); 
        model.addAttribute("medicineReqPlan",medicineReqPlan); 
        return "medicineReqPlan/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model, HttpSession session) throws IOException {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        List<MedicineReqPlan> list = medicineReqPlanService.findByUserId(sessionUser.getUserId());
        model.addAttribute("list",list); 
        return "medicineReqPlan/list"; 
    }
    @RequestMapping("/apprvlist")
    public String apprvlist(Model model, HttpSession session) throws IOException {
        List<MedicineReqPlan> list = medicineReqPlanService.findAll();
        model.addAttribute("list",list);
        return "medicineReqPlan/apprvlist";
    }

    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineReqPlan> list = medicineReqPlanService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineReqPlan medicineReqPlan,Model model) { 
        List<MedicineReqPlan> list = medicineReqPlanService.search(medicineReqPlan); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineReqPlan); 
        return "medicineReqPlan/list"; 
    } 
 
} 
