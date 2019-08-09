package edu.mum.cs.cs425.bankapp.Controllers;

import edu.mum.cs.cs425.bankapp.Entities.Customer;
import edu.mum.cs.cs425.bankapp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/edit/{customerId}")
    public String editCustomer(@PathVariable("customerId") Long customerId, Model model){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null){
            model.addAttribute("customer", customer);
            return "customer/edit";
        }
        return"customer/edit";
    }

    @PostMapping(value = {"/edit"}) // Voor het knop
    public String updateStudent(@Valid @ModelAttribute("customer") Customer customer,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/edit";
        }
        customer = customerService.saveCustomer(customer);
        return "redirect:/list";
    }

    @GetMapping(value = {"/list"})
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerService.getAllCustomers());
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        customer = customerService.saveCustomer(customer);
        return "redirect:/list";
    }
    @GetMapping(value = {"/delete/{customerId}"})
    public String deleteById(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomerById(customerId);
        return "redirect:/list";
    }

}
