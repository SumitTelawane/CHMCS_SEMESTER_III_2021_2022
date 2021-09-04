import java.io.*;
import java.util.*;

public class P5_Q2_Primes_ST {
    public static void main(String[] args) {
        try {
            P5_Q2_PrimeThread_ST pt = null;
            System.out.print("Enter a number > ");
            Scanner scan = new Scanner(System.in);
            int limit = scan.nextInt();
            System.out.print("Enter a file name to store the result > ");
            String fName = scan.next();

            if (fName.length() > 0)
                pt = new P5_Q2_PrimeThread_ST (limit, new FileOutputStream(fName));
            else
                pt = new P5_Q2_PrimeThread_ST(limit);
            pt.run();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
