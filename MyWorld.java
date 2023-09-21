import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        PLANE player1 = new PLANE();
        this.addObject(player1, 30, 40);
        player1.setName("player1");
        
        PLANE player2 = new PLANE();
        player2.setRotation(180);
        player2.setName("player2");
        this.addObject(player2, 570, 40);
        
        PLANE player3 = new PLANE();
        player3.setRotation(270);
        player3.setName("player3");
        this.addObject(player3, 400, 400);
        
        PLANE player4 = new PLANE();
        player4.setRotation(90);
        player4.setName("player4");
        this.addObject(player4, 300, 30);
    }
}
