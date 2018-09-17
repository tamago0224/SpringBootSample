package com.narberalgamma.com.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "current data.");
        DataObject obj = new DataObject(123, "hanako", "hanako@flower");
        mav.addObject("object", obj);
        return mav;
    }
}


@Getter
@Setter
@AllArgsConstructor
class DataObject {
    private int id;
    private String name;
    private String value;
}