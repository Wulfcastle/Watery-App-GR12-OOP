
import java.util.Arrays;

public class Household {

    private String account;
    private int members;
    private int[] arrWaterUse;

    public Household() {

    }

    public Household(String Account, int Members, int[] arrWater) {
        this.account = Account;
        this.members = Members;
        this.arrWaterUse = arrWater;
    }

    public int calculateTotal() {
        int usage = 0;
        for (int i = 0; i < arrWaterUse.length; i++) {
            usage = usage + arrWaterUse[i];
        }
        return usage;
    }

    public double calculateAve() {
        int total = this.calculateTotal();
        double average = total / arrWaterUse.length;
        return average;
    }

    public int determineHighDay() {
        int highDay = 0;
        int amount = 0;
        for (int i = 0; i < arrWaterUse.length; i++) {
            if (arrWaterUse[i] > amount) {
                amount = arrWaterUse[i];
                highDay = i;
            }
        }
        return highDay;
    }

    public int calculateDaysAboveLimit(double dailyLimit) {
        int days = 0;
        for (int i = 0; i < arrWaterUse.length; i++) {
            if (arrWaterUse[i] > dailyLimit) {
                days = days + 1;
            }
        }
        return days;
    }

    public int calculateDaysAboveAvg() {
        double average = this.calculateAve();
        int days = 0;
        for (int i = 0; i < arrWaterUse.length; i++) {
            if (arrWaterUse[i] > average) {
                days = days + 1;
            }
        }
        return days;
    }

    public double[][] calculateExcessAmounts() {
        double average = this.calculateAve(); // Referenced later to compare values
        int numberDays = this.calculateDaysAboveAvg(); // This is done to determine the exact number of days above average in the week.
        double arrExcess[][] = new double[numberDays][2];

        /* The reason "numberDays" has been used here is so that the number of "rows" created in two-dimensional array is 
         specifically based on the actual number of days that are above average. The main reason behind this is that there are no "null" or "NaN' values in the 2D Array.
        
         numberDays = number of rows on the two-dimensional array - Determined by the exact number of days above average in the week. 
         2 = number of columns on the two-dimensional array
        
         The two columns are : Days & Excess Amount
        
        To ensure that there are no "null"/"NaN" values and that the two-dimensional array is "optimized", i.e. no empty values, two counters 
        i & j have to be used to loop/increment between the two-dimensional array and the one-dimensional array - "arrWaterUse", which is the array
        from which information is being read from, manipulated and then parsed into the two-dimensional array.
        
        Since the one-dimensional array - "arrWaterUse" and the
        two-dimensional array - "arrExcess" have different lengths, two different counters are used to loop/increment for each array/in terms of each array.
        Therefore "i" is used to increment in terms of the one-dimensional array - "arrWaterUse"
        & "j" is used to increment in terms of the two-dimensional array - "arrExcess".
         */
        
        int j = 0; // This is the counter that will increment in terms of the two-dimensional array. 
        for (int i = 0; i < arrWaterUse.length; i++) {
            if (arrWaterUse[i] > average) {
                arrExcess[j][0] = i + 1;

                /* Days - The "i", is being used as it is the counter that is being incremented in terms of the one-dimensional array - arrWaterUse. 
                 It keeps track of the number of the day in the week. This is why the "j" variable is not used here. */
                
                arrExcess[j][1] = arrWaterUse[i] - average; // Calculating amount in excess
                j++;
            }
        }

        return arrExcess;
    }

    public String twoDimensionalArraytoString() {
        String output = "";
        output = Arrays.deepToString(calculateExcessAmounts());
        return output;
    }

    public boolean determineHighRisk(double dayLimit) {
        boolean flag = false;
        if (this.calculateAve() > dayLimit) {
            flag = true;
        } else if (this.calculateDaysAboveLimit(dayLimit) > 2) {
            flag = true;
        }
        return flag;

    }

    public String intArraytoString() {
        String content = "";
        String index = "";
        for (int waterUsage : arrWaterUse) {
            content = content + waterUsage + ", ";

        }
        for (int i = 0; i < arrWaterUse.length; i++) {
            index = index + i + ", ";

        }
        String output = content + "\n" + index;
        return output;
    }

    public String toString() {
        String objStr = "Account number: " + this.account + "\n"
                + "Number of members: " + this.members + "\n"
                + "Daily Water Usage: " + this.intArraytoString();
        return objStr;
    }

}
