/**
 * It is a Solution class
 * It contains same possible solutions
 */

/**
 * 1. Take any painkillers you have used recently
 * 2. Drink water
 * 3. Sleep more
 * 4. Apply ice
 * 5. Get fresh air
 * 6. Don't move too much
 * 7. Don't eat anything
 * 8. Eat something
 * 9. Apply hot
 * 10. Have a rest
 * 11. Take your allergy medicine
 * 12. Move away from allergen
 * 13. Take vitamin C
 * 14. Take off your clothes
 * 15. Take your asthma medicine
 * 16. Drink hot liquid
 */

public class Solution 
{
    //Instance variables
    private String solution;

    //Costructor
    public Solution(int number)
    {
        if(number == 1) {solution = "Take any painkillers you have used recently.";}
        else if(number == 2) {solution = "Drink water.";}
        else if(number == 3) {solution = "Sleep more.";}
        else if(number == 4) {solution = "Apply ice.";}
        else if(number == 5) {solution = "Get fresh air.";}
        else if(number == 6) {solution = "Don't move too much.";}
        else if(number == 7) {solution = "Don't eat anything.";}
        else if(number == 8) {solution = "Eat something.";}
        else if(number == 9) {solution = "Apply hot.";}
        else if(number == 10) {solution = "Have a rest.";}
        else if(number == 11) {solution = "Take your allergy medicine.";}
        else if(number == 12) {solution = "Move away from allergen.";}
        else if(number == 13) {solution = "Take vitamin C.";}
        else if(number == 14) {solution = "Take off your clothes.";}
        else if(number == 15) {solution = "Take your asthma medicine.";}
        else if(number == 16) {solution = "Drink hot liquid.";}
    }

    /**
     * Give solution as a string
     * @return solution
     */
    public String getSolution()
    {
        return solution;
    } 
}
