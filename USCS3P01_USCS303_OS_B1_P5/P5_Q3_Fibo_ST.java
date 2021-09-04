import java.util.ArrayList;
import java.util.Scanner;

public class P5_Q3_Fibo_ST {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList al = new ArrayList();
        int a=scan.nextInt();;
        System.out.println("Enter the number: ");
        P5_Q3_FiboThread_ST fibTh = new P5_Q3_FiboThread_ST(a);
        fibTh.start();
        try {
            fibTh.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        int fseries[] = fibTh.arr;
        System.out.println("First " + a + "fibonacci numbers are: ");
        for (int i=0; i<a; i++){
            System.out.print(fseries[i] + " ");
        }
    } // main ends
}

class P5_Q3_FiboThread_ST extends Thread {
    private int a, i;
    Thread t;
    int arr[];

    public P5_Q3_FiboThread_ST(int a) {
        this.a = a;
        arr = new int[a];
    }

    public void run() {
        arr[0] = 0;
        arr[1] = 1;
        for (i=2; i<a; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
    } // run ends
}
