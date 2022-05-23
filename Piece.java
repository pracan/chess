import java.util.ArrayList;

public class Piece {
    int type;
    Boolean isWhite; //true = blanc // false == noir
    Boolean hasMoved;
    Boolean isCheck;
    
    ArrayList<Integer> CoupsPossibles = new ArrayList<Integer>();
    
    public Piece(boolean isWhite,int type){
        this.isWhite=isWhite;
        this.type=type;
        if (type==1){
            this.hasMoved=false;
        }
        this.isCheck=false;
    }

    public Piece(boolean isWhite,int type,Boolean b){
        this.isWhite=isWhite;
        this.type=type;
        if (type==1){
            this.hasMoved=b;
        }
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public Boolean getHasMoved() {
        return hasMoved;
    }

    public Piece(int type){
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getIsWhite() {
        return isWhite;
    }

    public void setIsWhite(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    public ArrayList<Integer> getCoupsPossibles() {
        return CoupsPossibles;
    }


    public void setCoupsPossibles(Piece[][] b,int x, int y) {
        //on s'occupe juste de créer une liste de coups possibles pour chaque piece
        //il restera a coder is check qui vérifie en préhenbule si notre roi est check ==> et a la fin du coup s'il l'est toujours 
        Boolean couleur = b[x][y].getIsWhite();
        Boolean bool;
        b[x][y].CoupsPossibles.clear(); // on reset la liste
        int cpx = x;
        int cpy = y;
        switch(b[x][y].getType()){

            case 0: // rien
                break;
            case 1: // pion
                //je dois check la couleur du pion.
                
                if (couleur){ //si c blanc
                    //H
                    if (cpx-1>=0){
                        if(b[cpx-1][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx-1][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx-1);
                                b[x][y].CoupsPossibles.add(cpy);
                                bool = false;
                            } else {
                                bool = false;
                            }
                            
                        } else { // sinon on peux l'ajouter
                            b[x][y].CoupsPossibles.add(cpx-1);
                            b[x][y].CoupsPossibles.add(cpy);
                        }
                        //+ si il a jms bouge
                        if (!b[x][y].getHasMoved()){
                            if (cpx-2>=0){
                                if(b[cpx-2][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                                    bool = false;
                                } else { // sinon on peux l'ajouter
                                    b[x][y].CoupsPossibles.add(cpx-2);
                                    b[x][y].CoupsPossibles.add(cpy);
                                }}
                        }
                    }


                    //HG
                    if (cpx-1>=0 && cpy-1>=0){
                        if(b[cpx-1][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx-1][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx-1);
                                b[x][y].CoupsPossibles.add(cpy-1);
                            }  
                        }
                    }
                    //HD
                    if (cpx-1>=0 && cpy+1<=7){
                        if(b[cpx-1][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx-1][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx+1);
                                b[x][y].CoupsPossibles.add(cpy+1);
                            }  
                        }
                    }
                    
                } else {
                    //la mm mais pour les blacks
                    //B
                    if (cpx+1<=7){
                        if(b[cpx+2][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx+1][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx+1);
                                b[x][y].CoupsPossibles.add(cpy);
                                bool = false;
                            } else {
                                bool = false;
                            }
                            
                        } else { // sinon on peux l'ajouter
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy);
                        }
                        //+ si il a jms bouge
                        if (!b[x][y].getHasMoved()){
                            if (cpx+2<=7){
                                if(b[cpx+2][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                                    bool = false;
                                } else { // sinon on peux l'ajouter
                                    b[x][y].CoupsPossibles.add(cpx+2);
                                    b[x][y].CoupsPossibles.add(cpy);
                                }}
                        }
                    }


                    //BG
                    if (cpx+1<=7 && cpy-1>=0){
                        if(b[cpx+1][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx+1][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx+1);
                                b[x][y].CoupsPossibles.add(cpy-1);
                            }  
                        }
                    }
                    //HD
                    if (cpx+1<=7 && cpy+1<=7){
                        if(b[cpx+1][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                            if ( (b[cpx+1][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx+1);
                                b[x][y].CoupsPossibles.add(cpy+1);
                            }  
                        }
                    }
                }
                break;
            case 2: // tour - pareil pour blanc ou noir
                //check gauche
                bool = true;
                cpx = x;
                cpy -= 1;
                while( (cpy>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                    if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        cpy -= 1;
                    }  
                }
                //check haut
                bool = true;
                cpx = x-1;
                cpy = y;
                while( (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                    if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        cpx -= 1;
                    }  
                }
                //check droit
                bool = true;
                cpx = x;
                cpy = y+1;
                while( (cpy<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                    if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        cpy += 1;
                    }  
                }
                //check bas
                bool = true;
                cpx = x+1;
                cpy = y;
                while( (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                    if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        cpx += 1;
                    }  
                }
            break;
            case 3: // fou
            //check haut gauche
            bool = true;
            
            cpx -= 1;
            cpy -= 1;
            while( (cpy>=0) && (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx -= 1;
                    cpy -= 1;
                }  
            }
            //check haut droite
            bool = true;
            cpx =x; //5
            cpy =y; //0
            cpx -= 1; // 4
            cpy += 1; // 1
            while( (cpy<=7) && (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx -= 1;
                    cpy += 1;
                }  
            }
            //check bas droit
            bool = true;
            cpx =x;
            cpy =y;
            cpx += 1;
            cpy += 1;
            while( (cpy<=7) && (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx += 1;
                    cpy += 1;
                }  
            }
            //check bas gauche
            bool = true;
            cpx =x;
            cpy =y;
            cpx += 1;
            cpy -= 1;
            while( (cpy>=0) && (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx += 1;
                    cpy -= 1;
                }  
            }
            break;
            
            case 4: // cheval
                //HG
                cpx = x;
                cpy = y;
                if (cpx-2>=0 && cpy-1>=0){
                    if(b[cpx-2][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-2][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-2);
                            b[x][y].CoupsPossibles.add(cpy-1);
                            bool = false;
                        } else {
                            bool = false;
                        }   
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-2);
                        b[x][y].CoupsPossibles.add(cpy-1);
                    }
                }
                //HD
                if (cpx-2>=0 && cpy+1<=7){
                    if(b[cpx-2][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-2][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-2);
                            b[x][y].CoupsPossibles.add(cpy+1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-2);
                        b[x][y].CoupsPossibles.add(cpy+1);
                    }
                }
                //DH
                if (cpx-1>=0 && cpy+2<=7){
                    if(b[cpx-1][cpy+2].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-1][cpy+2].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-1);
                            b[x][y].CoupsPossibles.add(cpy+2);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-1);
                        b[x][y].CoupsPossibles.add(cpy+2);
                    }
                }
                //DB
                if (cpx+1<=7 && cpy+2<=7){
                    if(b[cpx+1][cpy+2].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+1][cpy+2].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy+2);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+1);
                        b[x][y].CoupsPossibles.add(cpy+2);
                    }
                }
                //BD
                if (cpx+2<=7 && cpy+1<=7){
                    if(b[cpx+2][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+2][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+2);
                            b[x][y].CoupsPossibles.add(cpy+1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+2);
                        b[x][y].CoupsPossibles.add(cpy+1);
                    }
                }
                //BG
                if (cpx+2<=7 && cpy-1>=0){
                    if(b[cpx+2][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+2][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+2);
                            b[x][y].CoupsPossibles.add(cpy-1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+2);
                        b[x][y].CoupsPossibles.add(cpy-1);
                    }
                }
                //GB
                if (cpx+1<=7 && cpy-2>=0){
                    if(b[cpx+1][cpy-2].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+1][cpy-2].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy-2);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+1);
                        b[x][y].CoupsPossibles.add(cpy-2);
                    }
                }
                //GH
                if (cpx-1>=0 && cpy-2>=0){
                    if(b[cpx-1][cpy-2].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-1][cpy-2].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-1);
                            b[x][y].CoupsPossibles.add(cpy-2);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-1);
                        b[x][y].CoupsPossibles.add(cpy-2);
                    }
                }
                break;
            case 5: // reine
            //check gauche
            bool = true;
            cpx = x;
            cpy = y;
            cpy -= 1;
            while( (cpy>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpy -= 1;
                }  
            }
            //check haut
            bool = true;
            cpx = x-1;
            cpy = y;
            while( (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx -= 1;
                }  
            }
            //check droit
            bool = true;
            cpx = x;
            cpy = y+1;
            while( (cpy<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpy += 1;
                }  
            }
            //check bas
            bool = true;
            cpx = x+1;
            cpy = y;
            while( (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
                if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                    if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy);
                        bool = false;
                    } else {
                        bool = false;
                    }
                } else { // sinon on peux l'ajouter
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    cpx += 1;
                }  
            }
            //check haut gauche
        bool = true;
        cpx=x;
        cpy=y;
        cpx -= 1;
        cpy -= 1;
        while( (cpy>=0) && (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
            if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    bool = false;
                } else {
                    bool = false;
                }
            } else { // sinon on peux l'ajouter
                b[x][y].CoupsPossibles.add(cpx);
                b[x][y].CoupsPossibles.add(cpy);
                cpx -= 1;
                cpy -= 1;
            }  
        }
        //check haut droite
        bool = true;
        cpx=x;
        cpy=y;
        cpx -= 1;
        cpy += 1;
        while( (cpy<=7) && (cpx>=0) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
            if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    bool = false;
                } else {
                    bool = false;
                }
            } else { // sinon on peux l'ajouter
                b[x][y].CoupsPossibles.add(cpx);
                b[x][y].CoupsPossibles.add(cpy);
                cpx -= 1;
                cpy += 1;
            }  
        }
        //check bas droit
        bool = true;
        cpx=x;
        cpy=y;
        cpx += 1;
        cpy += 1;
        while( (cpy<=7) && (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
            if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    bool = false;
                } else {
                    bool = false;
                }
            } else { // sinon on peux l'ajouter
                b[x][y].CoupsPossibles.add(cpx);
                b[x][y].CoupsPossibles.add(cpy);
                cpx += 1;
                cpy += 1;
            }  
        }
        //check bas gauche
        bool = true;
        cpx=x;
        cpy=y;
        cpx += 1;
        cpy -= 1;
        while( (cpy>=0) && (cpx<=7) && (bool)){ //tant que tu ne sors pas du board et que tu ne touche pas un ally
            if(b[cpx][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                if ( (b[cpx][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                    b[x][y].CoupsPossibles.add(cpx);
                    b[x][y].CoupsPossibles.add(cpy);
                    bool = false;
                } else {
                    bool = false;
                }
            } else { // sinon on peux l'ajouter
                b[x][y].CoupsPossibles.add(cpx);
                b[x][y].CoupsPossibles.add(cpy);
                cpx += 1;
                cpy -= 1;
            }  
        }
            
                break;
            case 6: // roi
                //HG
                cpx =x;
                cpy =y;
                if (cpx-1>=0 && cpy-1>=0){
                    if(b[cpx-1][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-1][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-1);
                            b[x][y].CoupsPossibles.add(cpy-1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-1);
                        b[x][y].CoupsPossibles.add(cpy-1);
                    }
                }
                //H
                if (cpx-1>=0){
                    if(b[cpx-1][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-1][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx-1);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-1);
                        b[x][y].CoupsPossibles.add(cpy);
                    }
                }
                //HD
                if (cpx-1>=0 && cpy+1<=7){
                    if(b[cpx-1][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx-1][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                                b[x][y].CoupsPossibles.add(cpx-1);
                                b[x][y].CoupsPossibles.add(cpy+1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx-1);
                        b[x][y].CoupsPossibles.add(cpy+1);
                    }
                }
                //DD
                if (cpy+1<=7){
                    if(b[cpx][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy+1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy+1);
                    }
                }
                //DB
                if (cpx+1<=7 && cpy+1<=7){
                    if(b[cpx+1][cpy+1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+1][cpy+1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy+1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+1);
                        b[x][y].CoupsPossibles.add(cpy+1);
                    }
                }
                //BB
                if (cpx+1<=7){
                    if(b[cpx+1][cpy].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+1][cpy].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+1);
                        b[x][y].CoupsPossibles.add(cpy);
                    }
                }
                //BG
                if (cpx+1<=7 && cpy-1>=0){
                    if(b[cpx+1][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx+1][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx+1);
                            b[x][y].CoupsPossibles.add(cpy-1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx+1);
                        b[x][y].CoupsPossibles.add(cpy-1);
                    }
                }
                //GG
                if (cpy-1>=0){
                    if(b[cpx][cpy-1].getType() != 0){ //si ce n'est pas une piece vide alors on peux recup sa couleur
                        if ( (b[cpx][cpy-1].getIsWhite() != couleur)){ // si la couleur est différente alors on add et on stop
                            b[x][y].CoupsPossibles.add(cpx);
                            b[x][y].CoupsPossibles.add(cpy-1);
                            bool = false;
                        } else {
                            bool = false;
                        }
                        
                    } else { // sinon on peux l'ajouter
                        b[x][y].CoupsPossibles.add(cpx);
                        b[x][y].CoupsPossibles.add(cpy-1);
                    }
                }
                break;
        }
    }
}