package com.tech.vehicle.repository;

import com.tech.vehicle.entity.Seller;
import com.tech.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findBySeller(Seller seller);

}
