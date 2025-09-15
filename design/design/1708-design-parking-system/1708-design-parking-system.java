class ParkingSystem {
    int[] freq = new int[4];
    public ParkingSystem(int big, int medium, int small) {
        freq[1]=big;
          freq[2]=medium;
            freq[3]=small;
        
    }
    
    public boolean addCar(int carType) {
        if(freq[carType]>0){
            freq[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */