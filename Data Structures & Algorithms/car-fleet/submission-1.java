class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int carsCount = position.length;
        int[][] cars = new int[carsCount][2];
        for (int i = 0; i < carsCount; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort the cars array so that we know the cars ahead for an ith car.
        // Sort by position descending
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double maxTime = 0;
        for(int[] car : cars) {
            double time = (double)(target - car[0]) / car[1];
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
}
