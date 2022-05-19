package com.mes.dto.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AccountInputDto {
    private final Integer accountId;
    private final String accountCode;
    private final String accountName;
    private final String accountKind;
    private final String businessNumber;
    private final String businessType;
    private final String businessCategory;
    private final String ceo;
    private final String tel;
    private final String fax;
    private final String email;
    private final String zipCode1;
    private final String address1;
    private final String addressDetail1;
    private final String zipCode2;
    private final String address2;
    private final String addressDetail2;
}
