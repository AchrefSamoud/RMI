import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {

    String sayHello()throws RemoteException;
     //String MAJ(String a)throws  RemoteException;
    // void palindrome(String ch) throws  RemoteException;
    double lireSolde() throws RemoteException;
    void debiter(int montant) throws RemoteException;
    void crediter(int montant) throws RemoteException;

}
