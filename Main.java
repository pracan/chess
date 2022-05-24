class Main {

  public static void main(String[] args) {
    InOut entree = new InOut();
    //on demande le type de partie
    int starttype = entree.typePartie();
    //on demande le nom de la partie
    String nameGame = entree.gameName();
    //on cree toute nos variable utilisées dans le if{}else{]}
    String nameP1;
    String nameP2;
    boolean whiteturn = true;
    boolean loop = true;
    int counter = 0;
    Board board = new Board();
    SaveFile save = new SaveFile(nameGame);
    //si on cree une nouvelle partie
    if (starttype == 1) {
      //on demande le nom des joueurs
      nameP1 = entree.playerName(1);
      nameP2 = entree.playerName(2);
      //si ce fichier est nouveau on l'initialise
      if(save.getNewfile()){
        save.formatWriteFile(nameP1,nameP2);
        save.WriteToFile(board.getBoard(),0);
      }
      System.out.println("\n" + "Begining of " + nameGame + " :\n");
      
    } else {
      //si on met pas ca le compilateur est pas sur qu'on initialise la variable et refuse de compiler
      nameP1 = "recover it";
      nameP2 = "recover it";
      //si le fichier n'est pas vide
      if(save.getNewfile()==false){
        //on regarde combien de sauvegardes contient le fichier
        int numberturns = save.NumberTurns();
        if (numberturns>=12){
          numberturns = ((numberturns - 3)/9)-1;
        } else {
          loop=false;
          System.out.println("Erreur la partie ne contient aucun coup");
        }
        if(loop){
          //on recupere les noms des joueurs
          nameP1 = save.recoverPlayer1();
          nameP2 = save.recoverPlayer2();
          //on demande a l'utilisateur quel etat de l'echiquier il souhaite charger
          int y1 = entree.replaynumero(numberturns);
          //on charge la partie
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

          int x1 = entree.posletter("White",nameP1);
          int y1 = entree.posnumber("White",nameP1);
          System.out.println("White turn : Where to move now ?");
          int x2 = entree.posletter("White",nameP1);
          int y2 = entree.posnumber("White",nameP1);
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
          int x1 = entree.posletter("Black",nameP2);
          int y1 = entree.posnumber("Black",nameP2);
          System.out.println("White turn : Where to move now ?");
          int x2 = entree.posletter("Black",nameP2);
          int y2 = entree.posnumber("Black",nameP2);
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
