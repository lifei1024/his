package com.qhit.baseRole.service.impl;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.service.IBaseRoleService;
import java.util.List;
import com.qhit.baseRole.dao.IBaseRoleDao;
import com.qhit.baseRole.dao.impl.BaseRoleDaoImpl;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
import com.qhit.baseRoleFunction.service.IBaseRoleFunctionService;
import com.qhit.baseRoleFunction.service.impl.BaseRoleFunctionServiceImpl;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.qhit.baseUserRole.service.IBaseUserRoleService;
import com.qhit.baseUserRole.service.impl.BaseUserRoleServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseRoleServiceImpl  implements IBaseRoleService {

    IBaseRoleDao dao=new BaseRoleDaoImpl();

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        BaseRole baseRole = findById(id); 
        return dao.delete(baseRole); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseRole findById(Object id) { 
        List<BaseRole> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<BaseFunction> distributeLeft(BaseRole baseRole) {
        String sql = "select * from base_function bf where bf.fid not in\n" +
                "(select brf.fid from base_role br join base_role_function brf on br.rid = brf.rid and br.rid = '"+baseRole.getRid()+"' )";
        return dao.freeFind(sql);
    }

    @Override
    public List<BaseFunction> distributeRight(BaseRole baseRole) {
        String sql = "select * from base_function bf where bf.fid  in\n" +
                "(select brf.fid from base_role br join base_role_function brf on br.rid = brf.rid and br.rid = '"+baseRole.getRid()+"' )";
        return dao.freeFind(sql);
    }
    @Override
    public List<BaseRole> search(BaseRole baseRole) {
        String sql = "select * from base_role where 1=1 ";
        if (baseRole.getRname()!=null && !"".equals(baseRole.getRname())){
            sql+=" and rname like '%"+baseRole.getRname()+"%' ";
        }
        List<BaseRole> list = dao.freeFind(sql);
        return list;
    }
    @Override
    public void distributeUpdate(Integer rid, String[] arr) {
        //        删除base_role_function表中所有userId记录
        IBaseRoleFunctionService baseRoleFunctionService = new BaseRoleFunctionServiceImpl();
        String  delSql = "delete from base_role_function where rid = "+rid;
        baseRoleFunctionService.freeUpdate(delSql);
//        批量插入
        if (arr!=null){
            for(String fid:arr){
                BaseRoleFunction baseRoleFunction = new BaseRoleFunction();
                baseRoleFunction.setFid(Integer.parseInt(fid));
                baseRoleFunction.setRid(rid);
                baseRoleFunctionService.insert(baseRoleFunction);
            }
        }

    }


}