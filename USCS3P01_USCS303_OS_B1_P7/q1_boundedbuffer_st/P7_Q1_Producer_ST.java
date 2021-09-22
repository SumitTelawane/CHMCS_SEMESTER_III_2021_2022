import java.util.Random;

public class P7_Q1_Producer_ST implements Runnable

{

private final static Random generator = new Random(); 
private final P7_Q1_Buffer_ST sharedLocation;
public P7_Q1_Producer_ST(P7_Q1_Buffer_ST shared)

{

sharedLocation = shared;

}

public void run()
 

{

for(int count = 1; count<= 10; count++)

{

try
{

	Thread.sleep(generator.nextInt(3000)); 
	sharedLocation.set(count);
	}catch(InterruptedException e){ 
	e.printStackTrace();
}

}

System.out.println("Producer done producing. Terminating Producer");

}//run() ends

}//Producer class ends

