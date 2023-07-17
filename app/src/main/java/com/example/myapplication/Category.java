package com.example.myapplication;

public class Category{
    String type;
    int limit;
    int spent;

    public Category(String inputType){
        this.type = inputType;
        this.limit = Integer.MAX_VALUE;
        this.spent = 0;
    }

    public String getType(){ return this.type;}
    public int getLimit(){ return this.limit;}
    public int getSpent(){ return this.spent;}
    public void addExpense(int amount){ this.spent += amount;}
}