package edu.depaul.csc372marlon.garciamlistviewappfoodtype;

/**
 * Created by marlon on 10/23/2015.
 */
public class GuatemalaRestaurant {

    enum Type {Taco, Coffee, Fish, Pizza, Soda}

    String name;
    Type type;
    String shortDescription;
    String longDescription;

    public GuatemalaRestaurant(String name, Type type, String shortDescription, String longDescription ){

        this.name = name;
        this.type = type;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return name;
    }


    public static int getIconResource(Type type) {
        switch (type) {

            case Taco: return R.drawable.taco;
            case Coffee: return R.drawable.coffee;
            case Fish: return R.drawable.fish;
            case Pizza: return R.drawable.pizza;
            case Soda: return R.drawable.soda;

        }

        return -1;
    }


}
