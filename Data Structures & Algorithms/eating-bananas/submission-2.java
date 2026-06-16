class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // the min rate could be 1 and the max rate could be the max pile.
        // We will have to find the min possible rate to satisfy h hours.
        
        // Find max pile
        int maxPile = 0;
        for(int pile : piles)
            maxPile = Math.max(maxPile, pile);
        
        int start = 1, end = maxPile, minSpeed = maxPile;
        while (start <= end) {
            int mid = (start + end) / 2;
            int hours = hoursNeeded(piles, mid);
            //System.out.println("S: " + start + " , E: " + end + " , M: " + mid + " , H: " + hours);
            if (hours <= h) 
            {
                minSpeed = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return minSpeed;
    }

    private int hoursNeeded(int[] piles, int speed) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double)pile / speed);
        }
        
        return hours;
    }
}
