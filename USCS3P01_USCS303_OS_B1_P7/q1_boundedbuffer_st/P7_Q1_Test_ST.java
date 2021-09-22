import java.util.concurrent.*; public class P7_Q1_Test_ST
{

public static void main(String args[])

{

ExecutorService application = Executors.newCachedThreadPool(); 
P7_Q1_CircularBuffer_ST sharedLocation = new P7_Q1_CircularBuffer_ST(); 
sharedLocation.displayState("Initial State");
application.execute(new P7_Q1_Producer_ST(sharedLocation)); 
application.execute(new P7_Q1_Consumer_ST(sharedLocation)); 
application.shutdown();
}

}
