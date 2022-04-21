import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author Brandon Akuoko
 */
public class City {
    private String name;
    private String state;
    private double latitude;
    private double longitude;


    public City(String name, String state, double latitude, double longitude){
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    

    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public String getName() {return name;}
    public String getState() {return state;}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof City){
            return this.hashCode() == obj.hashCode();
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {return this.name + ", " + this.state;}

    @Override
    public int hashCode() {
        return (int)(latitude *1000 - longitude);
    }

    public double distanceFrom(City city){
        double diff1 = this.latitude - city.latitude;
        double diff2 = this.longitude - city.longitude;

        return Math.sqrt(diff1 * diff1 + diff2 * diff2);
    }

}
