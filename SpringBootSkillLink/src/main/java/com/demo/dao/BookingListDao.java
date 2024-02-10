

package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.demo.model.BookingList;

@Repository
//Integer is data type of products id property
public interface BookingListDao extends JpaRepository<BookingList, Integer>{
    
}

