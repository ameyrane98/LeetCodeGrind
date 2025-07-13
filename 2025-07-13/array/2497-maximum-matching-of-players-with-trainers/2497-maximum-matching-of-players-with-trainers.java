class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int counter=0;
        int ptPlayer=0;
        int ptTrainer=0;

        while(ptPlayer<players.length && ptTrainer<trainers.length){
            if(players[ptPlayer]<=trainers[ptTrainer]){
                counter++;
                ptPlayer++;
            }

            ptTrainer++;
        }

        return counter;
    }
}