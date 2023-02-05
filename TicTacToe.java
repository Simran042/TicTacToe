

import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    board b = new board();
    System.out.println("Please select the mode you want to play in");
    System.out.println("Enter 1 for 2- player version");
    System.out.println("Enter 2 for playing against computer");
    System.out.println("Enter 0 to quit");
    Scanner sc = new Scanner(System.in);
    int mode = sc.nextInt();

    

    while (mode!=0) {
      //check if valid mode is selected
      while (mode != 0 && mode != 1 && mode != 2) {
        System.out.println("Please enter valid code");
        System.out.println("Enter 1 for 2- player version");
        System.out.println("Enter 2 for playing against computer");
        System.out.println("Enter 0 to quit");
        // Scanner sc = new Scanner(System.in);
        mode = sc.nextInt();
      }

      //if mode 2 is selected
      if (mode == 2) {
        System.out.println("\nYou chose to play against Computer");
        b.PrintFrame();
        b.InitialiseBoard();
        b.display();
        int win = 0;
        int count = 0;
        //total number of tries can't be >9 since 9 blocks are present
        while (count < 9) {
          if (count % 2 == 0 && count < 10) {
            System.out.println("\nPlayer (\"X\")'s turn");
            b.modifyBoard(1);
            b.display();
            count++;
          } 
          //taking computer as player 2 and using random fxn
          else if (count % 2 == 1 && count < 10) {
            System.out.println("\nComputer(\"0\")'s turn");
            b.modifyBoardRandom(-1);
            b.display();
            count++;
          }
          // System.out.println(count + "count");
          win = b.Winner();
          if (win == 1) {
            System.out.println("\nCongratulations! Player 1 won! ");
            count = 13;
          } else if (win == -1) {
            System.out.println("\nComputer won this game");
            count = 13;
          }
        }
        //if no one won and count>9 i.e. board is filled
        if (count != 13) {
          System.out.println("\nThis match ended in a draw");

        }

        //ask for another game
        System.out.println("\nTry again?");
        System.out.println("Enter 1 for 2- player version");
        System.out.println("Enter 2 for playing against computer");
        System.out.println("Enter 0 to quit");
        // Scanner sc = new Scanner(System.in);
        mode = sc.nextInt();
      }
      if (mode == 1) {
        //comments same as prvs mode
        System.out.println("\nYou chose to play against another player");
        b.PrintFrame();
        b.InitialiseBoard();
        b.display();
        int win = 0;
        int count = 0;
        while (count < 9) {
          if (count % 2 == 0 && count < 10) {
            //
            System.out.println("\nPlayer 1(\"X\")'s turn");
            b.modifyBoard(1);
            b.display();
            count++;
          } else if (count % 2 == 1 && count < 10) {
            System.out.println("\nPlayer 2(\"0\")'s turn");
            b.modifyBoard(-1);
            b.display();
            count++;
          }
          // System.out.println(count + "count");
          win = b.Winner();
          if (win == 1) {
            System.out.println("\nCongratulations! Player 1 won! ");
            count = 13;
          } else if (win == -1) {
            System.out.println("\nCongratulations! Player 2 won! ");
            count = 13;
          }
        }
        if (count != 13) {
          System.out.println("This match ended in a draw");
        }
        System.out.println("\nTry again?");
        System.out.println("Enter 1 for 2- player version");
        System.out.println("Enter 2 for playing against computer");
        System.out.println("Enter 0 to quit");
        // Scanner sc = new Scanner(System.in);
        mode = sc.nextInt();

      }
    }

  }
}
