package edu.dmacc.dsmcode.coma510.review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class AssignmentReview {

    /**
     * We're going to create a restaurant application. The user has the choice to either add food items to the menu or
     * order multiple food items and see a total. This is similar to last week's assignment and examples, so use them as
     * reference. Feel free to use the instructor's solution from last week as a starting point.
     * <p>
     * However, this time you must also save the menu to file! When you run the application again, it should re-load
     * the food items and their prices from file. The file will be called 'menu.txt'. If the text file doesn't exist,
     * you can just assume the menu has no items.
     * <p>
     * How the application should operate:
     * When the application starts,
     * (1) load the menu from file 'menu.txt',
     * (2) print the menu to the user and
     * (3) ask the user, "Do you want to 'order' or 'add' to the menu?"
     * <p>
     * If the user says 'add', then ask, "What food would you like to add?" And then ask, "What's the price?"
     * If the price entered isn't a number print, "The price must be a number." and ask again.
     * Repeat those two questions until the user enters 'done' for the food.
     * Then, print out the menu again, save the menu to file 'menu.txt' and end the application.
     * <p>
     * If the user says 'order', then ask, "What food would you like?"
     * If the food entered is not on the menu print, "Sorry, we don't have "+food.
     * Repeat that question until the user enters 'done' for the food.
     * Print the user's total price of the order and end the application.
     * <p>
     * The following hints are optional, but may help you get started on the right track.
     * Hint 1: You can use a Scanner to read from your file and a PrintWriter to save to your file, both of which
     * you can find examples of from class.
     * Hint 2: Think ahead about how to format your file to make reading from file easier. One solution is to
     * format each menu item on a new line and separate the menu item and corresponding price with a comma. For
     * example:
     * burger,1.5
     * fries,2.0
     * Hint 3: If you separate each item on a new line, you can use Scanner's nextLine() to read them into a String.
     * Hint 4: If you separate each item and corresponding price with a comma, you can split the line String using
     * String[] split = line.split(","), which would make split[0] the food name and split[1] the price.
     * <p>
     * Here's an example of running the application for the first time:
     * --- Menu ---
     * <p>
     * Do you want to 'order' or 'add' to the menu? add
     * What food would you like to add? burger
     * What's the price? 1.5
     * What food would you like to add? fries
     * What's the price? a
     * The price must be a number.
     * What's the price? 2
     * What food would you like to add? done
     * --- Menu ---
     * $1.50	burger
     * $2.00	fries
     * <p>
     * Here's an example of running the application another time:
     * --- Menu ---
     * $1.50	burger
     * $2.00	fries
     * <p>
     * Do you want to 'order' or 'add' to the menu? order
     * What food would you like? burger
     * What food would you like? yogurt
     * Sorry, we don't have yogurt
     * What food would you like? fries
     * What food would you like? done
     * Your total is $3.50
     */
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Double> menu = new HashMap<>();

//     * (1) load the menu from file 'menu.txt',
        File menuFile = new File(
                "src\\main\\edu\\dmacc\\dsmcode\\coma510\\review\\menu.txt");
        getMenuFromFile(menu, menuFile);

//     * (2) print the menu to the user and
        printMenu(menu);

//     * (3) ask the user, "Do you want to 'order' or 'add' to the menu?"
        System.out.print("Do you want to 'order' or 'add' to the menu? ");
        Scanner userInput = new Scanner(System.in);
        String operation = userInput.nextLine();

        if ("order".equals(operation)) {
            askUserForOrderAndTotal(menu, userInput);
        } else if ("add".equals(operation)) {
            getFoodAndPricesToAdd(menu, userInput);
            saveMenuToFile(menu, menuFile);
        } else {
            System.out.println("Wrong! Must be 'order' or 'add'! ;-)");
        }
    }

    private static void saveMenuToFile(HashMap<String, Double> menu, File menuFile) throws FileNotFoundException {
        PrintWriter fileWriter = new PrintWriter(menuFile);
        try {
            for (String food : menu.keySet()) {
                fileWriter.printf("%s,%.2f\n", food, menu.get(food));
            }
        } finally {
            fileWriter.close();
        }
    }

    private static void getFoodAndPricesToAdd(HashMap<String, Double> menu, Scanner userInput) {
        //            What food would you like to add? burger
//            What's the price? 1.5
        String food = getFoodToAdd(userInput);
        while(!"done".equals(food)) {
            System.out.print("What's the price? ");
            double price = userInput.nextDouble();
            menu.put(food, price);

            food = getFoodToAdd(userInput);
        }
    }

    private static String getFoodToAdd(Scanner userInput) {
        System.out.print("What food would you like to add? ");
        return userInput.next();
    }

    private static void askUserForOrderAndTotal(HashMap<String, Double> menu, Scanner userInput) {
        String food = takeOrder(userInput);
        double total = 0;
        while (!"done".equals(food)) {
            if(menu.containsKey(food)) {
                total += menu.get(food);
            } else {
                System.out.println("Nope!");
            }
            food = takeOrder(userInput);
        }
        System.out.println("Your total is " + String.format("$%.2f", total));
    }

    private static String takeOrder(Scanner userInput) {
        System.out.print("What food would you like? ");
        return userInput.nextLine();
    }

    private static void printMenu(HashMap<String, Double> menu) {
        System.out.println("--- Menu ---");
        for (String food : menu.keySet()) {
            Double price = menu.get(food);
            System.out.println(String.format("$%.2f", price) + "  " + food);
//            System.out.printf("$%.2f  %s\n", price, food);//Same thing as println
        }
    }

    private static void getMenuFromFile(HashMap<String, Double> menu, File menuFile) throws FileNotFoundException {
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
}
