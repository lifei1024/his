package com.qhit.baseUser.service;

import java.util.List;

import com.qhit.baseDept.pojo.BaseDept;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseUser.pojo.BaseUser;
/**
* Created by GeneratorCode on 2018/11/26
*/

public interface IBaseUserService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseUser findById(Object id);

    List<BaseUser> search(BaseUser baseUser);

    BaseUser login(BaseUser baseUser);

    boolean findOldPassword(BaseUser baseUser);

    List<BaseRole> findLeftRole(Integer userId);

    List<BaseRole> findRightRole(Integer userId);

    void distributeUpdate(Integer userId, String rids);

    List<BaseUser> findDept(Integer deptId);
}

