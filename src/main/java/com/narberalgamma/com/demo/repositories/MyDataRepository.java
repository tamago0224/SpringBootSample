package com.narberalgamma.com.demo.repositories;

import com.narberalgamma.com.demo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
