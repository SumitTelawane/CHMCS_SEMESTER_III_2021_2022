import java.util.Vector;
public class P4_PC_MP_MessageQueue_ST<E> implements P4_PC_MP_Channel_ST<E> {
    private Vector<E> queue;
 public P4_PC_MP_MessageQueue_ST(){
    	queue = new Vector<E>();
    }
  // This implements a nonblocking send
    public void send(E item){
    	queue.addElement(item);
    } // send() ends
 // This implements a nonblocking recieve
    public E recieve() {
	if(queue.size() == 0)
	    return null;
	else
	    return queue.remove(0);
    }
}
