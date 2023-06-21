class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dy=coordinates[1][1]-coordinates[0][1];
        int dx=coordinates[1][0]-coordinates[0][0];
        
        for(int i=2;i<coordinates.length;i++){
            
            // int curr_dy=coordinates[i][1]-coordinates[i-1][1];
            // int curr_dx=coordinates[i][0]-coordinates[i-1][0];
            
            if(dy*(coordinates[i][0]-coordinates[i-1][0]) != dx*(coordinates[i][1]-coordinates[i-1][1]))
                return false;  
            // dy/dx != curr_dy/curr_dx might through a run time error:division by 0
        }
        return true;
    }
}