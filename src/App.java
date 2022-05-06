import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;
public class App 
{
    private static void test()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();
        
        System.out.println("\n\ndone");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception 
    {
        test();
    }
}
