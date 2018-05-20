package com.spp.spring.boot.cloud.jpa.bank.security.model;
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
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userId","userPassword","passwordHistory","userShortName",
        "userFullName","userSex","userDateofBirth",
        "userContactNumber","userAlternateNumber","userMails",
        "userType","userDepartment","userEmpNumber"})
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable
{
    @Id
    private @NonNull  String userId = "";
    private @NonNull  String userPassword = "";
    //Store last 5 used password
    private Map<String,String> passwordHistory = new HashMap<>();
    private @NonNull  String userShortName = "";
    private @NonNull  String userFullName = "";
    private @NonNull  String userSex = "";
    private Date userDateofBirth = new Date();
    private @NonNull  String userContactNumber = "";
    private String userAlternateNumber = "";
    private @NonNull  String userMails = "";
    //Either employee,Admin,Manager etc
    private @NonNull  String userType = "";
    private @NonNull  String userDepartment = "";
    private @NonNull  String userEmpNumber = "";
}
