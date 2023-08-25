import java.rmi.*;
import java.rmi.server.*;

public class RMIClass extends UnicastRemoteObject implements RMIServiceInterface {
    RMIClass() throws RemoteException
    {
    }

    @Override
    public int RMIMethod(int a, int b) throws RemoteException {
        return a+b;
    }
}
