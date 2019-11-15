package edu.dmacc.dsmcode.coma510.review;

public class QuizReview {

    public static void main(String[] args) {
        // For questions 1-4, answer true if the corresponding output would be printed, otherwise false.
        try {
            badMethod();
            System.out.println("Question 1 Output");
        } catch(Exception e) {
            System.out.println("Question 2 Output");
        } finally {
            System.out.println("Question 3 Output");
        }
        System.out.println("Question 4 Output");
        // 1. Would "Question 1 Output" be printed? false
        // 2. Would "Question 2 Output" be printed? true
        // 3. Would "Question 3 Output" be printed? true
        // 4. Would "Question 4 Output" be printed? true

        // For questions 5-7, answer true if the corresponding output would be printed, otherwise false.
        try {
            badMethod();
            System.out.println("Question 5 Output");
        } finally {
            System.out.println("Question 6 Output");
        }
        System.out.println("Question 7 Output");
        // 5. Would "Question 5 Output" be printed? false
        // 6. Would "Question 6 Output" be printed? true
        // 7. Would "Question 7 Output" be printed? false
    }

    public static void badMethod() {
        throw new RuntimeException("Practice exception");
    }
}
