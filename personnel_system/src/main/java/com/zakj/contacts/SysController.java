package com.zakj.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sys")
public class SysController {


    /**
     * 职工通讯录
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/empContacts")
    public String employee(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "contacts/empContacts";
    }
}
