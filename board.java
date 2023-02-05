
import java.util.Scanner;
import java.util.Random;

public class board {
  int[][] tempb = new int[3][3];
  //print position numbers for reference of player
  public void PrintFrame() {
    System.out.println("\nThe positions in your board are: ");
    int x = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(x + " | ");
        x++;
      }
      System.out.println("\n------------");
    }
  }

  public int[][] InitialiseBoard() {
    //initialise an empty board
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        tempb[i][j]=0;
      }
    }
    return tempb;
  }

  //ask for desired posn from player and modify the current game
  public void modifyBoard(int player)
  {
    int pos=0;
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the desired position: ");
    pos= sc.nextInt();
    int p=0;
    if(player==1){
      p=1;
    }
    if(player==-1){
      p=-1;
    }

    //pos can't be<0 or >8
    while(pos>8 || pos<0 )
    {
      System.out.print("\nPlease choose a location from 0 to 8(both inclusive): ");
      pos= sc.nextInt();         
    }
    int x= (pos)/3;
    int y= (pos)%3;
    
    while(tempb[x][y]!=0)
      {
        System.out.print("\nAw looks like the position you selected is already used. Please choose another location from 0 to 8(both inclusive): ");
        pos= sc.nextInt();
        x= pos/3;
        y=pos%3;
      }
    tempb[x][y]=p;
  }

  //this is for random generation by computer
  public void modifyBoardRandom(int player)
  {
    int pos=0;
    Random r= new Random();
    pos= r.nextInt(9);
    int p=0;
    if(player==1){
      p=1;
    }
    if(player==-1){
      p=-1;
    }
    while(pos>8 || pos<0 )
    {
      pos= r.nextInt(9);         
    }
    int x= (pos)/3;
    int y= (pos)%3;
        
    while(tempb[x][y]!=0)
      {
        pos= r.nextInt(9);
        x= pos/3;
        y=pos%3;
      }
      System.out.println("Computer chose "+ pos);
    tempb[x][y]=p;
  }

  //this fxn will return winner by counting the sum from temp(all 4 possible cases are covered)
  public int Winner() {
    int count=0;
    //check in row first
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        count= count + tempb[i][j];
      }
      if(count==3){
        return 1;
      }
      if(count==-3){
        return -1;
      }
      count=0;
    }

    //check in column
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        count= count + tempb[j][i];
      }
      if(count==3){
        return 1;
      }
      if(count==-3){
        return -1;
      }
      count=0;
    }

    //check diagonal 1
    count= tempb[1][1] + tempb[0][0] + tempb[2][2];
    if(count==3){
      return 1;
    }
    if(count==-3){
      return -1;
    }
    count=0;

    //check diagonal-2
    count= tempb[0][2] + tempb[1][1] + tempb[2][0];
    if(count==3){
      return 1;
    }
    if(count==-3){
      return -1;
    }
    count=0;
    //if no one won, returning 0
    return count;

  }

  //this will display the current state of your board
  public void display() {
    System.out.println("\nThe current state of your board is: ");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // player 1 = -1= "0"
        // player 2 = 1 = "X"
        if (tempb[i][j] == 0) {
          System.out.print(" "+ " | ");
        }
        if (tempb[i][j] == -1) {
          System.out.print("0"+ " | ");
        }
        if (tempb[i][j] == 1) {
          System.out.print("X"+ " | ");
        }
      }
      System.out.println("\n------------");
    }
  }

  public static void main(String[] args) {
    
  }
}
