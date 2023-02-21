package com.obm.onlinebookmanagement.controller;

import com.obm.onlinebookmanagement.entity.Book;
import com.obm.onlinebookmanagement.entity.MyBookList;
import com.obm.onlinebookmanagement.services.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookListService;


    @RequestMapping("/deleteBookedBook/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        myBookListService.DeleteBookedBooksById(id);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBookedBook/{id}")
    public String editMyBookListBook(@PathVariable("id") int id, Model model)
    {
        MyBookList bookList= myBookListService.getMyBookListById(id);
        model.addAttribute("bookss",bookList);
        return "bookedbookEdit";
    }
    @PostMapping("/SaveBookedBooks")
    public String addBook (@ModelAttribute MyBookList bookedBook){
        myBookListService.saveMyBook(bookedBook);
        return "redirect:/my_books";
    }

}
