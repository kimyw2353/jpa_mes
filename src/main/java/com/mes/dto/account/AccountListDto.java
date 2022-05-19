package com.mes.dto.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class AccountListDto {
    private final String accountCode;
    private final String accountName;
    private final String accountKind;
}
