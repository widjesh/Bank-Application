package edu.mum.cs.cs425.bankapp.Controllers;

import edu.mum.cs.cs425.bankapp.Entities.Account;
import edu.mum.cs.cs425.bankapp.Service.AccountService;
import edu.mum.cs.cs425.bankapp.Service.AccountTypeService;
import edu.mum.cs.cs425.bankapp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountTypeService accountTypeService;


    @GetMapping(value = {"account/new"})
    public String displayNewAccountForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("accountTypes",accountTypeService.findAll());
        return "account/new";
    }

    @PostMapping(value = {"account/new"})
    public String addNewCustomer(@Valid @ModelAttribute("account") Account account,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "account/new";
        }
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping(value = "account/list")
    public String displayAccounts(Model model){
        model.addAttribute("accounts",accountService.getAllAccounts());
        return "account/list";
    }

}
