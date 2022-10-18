import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int lineSeparatorEvery = 100;

    public static void main(String[] args) {

        System.out.println("Hi, I can list the prime numbers");

        //Wersja podstawowa - sprawdza każdą liczbę czy podzielna jest przez wszystkie mniejsze od siebie.
        //nie przerywa jeżeli tak.
        int firstNumberFromUser = readIntFromUser();
        System.out.print("1 ");
        for (int i = 2; i <= firstNumberFromUser; i++) {
            boolean isItDevidable = false;
            //odstęp dla czytelności dużej ilości liczb
            LineSeparator(lineSeparatorEvery, i);
            for (int j = 2; j <= i; j++) {
                if ((i % j) == 0 && i != j) {
                    isItDevidable = true;
                }
                if (!isItDevidable) {
                    if (i == j) {
                        System.out.print(j + " ");
                    }
                }
            }
        }

        //druga i trzecia wersja nie planowana ale przyszła mi do głowy wczoraj wieczorem więc jest.
        //druga wersja - mniej kodu i szybsza? - break jeżeli podzielne przez liczbę.
        System.out.println();
        int secondNumberFromUser = readIntFromUser();
        System.out.print("1 ");
        for (int i = 2; i <= secondNumberFromUser; i++) {
            LineSeparator(lineSeparatorEvery, i);
            for (int j = 2; j <= i; j++) {
                if ((i % j) == 0 && i != j) {
                    break;
                }
                if (i == j) {
                    System.out.print(j + " ");
                }
            }
        }

        //trecia wersja - optymalizacja dla bardzo dużych liczb (sprawdzanie do połowy liczby).
        //początkowo myślałem że będzie dużo więcej kodu na ta optymalizacje ;)
        System.out.println();
        int thirdNumberFromUser = readIntFromUser();
        System.out.print("1 ");
        for (int i = 2; i <= thirdNumberFromUser; i++) {
            LineSeparator(lineSeparatorEvery, i);
            for (int j = 2; j <= i; j++) {
                if ((i % j) == 0 && i != j) {
                    break;
                }
                if (i < (2 * j)) {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }

    private static void LineSeparator(int separator, int number) {
        if (number % separator == 0) {
            System.out.println();
        }
    }

    private static int readIntFromUser() {
        boolean isInputInt;
        String line;
        int inputInt = 0;
        do {
            System.out.println("Please enter a positive number");
            line = SCANNER.nextLine();
            try {
                inputInt = Integer.parseInt(line);
                isInputInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter only Integer Value");
                isInputInt = false;
                //reset chyba jest niepotrzebny gdy skanuje całą linię.
                SCANNER.reset();
            }
        } while (!isInputInt);

        return ((inputInt > 0) ? inputInt : readIntFromUser());

    }
}