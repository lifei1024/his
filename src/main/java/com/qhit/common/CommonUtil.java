package com.qhit.common;

import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseUser.pojo.BaseUser;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/12/5.
 */
public class CommonUtil {

    public static String dateToStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static boolean isRoleExists(HttpSession session, Integer rid){
        boolean flag = false;
        BaseUser baseUser = (BaseUser) session.getAttribute("sessionUser");
        List<BaseRole> baseRoleList = baseUser.getBaseRoleList();
        for(BaseRole baseRole:baseRoleList){
            if(rid==baseRole.getRid()){
                flag=true;
                break;
            }
        }
        return flag;
    }

}
