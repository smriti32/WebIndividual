package com.obm.onlinebookmanagement.repository;

import com.obm.onlinebookmanagement.entity.Book;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
   //For searching books
   @Query(value = "SELECT * FROM book  WHERE LOWER(title) LIKE lower(CONCAT('%',:searchInput,'%'))" ,nativeQuery = true)
   List<Book> FindBookByTitle(@Param("searchInput")String searchInput);
}
