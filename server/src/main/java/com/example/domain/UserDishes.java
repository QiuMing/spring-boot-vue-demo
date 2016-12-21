package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Ming on 2016/12/9.
 */
@Builder
@Data
@Document(collection = "ya_user")
public class UserDishes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long uid;

    private Long cid;

}
