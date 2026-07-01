package com.tka.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Payment;
@Repository
public interface  PaymentRepository extends JpaRepository<Payment,Long> {

}
