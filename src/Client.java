import java.rmi.Naming;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        try {
            MyInterface service1 = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            System.out.println(service1.sayHello());
            String entree="";
            while (entree!="0") {

                System.out.println("Choisissez l'opération que vous voulez faire: \n" +
                        "Tapez \"1\" pour consulter votre solde \n"
                        + "Tapez \"2\" pour retirer de l'argent \n"
                        + "Tapez \"3\" pour déposer de l'argent  \n"
                        + "Tapez \"0\" pour quitter ");
                Scanner sc = new Scanner(System.in);
                entree = sc.nextLine();
                switch (entree) {
                    case "1":
                        System.out.println("Votre solde est " + service1.lireSolde());
                        System.out.println("*****************************");
                        System.out.println("*****************************");
                        break;

                    case "2":
                        System.out.println("Donnez le montant a retirer");
                        String val = sc.nextLine();
                        int montant = Integer.parseInt(val);
                        service1.debiter(montant);
                        System.out.println("*****************************");
                        System.out.println("*****************************");
                        break;
                    case "3":
                        System.out.println("Donner la somme d'argent");
                        int somme = sc.nextInt();
                        service1.crediter(somme);
                        System.out.println("*****************************");
                        System.out.println("*****************************");
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Entrée invalide");
                }
            }


          /**  System.out.println(service1.MAJ(ligne));
            System.out.println("donner une chaine");
            String ch=sc.nextLine();
            service1.palindrome(ch);
**/
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }



}}