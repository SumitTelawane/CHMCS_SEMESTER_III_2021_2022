import java.util.Date;

public class P4_PC_MP_ST {
	public static void main(String[] args){
	    
	    // procucer and consumer process
	    P4_PC_MP_Channel_ST<Date> mailBox = new P4_PC_MP_MessageQueue_ST<Date>();

	    int i=0;
	    
	    do {
	    	Date message = new Date();
	    	System.out.println("Producer produced - " + (i+1) + " : " + message);
	    	mailBox.send(message);
	    	Date rightNow = mailBox.recieve();
	    	if (rightNow != null)
		    	System.out.println("Producer produced - " + " : " + rightNow);
		    i++;
	    }while(i<10);
	}
}
