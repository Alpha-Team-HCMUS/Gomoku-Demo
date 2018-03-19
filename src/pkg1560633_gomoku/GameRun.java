/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1560633_gomoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg1560633_gomoku.Gomoku;

/**
 *
 * @author Doan Minh Tuan
 */
public class GameRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
        int nRow;
        int nCol;
        String strBuffer;
        Scanner idv = new Scanner(System.in);
        System.out.print("Nhap so dong toi da, so cot: ");
        strBuffer = idv.nextLine();
        String[] n = strBuffer.split(" ");
        try{
            nRow = Integer.parseInt(n[0]);
            nCol = Integer.parseInt(n[1]);
        }
        catch(NumberFormatException e){
            System.out.println(e);
            return;
        }
        
        
        Gomoku newGame = new Gomoku(nRow,nCol);
        
        System.out.print("Bat dau choi (Y/N): ");
        strBuffer = idv.next();
        if(strBuffer.compareTo("Y") == 0){
            newGame.gameStart();
        } 
        else {
            System.out.print("Thoat game");
        }
    }
}
