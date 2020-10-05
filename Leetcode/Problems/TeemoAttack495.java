public class TeemoAttack495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (duration < 1)
            return 0;
        if (timeSeries.length < 1)
            return 0;
        int[] prevArr = new int[timeSeries.length];
        int currDif = 0;
        int maxPrev = timeSeries[0] + duration;
        prevArr[0] = maxPrev;
        int result = duration;

        for (int i = 1; i < timeSeries.length; i++) {
            int maxCurr = timeSeries[i] + duration;
            maxPrev = prevArr[i - 1];
            if (timeSeries[i - 1] == (timeSeries[i] - 1) || timeSeries[i] <= maxPrev) {
                currDif = maxCurr - maxPrev;
            } else {
                currDif = duration;
            }
            prevArr[i] = maxCurr;
            result += currDif;
        }
        return result;
    }

}

