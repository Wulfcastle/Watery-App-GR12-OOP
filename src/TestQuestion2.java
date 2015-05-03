
import java.util.Scanner;

public class TestQuestion2 {

    public static void main(String args[]) throws Exception {
        String accountNumber = "AC-23245";
        int members = 4;
        double usageLimit = 400;
        int[] arrWaterUse = {481, 438, 454, 353, 421, 396, 432};

        Household house = new Household(accountNumber, members, arrWaterUse);

        Scanner input = new Scanner(System.in);
        char ch = ' ';
        while (ch != 'Q') {
            System.out.println();
            System.out.println("         Menu");
            System.out.println(" ");
            System.out.println("       Option A ");
            System.out.println("       Option B ");
            System.out.println("       Option C ");
            System.out.println(" ");
            System.out.println("       Q - QUIT");
            System.out.println(" ");
            System.out.print("       Your choice? ");

            ch = input.nextLine().toUpperCase().charAt(0);

            switch (ch) {
                case 'A': {
                    System.out.print(house.toString() + "\n");
                    System.out.print("\n" + "Total Water Usage: " + house.calculateTotal() + " litres.");
                    System.out.print("\n" + "Average Water Usage: " + house.calculateAve() + " litres.");
                    break;
                }

                case 'B': {
                    System.out.print("Days and amount of water exceeding the average" + "\n");
                    System.out.print(house.twoDimensionalArraytoString());

                    break;
                }

                case 'C': {
                    System.out.print(house.toString() + "\n" + "\n");
                    System.out.print("The day on which the most water was used : " + house.determineHighestDay() + "\n");
                    if (house.determineHighRisk(usageLimit) == true) {
                        System.out.print("High-Risk Household");
                    } else {
                        System.out.print("Low-Risk Household");
                    }

                    break;
                }
                case 'Q': {
                    System.exit(0);
                } // case

            } // switch

        } // while

    } // main

} // class
