import java.rmi.*;
import java.rmi.server.*;

public class P4_RMI_CalcServerImpl_ST extends UnicastRemoteObject implements P4_RMI_CalcServerIntf_ST {
	public P4_RMI_CalcServerImpl_ST() throws RemoteException {
	}
	public int add(int a, int b) throws RemoteException {
		return a+b;
	}
	public int subtract(int a, int b) throws RemoteException {
		return a-b;
	}
	public int mutliply(int a, int b) throws RemoteException {
		return a*b;
	}
	public int divide(int a, int b) throws RemoteException {
		return a/b;
	}
}
