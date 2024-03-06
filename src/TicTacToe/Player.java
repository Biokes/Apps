package TicTacToe;

import java.util.Scanner;

public class Player {
    private String name;
    public Player(String name){
        this.name = name;
    }
    private static int id =1;
    private Scanner input = new Scanner(System.in);
    private String name(){
        return this.name;
    }
    public int playGame() {
        System.out.println(""+name()+ " Enter where you want to play: ");
        int  choice =  input.nextInt();
        return choice;
    }



}
