package week3;

import java.util.Collections;
import java.util.List;

public class MaximumAddRevenue {

    public static long calculateMaximumAddRevenue(final List<Integer> profitsPerClicks,
                                                  final List<Integer> numberOfClicks) {
        Collections.sort(profitsPerClicks);
        Collections.sort(numberOfClicks);

        long maximumRevenue = 0;
        for(int i = 0; i < profitsPerClicks.size(); i++) {
            maximumRevenue += profitsPerClicks.get(i) * numberOfClicks.get(i);
        }

        return maximumRevenue;
    }
}
