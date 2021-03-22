package com.home.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 *
 *
 * @Author 冯根源
 * @create 2021/3/22 16:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
