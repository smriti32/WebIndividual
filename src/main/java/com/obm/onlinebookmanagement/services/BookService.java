package com.obm.onlinebookmanagement.services;


import com.obm.onlinebookmanagement.entity.Book;
import com.obm.onlinebookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;


    public  void Save(Book book)
    {
        bookRepository.save(book);
    }

    public List<Book> GetAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookByID(int id){
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

    //To Get List of all books
    public  List<Book> getAllBooks(){
        List<Book> bookList=bookRepository.findAll();
        return bookList;
    }

    //To Get Particular Book from list using Book Title
    public List<Book> getBookByTitle(String title){
        List<Book> bookListByTitle=bookRepository.FindBookByTitle(title);
        return bookListByTitle;
}



}
