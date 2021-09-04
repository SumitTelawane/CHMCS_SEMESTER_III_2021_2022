import java.rmi.*;

public interface P4_RMI_CalcServerIntf_ST extends Remote {
	int add(int a, int b) throws RemoteException;
	int subtract(int a, int b) throws RemoteException;
	int mutliply(int a, int b) throws RemoteException;
	int divide(int a, int b) throws RemoteException;
} // interface ends
