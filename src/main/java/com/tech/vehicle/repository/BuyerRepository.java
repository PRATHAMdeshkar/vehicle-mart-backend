package com.tech.vehicle.repository;

import com.tech.vehicle.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Optional<Buyer> findByMobileNumber(String mobileNumber);
}

