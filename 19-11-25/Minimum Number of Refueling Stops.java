class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y - x));
        
        int res = 0;
        int fuel = startFuel;
        
        for (int[] station : stations) {
            while (fuel < station[0]) {
                if (pq.isEmpty()) return -1;
                fuel += pq.poll();
                res++;
            }
            pq.offer(station[1]);
        }
        
        while (fuel < target) {
            if (pq.isEmpty()) return -1;
            fuel += pq.poll();
            res++;
        }
        
        return res;
    }
}
