package edu.mum.cs.cs425.bankapp.Controllers;

import edu.mum.cs.cs425.bankapp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = {"/"}) //Displaying Homepage
    public ModelAndView home(Model model){
        ModelAndView modelAndView = new ModelAndView();
        float checkingTotal = accountService.findSumOfAccounts(1);
        float savingTotal = accountService.findSumOfAccounts(2);
        float loanTotal = accountService.findSumOfAccounts(3);
        float liquidity = (checkingTotal + savingTotal) - loanTotal;
        modelAndView.addObject("CheckingTotal",checkingTotal);
        modelAndView.addObject("savingTotal",savingTotal);
        modelAndView.addObject("loanTotal",loanTotal);
        modelAndView.addObject("liquidity", liquidity);
        modelAndView.setViewName("home/homepage");
        return modelAndView;
    }


}
