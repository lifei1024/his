package com.qhit.doctorMenu.service;

import java.util.List;

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.medicineCode.pojo.MedicineCode;

/**
* Created by GeneratorCode on 2018/12/19
*/

public interface IDoctorMenuService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    DoctorMenu findById(Object id);

    boolean freeUpdate(String sql);

    List<DoctorMenu> search(DoctorMenu doctorMenu);

    boolean findByname(String menuName);

    List<MedicineCode> findLeftRole(Integer menuId);

    List<MedicineCode> findRightRole(Integer menuId);

    List<DoctorMenu> find1(Integer userId);

    List<DoctorMenu> find2(BaseUser sessionUser);

    List<DoctorMenu> find3();

    List<DoctorMenu> findMenu(BaseUser sessionUser);
}