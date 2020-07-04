package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteEnvironmentMessage extends Remote{

	void sendMessage(String id) throws RemoteException;
	
}
