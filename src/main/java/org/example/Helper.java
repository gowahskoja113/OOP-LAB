package org.example;

import java.util.Scanner;

public class Helper {

    public static final Scanner scanner = new Scanner(System.in);

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicateId(Product[] products, int id){
        for (int i = 0; i < products.length; i++){
            if (products[i] != null && products[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    //nhap string
    public static String readNonEmptyString(String msg){
        while (true){
            System.out.println(msg);
            String input = scanner.nextLine().trim();
            if (!isNullOrEmpty(input)) {
                return input;
            }else {
                System.out.println("Input cannot be empty, please try again!");
            }
        }
    }

    //nhap so int
    public static int readNonNegativeInt(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Input must be a non-negative integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static int inputProductId(String msg, Product[] products){
        while (true){
            System.out.println(msg);
            try{
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= 0 && !isDuplicateId(products, input)){
                    return input;
                }else {
                    System.out.println("ID already exists. Please enter another ID!");
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid interger.");
            }
        }
    }

    //nhap so float
    public static float readNonNegativeFloat(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                float input = Float.parseFloat(scanner.nextLine().trim());
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Input must be a non-negative integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static void subMenu(){
        System.out.println("Choose your type of product:");
        System.out.println("1. Electronic");
        System.out.println("2. Clothing");
        System.out.println("3. Exit");
    }

    public static void mainMenu(){
        System.out.println("Enter your choice: ");
        System.out.println("1. Add new product: ");
        System.out.println("2. Display all product: ");
        System.out.println("3. Find product by ID: ");
        System.out.println("0: Exit");
    }

}
