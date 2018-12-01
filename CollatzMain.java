package CollatzStuff;

import java.util.ArrayList;
import java.util.Scanner;


public class CollatzMain {

    public static void main(String[] args) {

        CollatzData c = new CollatzData();
    }

}

class CollatzData {

    CollatzData() {
        mainCollatzInterface();
    }


    private void getNumsWithLength(long n) {
        ArrayList<Long> data = new ArrayList<>();
        long i = 1;
        while (i != 1000) {
            System.out.print(i + "\r");
            if (getCollatzString(i).size() - 1 == n) {
                data.add(i);
            }

            i++;
        }
        if (data.size() == 0) {
            i = 0;
            data.add(i);
            System.out.println("There were no numbers with Collatz string of length " + n);
        } else {
            int j;
            for (j = 0; j < data.size(); j++) {
                System.out.println(data.get(j));
            }
        }

    }

    private ArrayList<Long> getCollatzString(long n) {
        ArrayList<Long> collatzString = new ArrayList<>();
        long tempN = n;
        collatzString.add(tempN);
        while (tempN != 1) {
            if (tempN % 2 == 0) {
                tempN = tempN / 2;
                collatzString.add(tempN);
            } else {
                tempN = (tempN * 3) + 1;
                collatzString.add(tempN);
            }
        }
        return collatzString;
    }

    private void mainCollatzInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWelcome to The CollatzData Program");
        System.out.println("Features:");
        System.out.println("To find all Collatz Chains with a given length, press 1.\n\nTo see a range of numbers and their Collatz Chain, press 2.\n");
        System.out.println("To exit, enter 0.");
        long l;
        while (sc.hasNext()) {
            if (sc.hasNextLine() && sc.hasNextLong()) {
                l = sc.nextLong();
                if (l == 0) {
                    System.out.println("\n\nThank you for using CollatzData!");
                    break;
                } else if (l == 1) {
                    numWithLengthInterface();
                    System.out.println("Welcome to The CollatzData Program");
                    System.out.println("Features:");
                    System.out.println("To find all Collatz Chains with a given length, press 1.\n\nTo see a range of numbers and their Collatz Chain, press 2.\n");
                    System.out.println("To exit, enter 0.");
                } else if (l == 2) {

                }
            }else{
            sc.nextLine();
        }
    }

}


    private void numWithLengthInterface()
    {
        System.out.println("To see a list of numbers with a Collatz Chain length, enter the desired length and hit enter.");
        Scanner sc = new Scanner(System.in);
        long l;
        while(sc.hasNext()) {
            if(sc.hasNextLine() && sc.hasNextLong())
            {
                l = sc.nextLong();
                if(l == 0){
                    break;
                }
                System.out.println("Begin list");
                getNumsWithLength(l);
                System.out.println("End list");
            }else {
                sc.nextLine();
            }

        }
    }

}