package com.raif.testtaskf.json_mapping;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class SocksForm {
   private String color;
   private String operation;
    @Min(value = 0)
    @Max(value = 100)
   private int cottonPart;

    public SocksForm() {
    }

    public SocksForm(String color, String operation, int cottonPart) {
        this.color = color;
        this.operation = operation;
        this.cottonPart = cottonPart;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

}
