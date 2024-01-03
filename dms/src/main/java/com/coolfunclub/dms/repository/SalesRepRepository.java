package com.coolfunclub.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coolfunclub.dms.model.SalesRep;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long>{

}
