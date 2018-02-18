import java.lang.*;
import java.util.*;
import java.io.*;

public class Combinations {
    public static int getNumCombs(int desired, int[] denoms) {
        return getNumCombsHelper(desired, denoms, 0);
    }

    private static int getNumCombsHelper(int total, int[] denoms, int i) {
        if (total == 0)
            return 1;
        if (total < 0 || i == denoms.length)
            return 0;
        return getNumCombsHelper(total - denoms[i], denoms, i) +
            getNumCombsHelper(total, denoms, i + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("combinations.dat"));

        int n = s.nextInt();
        s.nextLine();

        for (int _n = 0; _n < n; _n++) {
            int desired = s.nextInt();
            int c = s.nextInt();
            int[] denoms = new int[c];

            for (int i = 0; i < c; i++) {
                denoms[i] = s.nextInt();
            }

            System.out.println(getNumCombs(desired, denoms));
        }
    }
}
