package com.tech.vehicle.dto;

import lombok.Data;

@Data
public class VehicleUploadRequest {
    public Long getSellerId() {
        return sellerId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getNumberOfOwners() {
        return numberOfOwners;
    }

    private Long sellerId;
    private String brand;
    private String model;
    private Integer year;
    private String fuelType;
    private String transmissionType;
    private String vehicleType;
    private Integer mileage;
    private Integer numberOfOwners;
}
