package com.coolfunclub.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coolfunclub.dms.model.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long>{

}
