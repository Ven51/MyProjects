package ch7;

import java.util.Scanner;

/**
 * Εφαρμογή που κάνει κρυπτογράφηση ή/και αποκρυπτογράφηση
 * λέξης που περιέχει μόνο γράμματα, κεφαλαία ή μικρά.
 */
public class TaskEncryptDecrypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word;
        int option = 0;

        // Μενού που δίνει επιλογές στον χρήστη
        while (option != 3) {
            System.out.println("Please choose one of the following: 1. Encryption, " +
                    "2. Decryption, 3. Exit (int)");
            option = in.nextInt();

        // Ανάλογα την επιλογή του χρήστη καλεί την κατάλληλη μέθοδο ή κάνει έξοδο.
            if (option <= 0 || option > 3) {
                System.out.println("Invalid option");
            } else if (option == 1) {
                System.out.println("Please insert a word to encrypt:");
                word = in.next();
                in.nextLine();

                if (isWordValid(word)) {
                    wordEncrypt(word);
                    System.out.println();
                } else {
                    System.out.println("Please insert a valid word");
                }

            } else if (option == 2) {
                System.out.println("Please insert a word to decrypt:");
                word = in.next();
                in.nextLine();

                if (isWordValid(word)) {
                    wordDecrypt(word);
                    System.out.println();
                } else {
                    System.out.println("Please insert a valid word");
                }
            } else {
                System.out.println("You have chosen to exit");
            }
        }
    }

    /**
     * Η μέθοδος που ελέγχει αν η λέξη είναι έγκυρη,
     * δηλαδή ότι περιέχει μόνο γράμματα.
     */
    public static boolean isWordValid(String word) {
        boolean isValid = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int asciiConverted = (int) ch;

            if ((asciiConverted >= 97 && asciiConverted <= 122) ||
                    (asciiConverted >= 65 && asciiConverted <= 90)) {
                isValid = true;
            } else { isValid = false;
                break;
            }
        }
        return isValid;

    }

    /**
     * Η μέθοδος που κάνει κρυπτογράφηση της λέξης.
     * Σε περίπτωση που είναι z ή Z δίνει a ή A αντίστοιχα.
     */
    public static void wordEncrypt(String word) {
        char charEncrypted;
        int[] arrEncrypted = new int[word.length()];

        System.out.println("The encrypted word is:");

        for (int i = 0; i < arrEncrypted.length; i++) {
                arrEncrypted[i] = word.charAt(i) + 1;
                if (arrEncrypted[i] == 91) {
                    System.out.print("A");
                    continue;
                } else if (arrEncrypted[i] == 123) {
                    System.out.print("a");
                    continue;
            } else {
                charEncrypted = (char) arrEncrypted[i];
                System.out.print(charEncrypted);
                }
            }

        }

    /**
     * Η μέθοδος που κάνει αποκρυπτογράφηση της λέξης.
     * Σε περίπτωση που είναι a ή A δίνει z ή Z αντίστοιχα.
     */
    public static void wordDecrypt(String word) {
        char charEncrypted;
        int[] arrDecrypted = new int[word.length()];

        System.out.println("The decrypted word is:");

        for (int i = 0; i < arrDecrypted.length; i++) {
            arrDecrypted[i] = word.charAt(i) - 1;
            if (arrDecrypted[i] == 64) {
                System.out.print("Z");
                continue;
            } else if (arrDecrypted[i] == 96) {
                System.out.print("z");
                continue;
            } else {
                charEncrypted = (char) arrDecrypted[i];
                System.out.print(charEncrypted);
            }
        }

    }

}
