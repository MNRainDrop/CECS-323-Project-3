package model;

public class Trim 
{
    private String name;
    private static float cost;
    
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public static float getCost() 
    {
        return cost;
    }
    public void setCost(float cost) 
    {
        Trim.cost = cost;
    }
}
