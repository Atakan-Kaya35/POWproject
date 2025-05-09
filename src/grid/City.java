package grid;

import java.util.*;


import entity.mobile.*;
import entity.mobile.physcian.Nurses;
import entity.mobile.physcian.Scooter;
import entity.mobile.physcian.Van;
import entity.stationary.*;

/**
 * Represents a city grid with roads, mobile entities, and stationary entities.
 */
public class City {

    Road[][] roads;
    Mobile[][] mobiles;
    Stationary[][] stationarys;
    ArrayList<Order> orders;
    public ArrayList<ArrayList<Integer>> wholeWay = new ArrayList<ArrayList<Integer>>();
    int width;
    int height;

    private ArrayList <Patients> patientList = new ArrayList<>();
    private ArrayList <Nurses> NurseList = new ArrayList<>();
    private ArrayList <Stationary> stationaryList = new ArrayList<>();
    private ArrayList <Van> vanList = new ArrayList<>();
    private ArrayList <Scooter> scooterList = new ArrayList<>();

    /**
     * Constructs a city grid with the specified width and height.
     * @param width The width of the city grid.
     * @param height The height of the city grid.
     */
    public City(int width, int height){
        this.width = width;
        this.height = height;

        this.orders = new ArrayList<Order>();

        roads = new Road[ width + 1][ height + 1];
        stationarys = new Stationary[ width][ height];

        for (int x = 0; x < width + 1; x++) {
            for (int y = 0; y < height + 1; y++) {
                roads[x][y] = new Road(x,y);
            }    
        }
    }

    /**
     * Finds a mobile entity nearest to the given stationary entity.
     * @param stationary The stationary entity to find the nearest mobile to.
     * @return The coordinates of the nearest mobile entity.
     */
    public int[] findMobile(Stationary stationary){
        boolean control = true;
        int x = stationary.getCoordinates()[0];
        int y = stationary.getCoordinates()[1];
        int distance = 1;
        int[] coord = new int[2];
        while (control && distance<=this.height && distance<=this.width) {
            for (int i = 0; i < distance; i++) {
                if(roads[x+i][y-(distance-i)].getContained() instanceof Nurses){
                    coord[0]=x+i;
                    coord[1]=y-(distance-i);
                    control = false;
                    return coord;
                }
                if(roads[x+i][y+(distance-i)].getContained() instanceof Nurses){
                    coord[0]=x+i;
                    coord[1]=y-(distance-i);
                    control = false;
                    return coord;
                }
                
                if(roads[x-i][y+(distance-i)].getContained() instanceof Nurses){
                    coord[0]=x-i;
                    coord[1]=y+(distance-i);
                    control = false;
                    return coord;
                }
                if(roads[x-i][y-(distance-i)].getContained() instanceof Nurses){
                    coord[0]=x-i;
                    coord[1]=y+(distance-i);
                    control = false;
                    return coord;
                }
            }
        }
        return null;
    }

    /**
     * Finds a mobile entity nearest to the given coordinates.
     * @param coordinates The coordinates to find the nearest mobile to.
     * @return The coordinates of the nearest mobile entity.
     */
    public int[] findMobile(int[] coordinates){
        return this.findMobile(stationarys[coordinates[0]][coordinates[1]]);
    }

    /**
     * Finds the shortest path for a mobile entity to reach a stationary entity.
     * @param mobile The mobile entity.
     * @param stationary The stationary entity.
     * @return The list of roads representing the shortest path.
     */
    public List<Road> findPath(Van mobile, Stationary stationary){
        // Create open and closed lists
        List<Road> open = new ArrayList<>();
        Set<Road> closed = new HashSet<>();

        // Add start Road to open list
        open.add(mobile.getContainedIn());  

        // clarify the end road
        Road endRoad = roads[stationary.getCoordinates()[0]][stationary.getCoordinates()[1]];

        while (!open.isEmpty()) {
            // Get the Road with the lowest f value from open list
            Road current = open.stream().min(Comparator.comparingInt(Road::totalCost)).get();

            // Remove current Road from open list
            open.remove(current);

            // Add current Road to closed list
            closed.add(current);

            // If we reached the end Road, reconstruct and return the path
            if (current == endRoad) {
                List<Road> path = new ArrayList<>();
                Road node = current;
                while (node != null) {
                    path.add(node);

                    // to show the way taken
                    /* int[] a = {0,0};
                    node.setTraffic(a); */
                    node.setWasCrossed(true);


                    node = node.getParent();
                }
                Collections.reverse(path);
                return path;
            }

            // Generate neighboring nodes
            List<Road> neighbors = new ArrayList<>();

            // Generate neighboring nodes based on grid dimensions and obstacles
            int[] currentSCoords = current.getCoords();

            if (currentSCoords[0] + 1 <= this.width && roads[currentSCoords[0] + 1][currentSCoords[1]] != null) {
                neighbors.add(roads[currentSCoords[0] + 1][currentSCoords[1]]);
            }
            
            if (currentSCoords[0] - 1 >= 0 && roads[currentSCoords[0] - 1][currentSCoords[1]] != null) {
                neighbors.add(roads[currentSCoords[0] - 1][currentSCoords[1]]);
            }
            
            if (currentSCoords[1] + 1 <= this.height && roads[currentSCoords[0]][currentSCoords[1] + 1] != null) {
                neighbors.add(roads[currentSCoords[0]][currentSCoords[1] + 1]);
            }
            
            if (currentSCoords[1] - 1 >= 0 && roads[currentSCoords[0]][currentSCoords[1] - 1] != null) {
                neighbors.add(roads[currentSCoords[0]][currentSCoords[1] - 1]);
            }
            


            for (Road neighbor : neighbors) {
                 if (closed.contains(neighbor)) {
                    continue; // Skip this neighbor, it is already evaluated
                }
                else{

                int tentativeG = current.getCostFromStart() + this.getTrafficBetweenRoads(current, neighbor); 

                if (!open.contains(neighbor) || tentativeG < neighbor.getCostFromStart()) {
                    neighbor.parent = current;
                    neighbor.setCostFromStart(tentativeG);
                    neighbor.setCostToFinish(calculateHeuristic(neighbor, endRoad));
                    if (!open.contains(neighbor)) {
                        open.add(neighbor);
                    }
                }}
            }
        }
        return null; // No path found
    }

    /**
     * Cslculate the total road between first-last road by taking absolute values of roads' x, y coordinates.
     * @param node first road
     * @param endNode last road
     * @return total disance as a count of road
     */
    private static int calculateHeuristic(Road node, Road endNode) {
        // Manhattan distance heuristic
        return Math.abs(node.getCoords()[0] - endNode.getCoords()[0]) + Math.abs(node.getCoords()[1] - endNode.getCoords()[1]);
    }

    /**
     * 
     * @param changed mobile which gonna be located to specific coordiinate (road)
     * @param x road's x-coordinate
     * @param y road's y-coordinate
     */
    public void setRoad(Mobile changed, int x, int y){
        roads[x][y].setContined(changed);
        changed.setContainedIn(roads[x][y]);
    }

    public int getTrafficBetweenRoads(Road a, Road b){
        // TODO: Safety net for Roads that may not be adjasent
        int [] aCoords = a.getCoords();
        int [] bCoords = b.getCoords();

        if( aCoords[0] < bCoords[0]){
            return a.getTraffic()[0];
        }
        else if( aCoords[0] > bCoords[0]){
            return b.getTraffic()[0];
        }
        else if( aCoords[1] < bCoords[1]){
            return b.getTraffic()[1];
        }
        else if( aCoords[1] > bCoords[1]){
            return a.getTraffic()[1];
        }
        else{
            return 0;
        }
    }

    public void emptyRoad(int x, int y){
        roads[x][y] = null;
    }

    /*
     * Does the vehicle choosing and sending order
     * @param med
     * @param stationary
     */
    /* public getOrder(Medicine med, Stationary stationary){
        // path bulunup order yapılmalı
    } */

    /**
     * Builds a stationary at a given coordinate the size and width wanted
     */
    public Stationary buildCustomeStationary(int x, int y, int width, int height, Stationary stationaryInside){

        // hollowing the inside of the wanted stationary of roads
        for (int i = x + 1; i < x + width; i++) {
            for( int j = x + 1; j < x + height; j++){
                roads[i][j] = null;
            }
        }

        // creating and allocating a stationary to the monstrocity
        stationarys[x][y] = new Stationary(x, y);

        return stationarys[x][y];
    }

    public Road getRoad(int x, int y){
        return roads[x][y];
    }

/**
 * Creates a map of the city.
 * @param showTraffic Whether to display traffic information.
 * @return The map of the city.
 */
public String viewMap(boolean showTraffic){
    StringBuilder map = new StringBuilder("");
    StringBuilder primaryRow = new StringBuilder("");
    StringBuilder secondaryRow = new StringBuilder("");

    // write an index map to the top
    map.append("    ");
    for (int i = 0; i < roads.length; i++) {

        map.append(new String().format("%-4s  ", "" + i));
    }
    map.append("\n");
    

    for (int j = 0; j < roads[0].length; j++) {

        // write the index to the left for convenience
        primaryRow.append(new String().format("%3s", "" + j));
        secondaryRow.append("   ");

        for (int i = 0; i < roads.length; i++) {
            // check if there is a road there at all
            if( roads[i][j] != null){
                // displaying vehicle
                if(roads[i][j].getContained() == null){
                    if(roads[i][j].getWasCrossed()){
                        primaryRow.append(" 0 ");
                        int current = wholeWay.size();
                        wholeWay.add(new ArrayList<Integer>() );
                        wholeWay.get(current).add(i);
                        wholeWay.get(current).add(j);
                    } 
                    else primaryRow.append(" . ");
                }
                else if(roads[i][j].getContained() instanceof Van){
                    primaryRow.append(" V ");
                }
                else{
                    primaryRow.append(" S ");
                }

                // draw the road rightwards
                if( i < this.width
                //&& roads[i + 1][j] != null
                ){
                    // show the traffic level in format "-traffic-"
                    try {
                        if( roads[i + 1][j] !=  null){
                            if(showTraffic){
                            primaryRow.append(String.format("-%s-", roads[i][j].getTraffic()[0]));
                            }
                            else{
                            // not show traffic
                            primaryRow.append("---");
                            }
                        }
                        else{
                            primaryRow.append("   ");
                        }
                    } catch (Exception e) {
                        primaryRow.append("---");
                    }
                    
                }
                
                // draw the road downward
                if( j < this.height && roads[i][j+1] != null){
                    if(showTraffic){
                        // show the traffic level downward
                        secondaryRow.append(String.format(" |%s", roads[i][j].getTraffic()[1]));
                    }
                    else{
                        // not show traffic
                        secondaryRow.append(" | ");
                        
                    }
                }
                else{
                    secondaryRow.append("   ");
                }

                if(j < this.height && i < this.width)
                {    // draw the stationary
                    if( roads[i][j].getEnterenceOf() == null){
                        secondaryRow.append(" * ");
                    }
                    else if( roads[i][j].getEnterenceOf() instanceof Pharmacy){
                        secondaryRow.append(" M ");
                    }
                    else if( roads[i][j].getEnterenceOf() instanceof Patients){
                        secondaryRow.append(" P ");
                    }
                    else{
                        secondaryRow.append(" A ");
                    }
                }
                else{
                    secondaryRow.append("   ");
                }
            }
            else{
                primaryRow.append("      ");
                secondaryRow.append("      ");
            }
        }
        // append to final map and clear rows
        map.append(primaryRow + "\n");
        map.append(secondaryRow + "\n");
        primaryRow.delete(0, primaryRow.length());
        secondaryRow.delete(0, secondaryRow.length());
    }

    return map.toString();
}

public int getWidth() {
    return width;
}

public int getHeight() {
    return height;
}

public ArrayList<Patients> getPatientList(){
    return patientList;
}

public ArrayList<Nurses> getNurseList(){
    return NurseList;
}

public ArrayList<Stationary> getStationaryList(){
    return stationaryList;
}

public ArrayList<Scooter> getScooterList(){
    return scooterList;
}

public ArrayList<Van> getVanList(){
    return vanList;
}

// Method to randomly create buildings within the city area
public void createRandomBuildings(int numBuildings, double portionOfCity) {
    Random random = new Random();
    int totalCells = width * height;
    int cellsToFill = (int) (totalCells * portionOfCity);

    for (int i = 0; i < numBuildings; i++) {
        int buildingWidth = random.nextInt(width / 50) + 1;  // Random width (genişliğin 50de biri)
        int buildingHeight = random.nextInt(height / 50) + 1;  // Random height (50de biri uzunluğun)

        // Random position for the bottom-left corner of the building
        int startX = random.nextInt(width - buildingWidth);
        int startY = random.nextInt(height - buildingHeight);

        // Ensure building does not overlap with existing buildings or roads
        boolean isOverlap = false;
        for (int x = startX; x < startX + buildingWidth; x++) {
            for (int y = startY; y < startY + buildingHeight; y++) {
                if (stationarys[x][y] != null) {
                    isOverlap = true;
                    break;
                }
            }
        }

        if (!isOverlap) {
            // Build the stationary object for the building
            Stationary building = new Stationary(startX, startY);
            stationaryList.add(building);
            // Place the building in the city grid
            buildCustomeStationary(startX, startY, buildingWidth, buildingHeight, building);
            // Update the remaining cells to fill
            cellsToFill -= buildingWidth * buildingHeight;
        }

        // Stop if the desired portion of the city area is filled
        if (cellsToFill <= 0) {
            break;
        }
    }
}

public void createVansAndScooters() {
    Random random = new Random();
    
    // Determine the number of vans and scooters based on city parameters
    int numVans = 1 + width * height / 100; // Adjust the factor as needed. en az 1 olmalı
    int numScooters = 1  + width * height / 50; // Adjust the factor as needed
    
    // Place vans randomly in the city
    for (int i = 0; i < numVans; i++) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        String name = "v" + (i + 1); // Unique name for each van
        Van van = new Van(name, 0,0);
        vanList.add(van);
        setRoad(van, x, y);
    }

    // Place scooters randomly in the city
    for (int i = 0; i < numScooters; i++) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        String name = "s" + (i + 1); // Unique name for each scooter
        Scooter scooter = new Scooter(name);
        scooterList.add(scooter);
        setRoad(scooter, x, y);
    }
}
}
