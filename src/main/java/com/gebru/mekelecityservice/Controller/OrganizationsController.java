package com.gebru.mekelecityservice.Controller;

import com.gebru.mekelecityservice.Model.Organizations;
import com.gebru.mekelecityservice.Repository.OrganizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrganizationsController {
    @Autowired
    OrganizationsRepository organizationsRepository;


    @RequestMapping(value = "/organizations/new", method = RequestMethod.GET)
    public String newOrganizationsForm(Model model){
        model.addAttribute("organizations", new Organizations());
        return "organizations/new";
    }
    @RequestMapping(value = "/organizations/new", method = RequestMethod.POST)
    public String saveOrganizations(Model model, Organizations organizations){

        organizationsRepository.save(organizations);
        model.addAttribute("organizations", organizations);
        return "redirect:/organizations/list";

    }
    @RequestMapping(value = "/organizations/list", method = RequestMethod.GET)
    public String findAllOrganizations(Model model){

        List<Organizations> organizations= organizationsRepository.findAll();
        model.addAttribute("organizations", organizations);
        return "organizations/list";
    }
    @RequestMapping(value = "/organizations/edit/{id}", method = RequestMethod.GET)
    public String editOrganizations(Model model,@PathVariable Long id){
        Organizations organizations= organizationsRepository.findById(id).orElse(null);
        model.addAttribute("organizations", organizations);
        return "organizations/edit";
    }

    @RequestMapping(value = "/organizations/edit", method = RequestMethod.POST)
    public String updateOrganizations(Model model,Organizations organizations){
        organizationsRepository.save(organizations);
        model.addAttribute("organizations", organizations);
        return "redirect:/organizations/list";
    }

    @RequestMapping(value = "/organizations/delete/{id}", method = RequestMethod.GET)
    public String deleteOrganizations(@PathVariable Long id){
        organizationsRepository.deleteById(id);
        return "redirect:/organizations/list";
    }
}
