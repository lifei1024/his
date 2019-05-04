package com.qhit.common;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseUser.pojo.BaseUser;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 18203709505 on 2018/12/14.
 */
@Component
@Aspect
public class AuthorityInterceptor {
    @Before("execution(* com.qhit.*.controller.*.*(..))")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
        BaseUser user = (BaseUser) session.getAttribute("sessionUser");
        if (user!=null){
            List<BaseFunction> baseFunctionList = user.getBaseFunctionList();
            String uri = request.getRequestURI();
            boolean flag = false;
            for (BaseFunction baseFunction:baseFunctionList){
                if (baseFunction.getUrl()!=null&&uri.indexOf(baseFunction.getUrl())!=-1){
                    flag=true;
                }
            }
            request.setAttribute("qx",flag);
        }
    }
}
