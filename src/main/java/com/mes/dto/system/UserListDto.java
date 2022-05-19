package com.mes.dto.system;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class UserListDto {
    private final String userId;
    private final String userName;
}
