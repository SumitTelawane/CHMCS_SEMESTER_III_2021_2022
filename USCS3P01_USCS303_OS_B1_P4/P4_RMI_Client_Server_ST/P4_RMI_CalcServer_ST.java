import java.net.*;
import java.rmi.*;

public class P4_RMI_CalcServer_ST {
	public static void main(String[] args) {
		try {
			P4_RMI_CalcServerImpl_ST csi = new P4_RMI_CalcServerImpl_ST();
			Naming.rebind("CSB0", csi);
		} // try ends
		catch (Exception e) {
			System.out.println("Exception: " + e );
		} // catch ends
	}
}
