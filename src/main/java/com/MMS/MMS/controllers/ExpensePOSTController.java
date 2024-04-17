package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseQuickCreateDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.service.expense_services.ExpenseService;
import com.MMS.MMS.service.expense_services.ExpenseDTOMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ExpensePOSTController {
    // Expose functionality so that it can be consumed by external entities (including UI)
    // If someone wants to access business logic, they go through a controller to get there.
    // If code is dealing with exposing functionality, it goes in the controller.
    // Controller is passing work between Repository and Service layer

    @Autowired
    private ExpenseRepository ExpenseRepository;

    @Autowired
    private ExpenseService expenseService = new ExpenseService(ExpenseRepository);
    private final ExpenseDTOMapper expenseDTOMapper = new ExpenseDTOMapper();


    @RequestMapping(value = "/addExpense", method = RequestMethod.POST)
    public String addExpense(Model model, @ModelAttribute("newExpense") ExpenseQuickCreateDTO newExpense) {

        try{
            ExpenseCreationDTO populatedExp = expenseDTOMapper.quickCreateToFullDTO(newExpense);
            Expense expense = expenseDTOMapper.toExpense(populatedExp);
            expenseService.saveExpense(expense);
            return "redirect:/viewExpenses";
        }
        catch(Exception e){
            return "redirect:/viewExpenses?error=true";
        }
    }


    @PostMapping("/delete/{expenseID}")
    public String deleteExpense(@PathVariable ObjectId expenseID) {

        // Directly converted from UserPOSTController, needs editing.

        try {
            expenseService.deleteExpenseById(expenseID);
            return "redirect:/getAllExpenses";
        }
        catch (Exception e) {
            return "redirect:/getAllExpenses?error=true";
        }
    }

    // OLD CODE PROBABLY TRASH BUT STILL MIGHT NEED TO REFERENCE  
//
//    @Autowired
//    private ExpenseRepository expenseRepository;
//
//    private UserDTO user;
//    private ExpenseDTO expense;
//    private Model model;
//
//    @PostMapping("/addExpense")
//    public String addExpense(HttpSession session, @ModelAttribute("newExpense") ExpenseDTO newExpense) {
//        // Adjust entire method for DTOs
//        UserDTO loggedUser = (UserDTO) session.getAttribute("loggedUser");
//        // newExpense.setUserID(loggedUser.getUserID());
//        if(newExpense.getName() != null && !newExpense.getName().isEmpty()) {
//            //expenseRepository.save(newExpense);
//            return "redirect:/viewExpenses";
//        }
//
//        return "redirect:/viewExpenses?error=true";
//
//    }
//
//    @PostMapping("/deleteExpense/{id}")
//    public String deleteExpense(@PathVariable String id) {
//        expenseRepository.deleteById(id);
//
//        return "redirect:/viewExpenses";
//    }
//
//    @PostMapping("/editExpense/{id}")
//    public String editExpense(@PathVariable String id) {
//        expenseRepository.deleteById(id);
//
//        return "redirect:/viewExpenses";
//    }




}
