package Java2022;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean Status = true;

        ArrayList<String> items = new ArrayList<String>();
        items.add("Red-Hot Spicy Doritos");
        items.add("Cool Ranch Doritos ");
        items.add("Coke");
        items.add("Diet Coke");
        items.add("Pepsi");
        items.add("Five Hour Energy");
        items.add("Sunflower Seeds");
        items.add("Peanuts");
        items.add("Macbook Charger");
        items.add("Dell Charger");

        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(2.99);
        prices.add(2.99);
        prices.add(0.99);
        prices.add(0.99);
        prices.add(0.99);
        prices.add(3.99);
        prices.add(0.99);
        prices.add(0.99);
        prices.add(120.00);
        prices.add(50.00);

        String receipt = "";
        ArrayList<String> useritems = new ArrayList<String>();
        ArrayList<Integer> usercount = new ArrayList<Integer>();
        Scanner userinfo = new Scanner(System.in);
        String info;

        double total;
        double finalT = 0;

        System.out.println("Welcome to COBIS Convenience Store!\n");
        System.out.println("The ten items offered are displayed below: ");
        System.out.println("1 :  Red-Hot Spicy Doritos" +
                "\n2 :  Cool ranch Doritos" +
                "\n3 :  Coke" +
                "\n4 :  Diet Coke" +
                "\n5 :  Pepsi" +
                "\n6 :  Five Hour Energy" +
                "\n7 :  Sunflower seeds" +
                "\n8 :  Peanuts" +
                "\n9 :  Macbook Charger" +
                "\n10 : Dell Charger");
        System.out.println("Enter your name: ");
        while (!(info = userinfo.nextLine()).equalsIgnoreCase("Done")) {

            System.out.println("Enter your snack choices or 'Done' to end order: ");
            total = 0;
            receipt += "\n" + info;

            while (!(info = userinfo.nextLine()).equalsIgnoreCase("Done")) {

                for (String i: items) {
                    if (i.contains(info) || i.equalsIgnoreCase(info)) {
                        total += prices.get(items.indexOf(i));
                        receipt += "\n\t" + info;

                        if (!useritems.contains(info)) {
                            useritems.add(info);
                            usercount.add(1);
                        }
                        else {
                            int d = useritems.indexOf(info);
                            usercount.set(d, usercount.get(d) + 1);
                        }

                        break;
                    }
                }
            }

            receipt += "\n\t\t" + String.format("%.2f", total) + "\n";
            finalT += total;
            System.out.println("\nEnter your name or 'Done' to end: ");
        }

        System.out.println("\nRECEIPT:" + receipt);
        System.out.println("\nINVENTORY SOLD: ");

        for (String a: useritems) {
            System.out.println("\t" + a + " (" + usercount.get(useritems.indexOf(a)) + ")");
        }

        System.out.format("\nGRAND TOTAL: " + String.format("%.2f", finalT));
    }
}
