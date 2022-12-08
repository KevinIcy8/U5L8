import java.text.DecimalFormat;

public class Temperature
{
    private double highTemp;
    private double lowTemp;
    private String tempScale;
    public static final int FREEZING_TEMP_F = 32;
    private static double highestTrackedTempF = 0;
    private static double lowestTrackedTempF = 0;
    private static boolean isSetFirstTemps = false;

    public void highestLowestTracker(){

        if(tempScale.equals("F")){
            if(!isSetFirstTemps){
                highestTrackedTempF = highTemp;
                lowestTrackedTempF = lowTemp;
            }
            else{
                if(highTemp > highestTrackedTempF){
                    highestTrackedTempF = highTemp;
                }
                if(lowTemp < lowestTrackedTempF){
                    lowestTrackedTempF = lowTemp;
                }
            }
        }
        else{
            double convHighTemp = convertCtoF(highTemp);
            double convLowTemp = convertCtoF(lowTemp);
            if(!isSetFirstTemps){
                highestTrackedTempF = convHighTemp;
                lowestTrackedTempF = convLowTemp;
            }
            if(convHighTemp > highestTrackedTempF){
                highestTrackedTempF = convHighTemp;
            }
            if(convLowTemp < lowestTrackedTempF){
                lowestTrackedTempF = convLowTemp;
            }
        }
        isSetFirstTemps = true;
    }

    public static void tempTest(Temperature temperature){
        System.out.println("High Temp:" + temperature.highTemp);
        System.out.println("Low Temp:" + temperature.lowTemp);
        System.out.println("Scale" + temperature.tempScale);
        System.out.println("Highest tracked temp (F): " + highestTrackedTempF);
        System.out.println("Lowest tracked temp (F): " + lowestTrackedTempF);

    }

    public boolean belowFreezing(){
        if(highTemp < 32 || lowTemp < 32){
            return true;
        }
        return false;
    }

    public static boolean sawFreezing(){
        if(highestTrackedTempF < 32 || lowestTrackedTempF < 32){
            return true;
        }
        return false;
    }


    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale)
    {
        highTemp = high;
        lowTemp = low;

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }
    }

    // 1. Add your two static methods here:
    public static double convertCtoF(double temp){
        double fahrenheit = ((temp * 9)/5) + 32;
        return fahrenheit;
    }

    public static double convertFtoC(double temp){
        double celsius = (temp - 32) * 5/9;
        return celsius;
    }


    // 2. Add your two instance methods here:
    public void changeToC(){
        tempScale = "C";
        highTemp = convertFtoC(highTemp);
        lowTemp = convertFtoC(lowTemp);
    }

    public void changeToF(){
        tempScale = "F";
        highTemp = convertCtoF(highTemp);
        lowTemp = convertCtoF(lowTemp);
    }


    // 3. Add your private static helper rounding "utility" method here:
    private static final DecimalFormat df = new DecimalFormat("0.0");
    public static double roundToNearestTenth(double num){

        return Double.parseDouble(df.format(num));
    }


    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:

    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public String toString()
    {
        String high = "High Temperature: " + roundToNearestTenth(highTemp) + tempScale;
        String low = "Low Temperature: " + roundToNearestTenth(lowTemp) + tempScale;
        return high + "\n" + low;
    }
}
