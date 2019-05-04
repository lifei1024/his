package com.qhit.doctorMenu.service.impl;

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUser.service.IBaseUserService;
import com.qhit.baseUser.service.impl.BaseUserServiceImpl;
import com.qhit.doctorMenu.service.IDoctorMenuService;
import java.util.List;
import com.qhit.doctorMenu.dao.IDoctorMenuDao;
import com.qhit.doctorMenu.dao.impl.DoctorMenuDaoImpl;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.medicineCode.pojo.MedicineCode;

/**
* Created by GeneratorCode on 2018/12/19
*/

public class DoctorMenuServiceImpl  implements IDoctorMenuService {

    IDoctorMenuDao dao = new DoctorMenuDaoImpl();

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
        DoctorMenu doctorMenu = findById(id); 
        return dao.delete(doctorMenu); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorMenu findById(Object id) { 
        List<DoctorMenu> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<DoctorMenu> search(DoctorMenu doctorMenu) {
            String sql = "select * from doctor_menu where 1=1 "; 
            if (doctorMenu.getMenuName()!=null && !"".equals(doctorMenu.getMenuName())){        
                sql+=" and menu_name like '%"+doctorMenu.getMenuName()+"%' ";        
            } 
            if (doctorMenu.getUserId()!=null && !"".equals(doctorMenu.getUserId())){        
                sql+=" and user_id like '%"+doctorMenu.getUserId()+"%' ";        
            } 
            if (doctorMenu.getDescription()!=null && !"".equals(doctorMenu.getDescription())){        
                sql+=" and description like '%"+doctorMenu.getDescription()+"%' ";        
            } 
            if (doctorMenu.getType()!=null && !"".equals(doctorMenu.getType())){        
                sql+=" and type like '%"+doctorMenu.getType()+"%' ";        
            } 
            List<DoctorMenu> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public boolean findByname(String menuName) {
        List list = dao.findByMenuName(menuName);
        if (list!=null&&list.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public List<MedicineCode> findLeftRole(Integer menuId) {
        String sql = "SELECT * from medicine_code mc WHERE mc.code_id NOT IN\n" +
                "(SELECT code_id\n" +
                "from doctor_menu_medicine dmm JOIN doctor_menu dm \n" +
                "ON dmm.menu_id =dm.menu_id AND dm.menu_id="+menuId+")";
        return dao.freeFind(sql);
    }

    @Override
    public List<MedicineCode> findRightRole(Integer menuId) {
        String sql = "SELECT * from medicine_code mc WHERE mc.code_id IN\n" +
                "(SELECT code_id\n" +
                "from doctor_menu_medicine dmm JOIN doctor_menu dm \n" +
                "ON dmm.menu_id =dm.menu_id AND dm.menu_id="+menuId+")";
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenu> find1(Integer userId) {
        //状态等于1
        String sql ="SELECT * from doctor_menu dm \n" +
                "JOIN base_user bu ON dm.user_id=bu.user_id\n" +
                "WHERE dm.type=1 AND dm.user_id="+userId;
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenu> find2(BaseUser sessionUser) {
        //状态等于2
        IBaseUserService baseUserService = new BaseUserServiceImpl();
        BaseUser baseUser = baseUserService.findById(sessionUser.getUserId());
        String sql ="SELECT * from doctor_menu dm \n" +
                "JOIN base_user bu ON dm.user_id=bu.user_id\n" +
                "WHERE dm.type=2 AND bu.dept_id="+baseUser.getDeptId();
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenu> find3() {
        //状态等于3
        String sql = "SELECT * from doctor_menu dm \n" +
                "JOIN base_user bu ON dm.user_id=bu.user_id\n" +
                "WHERE dm.type=3";
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenu> findMenu(BaseUser sessionUser) {
        String sql = "SELECT * from doctor_menu dm JOIN base_user bu ON dm.user_id=bu.user_id WHERE (TYPE = 3) OR (TYPE=2 AND bu.dept_id="+sessionUser.getDeptId()+") OR (TYPE=1 AND bu.user_id="+sessionUser.getUserId()+")";
        return dao.freeFind(sql);
    }


}