package com.tech.vehicle.service;

import com.tech.vehicle.dto.VehicleUploadRequest;
import com.tech.vehicle.entity.Seller;
import com.tech.vehicle.entity.Vehicle;
import com.tech.vehicle.repository.SellerRepository;
import com.tech.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final SellerRepository sellerRepository;
    private final VehicleRepository vehicleRepository;

    public VehicleService(SellerRepository sellerRepository, VehicleRepository vehicleRepository) {
        this.sellerRepository = sellerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void uploadVehicle(VehicleUploadRequest req) {
        Seller seller = sellerRepository.findById(req.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(req.getBrand());
        vehicle.setModel(req.getModel());
        vehicle.setYear(req.getYear());
        vehicle.setFuelType(req.getFuelType());
        vehicle.setTransmissionType(req.getTransmissionType());
        vehicle.setVehicleType(req.getVehicleType());
        vehicle.setMileage(req.getMileage());
        vehicle.setNumberOfOwners(req.getNumberOfOwners());
        vehicle.setPrice(req.getPrice());
        vehicle.setSeller(seller);

        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehiclesBySellerId(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));
        return vehicleRepository.findBySeller(seller);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
