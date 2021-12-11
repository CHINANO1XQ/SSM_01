package com.zking.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String sname;
    private String password;
    private String sex;
    private String hobby;
    private String[] favorite;
}
