class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        CarState[] cars= new CarState[position.length];

        for(int i=0; i<position.length; i++){
            cars[i]= new CarState(target-position[i],speed[i],1.0*(target-position[i])/speed[i]);
        }
        //compares nearest to fartest
        Arrays.sort(cars, new Comparator<CarState>(){
            public int compare(CarState st1, CarState st2){
                return st1.distanceFromT-st2.distanceFromT;
            }
        });

        int fleetCount=0;
        double currTime=0.0;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].time > currTime){
                fleetCount++;
                currTime=cars[i].time;
            }
        }
       

        return fleetCount;
    }

    class CarState{
        int distanceFromT;
        double time;
        int speed;

        public CarState(int dt, int s, double t){
            this.distanceFromT=dt;
            this.speed=s;
            this.time=t;
        }
    }

        
 
}