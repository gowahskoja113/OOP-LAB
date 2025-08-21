package org.example;

import java.net.spi.InetAddressResolver;
import java.util.Objects;
import java.util.Optional;

public class Program {
    public Program program;
    private Product[] products;
    private byte numOfProduct;
    private static final byte MAX = 100;

    //option in submenu
    private final int ADD_ELECTRONICS = 1;
    private final int ADD_CLOTHINGS = 2;
    private final int EXIT_SUBMENU = 3;

    //option in main menu
    private final String ADD = "1";
    private final String DISPLAY = "2";
    private final String FIND = "3";
    private final String EXIT = "0";

    public Program(){
        products = new Product[MAX];
        numOfProduct = 0;
    }

    public void displayProducts(){
        if (numOfProduct == 0) {
            System.out.println("No items in the list.");
            return;
        }
        for (int i = 0; i < numOfProduct; i++) {
            System.out.println(products[i]);
        }
    }

    //dung1 optional de khong tra ve null
    public Optional<Product> findProduct(int id) {
        if (numOfProduct == 0) {
            return Optional.empty();
        }

        for (int i = 0; i < numOfProduct; i++) {
            if (products[i] != null && products[i].getId() == id) {
                return Optional.of(products[i]);
            }
        }

        return Optional.empty();
    }

    public void displayProductById(int input){
        findProduct(input).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Can not find this product!")
        );
    }

    public void addProduct (Product product){
        if (numOfProduct < MAX){
            products[numOfProduct++] = product;
            System.out.println("Product add successfully");
        }else {
            System.out.println("Product list is full");
        }
    }

    public void addNewProduct() {
        int choice;
        do {
            Helper.subMenu();
            choice = Helper.readNonNegativeInt("Enter your choice: ");

            switch (choice) {

                case ADD_ELECTRONICS:
                    int electronicId = Helper.inputProductId("Enter number id: ", products);
                    String electronicName = Helper.readNonEmptyString("Enter name of product: ");
                    float electronicPrice = Helper.readNonNegativeFloat("Enter product's price: ");
                    String electronicBrand = Helper.readNonEmptyString("Enter product's brand: ");

                    Electronics electronics = new Electronics(electronicId, electronicName, electronicPrice, electronicBrand);
                    addProduct(electronics);
                    break;

                case ADD_CLOTHINGS:
                    int clothingId = Helper.inputProductId("Enter number id: ", products);
                    String clothingName = Helper.readNonEmptyString("Enter name of product: ");
                    float clothingPrice = Helper.readNonNegativeFloat("Enter product's price: ");
                    String clothingSize = Helper.readNonEmptyString("Enter product's size: ");

                    Clothing clothing = new Clothing(clothingId, clothingName, clothingPrice, clothingSize);
                    addProduct(clothing);
                    break;

                case EXIT_SUBMENU:
                    System.out.println("Exit sub menu!");
                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        } while (choice != EXIT_SUBMENU);
    }

    public void runMainMenu() {
        String choice;
        do {
            Helper.mainMenu();
            choice = Helper.readNonEmptyString("Enter your choice: ");

            switch (choice) {

                case ADD:
                    addNewProduct();
                    break;

                case DISPLAY:
                    displayProducts();
                    break;

                case FIND:
                    int inputId = Helper.readNonNegativeInt("Enter product's ID to find: ");
                    displayProductById(inputId);
                    break;

                case EXIT:
                    System.out.println("Exit the program");
                    break;

                default:
                        System.out.println("Invalid choice. Please enter a number from 0 to 3.");
                        break;
            }
        } while (!choice.equals("0"));
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.runMainMenu();
    }
}



