package com.jessica.entity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class Dept {
    private int depNo;
    private String depName;
    private String loc;
    private boolean flag;
}
