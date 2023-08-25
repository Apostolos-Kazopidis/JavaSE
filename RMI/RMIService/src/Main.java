import java.net.MalformedURLException;
import java.rmi.*;

public class Main {
    public static void main(String[] args) {
        try {
            RMIClass RMIObject = new RMIClass();
            Naming.rebind("RMIService", RMIObject);
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
