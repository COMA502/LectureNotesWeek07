package edu.dmacc.dsmcode.coma510.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    File menuFile = new File(
            "src\\main\\edu\\dmacc\\dsmcode\\coma510\\review\\menu.txt");
    HashMap<String, Double> menu = new HashMap<>();

    public void getMenuFromFile() throws FileNotFoundException {
        //        System.out.println(menuFile.getAbsolutePath()); // Use this if you're getting FileNotFoundException
        Scanner fileInput = new Scanner(menuFile);
        while (fileInput.hasNextLine()) {
            String commaSeparatedFoodAndPrice = fileInput.nextLine();
            String[] foodAndPrice = commaSeparatedFoodAndPrice.split(",");
            String food = foodAndPrice[0];
            String price = foodAndPrice[1];
            menu.put(food, Double.parseDouble(price));
        }
    }

    public void saveMenuToFile() throws FileNotFoundException {
        PrintWriter fileWriter = new PrintWriter(menuFile);
        try {
            for (String food : menu.keySet()) {
                fileWriter.printf("%s,%.2f\n", food, menu.get(food));
            }
        } finally {
            fileWriter.close();
        }
    }

    public void printMenu() {
        System.out.println("--- Menu ---");
        for (String food : menu.keySet()) {
            Double price = menu.get(food);
            System.out.println(String.format("$%.2f", price) + "  " + food);
//            System.out.printf("$%.2f  %s\n", price, food);//Same thing as println
        }
    }

    public void addMenuItem(String food, double price) {
        menu.put(food, price);
    }

    public boolean hasFood(String food) {
        return menu.containsKey(food);
    }

    public double getPrice(String food) {
        return menu.get(food);
    }
}
