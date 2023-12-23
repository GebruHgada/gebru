package com.gebru.mekelecityservice.Repository;

import com.gebru.mekelecityservice.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {
}
