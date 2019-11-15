package edu.dmacc.dsmcode.coma510.review;

import java.io.File;

public class AssignmentReview {

    /**
     * We're going to create a restaurant application. The user has the choice to either add food items to the menu or
     * order multiple food items and see a total. This is similar to last week's assignment and examples, so use them as
     * reference. Feel free to use the instructor's solution from last week as a starting point.
     *
     * However, this time you must also save the menu to file! When you run the application again, it should re-load
     * the food items and their prices from file. The file will be called 'menu.txt'. If the text file doesn't exist,
     * you can just assume the menu has no items.
     *
     * How the application should operate:
     * When the application starts,
     * (1) load the menu from file 'menu.txt',
     * (2) print the menu to the user and
     * (3) ask the user, "Do you want to 'order' or 'add' to the menu?"
     *
     * If the user says 'add', then ask, "What food would you like to add?" And then ask, "What's the price?"
     * If the price entered isn't a number print, "The price must be a number." and ask again.
     * Repeat those two questions until the user enters 'done' for the food.
     * Then, print out the menu again, save the menu to file 'menu.txt' and end the application.
     *
     * If the user says 'order', then ask, "What food would you like?"
     * If the food entered is not on the menu print, "Sorry, we don't have "+food.
     * Repeat that question until the user enters 'done' for the food.
     * Print the user's total price of the order and end the application.
     *
     * The following hints are optional, but may help you get started on the right track.
     * Hint 1: You can use a Scanner to read from your file and a PrintWriter to save to your file, both of which
     * you can find examples of from class.
     * Hint 2: Think ahead about how to format your file to make reading from file easier. One solution is to
     * format each menu item on a new line and separate the menu item and corresponding price with a comma. For
     * example:
     *         burger,1.5
     *         fries,2.0
     * Hint 3: If you separate each item on a new line, you can use Scanner's nextLine() to read them into a String.
     * Hint 4: If you separate each item and corresponding price with a comma, you can split the line String using
     * String[] split = line.split(","), which would make split[0] the food name and split[1] the price.
     *
     * Here's an example of running the application for the first time:
     * --- Menu ---
     *
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
     *
     * Here's an example of running the application another time:
     * --- Menu ---
     * $1.50	burger
     * $2.00	fries
     *
     * Do you want to 'order' or 'add' to the menu? order
     * What food would you like? burger
     * What food would you like? yogurt
     * Sorry, we don't have yogurt
     * What food would you like? fries
     * What food would you like? done
     * Your total is $3.50
     */
    public static void main(String[] args) {
        //todo: add review assignment(s) from last week
    }
}
