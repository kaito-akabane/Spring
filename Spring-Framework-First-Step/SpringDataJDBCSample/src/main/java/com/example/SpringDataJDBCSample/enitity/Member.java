package com.example.SpringDataJDBCSample.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private Integer id;
    private String name;
}