import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class PLANE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PLANE extends Actor
{
    /**
     * Act - do whatever the PLANE wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String name;
    
    private int kecepatan = 3;
    
    public PLANE(){
        GreenfootImage img = this.getImage();
        img.scale(20, 20);
        this.setImage(img);
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void act()
    {
        System.out.println(" -->"+this.getRotation());
        
        int xPos = this.getX();
        int yPos = this.getY();
        
        System.out.print("PLANE " + this.name + " x:" + xPos + " y:" + yPos);
        System.out.println(" -->Menabrak objek " + this.isTouching(PLANE.class));
        
        move(kecepatan);
        
        if (isAtEdge()) {
            turn(180);
        }
        
        if(this.isTouching(PLANE.class)) {
            for (PLANE other : getIntersectingObjects(PLANE.class)) {
                if (other != this && this.getName().startsWith("player") && other.getName().startsWith("player")) {
                    if (this.getName().equals("player1") && other.getName().equals("player2")) {
                        Skull skull = new Skull();
                        getWorld().addObject(skull, getX(), getY());
                        getWorld().removeObject(this);
                        
                        Skull skull2 = new Skull();
                        getWorld().addObject(skull2, other.getX(), other.getY());
                        getWorld().removeObject(other);
                    }
                }
            }
        }
        
        if (this.getName().equals("player1") || this.getName().equals("player2")) {
            checkDistance(0);
        } else if (this.getName().equals("player3") || this.getName().equals("player4")) {
            checkDistance(100);
        }    
    }

    private void checkDistance(int minDistance) {
        for (PLANE other : getWorld().getObjects(PLANE.class)) {
            if (other != this && getDistance(other) < minDistance) {
                turn(180);
            }
        }
    }
    
    private double getDistance(PLANE other) {
        int x1 = getX();
        int y1 = getY();
        int x2 = other.getX();
        int y2 = other.getY();
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
