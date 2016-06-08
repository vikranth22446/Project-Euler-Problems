package problem11to20.problem19;

import java.util.Calendar;

/**
 * Created by vikranth on 6/8/2016.
 */
public class Problem19 {
    private static int NUM_SUNDAYS;

    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        NUM_SUNDAYS = problem19.findSundays();
        System.out.println(NUM_SUNDAYS);
    }

    public int findSundays() {
        int totalSundays = 0;
        for (int i = 1901; i < 2001; i++) {
            for (int j = 1; j <= 12; j++) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.DATE, 1);
                c.set(Calendar.MONTH, j);
                c.set(Calendar.YEAR, i);
                if (Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK)) {
                    totalSundays++;
                }
            }
        }
        return totalSundays;
    }
}
