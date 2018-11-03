/**
 * Dan Matheson
 * 2/9/18
 * This program will serve as the interface for the stock server and stock client to use to implement remote method invocation
 */
import java.rmi.*;
import java.sql.Date;

//Create the interface class and methods
public interface Stock extends Remote{
	public boolean getQuote(String ticker) throws RemoteException;
	public Date getDate() throws RemoteException;
	public double getOpen() throws RemoteException;
	public double getHigh() throws RemoteException;
	public double getLow() throws RemoteException;
	public double getClose() throws RemoteException;
	public double getVolume() throws RemoteException;
}
