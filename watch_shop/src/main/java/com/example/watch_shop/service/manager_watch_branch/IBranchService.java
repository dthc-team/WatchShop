package com.example.watch_shop.service.manager_watch_branch;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBranchService {
    Page<Branch> findAll(String name , Pageable pageable);
    List<Employee> findAllEmployee(int id);
    List<Watch> findAllWatch(int idBranch);
    Branch findById(int id);
//    List<Employee> find
    void create (BranchDTO branchDTO);
    void update(BranchDTO branchDTO , int id);
    void delete(int isDelete);
}