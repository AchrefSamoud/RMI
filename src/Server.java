import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {
double solde=1125.10;
    public Server() throws RemoteException {}

        public String sayHello() {
        return "Bienvenue !!";
    }

    @Override
    public double lireSolde() throws RemoteException {
        return this.solde;
    }

    @Override
    public void debiter(int montant) throws RemoteException {
        if (this.solde>=montant){
        this.solde -= montant;
        System.out.println("montant retirer avec succes il vous reste: "+solde);
        }else System.out.println("solde insuffisant");
    }

    @Override
    public void crediter(int montant) throws RemoteException {
        this.solde += montant;
        System.out.println("vous avez verser "+montant+"dt votre solde total est "+solde+"dt");
    }


    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);

    }
}
