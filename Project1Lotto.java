package ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Διαβάζει από ένα αρχείο αριθμούς, παράγει όλες τις δυνατές 6άδες,
 * και αποθηκεύει σε ένα άλλο αρχείο τους συνδυασμούς που πληρούν τα εξής κριτήρια:
 * - περιέχουν το πολύ 4 άρτιους
 * - περιέχουν το πολύ 4 περιττούς
 * - περιέχουν το πολύ 2 συνεχόμενους
 * - περιέχουν το πολύ 3 ίδιους λήγοντες
 * - περιέχουν το πολύ 3 αριθμούς στην ίδια δεκάδα
 */
public class Project1Lotto {

    public static void main(String[] args) throws FileNotFoundException {
        final int N = 6;
        File inFile = new File("C:/Users/30698/Desktop/lottoProjectIn.txt");
        File outFile = new File("C:/Users/30698/Desktop/lottoProjectOut.txt");
        Scanner in = new Scanner(inFile);
        PrintStream ps = new PrintStream(outFile);
        int[] row = new int[6];
        ArrayList<Integer> numbers = new ArrayList<>();

        while (in.hasNext()) {
            numbers.add(in.nextInt());
            Collections.sort(numbers);
        }

        for (int i = 0; i <= numbers.size() - N; i++) {
            for (int j = i + 1; j <= numbers.size() - N + 1; j++) {
                for (int k = j + 1; k <= numbers.size() - N + 2; k++) {
                    for (int m = k + 1; m <= numbers.size() - N + 3; m++) {
                        for (int p = m + 1; p <= numbers.size() - N + 4; p++) {
                            for (int v =  p + 1; v < numbers.size(); v++) {
                                row[0] = numbers.get(i);
                                row[1] = numbers.get(j);
                                row[2] = numbers.get(k);
                                row[3] = numbers.get(m);
                                row[4] = numbers.get(p);
                                row[5] = numbers.get(v);

                                if (isEven(row) && isOdd(row) && isContiguous(row)
                                        && isSameEnding(row) && isSameTen(row)) {
                                    ps.printf("%d\t%d\t%d\t%d\t%d\t%d\t\n", row[0], row[1],
                                            row[2], row[3], row[4], row[5]);
                                    System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t\n", row[0], row[1],
                                            row[2], row[3], row[4], row[5]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isEven(int[] row) {
        boolean isEven = false;
        int evens = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 == 0) {
                evens += 1;
            }
        }
        if (evens <= 4) {
            isEven = true;
        }
        return isEven;
    }

    public static boolean isOdd(int[] row) {
        boolean isOdd = false;
        int odds = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 != 0) {
                odds += 1;
            }
        }
        if (odds <= 4) {
            isOdd = true;
        }
        return isOdd;
    }

    public static boolean isContiguous(int[] row) {
        boolean isContiguous = false;
        int maxContiguous = 0;
        int numsContiguous = 1;
        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] == row[j]) {
                    numsContiguous += 1;
                }
            }
            if (numsContiguous > maxContiguous) {
                maxContiguous = numsContiguous;
            }
            numsContiguous = 1;
        }
        if (maxContiguous == 2) {
            isContiguous = true;
        }
        return isContiguous;
    }

    public static boolean isSameEnding(int[] row) {
        boolean isSame = false;
        if (row[2] != row[3]) {
            isSame = true;
        }
        return isSame;
    }

    public static boolean isSameTen(int[] row) {
        boolean isTen = false;
        int firstTen = 0;
        int secondTen = 0;
        int thirdTen = 0;
        int fourthTen = 0;
        int fifthTen = 0;
        for (int i = 0; i < row.length; i++) {
            if ((row[i] >= 1) && (row[i] <=10)) {
                firstTen += 1;
            } else if ((row[i] > 11) && (row[i] <=20)) {
                secondTen += 1;
            } else if ((row[i] > 21) && (row[i] <=30)) {
                thirdTen += 1;
            } else if ((row[i] > 31) && (row[i] <=40)) {
                fourthTen += 1;
            } else if ((row[i] > 41) && (row[i] <=49)) {
                fifthTen += 1;
            }
        }
        if ((firstTen <= 3) && (secondTen <= 3) && (thirdTen <= 3) &&
                (fourthTen <= 3) && (fifthTen <= 3)) {
            isTen = true;
        }
        return isTen;
    }
}
