package com.circleback.portfolio.controller;

import com.circleback.portfolio.entity.contract.Rental;
import com.circleback.portfolio.service.ContractService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/contracts")
public class Contracts {

    private final ContractService contractService;

    @PostMapping("/contract")
    public ResponseEntity<Rental> contract(@Validated @RequestBody @NonNull Rental rental){
        var contract = contractService.createContract(rental);
        return ResponseEntity.ok(contract);
    }

    @GetMapping("/contract")
    public ResponseEntity<List<Rental>> getContract(){
        return ResponseEntity.ok(contractService.getAllContracts());
    }
}
