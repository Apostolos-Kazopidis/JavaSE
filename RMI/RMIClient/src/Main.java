import java.net.*;
import java.rmi.*;

public class Main {
    public static void main(String[] args) {
        try {
            RMIServiceInterface RMIService =
                    (RMIServiceInterface) Naming.lookup("rmi://127.0.0.1/RMIService");

            int sum = RMIService.RMIMethod(1,2);

            System.out.println(sum);

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
