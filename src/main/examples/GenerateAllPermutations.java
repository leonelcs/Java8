package main.examples;

public class GenerateAllPermutations {

    /**
     * @param args
     */
    static int totalCounter = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int numberOfStairs = 4;
        int countSoFar = 0;
        String path = "";
        for(int i=1;i<2;i++){
            path = ""+i;
            displayAllPerms(numberOfStairs, i, path);
        }
        System.out.println("Total combinations found "+totalCounter);
    }

    public static void displayAllPerms(int n,int countSoFar,String s){
        if(countSoFar > n) return;
        else if(countSoFar < n){
            for(int i=1;i<2;i++){
                s+=" "+i;
                countSoFar+=i;
                displayAllPerms(n, countSoFar, s);
            }
        }else{
            System.out.println("Found combination "+s);
            totalCounter++;
            return;
        }
    }

}
