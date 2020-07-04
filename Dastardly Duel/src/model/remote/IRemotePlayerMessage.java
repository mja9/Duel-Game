package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemotePlayerMessage extends Remote {
	
	void sendMessage(String id) throws RemoteException;

}
