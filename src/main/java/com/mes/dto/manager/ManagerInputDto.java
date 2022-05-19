package com.mes.dto.manager;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ManagerInputDto {
    private final Integer managerId;
    private final Integer accountId;
    private final String name;
    private final String grade;
    private final String tel;
    private final String email;
    private final String etc;
}
