package Model;


import Model.Pieces.*;

import javax.swing.*;
import java.util.Random;

public class Board {
    Piece[][] pieces;
    Piece[][] piecesBack;
    private Piece[] shuffle;
    private Piece[] shuffle1;

    /**
     * constructor of Board
     */
    public Board() {
        piecesBack=new Piece[8][10];
        pieces = new Piece[8][10];
        this.shuffle = new Piece[30];
        this.shuffle1 = new Piece[30];

        this.Initialize_Board();
    }

    /**
     * @return the piece that i create
     */
    public Piece[][] getPieces() {

        return this.pieces;
    }

    /**
     * initialize the board for the blue and red images
     */
    public void Initialize_Board() {
        int i;


          this.shuffle[0]= new Dragon(Color.BLUE,"/images/bluePieces/dragonB.png",10);
          shuffle[1] = new Mage(Color.BLUE, "/images/bluePieces/mageB.png",9);
          shuffle[2] = new Knight(Color.BLUE, "/images/bluePieces/knightB.png",8);
          shuffle[3] = new Knight(Color.BLUE, "/images/bluePieces/knightB.png",8);
          shuffle[4] = new BeastRider(Color.BLUE, "/images/bluePieces/beastRiderB.png",7);
          shuffle[5] = new BeastRider(Color.BLUE, "/images/bluePieces/beastRiderB.png",7);
          shuffle[6] = new BeastRider(Color.BLUE, "/images/bluePieces/beastRiderB.png",7);
          shuffle[7] = new Sorceress(Color.BLUE, "/images/bluePieces/sorceressB.png",6);
          shuffle[8] = new Sorceress(Color.BLUE, "/images/bluePieces/sorceressB.png",6);
          shuffle[9] = new LavaBeast(Color.BLUE, "/images/bluePieces/yeti.png",5);
          shuffle[10] = new LavaBeast(Color.BLUE, "/images/bluePieces/yeti.png",5);
          shuffle[11] = new Elf(Color.BLUE, "/images/bluePieces/elfB.png",4);
          shuffle[12] = new Elf(Color.BLUE, "/images/bluePieces/elfB.png",4);
        shuffle[13] = new Dwarf(Color.BLUE, "/images/bluePieces/dwarfB.png",3);
        shuffle[14] = new Dwarf(Color.BLUE, "/images/bluePieces/dwarfB.png",3);
        shuffle[15] = new Dwarf(Color.BLUE, "/images/bluePieces/dwarfB.png",3);
        shuffle[16] = new Dwarf(Color.BLUE, "/images/bluePieces/dwarfB.png",3);
        shuffle[17] = new Dwarf(Color.BLUE, "/images/bluePieces/dwarfB.png",3);
        shuffle[18] = new Scout(Color.BLUE, "/images/bluePieces/scoutB.png",2);
        shuffle[19] = new Scout(Color.BLUE, "/images/bluePieces/scoutB.png",2);
        shuffle[20] = new Scout(Color.BLUE, "/images/bluePieces/scoutB.png",2);
        shuffle[21] = new Scout(Color.BLUE, "/images/bluePieces/scoutB.png",2);
        shuffle[22] = new Slayer(Color.BLUE, "/images/bluePieces/slayerB.png",1);
        shuffle[23] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[24] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[25] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[26] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[27] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[28] = new Bomb(Color.BLUE, "/images/bluePieces/trapB.png",11);
        shuffle[29] = new Flag(Color.BLUE, "/images/bluePieces/flagB.png",0);


        Random rand = new Random();
        for (i =shuffle.length-1; i >0; i--) {
            int r =rand.nextInt(i+1);
            Piece temp = shuffle[i];
            shuffle[i] = shuffle[r];
            shuffle[r] = temp;
        }
        int  p=0;
        for(int w=0;w<3;w++){
            for (int a=0; a<10; a++){

                this.pieces[w][a] = this.shuffle[p++];

            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////

        this.shuffle1[0]= new Dragon(Color.RED,"/images/RedPieces/dragonR.png",10);
        shuffle1[1] = new Mage(Color.RED, "/images/RedPieces/mageR.png",9);
        shuffle1[2] = new Knight(Color.RED, "/images/RedPieces/knightR.png",8);
        shuffle1[3] = new Knight(Color.RED, "/images/RedPieces/knightR.png",8);
        shuffle1[4] = new BeastRider(Color.RED, "/images/RedPieces/beastRiderR.png",7);
        shuffle1[5] = new BeastRider(Color.RED, "/images/RedPieces/beastRiderR.png",7);
        shuffle1[6] = new BeastRider(Color.RED, "/images/RedPieces/beastRiderR.png",7);
        shuffle1[7] = new Sorceress(Color.RED, "/images/RedPieces/sorceressR.png",6);
        shuffle1[8] = new Sorceress(Color.RED, "/images/RedPieces/sorceressR.png",6);
        shuffle1[9] = new LavaBeast(Color.RED, "/images/RedPieces/lavaBeast.png",5);
        shuffle1[10] = new LavaBeast(Color.RED, "/images/RedPieces/lavaBeast.png",5);
        shuffle1[11] = new Elf(Color.RED, "/images/RedPieces/elfR.png",4);
        shuffle1[12] = new Elf(Color.RED, "/images/RedPieces/elfR.png",4);
        shuffle1[13] = new Dwarf(Color.RED, "/images/RedPieces/dwarfR.png",3);
        shuffle1[14] = new Dwarf(Color.RED, "/images/RedPieces/dwarfR.png",3);
        shuffle1[15] = new Dwarf(Color.RED, "/images/RedPieces/dwarfR.png",3);
        shuffle1[16] = new Dwarf(Color.RED, "/images/RedPieces/dwarfR.png",3);
        shuffle1[17] = new Dwarf(Color.RED, "/images/RedPieces/dwarfR.png",3);
        shuffle1[18] = new Scout(Color.RED, "/images/RedPieces/scoutB.png",2);
        shuffle1[19] = new Scout(Color.RED, "/images/RedPieces/scoutB.png",2);
        shuffle1[20] = new Scout(Color.RED, "/images/RedPieces/scoutB.png",2);
        shuffle1[21] = new Scout(Color.RED, "/images/RedPieces/scoutB.png",2);
        shuffle1[22] = new Slayer(Color.RED, "/images/RedPieces/slayerR.png",1);
        shuffle1[23] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[24] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[25] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[26] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[27] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[28] = new Bomb(Color.RED, "/images/RedPieces/trapR.png",11);
        shuffle1[29] = new Flag(Color.RED, "/images/RedPieces/flagR.png",0);


        Random rand1= new Random();
        for (i =shuffle1.length-1; i >0; i--) {
            int rr =rand1.nextInt(i+1);
            Piece temp1 = shuffle1[i];
            shuffle1[i] = shuffle1[rr];
            shuffle1[rr] = temp1;
        }
       int  p1=0;
        for(int w=5;w<8;w++){
            for (int a=0; a<10; a++){

            this.pieces[w][a] = this.shuffle1[p1++];


        }
        }


    }
    boolean check=true;

    /**
     *
     * it change the location of the card to the new x,y
     * @param fromx
     * @param fromy
     * @param x
     * @param y
     * @return
     */
    public Piece[][] newLocation(int fromx,int fromy,int x,int y){

            getPieces()[fromx][fromy]=getPieces()[x][y];
            getPieces()[fromx][fromy].setNum(getPieces()[x][y].getNum());
            check=true;

        return this.pieces;
    }

    /**
     *
     * newLocation1 is when you attack i check if the card is beaten or not
     * and if the card attack to the flag you win
     * @param fromx
     * @param fromy
     * @param x
     * @param y
     * @return
     */
    public Piece[][] newLocation1(int fromx,int fromy,int x,int y){
        if(this.getPieces()[fromx][fromy].getNum()==0&&this.getPieces()[fromx][fromy].getColor()==Color.BLUE){
            JFrame f;
                f=new JFrame();
                JOptionPane.showMessageDialog(f,"Player 2 Red wins");

            }else if(this.getPieces()[fromx][fromy].getNum()==0&&this.getPieces()[fromx][fromy].getColor()==Color.RED){
            JFrame f;
            f=new JFrame();
            JOptionPane.showMessageDialog(f,"Player 1 Blue wins");


        }
        if(this.getPieces()[x][y].getNum()==this.getPieces()[fromx][fromy].getNum()){
            getPieces()[fromx][fromy].setImg("/images/bluePieces/white.jfif");
            getPieces()[fromx][fromy].setNum(-1);


        }
        if(this.getPieces()[x][y].getNum()>this.getPieces()[fromx][fromy].getNum()){

            if(this.getPieces()[fromx][fromy].getNum()==3&&this.getPieces()[x][y].getNum()==11){
                getPieces()[x][y] = getPieces()[fromx][fromy];
                check=false;
            }else {
                getPieces()[fromx][fromy] = getPieces()[x][y];
                getPieces()[fromx][fromy].setNum(getPieces()[x][y].getNum());
                check = true;
            }

        }else if(this.getPieces()[x][y].getNum()<this.getPieces()[fromx][fromy].getNum()){

            if(this.getPieces()[x][y].getNum()==1&&this.getPieces()[fromx][fromy].getNum()==10){
                getPieces()[fromx][fromy]=getPieces()[x][y];
                check=true;
            }

           else if(this.getPieces()[x][y].getNum()==3&&this.getPieces()[fromx][fromy].getNum()==11){
                getPieces()[fromx][fromy]=getPieces()[x][y];
                check=true;
            }else {
                getPieces()[x][y] = getPieces()[fromx][fromy];
                getPieces()[x][y].setNum(getPieces()[fromx][fromy].getNum());
                check = false;
            }
        }


        return this.pieces;
    }

    /**
     * @RETURN TRUE OR FALSE IF YOU WIN OR NOT TO SET WHAT COLOR SHOULD THE CARD HAVE TO SET AFTER THE BACK IMAGE
     */
    public boolean newLocationResult(){


        if(check==false){

            check=false;

        }else if(check==true) {

            check=true;
        }
        return check;
    }


}






