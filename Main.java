import java.util.Scanner;

class Main {
  // We create scanner so we can read input.
  static Scanner entree = new Scanner(System.in);

  public static void main(String[] args) {
    
    System.out.println("1- New game");
    System.out.println("2- Recover a game");
    int starttype = entree.nextInt();
    System.out.println("\n" + "Please, Enter the name of your game :");
    String nameGame = entree.nextLine();
    nameGame = entree.nextLine();
    String nameP1;
    String nameP2;
    boolean whiteturn = true;
    boolean loop = true;
    int counter = 0;
    Board board = new Board();
    SaveFile save = new SaveFile(nameGame);
    
    if (starttype == 1) {
      System.out.println("Please, Enter the name of your player 1 :");
      nameP1 = entree.nextLine();
      System.out.println("Please, Enter the name of your player 2 :");
      nameP2 = entree.nextLine();
      if(save.getNewfile()){
        save.formatWriteFile(nameP1,nameP2);
        save.WriteToFile(board.getBoard(),0);
      }
      System.out.println("\n" + "Begining of " + nameGame + " :\n");
      
    } else {
      nameP1 = "recover it";
      nameP2 = "recover it";
      
      if(save.getNewfile()==false){
        int numberturns = save.NumberTurns();
        if (numberturns>=12){
          numberturns = ((numberturns - 3)/9)-1;
        } else {
          loop=false;
          System.out.println("Erreur la partie ne contient aucun coup");
        }
        if(loop){
          nameP1 = save.recoverPlayer1();
          nameP2 = save.recoverPlayer2();
          System.out.println("La partie contient "+numberturns+" coups");
          System.out.println("Choisissez en un :");
          int y1 = entree.nextInt();
          //verfier entree
          board = save.recover(y1);
          if(y1%2==0){
            whiteturn = true;
          } else{
            whiteturn = false;
          }
          counter = y1;
        }
      } else{
        loop=false;
        System.out.println("Erreur la partie n'as pas été trouvée");
        }
    };
    // boucle de jeu.
    while (loop) {
      if (counter != 0) {
        System.out.println("\n" + nameGame + " turn n° " + counter + "\n");
      }
      Boolean replay = true;
      board.displayBoard();
      int a = 0;
      if (whiteturn) {
        while (replay) {

          System.out.println("White turn : " + nameP1 + " enter letter");
          char c1 = entree.next().charAt(0);
          int x1 = (int) c1;
          if (x1 > 96) {
            x1 -= 97;
          } else {
            x1 -= 65;
          }
          ;
          System.out.println("White turn : " + nameP1 + " enter number");
          int y1 = entree.nextInt();
          y1 = 8 - y1;
          System.out.println("White turn : Where to move now ? enter letter");
          char c2 = entree.next().charAt(0);
          int x2 = (int) c2;
          if (x2 > 96) {
            x2 -= 97;
          } else {
            x2 -= 65;
          }
          ;
          System.out.println("White turn : enter number");
          int y2 = entree.nextInt();
          y2 = 8 - y2;
          replay = board.isValidMove(y1, x1, y2, x2, whiteturn);

          if (replay == false) {
            board.validMove(y1, x1, y2, x2);
            whiteturn = false;
            save.WriteToFile(board.getBoard(),counter+1);
          }

          if (a == 3) {
            System.out.println("Victory Black");
            loop = false;
            replay = false;
          } else {
            a += 1;
          }
        }

      } else {
        while (replay) {
          System.out.println("Black turn : " + nameP2 + " enter letter");
          char c1 = entree.next().charAt(0);
          int x1 = (int) c1;
          if (x1 > 96) {
            x1 -= 97;
          } else {
            x1 -= 65;
          }
          ;
          System.out.println("Black turn : " + nameP2 + " enter number");
          int y1 = entree.nextInt();
          y1 = 8 - y1;
          System.out.println("Black turn : Where to move now ? enter letter");
          char c2 = entree.next().charAt(0);
          int x2 = (int) c2;
          if (x2 > 96) {
            x2 -= 97;
          } else {
            x2 -= 65;
          }
          ;
          System.out.println("Black turn : enter number");
          int y2 = entree.nextInt();
          y2 = 8 - y2;
          replay = board.isValidMove(y1, x1, y2, x2, whiteturn);
          if (replay == false) {
            board.validMove(y1, x1, y2, x2);
            whiteturn = true;
            save.WriteToFile(board.getBoard(),counter+1);
          }

          if (a == 3) {
            loop = false;
            replay = false;
            System.out.println("Victory White");
          } else {
            a += 1;
          }
        }

      }
      counter++;
    }
  }
}
