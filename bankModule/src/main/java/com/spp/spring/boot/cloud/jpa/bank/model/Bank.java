package com.spp.spring.boot.cloud.jpa.bank.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bankCode","bankName","branches"})
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bank
{
    @Id
    private @NonNull String bankCode = "";
    private @NonNull String bankName = "";
    private List<Branch> branches = null;
}
