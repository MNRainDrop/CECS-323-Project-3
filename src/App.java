import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import jakarta.persistence.*;
import model.*;
import model.Package;
public class App 
{
    
    public static void main(String[] args) throws Exception 
    {
        test();

    }

    private static void test()
    {
        System.out.println("\n\nStart Program");

        inserts();
        //pricetest();
        featuretest();

        System.out.println("\ndone");
        System.exit(0);
    }

    private static void featuretest() {
        //Instantiate Entity Manager Factory and Entity Manager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();

        System.out.println("Get Features Per Automobile\n");
        var auto = em.createQuery("select a from automobiles a", Automobile.class).getResultList();
        for (Automobile a : auto) 
        {
            System.out.println("\n" + a.getVin() + " : ");
            Set<Feature> features = a.getFeatures();
            for(Feature f : features)
            {
                System.out.print("" + f.getName() + ", ");
            }
        }
    }

    private static void pricetest()
    {
        //Instantiate Entity Manager Factory and Entity Manager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();

        System.out.println("Get Sticker Price Per Automobile\n");
        var auto = em.createQuery("select a from automobiles a", Automobile.class).getResultList();
        for (Automobile a : auto) 
        {
            System.out.println(a.getVin() + " : $" + a.stickerPrice());
        }
    }

    //Does all the inserts from the Document
    private static void inserts()
    {
        //Instantiate Entity Manager Factory and Entity Manager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobilesDB");
        EntityManager em = factory.createEntityManager();

        System.out.println("\nInserting all data\n");
        //Features
        em.getTransaction().begin();
        System.out.println("Inserting Features");

        ArrayList<Feature> featurelist = new ArrayList<>(); 
        featurelist.add(new Feature("leather seats"));
        featurelist.add(new Feature("plug-in hybrid engine"));
        featurelist.add(new Feature("power sliding doors"));
        featurelist.add(new Feature("hands-free sliding doors"));
        featurelist.add(new Feature("Amazon FireTV"));
        featurelist.add(new Feature("rear-seat entertainment screens"));
        featurelist.add(new Feature("all-wheel drive"));
        featurelist.add(new Feature("adaptive cruise control"));
        for(Feature feature : featurelist)
        {
            em.persist(feature);
            em.getTransaction().commit();
            em.getTransaction().begin();
        }
        
        //Packages
        System.out.println("Inserting Packages");

        ArrayList<Package> packagelist = new ArrayList<>(); 
        packagelist.add(new Package("Theater Package"));
        packagelist.add(new Package("Amazon Theater Package"));
        packagelist.add(new Package("Safety Package"));
        for(Package pack : packagelist)
        {
            em.persist(pack);
            em.getTransaction().commit();
            em.getTransaction().begin();
        }

        //PackageFeatures
        System.out.println("Inserting PackageFeatures");
        packagelist.get(0).addPackagefeatures(featurelist.get(5));
        packagelist.get(1).addPackagefeatures(featurelist.get(5));
        packagelist.get(1).addPackagefeatures(featurelist.get(4));
        packagelist.get(2).addPackagefeatures(featurelist.get(7));


        //Models
        System.out.println("Inserting Models");

        ArrayList<Model> modellist = new ArrayList<>(); 
        modellist.add(new Model("Pacifica", 2022));
        modellist.add(new Model("Pacifica Hybrid", 2022));
        modellist.add(new Model("Pacifica Hybrid", 2021));
        for(Model model : modellist)
        {
            em.persist(model);
            em.getTransaction().commit();
            em.getTransaction().begin();
        }

        //ModelFeatures
        System.out.println("Inserting ModelFeatures");

        modellist.get(0).addModelfeatures(featurelist.get(2));
        modellist.get(1).addModelfeatures(featurelist.get(2));
        modellist.get(1).addModelfeatures(featurelist.get(1));
        modellist.get(2).addModelfeatures(featurelist.get(2));
        modellist.get(2).addModelfeatures(featurelist.get(1));

        //Trims
        System.out.println("Inserting Trims");

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
            em.getTransaction().commit();
            em.getTransaction().begin();
        }

        //TrimFeatures
        System.out.println("Inserting TrimFeatures");
        trimlist.get(1).addTrimfeatures(featurelist.get(0));
        trimlist.get(1).addTrimfeatures(featurelist.get(3));
        trimlist.get(2).addTrimfeatures(featurelist.get(0));
        trimlist.get(2).addTrimfeatures(featurelist.get(3));
        trimlist.get(2).addTrimfeatures(featurelist.get(5));
        trimlist.get(2).addTrimfeatures(featurelist.get(4));
        trimlist.get(2).addTrimfeatures(featurelist.get(6));
        trimlist.get(4).addTrimfeatures(featurelist.get(0));
        trimlist.get(4).addTrimfeatures(featurelist.get(3));
        trimlist.get(5).addTrimfeatures(featurelist.get(0));
        trimlist.get(5).addTrimfeatures(featurelist.get(3));
        trimlist.get(5).addTrimfeatures(featurelist.get(5));
        trimlist.get(5).addTrimfeatures(featurelist.get(4));
        trimlist.get(7).addTrimfeatures(featurelist.get(0));
        trimlist.get(7).addTrimfeatures(featurelist.get(3));
        trimlist.get(8).addTrimfeatures(featurelist.get(0));
        trimlist.get(8).addTrimfeatures(featurelist.get(3));
        trimlist.get(8).addTrimfeatures(featurelist.get(5));
        trimlist.get(8).addTrimfeatures(featurelist.get(7));

        //Available Packages
        System.out.println("Inserting AvailablePackages");

        ArrayList<AvailablePackage> availablePackage = new ArrayList<>(); 
        availablePackage.add(new AvailablePackage(3000, trimlist.get(0), packagelist.get(2)));
        availablePackage.add(new AvailablePackage(2500, trimlist.get(1), packagelist.get(1)));
        availablePackage.add(new AvailablePackage(2500, trimlist.get(4), packagelist.get(1)));
        availablePackage.add(new AvailablePackage(3000, trimlist.get(6), packagelist.get(2)));
        availablePackage.add(new AvailablePackage(2500, trimlist.get(7), packagelist.get(0)));
        availablePackage.add(new AvailablePackage(2000, trimlist.get(7), packagelist.get(2)));
        for(AvailablePackage packs : availablePackage)
        {
            em.persist(packs);
            em.getTransaction().commit();
            em.getTransaction().begin();
        }

        //Automobiles
        System.out.println("Inserting Automobiles");

        ArrayList<Automobile> autolist = new ArrayList<>();
        autolist.add(new Automobile("12345abcde", trimlist.get(1)));
        autolist.add(new Automobile("67890abcde", trimlist.get(5)));
        autolist.add(new Automobile("99999aaaaa", trimlist.get(8)));
        autolist.add(new Automobile("aaaaa88888", trimlist.get(6)));
        autolist.add(new Automobile("bbbbb77777", trimlist.get(7)));
        for(Automobile auto : autolist)
        {
            em.persist(auto);
            em.getTransaction().commit();
            em.getTransaction().begin();
        }

        //ChosenPackages
        System.out.println("Inserting ChosenPackages");
        autolist.get(0).addChosenpackages(availablePackage.get(1));
        autolist.get(3).addChosenpackages(availablePackage.get(3));
        autolist.get(4).addChosenpackages(availablePackage.get(4));
        autolist.get(4).addChosenpackages(availablePackage.get(5));
        em.getTransaction().commit();

        System.out.println("\nInserts Finished\n");
    }

}
