package com.obm.onlinebookmanagement.controller;

import com.obm.onlinebookmanagement.entity.Book;
import com.obm.onlinebookmanagement.entity.MyBookList;
import com.obm.onlinebookmanagement.services.BookService;
import com.obm.onlinebookmanagement.services.MyBookListService;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController
{
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;

    @GetMapping({"/","/home","/editBook/home","/editBookedBook/home"})
    public String index()
    {
        return "home";
    }

    @GetMapping({"/book_register","/editBook/book_register","/editBookedBook/book_register"})
    public String bookRegister()
    {
        return "bookregister";
    }

    @GetMapping({"available_book","/editBook/available_book","/editBookedBook/available_book"})
    public ModelAndView availableBook()
    {
        List<Book>bookList = bookService.GetAllBooks();
        return new ModelAndView("allBooksInLibrary","book",bookList);
    }
    @GetMapping({"/my_books","/editBook/my_books","/editBookedBook/my_books"})
    public String mybooks(Model model){
        List<MyBookList>bookLists=myBookListService.getMyBookList();
        model.addAttribute("bookss",bookLists);
        return "BookedBooks";
    }
    @PostMapping("/Save")
    public String addBook (@ModelAttribute Book book){
        bookService.Save(book);
        return "redirect:/available_book";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book=bookService.getBookByID(id);
        MyBookList bookList=new MyBookList(book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPrice(),null,null,null,null);
        myBookListService.saveMyBook(bookList);
        //bookService.deleteById(id);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model)
    {
        Book book= bookService.getBookByID(id);
        model.addAttribute("book",book);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return ("redirect:/available_book");
    }
    @RequestMapping(path = {"/","/search"})
    public String search(Book book , Model model,String searchInput)
    {
        if(searchInput!=null)
        {
            List<Book> list = bookService.getBookByTitle(searchInput);
            model.addAttribute("book",list);
        }
        else
        {
            List<Book> list = bookService.getAllBooks();
            model.addAttribute("book",list);
            return "home";
        }
        return "searchResult";
    }












}
