package com.obm.onlinebookmanagement.services;

import com.obm.onlinebookmanagement.entity.Book;
import com.obm.onlinebookmanagement.entity.MyBookList;
import com.obm.onlinebookmanagement.repository.BookRepository;
import com.obm.onlinebookmanagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository myBookRepository;
    @Autowired
    private BookRepository bookRepository;

    public  void  saveMyBook(MyBookList BookedBook){
        myBookRepository.save(BookedBook);
    }
    public List<MyBookList> getMyBookList(){

        return myBookRepository.findAll();
    }
    public void DeleteBookedBooksById(int id){
        myBookRepository.deleteById(id);
    }
    public MyBookList getMyBookListById(int id){
        return myBookRepository.findById(id).get();
    }


}
