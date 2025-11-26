package com.circleback.portfolio.entity.contract;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "contracts")
public class Rental {
    @Id
    private String id;
    private String contractId;
    private String contractType;
    private String createdOn;
    private String createdBy;
    private String modifiedOn;
    private String modifiedBy;
    private String startDate;
    private String endDate;
    private String rentAmount;
    private IdentityDetails owner;
    private IdentityDetails tenant;
    private String renewalDate;

}
