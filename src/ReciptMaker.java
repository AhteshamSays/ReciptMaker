/**
 * This code, you can used for learning purpose only.
 * If any error and bug will be found in this code
 * fix it and comment for changing and updating
 * this code.
 *
 * Project Name : ReceiptMaker
 * Version :  1.0
 * Author : @AhteshamSays
 */

import java.util.Scanner;

public class ReciptMaker {

    private static Scanner sc = new Scanner(System.in);

    private static String product[] = {"Rice", "Oil  ", "Floar", "Pulse"};
    private static int[] rate = {15,95,20,100};

    private static String product1[] = {"Rice", "Oil", "Floar", "Pulse"};
    private static int[] rate1 = {15,95,20,100};

    private static String[] final_item = new String[100];

    private static int amount, return_amount, pay, total_amount, quantity, select, index_count=0;
    private static int cvv;
    private static String card_number, holder_name, expiry;
    private static String name, address, contact_number, command;
    private static char key;

    public static void main(String args[]){
       System.out.println("\t\t\t Welcome to ABC Retails Pvt. Ltd.");
       sellService();
    }

    /**
     * This method are control all services in program.
     */
    private static void sellService(){
        System.out.print("\n> ");
        command = sc.next();
        if (command.equalsIgnoreCase("oil")) {
            for (int i = 1; i<=product.length; i++){
                System.out.println(i + "  " + product[i-1] + "  " + rate[i-1]);
            }
            System.out.print("\n Enter product: ");
            select = sc.nextInt();
            System.out.print("\n Enter the quantity: ");
            quantity = sc.nextInt();
            amount = quantity*rate[select-1];
            storingService(product[select-1], quantity, amount);
            sellService();
        } else if (command.equalsIgnoreCase("snack") || command.equalsIgnoreCase("snacks")) {
            for (int i = 1; i<=product1.length;i++) {
                System.out.print(i+".  " + product1[i-1] + "  " + rate1[i-1]);
            }
            System.out.print("\n Enter product: ");
            select = sc.nextInt();
            System.out.print("\n Enter the quantity: ");
            quantity = sc.nextInt();
            amount = quantity*rate[select-1];
            storingService(product[select-1], quantity, amount);
            sellService();
        } else if (command.equalsIgnoreCase("help")){
            System.out.println(" Welcome to ReceiptMaker CLI version, version 1.0(2) - release(x86_64-java-machine)");
            System.out.println(" In this program commands are define a internally. Type \"help\" to see this list");
            System.out.println("oil  \t: This Command for see oil list");
            System.out.println("end  \t: This Command for end program");
            sellService();
        } else if (command.equalsIgnoreCase("end")){
            getReceipt();
        } else {
            System.out.println(command + " : \t command not found");
            sellService();
        }
    }


    private static void storingService(String product, int quantity, int total){
        String st;
        st = " " + product + "\t\t\t\t" + quantity + "\t\t\t" + total;
        final_item[index_count] = st;
        index_count++;
    }

    /**
     * This method responsible for collecting payment in this program
     */
    private static void getPayment(){
        System.out.println("Which payment method do you want to use: ");
        System.out.println(" 1. Cash \t\t 2. Card");
        System.out.print("> ");
        select = sc.nextInt();
        if (select == 1) {
            System.out.println("Enter the receiving amount: ");
            pay = sc.nextInt();
            if (pay>total_amount){
                return_amount = pay - total_amount;
            }
        } else if (select == 2) {
            card();
        } else {
            System.out.println("Invalid payment method.");
            getPayment();
        }
    }

    /**
     * This method used for all Card mode transaction.
     */
    private static void card(){
        System.out.print("\n Enter you card number: ");
        card_number = sc.next();
        int card_length = card_number.length();
        for(int i=0; i<card_length;i++){
            char ch = card_number.charAt(i);
            if (Character.isLetter(ch)){
                System.out.println("Please, enter a valid card number");
                card();
            }
        }
        if (card_length == 16) {
            System.out.print("\n Enter expiry of your card(E.g. 01/22): ");
            expiry = sc.next();
            System.out.print("\n Enter CVV of your card: ");
            cvv = sc.nextInt();
            System.out.print("\n Enter card holder name: ");
            holder_name = sc.next();
        } else {
            System.out.println("Please, enter a valid card number");
            card();
        }
    }

    /**
     * This method responsible for printing the receipt you customer purchases.
     */
    private static void getReceipt(){
        System.out.print("\n Do you want to print receit(Y/N)");
        key = sc.next().charAt(0);
        if (key == 'Y' || key == 'y') {
            System.out.print("\nSr.\t Product name \t Quanity \t Total\n\n");
            for (int i=1; i<=index_count; i++) {
                System.out.println(i+ ". " + final_item[i-1]);
            }
        } else {
            System.out.print("\n Thank you for shopping.");
            System.out.print("\n Your total amount is " + total_amount);

        }
    }
}
