class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
          int n=speed.length;
        double[][] cars=new double[n][2];

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=(double)(target-position[i])/speed[i];
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));

        int fleet=0;
        double maxtime=0;

        for(int i=0;i<n;i++){
            double time=cars[i][1];
            if(time> maxtime){
                fleet++;
                maxtime=time;
            }
        }
        return fleet;
        
    }
}
