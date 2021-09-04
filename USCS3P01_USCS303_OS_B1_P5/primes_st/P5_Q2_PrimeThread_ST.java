import java.io.*;

class P5_Q2_PrimeThread_ST extends Thread {
    private PrintStream pOut = null;
    private int limit = 0;

    // default constructor.does nothing
    public P5_Q2_PrimeThread_ST() {
    }
    
    // constructor to set the number below which to generate primes no
    // output stream is specified, so it outputs to the System.out
    public P5_Q2_PrimeThread_ST(int l) {
        limit = l;
        try {
            pOut = System.out;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // constructor that sets both the number, as above, and specifies an
    // output stream if the specified stream is null, uses System.out
    public P5_Q2_PrimeThread_ST(int l, OutputStream outS) {
        limit = l;
        try {
            if (outS != null){
                pOut = new PrintStream(outS);
            } else {
                pOut = System.out;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // method that performs the work of the thread in this case the
    // generation of prime numbers
    public void run() {
        // compute primes via the seive
        boolean numbers[] = new boolean[limit+1];
        numbers[0] = false;
        numbers[1] = false;
        for (int i=2; i<numbers.length; i++){
            numbers[i] = true;
        }

        for (int i=2; i<numbers.length; i++){
            if (numbers[i]) {
                for (int j=(2*i); j<numbers.length; j+= i){
                    numbers[j] = false;
                } // inner for ends
            }
        }

        for (int i=0; i<numbers.length; i++){
            if(numbers[i])
                pOut.println(i);
        } // for ends
    }
}
