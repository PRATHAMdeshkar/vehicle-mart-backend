package com.tech.vehicle.service;

import com.tech.vehicle.dto.BuyerRegistrationRequest;
import com.tech.vehicle.dto.SellerRegistrationRequest;
import com.tech.vehicle.entity.Buyer;
import com.tech.vehicle.entity.Seller;
import com.tech.vehicle.repository.BuyerRepository;
import com.tech.vehicle.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    public boolean isExistingUser(String mobileNumber) {
        return sellerRepository.findByMobileNumber(mobileNumber).isPresent();
    }

    public boolean isExistingBuyer(String mobileNumber){
        return buyerRepository.findByMobileNumber(mobileNumber).isPresent();
    }


    public Seller registerSeller(SellerRegistrationRequest request) {
        Seller seller = new Seller();
        seller.setMobileNumber(request.getMobileNumber());
        seller.setName(request.getName());
        seller.setEmail(request.getEmail());
        seller.setCity(request.getCity());
        seller.setState(request.getState());
        return sellerRepository.save(seller);
    }

    public Buyer registerBuyer(BuyerRegistrationRequest request){
        Buyer buyer = new Buyer();
        buyer.setMobileNumber((request.getMobileNumber()));
        buyer.setName(request.getName());
        buyer.setEmail(request.getEmail());
        buyer.setCity(request.getCity());
        buyer.setState(request.getState());
        return buyerRepository.save(buyer);
    }
    public Optional<Seller> login(String mobileNumber) {
        return sellerRepository.findByMobileNumber(mobileNumber);
    }

    public Optional<Buyer> loginBuyer(String mobileNumber) {
        return buyerRepository.findByMobileNumber(mobileNumber);
    }
}
