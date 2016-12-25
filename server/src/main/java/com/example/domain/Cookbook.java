package com.example.domain;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ming on 2016/12/9.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cookbook {

    @Id
    private String id;
    private String name;
    private Integer buyNum;
    private Integer price;


    public Cookbook(String name, Integer buyNum, Integer price) {
        this.name = name;
        this.buyNum = buyNum;
        this.price = price;
    }
}
