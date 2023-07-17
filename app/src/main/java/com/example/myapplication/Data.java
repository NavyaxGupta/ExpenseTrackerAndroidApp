package com.example.myapplication;

import java.util.ArrayList;
import java.lang.String;


public class Data {

    public static ArrayList<Category> allData = new ArrayList<>();
    public static ArrayList<String> allTypes = new ArrayList<>();

      public static String printAllCategories() {

        String answer = "Category  :\n";

        for (Category x : allData) {
            answer += String.format("%s  :\n", x.getType());
        }

        return answer;
    }

    public static String printAllExpenses() {

        String answer = "  Expenses\n";

        for (Category x : allData) {
            answer += String.format("  %s\n", x.getSpent());
        }

        return answer;
    }

    public static String printBudgetDetails() {

        String answer = "";

        for (Category x : allData) {
            if (x.getSpent() > x.getLimit()){
                answer += String.format("You are over budget for the category %s.\n", x.getType());
            }
        }

        return answer;
    }

    public static String printNoData() {
        String answer = "You have no expenses to show at the moment.\nThis app keeps track of your total expenses.\n\n\n" +
                    "Please click on the Update Expenses button.\n" +
                    "This creates new categories for your expenses if given a unique name.\n" +
                    "Or you may enter an existing category name to add more expenses to the total.\n\n\n"+
                    "The Update Budget button sets budgets for existing categories.\n"+
                    "You will get alerts if you cross the set budget.";

            return answer;
    }

}

