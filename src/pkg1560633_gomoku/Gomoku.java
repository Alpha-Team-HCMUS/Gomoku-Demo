/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1560633_gomoku;

import java.util.Scanner;

/**
 *
 * @author Doan Minh Tuan
 */
public class Gomoku {
    int nRow;
    int nCol;
    char[][] gameMap;
    
    /*  
    ** Constructor Gomoku
    *** Init nRow, nCol
    *** Generate gameMap
    */
    public Gomoku(){
        
    }
    public Gomoku(int m, int n){
        if(m < 9 || n < 9){
            this.nCol = 9;
            this.nRow = 9;
        }
        else{
            this.nCol = n;
            this.nRow = m;    
        }
        gameMap = new char[this.nRow][this.nCol];
        for(int i = 0 ; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                gameMap[i][j] = '.';
            }
        }
    }
    
    public void display(){
        for(int i = -1; i < this.nRow; i++){
            if(i == -1){
                for(int j = -1; j < this.nCol; j++){
                    if(j == -1){
                        System.out.print(" \t");
                    }
                    else{
                        System.out.print(String.format("%d\t", j));
                    }
                }
            }
            else{
                for(int j = -1; j < this.nCol; j++){
                    if(j == -1){
                        System.out.print(String.format("%d\t", i));
                    }
                    else{
                        System.out.print(String.format("%c\t", gameMap[i][j]));
                    }
                }
            }
            System.out.println();
        }
    }
    
    public void gameStart(){
        int flag = 0;
        int x = 0, y = 0;
        String strBuffer;
        Scanner idv = new Scanner(System.in);
        int whoWin;
        while(true){
            this.display();
            if(flag == 0){
                //Turn of Player X
                System.out.print("Nguoi choi X di (so dong, so cot): ");
                strBuffer = idv.nextLine();
                String[] n = strBuffer.split(" ");
                try{
                    x = Integer.parseInt(n[0]);
                    y = Integer.parseInt(n[1]);
                }
                catch(Exception e){
                    x = 0;
                    y = 0;
                }
                
                //Put X into gameMap
                if(pushGame(flag,x,y) == true){
                    if(gameWin(flag) == true){
                        whoWin = 0;
                        this.display();
                        break;
                    }
                    flag = 1;
                }
                else{
                    flag = 0;
                }
            }
            else if(flag == 1){
                //Turn of Player Y
                System.out.print("Nguoi choi Y di (so dong, so cot): ");
                strBuffer = idv.nextLine();
                String[] n = strBuffer.split(" ");
                try{
                    x = Integer.parseInt(n[0]);
                    y = Integer.parseInt(n[1]);
                }
                catch(Exception e){
                    x = 0;
                    y = 0;
                }
                
                //Put X into gameMap
                if(pushGame(flag,x,y) == true){
                    if(gameWin(flag) == true){
                        whoWin = 1;
                        this.display();
                        break;
                    }
                    flag = 0;
                }
                else{
                    flag = 1;
                }
                
            }
        }
        
        if(whoWin == 0){
            System.out.print("Player X win");
        }
        else{
            System.out.print("Player O win");
        }
    }
    
    public boolean pushGame(int flag, int x, int y){
        if(gameMap[x][y] != '.'){
            return false;
        }
        else{
            if(flag == 0){
                gameMap[x][y] = 'x';
            }
            else{
                gameMap[x][y] = 'o';
            }
            return true;
        }
    }
    
    public boolean hasHorizontalWin(int flag){
        int count = 0;
        char player;
        if(flag == 0){
            player = 'x';
        }
        else{
            player = 'y';
        }
        boolean isWinner = false;
        for (int row = 0; row < gameMap.length; row++) {
            for (int column = 0; column < gameMap[row].length; column++) {
                if (gameMap[row][column] == player && count < 5)
                    count++;
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner)
                break;
        }
        return isWinner;
    }
    
    public boolean hasVerticalWin(int flag){
        int count = 0;
        char player;
        if(flag == 0){
            player = 'x';
        }
        else{
            player = 'y';
        }
        boolean isWinner = false;
        for (int col = 0; col < gameMap[0].length; col++) {
            for (int row = 0; row < gameMap.length; row++) {
                if (gameMap[row][col] == player && count < 5)
                    count++;
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner)
                break;
        }
        return isWinner;
    }
    
    public boolean hasDiagonal1Win(int flag){
        int count = 0;
        char player;
        if(flag == 0){
            player = 'x';
        }
        else{
            player = 'y';
        }
        boolean isWinner = false;
        for(int j = 0; j < gameMap[0].length; j++){
            for(int i = 0, t = j; i < gameMap.length && t < gameMap[i].length; i++, t++){
                if(gameMap[i][t] == player && count < 5){
                    count++;
                }
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner)
            {
                return isWinner;
            }
        }
        for(int i = 1; i < gameMap.length; i++){
            for(int t = i, j = 0; t < gameMap.length && j < gameMap[0].length;t++,j++){
                if(gameMap[t][j] == player && count < 5){
                    count++;
                }
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner){
                break;
            }
        }
        return isWinner;
    }
    
    public boolean hasDiagonal2Win(int flag){
        int count = 0;
        char player;
        if(flag == 0){
            player = 'x';
        }
        else{
            player = 'y';
        }
        boolean isWinner = false;
        for(int j = gameMap[0].length - 1; j >= 0; j--){
            for(int i = 0, t = j; i < gameMap.length && t >= 0; i++, t--){
                if(gameMap[i][t] == player && count < 5){
                    count++;
                }
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner)
            {
                return isWinner;
            }
        }
        for(int i = 1; i < gameMap.length; i++){
            for(int t = i, j = gameMap[0].length - 1; t < gameMap.length && j >= 0;t++,j--){
                if(gameMap[t][j] == player && count < 5){
                    count++;
                }
                else if(count == 5){
                    isWinner = true;
                    break;
                }
                else{
                    isWinner = false;
                    count = 0;
                }
            }
            if(isWinner){
                break;
            }
        }
        return isWinner;
    }
    
    public boolean gameWin(int flag){
        if(this.hasVerticalWin(flag) || this.hasHorizontalWin(flag) || this.hasDiagonal1Win(flag) || this.hasDiagonal2Win(flag)){
            return true;
        }
        return false;
    }
}
