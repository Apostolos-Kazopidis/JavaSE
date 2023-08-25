import java.rmi.*;

public interface RMIServiceInterface extends Remote {
    int RMIMethod(int a, int b) throws RemoteException;
}
