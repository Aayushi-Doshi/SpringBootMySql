package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.models.AppUsers;
import com.developer.SpringMySql.models.AppUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    AppUsersRepo appUsersRepo;


    @GetMapping("/")
    public ModelAndView doHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lists", appUsersRepo.findAll());
        System.out.print("list" + appUsersRepo.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") String id, @RequestParam("firstname") String fName, @RequestParam("lastname") String lName) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        AppUsers appUsers;
        if (!id.isEmpty() && appUsersRepo.findById(Integer.parseInt(id)).isPresent()) {
            appUsers = appUsersRepo.findById(Integer.parseInt(id)).get();
            appUsers.setFirstName(fName);
            appUsers.setLastName(lName);
        } else {
            appUsers = new AppUsers(fName, lName);
        }
        appUsersRepo.save(appUsers);
        return modelAndView;
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        if (appUsersRepo.findById(id).isPresent()) {
            modelAndView.addObject("list", appUsersRepo.findById(id).get());
        }
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        appUsersRepo.deleteById(id);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        if (appUsersRepo.findById(id).isPresent()) {
            modelAndView.addObject("lists", appUsersRepo.findById(id).get());
        }
        return modelAndView;
    }

}
