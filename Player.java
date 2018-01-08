public class Player{
    String name;
    int numGamesWon;
    boolean[] board = new boolean[24];
    public Player(){
        name = "Craig Daniels";
        numGamesWon = 0;
    }
    
    public Player(String _name){
        name = _name;
        numGamesWon = 0;
    }

    public int checkBoard(){
        for (int i = 0;i<24;i++){
            if(!board[i]){
                return i;
            }
        }
        return 24;
    }
    
    public void win(){
        numGamesWon++;
    }
    
    public void clearSquare(int index){
        board[index] = true;
    }
    
    public String toString(){
        return name + " has won " + numGamesWon + " games.";
    }
}
