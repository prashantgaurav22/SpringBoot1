package com.dxc.glic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.glic.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}