package com.narberalgamma.com.demo.repositories;

import com.narberalgamma.com.demo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
    public Optional<MyData> findById(Long name);
}
