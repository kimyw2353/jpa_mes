package com.mes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Business {
    @Column(name = "business_number")
    private String number;

    @Column(name = "business_type")
    private String type;

    @Column(name = "business_category")
    private String category;

    public Business() {
    }

    public Business(String number, String type, String category) {
        this.number = number;
        this.type = type;
        this.category = category;
    }
}
