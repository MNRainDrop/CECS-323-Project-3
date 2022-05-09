import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;
import model.Package;
public class App 
{
    private static void test()
    {
        System.out.println("\n\nStart Program");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();
        
        inserts(em);

        System.out.println("\n\ndone");
        System.exit(0);
    }

    //Does all the inserts from the Doc
    private static void inserts(EntityManager em)
    {
        //Features
        em.getTransaction().begin();
        System.out.println("\nInserting Features");

        ArrayList<Feature> featurelist = new ArrayList<>(); 
        featurelist.add(new Feature("leather seats"));
        featurelist.add(new Feature("plug-in hybrid engine"));
        featurelist.add(new Feature("power sliding doors"));
        featurelist.add(new Feature("Amazon FireTV"));
        featurelist.add(new Feature("rear-seat entertainment screens"));
        featurelist.add(new Feature("all-wheel drive"));
        featurelist.add(new Feature("adaptive cruise control"));
        for(Feature feature : featurelist)
        {
            em.persist(feature);
        }
        em.getTransaction().commit();
        
        //Packages
        em.getTransaction().begin();
        System.out.println("\nInserting Packages");

        ArrayList<Package> packagelist = new ArrayList<>(); 
        packagelist.add(new Package("Theater Package"));
        packagelist.add(new Package("Amazon Theater Package"));
        packagelist.add(new Package("Safety Package"));
        for(Package pack : packagelist)
        {
            em.persist(pack);
        }
        em.getTransaction().commit();

        //PackageFeatures
        em.getTransaction().begin();
        System.out.println("\nInserting PackageFeatures");

        ArrayList<PackageFeatures> packagefeaturelist = new ArrayList<>(); 
        //reference the packge and features from the previous lists
        packagefeaturelist.add(new PackageFeatures(packagelist.get(0), featurelist.get(4)));
        packagefeaturelist.add(new PackageFeatures(packagelist.get(1), featurelist.get(4)));
        packagefeaturelist.add(new PackageFeatures(packagelist.get(1), featurelist.get(3)));
        packagefeaturelist.add(new PackageFeatures(packagelist.get(2), featurelist.get(6)));
        for(PackageFeatures pack : packagefeaturelist)
        {
            em.persist(pack);
        }
        em.getTransaction().commit();

        //Models
        em.getTransaction().begin();
        System.out.println("\nInserting Models");

        ArrayList<Model> modellist = new ArrayList<>(); 
        modellist.add(new Model("Pacifica", 2022));
        modellist.add(new Model("Pacifica Hybrid", 2022));
        modellist.add(new Model("Pacifica Hybrid", 2021));
        for(Model model : modellist)
        {
            em.persist(model);
        }
        em.getTransaction().commit();

        //ModelFeatures
        em.getTransaction().begin();
        System.out.println("\nInserting ModelFeatures");

        ArrayList<ModelFeatures> modelfeaturelist = new ArrayList<>(); 
        //reference the packge and features from the previous lists
        modelfeaturelist.add(new ModelFeatures(modellist.get(0), featurelist.get(2)));
        modelfeaturelist.add(new ModelFeatures(modellist.get(1), featurelist.get(2)));
        modelfeaturelist.add(new ModelFeatures(modellist.get(1), featurelist.get(1)));
        modelfeaturelist.add(new ModelFeatures(modellist.get(2), featurelist.get(2)));
        modelfeaturelist.add(new ModelFeatures(modellist.get(2), featurelist.get(1)));
        for(ModelFeatures model : modelfeaturelist)
        {
            em.persist(model);
        }
        em.getTransaction().commit();

        //Trims
        em.getTransaction().begin();
        System.out.println("\nInserting Trims");

        ArrayList<Trim> trimlist = new ArrayList<>(); 
        trimlist.add(new Trim("Touring", 30000, modellist.get(0)));
        trimlist.add(new Trim("Limited", 34000, modellist.get(0)));
        trimlist.add(new Trim("Pinnacle", 42000, modellist.get(0)));
        trimlist.add(new Trim("Touring", 43000, modellist.get(1)));
        trimlist.add(new Trim("Limited", 48000, modellist.get(1)));
        trimlist.add(new Trim("Pinnacle", 54000, modellist.get(1)));
        trimlist.add(new Trim("Touring", 41000, modellist.get(2)));
        trimlist.add(new Trim("Limited", 46000, modellist.get(2)));
        trimlist.add(new Trim("Pinnacle", 52000, modellist.get(2)));
        for(Trim trim : trimlist)
        {
            em.persist(trim);
        }
        em.getTransaction().commit();
    }

    public static void main(String[] args) throws Exception 
    {
        test();
    }
}
