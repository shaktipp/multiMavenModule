package com.spp.spring.boot.cloud.jpa.bank.customer.model;


import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"customerId","customerName","customerSex",
        "customerDateofBirth","customerMailingAddress","customerPermanentAddress",
        "customerContactNumber","customerAlternateNumber","customerEmails",
        "customerCreditRating","customerAccountNumberList","customerLoanNumberList"})
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable
{
    @Id
    private @NonNull  String customerId = "";
    private @NonNull String customerName = "";
    private @NonNull String customerSex = "M";
    private Date customerDateofBirth = new Date();
    private @NonNull String customerMailingAddress = "";
    private @NonNull String customerPermanentAddress = "";
    private @NonNull String customerContactNumber = "";
    private String customerAlternateNumber = "";
    private @NonNull String customerEmails = "";
    private String customerCreditRating = "";
    private List<String> customerAccountNumberList =  new ArrayList<>();
    private List<String> customerLoanNumberList = new ArrayList<>();
}
