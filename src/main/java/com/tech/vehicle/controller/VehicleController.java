package com.tech.vehicle.controller;

import com.tech.vehicle.dto.VehicleUploadRequest;
import com.tech.vehicle.entity.Vehicle;
import com.tech.vehicle.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "http://localhost:5173")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadVehicle(@RequestBody VehicleUploadRequest request) {
        vehicleService.uploadVehicle(request);
        return ResponseEntity.ok("Vehicle uploaded successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/seller/{Id}")
    public ResponseEntity<List<Vehicle>> getVehiclesBySeller(@PathVariable Long Id) {
        return ResponseEntity.ok(vehicleService.getVehiclesBySellerId(Id));
    }

}
