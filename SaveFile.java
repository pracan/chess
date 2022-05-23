import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors

public class SaveFile {
  private String filename;
  private boolean newfile;
  
  public SaveFile(String name) {
    try {
      File myObj = new File(name+".txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        this.newfile= true;
      } else {
        System.out.println("File already exists.");
        this.newfile = false;
      }
      this.filename = name;
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      this.newfile = false;
    }
  }

  public void WriteToFile(Piece[][] board,int turn) {
    try {
      FileWriter myWriter = new FileWriter(this.filename+".txt",true);
      myWriter.write("\n"+"turn n° "+turn+"\n");
      for (int i = 0; i <= 7; i++) {
        for (int v = 0; v <= 7; v++) {
          if(v!=0){myWriter.write(" ");}
          if(board[i][v].getType()!=0){
          if(board[i][v].getIsWhite()){
            myWriter.write("W");
          } else {myWriter.write("B");}}
          switch(board[i][v].getType()) {
            case 1:
                myWriter.write("P");
              break;
            case 2:
                myWriter.write("R");
              break;
            case 3:
                myWriter.write("B");
              break;
            case 4:
                myWriter.write("N");
              break;
            case 5:
                myWriter.write("Q");
              break;
            case 6:
                myWriter.write("K");
              break;
            default:
              myWriter.write("  ");
          }
        }
        if (i<7){myWriter.write("\n");}
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public Board recover(int turn) {
    Board board = new Board();
    try {
      File myObj = new File(this.filename+".txt");
      Scanner myReader = new Scanner(myObj);
      String data = myReader.nextLine();
      for (int i = 0; i < (turn*9)+3; i++) {
        data = myReader.nextLine();
      }
      for (int i = 0; i <= 7; i++) {
        data = myReader.nextLine();
        for (int v = 0; v <= 7; v++) {
          char color = data.charAt(0+3*v);
          char pawn = data.charAt(1+3*v);
          switch (pawn){
            case 'P' :
              board.getBoard(i,v).setType(1);
              break;
            case 'R' :
              board.getBoard(i,v).setType(2);
              break;
            case 'B' :
              board.getBoard(i,v).setType(3);
              break;
            case 'N' :
              board.getBoard(i,v).setType(4);
              break;
            case 'Q' :
              board.getBoard(i,v).setType(5);
              break;
            case 'K' :
              board.getBoard(i,v).setType(6);
              break;
            default :
              board.getBoard(i,v).setType(0);
          }
          if (pawn != ' ') {
            if (color == 'W'){
              board.getBoard(i,v).setIsWhite(true);
            } else {
              board.getBoard(i,v).setIsWhite(false);
            }
          }
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return board;
  }

  public void formatWriteFile(String player1,String player2){
    try {
      FileWriter myWriter = new FileWriter(this.filename+".txt");
      myWriter.write("Begining of the game : "+filename+"\n");
      myWriter.write("Player 1 : "+player1+"\n");
      myWriter.write("Player 2 : "+player2);
      myWriter.close();
      System.out.println("Successfully wrote players info to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public boolean getNewfile(){
    return this.newfile;
  }

  public int NumberTurns(){
    int nbrLine = 0;
    try {
      File myObj = new File(this.filename+".txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        nbrLine++;
      }
      myReader.close();
      return nbrLine;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return -1;
    }
  }

  public String recoverPlayer1(){
    String name = "error";
    try {
      File myObj = new File(this.filename+".txt");
      Scanner myReader = new Scanner(myObj);
      String data = myReader.nextLine();
      data = myReader.nextLine();
      name = data.substring(11, data.length());
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return name;
  }

  public String recoverPlayer2(){
    String name = "error";
    try {
      File myObj = new File(this.filename+".txt");
      Scanner myReader = new Scanner(myObj);
      String data = myReader.nextLine();
      data = myReader.nextLine();
      data = myReader.nextLine();
      name = data.substring(11, data.length());
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return name;
  }

}