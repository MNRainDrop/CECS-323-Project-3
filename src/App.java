import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;
public class App {
    private static void test(){
        System.out.println("Hello World");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();
        System.out.println("done");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
