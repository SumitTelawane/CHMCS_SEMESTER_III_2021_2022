class P5_Q1_Summation_ST implements Runnable {
    int upperLimit, sum;
    public P5_Q1_Summation_ST(int upperLimit) {
        this.upperLimit=upperLimit;
    }
    public void run() {
        for (int i=1; i<=upperLimit; i++)
            sum += i;
    }
}

public class P5_Q1_SummationTest_ST {
    public static void main(String[] args) {
        if (args.length <= 0)
            System.out.println("Usage: P5_Q1_Summation_ST <integervalue>");
        else {
            int upp = Integer.parseInt(args[0]);
            if (upp <= 0)
                System.out.println("args[0]: " + args[0] + "must be a positive number");
            else {
                P5_Q1_Summation_ST s = new P5_Q1_Summation_ST(upp);
                Thread t = new Thread(s);
                t.start();
                try {
                    t.join();
                    System.out.println("The sum of first " + upp + "elements is " + (s.sum));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }   // inner else ends
        }   // outer else ends
    }   // main ends
}
