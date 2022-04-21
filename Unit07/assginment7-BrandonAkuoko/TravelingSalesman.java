import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import graphs.WAdjacencyGraph;
import graphs.WGraph;

public class TravelingSalesman {
    /**
     * 
     * The answer to number 5 is because he chooses the fastest path not the closest path
     */

    public static void main(String[] args) throws IOException, NullPointerException{
        List<City> cities = returnList("52cities.csv");
        WGraph<City> cityGraph = returnGraph(cities);
        connectCities(cities, cityGraph);

        
        boolean Quit = false;
        Scanner scanner = new Scanner(System.in);
        
        while(Quit == false){
            
            City o = null; // origin city
            City d = null; // destination city

            System.out.print("Enter origin city: ");
            String origin = scanner.nextLine(); // "Buckhead, GA"
            System.out.print("Enter destination city: ");
            String dest = scanner.nextLine(); // "Kempton, IN"
            if(origin.equals("") || dest.equals("")){System.out.println("Goodbye"); break;}

            boolean found = false;
            for(City c : cities){if(c.toString().equals(origin)){o = c; found = true;}}
            if(!found){System.out.println(origin + " not found. Try again!");}
            boolean found2 = false;
            for(City k : cities){if(k.toString().equals(dest)){d = k; found2 = true;}}
            if(!found2){System.out.println(dest + " not found. Try again!");}

            // if(cityGraph.nearestNeighbors(o, d) == null){continue;} not needed
            System.out.println(cityGraph.nearestNeighbors(o, d));
        }
    }
    public static List<City> returnList(String filename) throws NullPointerException, IOException{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        List<City> cities = new LinkedList<>();
        
        br.readLine(); // skips header [State, Name, Coords]
        String line;
        int count = 0;
        while((line = br.readLine()) != null){
            String [] tokens = line.split(",");
            String name = tokens[0];
            String state = tokens[1];
            double lat = Double.parseDouble(tokens[2]);
            double lng = Double.parseDouble(tokens[3]);
            City city = new City(name, state, lat, lng);
            cities.add(city);
            count++;
        }
        return cities;
    }
    public static WGraph<City> returnGraph(List<City> cities){
        WGraph<City> cityGraph = new WAdjacencyGraph<>();
        for(City c : cities){
            cityGraph.add(c);
        }
        return cityGraph;
    }
    public static void connectCities(List<City> cities, WGraph<City> cityGraph){
        for(City x : cities){
            for(City y : cities){
                if(!cityGraph.connected(x, y)){
                    if(x != y){
                        double weight = x.distanceFrom(y);
                        cityGraph.connect(x, y, weight);
                    }
                    
                }
            }
        }
    }
}