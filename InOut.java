import java.util.Scanner;

public class InOut {
  Scanner entree;
  
  public InOut(){
    this.entree = new Scanner(System.in);
  }
  
  public int typePartie(){
    int starttype = 1;
    boolean notok=true;
    while(notok){
      System.out.println("1- New game");
      System.out.println("2- Recover a game");
      try{
        starttype = Character.getNumericValue(entree.next().charAt(0));
        notok=false;
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return starttype;
  }

  public String gameName(){
    String nameGame = "";
    nameGame = entree.nextLine(); //la premiere fois on le fait 2 fois car sinon ca marche pas
    boolean notok=true;
    while(notok){
      System.out.println("\n" + "Please, Enter the name of your game :");
      try{
        nameGame = entree.nextLine();
        nameGame = nameGame.replaceAll("[^a-zA-Z0-9]",""); //car c'est un nom de fichier
        if(nameGame.isEmpty()==false){
          notok=false;
        }else{
          System.out.println("\n"+"Error please retry\n");
        }
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return nameGame;
  }

  public String playerName(int i){
    String player1Name = "";
    boolean notok=true;
    while(notok){
      System.out.println("Please, Enter the name of your player "+i+" :");
      try{
        player1Name = entree.nextLine();
        notok=false;
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return player1Name;
  }

  public int replaynumero(int max){
    int num = 0;
    boolean notok=true;
    while(notok){
      System.out.println("La partie contient "+max+" coups");
      System.out.println("Choisissez en un :");
      try{
        num = entree.nextInt();
        if ((0<=num)&(num<=max)){notok=false;} else {System.out.println("\n"+"Error please retry\n");}
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return num;
  }

  public int posletter(String color,String nameP){
    int x1 = 0;
    boolean notok=true;
    while(notok){
      System.out.println(color+" turn : " + nameP + " enter letter");
      try{
        char c1 = entree.next().charAt(0);
        x1 = (int) c1;
        if (x1 > 96) {
          x1 -= 97;
        } else {
          x1 -= 65;
        }
        if ((0<=x1)&(x1<=7)){notok=false;} else {System.out.println("\n"+"Error please retry\n");}
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return x1;
  }

  public int posnumber(String color,String nameP){
    int y1 = 0;
    boolean notok=true;
    while(notok){
      System.out.println(color+" turn : " + nameP + " enter number");
      try{
          y1 = Character.getNumericValue(entree.next().charAt(0));
          y1 = 8 - y1;
        if ((0<=y1)&(y1<=7)){notok=false;} else {System.out.println("\n"+"Error please retry\n");}
      }catch (Exception e) {
        System.out.println("\n"+"Error please retry\n");
      }
    }
    return y1;
  }

  
  
}
