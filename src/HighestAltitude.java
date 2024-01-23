public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int previousValue = 0;
        int result = 0;
        int netGain = 0;
        for (int i =0; i< gain.length; i++) {
            netGain = gain[i]+previousValue;
            previousValue = netGain;
            result = Math.max(result, netGain);

        }
        return result;
    }

}
