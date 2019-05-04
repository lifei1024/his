package com.qhit.medicinePurchaseInfo.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.medicineInstock.pojo.MedicineInstock;
import com.qhit.medicineInstock.service.IMedicineInstockService;
import com.qhit.medicineInstock.service.impl.MedicineInstockServiceImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService; 
import com.qhit.medicinePurchaseInfo.service.impl.MedicinePurchaseInfoServiceImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineStockinfo.service.IMedicineStockinfoService;
import com.qhit.medicineStockinfo.service.impl.MedicineStockinfoServiceImpl;
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
* Created by GeneratorCode on 2018/12/10
*/
@Controller 
@RequestMapping("/medicinePurchaseInfo") 
public class MedicinePurchaseInfoController { 

    IMedicinePurchaseInfoService medicinePurchaseInfoService = new MedicinePurchaseInfoServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.insert(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer pchId, HttpServletResponse response) throws IOException { 
        medicinePurchaseInfoService.delete(pchId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.update(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicinePurchaseInfo medicinePurchaseInfo) {
        medicinePurchaseInfo.setPchTotal(medicinePurchaseInfo.getPchPrice()*medicinePurchaseInfo.getPchAmt());
        medicinePurchaseInfo.setPchDate(CommonUtil.dateToStr(new Date()));
        medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo);
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer pchId, Model model) { 
        MedicinePurchaseInfo medicinePurchaseInfo = medicinePurchaseInfoService.findById(pchId); 
        model.addAttribute("medicinePurchaseInfo",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model,HttpSession session) throws IOException {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.find(sessionUser.getUserId());
        model.addAttribute("list",list); 
        return "medicinePurchaseInfo/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicinePurchaseInfo medicinePurchaseInfo,Model model) { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.search(medicinePurchaseInfo); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/list"; 
    }
    @RequestMapping("/purchaseInfo")
    public String purchaseInfo(HttpSession session){
        medicinePurchaseInfoService.purchaseInfo(session);
        return "forward:list.action";
    }
    @RequestMapping("/apprvlist")
    public String apprvList(Model model){
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.apprvList();
        model.addAttribute("list",list);
        return "medicinePurchaseInfo/apprvlist";
    }
    @RequestMapping("/updateBantch")
    public String updateBantch(HttpServletRequest request,HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        String[] pchIds = request.getParameterValues("pchId");
        if (pchIds!=null){
            MedicinePurchaseInfo medicinePurchaseInfo = new MedicinePurchaseInfo();
            for (String pchId:pchIds){
                MedicinePurchaseInfo purchaseInfo = medicinePurchaseInfoService.findById(pchId);
                if (purchaseInfo.getStatus()==3){
                    medicinePurchaseInfo.setPchId(Integer.valueOf(pchId));
                    medicinePurchaseInfo.setStatus(4);
                    medicinePurchaseInfo.setApprvUserid(sessionUser.getUserId());
                    medicinePurchaseInfo.setApprvDate(CommonUtil.dateToStr(new Date()));
                    medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo);
                    medicinePurchaseInfoService.Update();
                }
            }
        }

        return "forward:apprvlist.action";
    }
    @RequestMapping("/instock")
    public String instock(Model model,HttpServletRequest request, MedicineInstock medicineInstock,HttpSession session){
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        IMedicineInstockService service = new MedicineInstockServiceImpl();
        String[] pchIds = request.getParameterValues("pchId");
        String[] invnos = request.getParameterValues("invno");
        if (pchIds!=null){
            int a = 0;
            for (String pchid:pchIds){
                for (int i= a;a<invnos.length;i++){
                    MedicinePurchaseInfo purchaseInfo = medicinePurchaseInfoService.findById(pchid);
                    medicineInstock.setMedicineCodeid(purchaseInfo.getMedicineCodeid());
                    medicineInstock.setInamt(purchaseInfo.getPchAmt());
                    medicineInstock.setUnitprc(purchaseInfo.getPchPrice());
                    medicineInstock.setZje(purchaseInfo.getPchPrice()*purchaseInfo.getPchAmt());
                    medicineInstock.setInvno(invnos[i]);
                    medicineInstock.setInstockUserid(sessionUser.getUserId());
                    medicineInstock.setInstockDate(CommonUtil.dateToStr(new Date()));
                    medicineInstock.setManCode(purchaseInfo.getManCode());
                    service.insert(medicineInstock);
                    medicinePurchaseInfoService.UpdateStu(pchid);
                    break;
                }
                a++;
            }
            IMedicineStockinfoService stockinfoService = new MedicineStockinfoServiceImpl();
            stockinfoService.stockinfo();
        }

        return "redirect:/medicineInstock/list.action";
    }
    @RequestMapping("/re")
    public void reuestToCon(HttpServletRequest request){
        request.getRequestDispatcher("medicineInstock/list.action");
    }

 
} 
