package com.circleback.portfolio.service;

import com.circleback.portfolio.Repository.ContractRepository;
import com.circleback.portfolio.entity.contract.Rental;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public Rental createContract(Rental rental) {

        log.info("Creating new rental contract with ID: {}", rental.getContractId());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime currentDatetime = now.withNano((now.getNano() / 1_000_000) * 1_000_000);

        Rental contract = Rental.builder()
                .contractId(rental.getContractId())
                .contractType(rental.getContractType())
                .createdOn(String.valueOf(currentDatetime))
                .createdBy(rental.getCreatedBy())
                .modifiedOn(String.valueOf(currentDatetime))
                .modifiedBy(rental.getModifiedBy())
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .rentAmount(rental.getRentAmount())
                .owner(rental.getOwner())
                .tenant(rental.getTenant())
                .renewalDate(rental.getRenewalDate())
                .build();
        log.info("Saving rental contract with ID: {}", contract.getContractId());
        contractRepository.save(contract);
        return contract;
    }

    public List<Rental> getAllContracts() {
        log.info("Fetching all rental contracts");
        return contractRepository.findAll();
    }
}
