package com.gaurav.aggregator.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@ToString
public class FetchedData {


    private String test = "test";
    private Double code_3000;
    private Double code_3001;
    private Double code_3002;
    private Double code_3003;
    private Double code_3004;
    private Double code_3005;
    private Date time;
    public FetchedData(Double code_3000, Double code_3001, Double code_3002, Double code_3003, Double code_3004, Double code_3005, Date time) {
        this.code_3000 = code_3000;
        this.code_3001 = code_3001;
        this.code_3002 = code_3002;
        this.code_3003 = code_3003;
        this.code_3004 = code_3004;
        this.code_3005 = code_3005;
        this.time = time;
    }

    public Double getCode_3000() {
        return code_3000 == null ? 0 : code_3000;
    }

    public Double getCode_3001() {
        return code_3001 == null ? 0 : code_3001;
    }

    public Double getCode_3002() {
        return code_3002 == null ? 0 : code_3002;
    }

    public Double getCode_3003() {
        return code_3003 == null ? 0 : code_3003;
    }

    public Double getCode_3004() {
        return code_3004 == null ? 0 : code_3004;
    }

    public Double getCode_3005() {
        return code_3005 == null ? 0 : code_3005;
    }

    public String getTest() {
        return test;
    }

    public Date getTime() {
        return time;
    }
}
