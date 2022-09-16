package com.studentManagement.repository;

import com.studentManagement.Entity.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuardianRepositoryTest {

    @Autowired
    private GuardianRepository guardianRepository;

    @Test
    public void printAllGuardian(){
        List<Guardian> list = guardianRepository.findAll();
        System.out.println(list);
    }

}