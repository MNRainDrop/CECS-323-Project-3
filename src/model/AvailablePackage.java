package model;

public class AvailablePackage 
{
    private static float cost;

    public static float getCost() 
    {
        return cost;
    }

    public void setCost(float cost) 
    {
        AvailablePackage.cost = cost;
    }
}
