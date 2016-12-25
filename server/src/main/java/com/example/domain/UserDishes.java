package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ming on 2016/12/9.
 */
@Builder
@Data
@Document(collection = "ya_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserDishes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String userName;

    private String dishesName;

    private LocalDate localDate;

    private Integer price;

    public UserDishes(String userName, String dishesName, LocalDate localDate, Integer price) {
        this.userName = userName;
        this.dishesName = dishesName;
        this.localDate = localDate;
        this.price = price;
    }

}
