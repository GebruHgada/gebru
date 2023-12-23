package com.gebru.mekelecityservice.Controller;

import com.gebru.mekelecityservice.Model.Customers;
import com.gebru.mekelecityservice.Model.Organizations;
import com.gebru.mekelecityservice.Repository.CustomersRepository;
import com.gebru.mekelecityservice.Repository.OrganizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomersController {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    OrganizationsRepository organizationsRepository;
    @RequestMapping(value = "/customers/new", method = RequestMethod.GET)
    public String newCustomersForm(Model model){
        Customers customers=new Customers();
        model.addAttribute("customers", customers);
        List<Organizations> organizations= organizationsRepository.findAll();
        model.addAttribute("organization",organizations);
        return "customers/new";
    }
    @RequestMapping(value = "/customers/new", method = RequestMethod.POST)
    public String saveCustomers(Model model, Customers customers){

        customersRepository.save(customers);

        model.addAttribute("customers", customers);
        return "redirect:/customers/list";

    }
    @RequestMapping(value = "/customers/list", method = RequestMethod.GET)
    public String findAllCustomers(Model model){

        List<Customers> customers= customersRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }
    @RequestMapping(value = "/customers/edit/{id}", method = RequestMethod.GET)
    public String editCustomers(Model model,@PathVariable Long id){
        Customers customers= customersRepository.findById(id).orElse(null);
        model.addAttribute("customers", customers);
        List<Organizations> organizations= organizationsRepository.findAll();
        model.addAttribute("organization",organizations);
        return "customers/edit";
    }


    @RequestMapping(value = "/customers/edit", method = RequestMethod.POST)
    public String updateCustomers(Model model,Customers customers){
        customersRepository.save(customers);
        model.addAttribute("customers", customers);
        return "redirect:/customers/list";
    }

    @RequestMapping(value = "/customers/delete/{id}", method = RequestMethod.GET)
    public String deleteCustomers(@PathVariable Long id){
        customersRepository.deleteById(id);
        return "redirect:/customers/list";
    }
}
