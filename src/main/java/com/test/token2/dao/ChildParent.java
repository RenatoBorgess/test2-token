package com.test.token2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildParent {
    private String childName;
    private String fatherName;
    private String motherName;
}
