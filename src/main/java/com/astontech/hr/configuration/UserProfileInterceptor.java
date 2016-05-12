package com.astontech.hr.configuration;

import com.astontech.hr.domain.User;
import com.astontech.hr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Bipin on 5/12/2016.
 */
@Component
public class UserProfileInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        if(modelAndView != null) {
            User user = userService.getUserById(1);
            modelAndView.addObject("theme", user.getTheme());
        }

    }
}
