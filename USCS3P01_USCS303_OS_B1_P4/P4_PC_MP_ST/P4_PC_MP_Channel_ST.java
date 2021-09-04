public interface P4_PC_MP_Channel_ST<E> {
    // Send a message to the channel
    public void send(E item);

    // Receive a message from the channel
    public E recieve();
} // interface ends
