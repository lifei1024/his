package com.qhit.baseFunction.service.impl;

import com.qhit.baseFunction.service.IBaseFunctionService;
import java.util.List;
import com.qhit.baseFunction.dao.IBaseFunctionDao;
import com.qhit.baseFunction.dao.impl.BaseFunctionDaoImpl;
import com.qhit.baseFunction.pojo.BaseFunction;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseFunctionServiceImpl  implements IBaseFunctionService {

    IBaseFunctionDao dao = new BaseFunctionDaoImpl();

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
        BaseFunction baseFunction = findById(id); 
        return dao.delete(baseFunction); 
    } 


    @Override 
    public List findAll() {
        String sql = "SELECT * from base_function bf LEFT JOIN base_module bm ON bf.mid=bm.mid";
        return dao.freeFind(sql);
    } 


    @Override 
    public BaseFunction findById(Object id) { 
        List<BaseFunction> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List findByMid(Integer mid,Integer userId) {
        if(mid==null){
            mid=1;
        }
        String sql = "SELECT DISTINCT bf.*\n" +
                "from base_function bf JOIN base_role_function brf ON bf.fid=brf.fid\n" +
                "\t\t      JOIN base_role br ON brf.rid=br.rid\n" +
                "\t\t      JOIN base_user_role bur ON bur.rid = br.rid\n" +
                "\t\t      JOIN base_user bu ON bu.user_id = bur.uid\n" +
                "\t\t      JOIN base_module bm ON bm.mid = bf.mid\n" +
                "\t\t      AND bur.uid="+userId+"\n" +
                "\t\t      AND bf.mid="+mid;
        return dao.freeFind(sql);
    }
    @Override
    public List<BaseFunction> search(BaseFunction baseFunction) {
        String sql = "select * from base_function where 1=1 ";
        if (baseFunction.getFname()!=null && !"".equals(baseFunction.getFname())){
            sql+=" and fname like '%"+baseFunction.getFname()+"%' ";
        }
        if (baseFunction.getMid()!=null && !"".equals(baseFunction.getMid())){
            sql+=" and mid like '%"+baseFunction.getMid()+"%' ";
        }
        if (baseFunction.getUrl()!=null && !"".equals(baseFunction.getUrl())){
            sql+=" and url like '%"+baseFunction.getUrl()+"%' ";
        }
        List<BaseFunction> list = dao.freeFind(sql);
        return list;
    }

}