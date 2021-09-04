public class P7_Q1_CircularBuffer_ST implements 
P7_Q1_Buffer_ST
{
 

private final int[] buffer = {-1, -1, -1}; //shared buffer

private int occupiedCells = 0; //count number of buffers used 
private int writeIndex = 0; //index of next element to write tp 
private int readIndex = 0; //index of next element to read
public synchronized void set(int value) throws InterruptedException

{

while(occupiedCells == buffer.length)

{

System.out.println("Buffer is full. Producer waits."); 
wait();
}

buffer[writeIndex] = value;

writeIndex = (writeIndex + 1) % buffer.length;

++occupiedCells; 
displayState("Producer write" +value); 
notifyAll();
}//set() ends

public synchronized int get() throws InterruptedException

{

while(occupiedCells == 0)

{

System.out.println("Buffer is empty. Consumer waits."); 
wait();
}
 

int readValue = buffer[readIndex]; 
readIndex = (readIndex + 1) % buffer.length;
--occupiedCells;

displayState("Consumer reads" + readValue); 
notifyAll();
return readValue;

}//get() ends

public void displayState(String operation)

{

System.out.printf("%s%s%d)\n%S", operation,"(buffer cells occupied:", occupiedCells, "buffer cells:");
for(int value: buffer) 
System.out.printf(" %2d ", value); 
System.out.print("\n ");
for(int i=0; i<buffer.length; i++) 
System.out.print("	");
System.out.print("\n   "); 
for(int i=0; i<buffer.length; i++)
{

if(i==writeIndex && i==readIndex) 
System.out.print(" WR");
else if(i==writeIndex) 
System.out.print(" W");
else if(i==readIndex)
 

System.out.print(" R"); else
System.out.print(" ");

}

System.out.println("\n");

}//displayState() ends

}//CircularBuffer class end
