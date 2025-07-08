package com.tech.vehicle.repository;

import com.tech.vehicle.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByMobileNumber(String mobileNumber);
}
