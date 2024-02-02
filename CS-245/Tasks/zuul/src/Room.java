/*
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 */

import java.util.HashMap;

public class Room
{
    HashMap<String,Room> exits = new HashMap<String,Room>();
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    public Room UpExit;
    public Room DownExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description) 
    {
        this.description = description;
        exits.put("north",null);
        exits.put("east",null);
        exits.put("south",null);
        exits.put("west",null);
        exits.put("up",null);
        exits.put("down",null);
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExit(String label, Room room)
    {
        exits.put(label,room);
    }

    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
    public Room getExit(String exit){
        Room room = exits.get(exit);
        return room;
    }

    public String getExitString(){
        String exit = "";
        if(exits.get("north") != null)
            exit += "north";
        if(exits.get("east") != null)
            exit += " east";
        if(exits.get("south") != null)
            exit += " south";
        if(exits.get("west") != null)
            exit += " west";
        if(exits.get("up") != null)
            exit += " up";
        if(exits.get("down") != null)
            exit += " down";
        return exit;
    }

}
