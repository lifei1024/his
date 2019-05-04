package com.qhit.baseRole.controller;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseRole.service.IBaseRoleService;
import com.qhit.baseRole.service.impl.BaseRoleServiceImpl;
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
 * Created by GeneratorCode on 2018/12/10
 */
@Controller
@RequestMapping("/baseRole")
public class BaseRoleController {

    IBaseRoleService baseRoleService = new BaseRoleServiceImpl();

    @RequestMapping("/insert")
    public String insert(BaseRole baseRole) {
        baseRoleService.insert(baseRole);
        return "forward:list.action";
    }

    @RequestMapping("/delete")
    public String delete(Integer rid, HttpServletResponse response) throws IOException {
        baseRoleService.delete(rid);
        return "forward:list.action";
    }

    @RequestMapping("/update")
    public String update(BaseRole baseRole) {
        baseRoleService.update(baseRole);
        return "forward:list.action";
    }

    @RequestMapping("/updateSelective")
    public String updateSelective(BaseRole baseRole) {
        baseRoleService.updateSelective(baseRole);
        return "forward:list.action";
    }

    @RequestMapping("/load")
    public String load(Integer rid, Model model,HttpServletRequest request) {
        boolean qx = (boolean) request.getAttribute("qx");
        if (!qx){
            return "error/Tips";
        }
        BaseRole baseRole = baseRoleService.findById(rid);
        model.addAttribute("baseRole",baseRole);
        return "baseRole/edit";
    }

    @RequestMapping("/list")
    public String list(Model model) throws IOException {
        List<BaseRole> list = baseRoleService.findAll();
        model.addAttribute("list",list);
        return "baseRole/list";
    }

    @RequestMapping("/ajaxList")
    public void ajaxList(HttpServletResponse response) throws IOException {
        List<BaseRole> list = baseRoleService.findAll();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }

    @RequestMapping("/search")
    public String search(BaseRole baseRole,Model model) {
        List<BaseRole> list = baseRoleService.search(baseRole);
        model.addAttribute("list",list);
        model.addAttribute("searchObject",baseRole);
        return "baseRole/list";
    }
    @RequestMapping("/distributeLoad")
    public String distributeLoad(BaseRole baseRole, Model model){
        List<BaseFunction> leftList = baseRoleService.distributeLeft(baseRole);
        List<BaseFunction> rightList = baseRoleService.distributeRight(baseRole);
        model.addAttribute("leftList",leftList);
        model.addAttribute("rightList",rightList);
        model.addAttribute("rid",baseRole.getRid());
        return "baseRole/distribute";
    }
    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(BaseRole baseRole,HttpServletRequest request){
        String[] fid = request.getParameterValues("fid");
        baseRoleService.distributeUpdate(baseRole.getRid(),fid);
        return "forward:list.action";


    }

}
