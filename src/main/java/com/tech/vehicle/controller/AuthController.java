package com.tech.vehicle.controller;
import com.tech.vehicle.dto.OtpRequest;
import com.tech.vehicle.dto.*;
import com.tech.vehicle.entity.Buyer;
import com.tech.vehicle.entity.Seller;
import com.tech.vehicle.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/check")
    public ResponseEntity<?> checkUser(@RequestBody OtpRequest request) {
        boolean exists = authService.isExistingUser(request.getMobileNumber());
        return ResponseEntity.ok(Map.of("exists", exists));
    }

    @PostMapping("/check-buyer")
    public ResponseEntity<?> checkBuyer(@RequestBody OtpRequest request){
        boolean exists = authService.isExistingBuyer(request.getMobileNumber());
        return ResponseEntity.ok(Map.of("exists", exists));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SellerRegistrationRequest request) {
        Seller seller = authService.registerSeller(request);
        return ResponseEntity.ok(seller);
    }

    @PostMapping("/register-buyer")
    public ResponseEntity<?> register(@RequestBody BuyerRegistrationRequest request){
        Buyer buyer = authService.registerBuyer(request);
        return ResponseEntity.ok(buyer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody OtpRequest request) {
        return authService.login(request.getMobileNumber())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/login-buyer")
    public ResponseEntity<?> loginBuyer(@RequestBody OtpRequest request) {
        return authService.loginBuyer(request.getMobileNumber())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
