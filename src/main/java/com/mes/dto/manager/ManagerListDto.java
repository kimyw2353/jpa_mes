package com.mes.dto.manager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class ManagerListDto {
    private final String accountName;
    private final String managerName;
}
