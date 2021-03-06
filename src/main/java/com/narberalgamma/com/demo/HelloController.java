package com.narberalgamma.com.demo;

import com.narberalgamma.com.demo.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.Optional;


@Controller
public class HelloController {
    @Autowired
    MyDataRepository repository;

    @PostConstruct
    public void init() {
        //１つ目のダミーデータ
        MyData d1 = new MyData();
        d1.setName("tuyano");
        d1.setAge(90);
        d1.setMail("syada@tuyano.com");
        d1.setMemo("080-222-222");
        repository.saveAndFlush(d1);

        //２つ目のダミーデータ
        MyData d2 = new MyData();
        d2.setName("hanako");
        d2.setAge(23);
        d2.setMail("hanako@flower");
        d2.setMemo("090-111-111");
        repository.saveAndFlush(d2);

        //３つ目のダミーデータ
        MyData d3 = new MyData();
        d3.setName("sachiko");
        d3.setAge(43);
        d3.setMail("sachiko@happy");
        d3.setMemo("070-222-222");
        repository.saveAndFlush(d3);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(
            @ModelAttribute("formModel") MyData mydata,
            ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "this is sample content.");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(
            @ModelAttribute("formModel")
            @Validated MyData mydata,
            BindingResult result,
            ModelAndView mav) {
        ModelAndView res = null;
        if(!result.hasErrors()) {
            repository.saveAndFlush(mydata);
            res = new ModelAndView("redirect:/");
        } else {
            mav.setViewName("index");
            mav.addObject("msg", "sorry, erro is ocured...");
            Iterable<MyData> list = repository.findAll();
            mav.addObject("datalist", list);
            res = mav;
        }

        return res;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData mydata,
                             @PathVariable int id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "edit mydata.");
        Optional<MyData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView edit(@ModelAttribute MyData mydata,
                             ModelAndView mav) {
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/");
    }

}
