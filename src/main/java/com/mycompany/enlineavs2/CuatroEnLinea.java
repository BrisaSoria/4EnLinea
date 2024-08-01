/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.enlineavs2;

import java.util.Scanner;

/**
 *
 * @author soria
 * 
 *  JUEGO 4 EN LINEA
 * 
 *
 */
public class CuatroEnLinea {

     Scanner teclado = new Scanner(System.in);
           
            
     public void jugadas(String Jugador1, String Jugador2, String tablero[][]){
         int j = 0;
         String turno;
         int posicion;
         int posicion2;
         //42 jugadas
         //turno impar para jugador 1, par para jugador 2
         //String turno = jugador 1 o 2
        while(j<42){
            
            if(j % 2 == 0){
                turno = Jugador1;
            }else {
                turno = Jugador2;
            }
         
            System.out.println(" ");
            System.out.println("- "+turno +" ingrese posicion: ");
            posicion = teclado.nextInt();
            if(posicion >=7){                           //si el nº ingresado es mayor a 7 se debe volver a ingresar nº
                System.out.println(" ");
                System.out.println("- Posicion incorrecta, vuelva a intentar");
                if(j % 2 == 0){
                turno = Jugador1;
                    System.out.println(" ");
                    System.out.println("- "+turno +" ingrese posicion: ");              
                    posicion = teclado.nextInt();
                    repetirColumna(posicion, turno,tablero, Jugador1, Jugador2, j); //llama a la funcion repetirColumna() para volver a realizar el tiro
                }else{
                turno = Jugador2;
                        System.out.println(" ");
                        System.out.println("- "+turno +" ingrese posicion: ");
                    posicion = teclado.nextInt();
                    repetirColumna(posicion, turno, tablero, Jugador1, Jugador2, j);
                }
            }else{
                
                if(tablero[0][posicion] == "X" || tablero[0][posicion] == "O"){     //si todas las filas de la columna elegida estan llenas se debe volver a tirar
                    
                    System.out.println(" ");
                    System.out.println("- Ya existe ficha, intente nuevamente: ");
                    posicion2 = teclado.nextInt();
                   
                    //int b = 0;
                    
                    if(tablero[5][posicion2] == "°"){
                                    if(turno == Jugador1){
                                        tablero[5][posicion2] = "X";  //dependiendo del turno se le asigna "X" o "O"
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);  //funciones para verificar si hay ganador, devuelven true
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3 || resultado4){
                                            j=42;                      //si existe ganador se cierra el ciclo. finaliza el juego
                                        }
                                    }else if(turno == Jugador2){
                                        tablero[5][posicion2] = "O";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                      boolean resultado = verificarHorizontal(tablero, turno,j);
                                      boolean resultado2 = verificarVertical(tablero, turno,j);
                                      boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                      boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                    }
                    }else{
                        
                         for(int b=0; b<6; b++){                                           //si no estan llenas de asigna un lugar normalmente
                                if(tablero[b][posicion2] == "X" || tablero[b][posicion2] == "O"){
                                        if(turno == Jugador1){
                                            tablero[b-1][posicion2] = "X";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3 || resultado4){
                                              j=42;
                                            }
                                            break;
                                        }else if(turno == Jugador2){
                                            tablero[b-1][posicion2] = "O";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3 || resultado4 ){
                                              j=42;
                                            }
                                            break;
                                        }
                                }
                            }
                    }
                    
                }else if(tablero[5][posicion] == "°"){
                                    if(turno == Jugador1){
                                        tablero[5][posicion] = "X";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                        
                                    }else if(turno == Jugador2){
                                        tablero[5][posicion] = "O";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                       
                                    }
                        }else{
                        
                             for(int i=0; i<6; i++){
                                if(tablero[i][posicion] == "X" || tablero[i][posicion] == "O"){
                                        if(turno == Jugador1){
                                            tablero[i-1][posicion] = "X";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3  || resultado4 ){
                                             j=42;
                                            }
                                            break;
                                        }else if(turno == Jugador2){
                                            tablero[i-1][posicion] = "O";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3   || resultado4){
                                             j=42;
                                            }
                                            break;
                                        }
                                }
                            }       
                        }
                if(j==41){ // si completaron el tablero de fichas y no hay ganador, es un empate
                    System.out.println("------- EMPATE ---------");
                }
                j++;         
            }  
            
          
        }
        
     }
     
     //método para volver a asignar ficha
     
     public void repetirColumna(int posicion, String turno, String tablero[][],String Jugador1,String Jugador2 , int j){
         
         if(tablero[0][posicion] == "X" || tablero[0][posicion] == "O"){
                    int posicion2;
                    System.out.println("- Ya existe ficha, intente nuevamente: ");
                    posicion2 = teclado.nextInt();
                     
                            
                           if(tablero[5][posicion2] == "°"){
                                    if(turno == Jugador1){
                                        tablero[5][posicion2] = "X";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3   || resultado4){
                                            j=42;
                                        }
                                        
                                    }else if(turno == Jugador2){
                                        tablero[5][posicion2] = "O";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                       
                                    }
                    }else{
                        
                         for(int b=0; b<6; b++){
                                if(tablero[b][posicion2] == "X" || tablero[b][posicion2] == "O"){
                                        if(turno == Jugador1){
                                            tablero[b-1][posicion2] = "X";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3  || resultado4 ){
                                             j=42;
                                            }
                                            break;
                                        }else if(turno == Jugador2){
                                            tablero[b-1][posicion2] = "O";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3  || resultado4 ){
                                             j=42;
                                            }
                                            break;
                                        }
                                }
                         }
                            
                    }
                        
            }else{  
                           
                        if(tablero[5][posicion] == "°"){
                                    if(turno == Jugador1){
                                        tablero[5][posicion] = "X";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                        
                                    }else if(turno == Jugador2){
                                        tablero[5][posicion] = "O";
                                        limpiarPantalla();
                                        imprimirTablero(tablero);
                                        boolean resultado = verificarHorizontal(tablero, turno,j);
                                        boolean resultado2 = verificarVertical(tablero, turno,j);
                                        boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                        boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                        if(resultado || resultado2 || resultado3  || resultado4 ){
                                            j=42;
                                        }
                                        
                                    }
                    }else{
                        
                         for(int i=0; i<6; i++){
                                if(tablero[i][posicion] == "X" || tablero[i][posicion] == "O"){
                                        if(turno == Jugador1){
                                            tablero[i-1][posicion] = "X";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3  || resultado4 ){
                                             j=42;
                                            }
                                            break;
                                        }else if(turno == Jugador2){
                                            tablero[i-1][posicion] = "O";
                                            limpiarPantalla();
                                            imprimirTablero(tablero);
                                            boolean resultado = verificarHorizontal(tablero, turno,j);
                                            boolean resultado2 = verificarVertical(tablero, turno,j);
                                            boolean resultado3 = verificarDiagonal1(tablero, turno,j);
                                            boolean resultado4 = verificarDiagonal2(tablero, turno,j);
                                            if(resultado || resultado2 || resultado3  || resultado4 ){
                                             j=42;
                                            }
                                            break;
                                        }
                                }
                         }
                            
                    }
                  
                }
     }
     
     
     //Métodos para verificar ganadores -horizontal, -vertical, -diagonal
     
     public boolean verificarHorizontal(String tablero[][], String turno, int j){
         for(int i=0; i<6; i++){
             if((tablero[i][0] == "X" && tablero[i][1]=="X" && tablero[i][2]=="X" && tablero[i][3]=="X")|| (tablero[i][0] == "O" && tablero[i][1]=="O" && tablero[i][2]=="O" && tablero[i][3]=="O")){
                 System.out.println("-------------------------------------------------------------------- ");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
                
             }else if((tablero[i][3] == "X" && tablero[i][4]=="X" && tablero[i][5]=="X" && tablero[i][6]=="X")|| (tablero[i][3] == "O" && tablero[i][4]=="O" && tablero[i][5]=="O" && tablero[i][6]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
                 
             }else if((tablero[i][1] == "X" && tablero[i][2]=="X" && tablero[i][3]=="X" && tablero[i][4]=="X")|| (tablero[i][1] == "O" && tablero[i][2]=="O" && tablero[i][3]=="O" && tablero[i][4]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
                 
             }else if((tablero[i][2] == "X" && tablero[i][3]=="X" && tablero[i][4]=="X" && tablero[i][5]=="X")|| (tablero[i][2] == "O" && tablero[i][3]=="O" && tablero[i][4]=="O" && tablero[i][5]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
             }
             
         }
         return false;
     }
     
     public boolean verificarVertical(String tablero[][], String turno, int j){
         for(int i=0; i<7; i++){
             if((tablero[0][i] == "X" && tablero[1][i]=="X" && tablero[2][i]=="X" && tablero[3][i]=="X")|| (tablero[0][i] == "O" && tablero[1][i]=="O" && tablero[2][i]=="O" && tablero[3][i]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
                 
             }else if((tablero[1][i] == "X" && tablero[2][i]=="X" && tablero[3][i]=="X" && tablero[4][i]=="X")|| (tablero[1][i] == "O" && tablero[2][i]=="O" && tablero[3][i]=="O" && tablero[4][i]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
                 
             }else if((tablero[2][i] == "X" && tablero[3][i]=="X" && tablero[4][i]=="X" && tablero[5][i]=="X")|| (tablero[2][i] == "O" && tablero[3][i]=="O" && tablero[4][i]=="O" && tablero[5][i]=="O")){
                 System.out.println("--------------------------------------------------------------------");
                 System.out.println(" ");
                 System.out.println("Felicidades " + turno + " es el GANADOR!!");
                 return true;
             }
         }
         return false;
     }
     
     //verifica ganador en diagonal de derecha a izquierda
     public boolean verificarDiagonal1(String tablero[][], String turno, int j){
         int i=0;
         while(i<1){
         
             if((tablero[5][3]=="X" && tablero[4][4]=="X" && tablero[3][5]=="X" && tablero[2][6]=="X") || (tablero[5][3]=="O" && tablero[4][4]=="O" && tablero[3][5]=="O" && tablero[2][6]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");       
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
              }else if((tablero[5][2]=="X" && tablero[4][3]=="X" && tablero[3][4]=="X" && tablero[2][5]=="X") || (tablero[4][3]=="X" && tablero[3][4]=="X" && tablero[2][5]=="X" && tablero[1][6]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");      
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
               }else if((tablero[5][2]=="O" && tablero[4][3]=="O" && tablero[3][4]=="O" && tablero[2][5]=="O") || (tablero[4][3]=="O" && tablero[3][4]=="O" && tablero[2][5]=="O" && tablero[1][6]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");     
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                }else if((tablero[5][1]=="X" && tablero[4][2]=="X" && tablero[3][3]=="X" && tablero[2][4]=="X") || (tablero[4][2]=="X" && tablero[3][3]=="X" && tablero[2][4]=="X" && tablero[1][5]=="X") || (tablero[3][3]=="X" && tablero[2][4]=="X" && tablero[1][5]=="X" && tablero[0][6]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");    
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                 }else if((tablero[5][1]=="O" && tablero[4][2]=="O" && tablero[3][3]=="O" && tablero[2][4]=="O") || (tablero[4][2]=="O" && tablero[3][3]=="O" && tablero[2][4]=="O" && tablero[1][5]=="O") || (tablero[3][3]=="O" && tablero[2][4]=="O" && tablero[1][5]=="O" && tablero[0][6]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");   
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                  }else if((tablero[5][0]=="X" && tablero[4][1]=="X" && tablero[3][2]=="X" && tablero[2][3]=="X") || (tablero[4][1]=="X" && tablero[3][2]=="X" && tablero[2][3]=="X" && tablero[1][4]=="X") || (tablero[3][2]=="X" && tablero[2][3]=="X" && tablero[1][4]=="X" && tablero[0][5]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");  
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                   }else if((tablero[5][0]=="O" && tablero[4][1]=="O" && tablero[3][2]=="O" && tablero[2][3]=="O") || (tablero[4][1]=="O" && tablero[3][2]=="O" && tablero[2][3]=="O" && tablero[1][4]=="O") || (tablero[3][2]=="O" && tablero[2][3]=="O" && tablero[1][4]=="O" && tablero[0][5]=="O")){
                       System.out.println("--------------------------------------------------------------------");
                       System.out.println(" "); 
                       System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[4][0]=="X" && tablero[3][1]=="X" && tablero[2][2]=="X" && tablero[1][3]=="X") || (tablero[3][1]=="X" && tablero[2][2]=="X" && tablero[1][3]=="X" && tablero[0][4]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[4][0]=="O" && tablero[3][1]=="O" && tablero[2][2]=="O" && tablero[1][3]=="O") || (tablero[3][1]=="O" && tablero[2][2]=="O" && tablero[1][3]=="O" && tablero[0][4]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[3][0]=="X" && tablero[2][1]=="X" && tablero[1][2]=="X" && tablero[0][3]=="X") || (tablero[3][0]=="O" && tablero[2][1]=="O" && tablero[1][2]=="O" && tablero[0][3]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }
            i++;
         }
         return false;
     }
     
     
     //verifica ganador diagonal de izquierda a derecha
     public boolean verificarDiagonal2(String tablero[][], String turno, int j){
         int i=0;
         while(i<1){
         if((tablero[2][0]=="X" && tablero[3][1]=="X" && tablero[4][2]=="X" && tablero[5][3]=="X") || (tablero[2][0]=="O" && tablero[3][1]=="O" && tablero[4][2]=="O" && tablero[5][3]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");           
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
         }else if((tablero[1][0]=="X" && tablero[2][1]=="X" && tablero[3][2]=="X" && tablero[4][3]=="X") || (tablero[2][1]=="X" && tablero[3][2]=="X" && tablero[4][3]=="X" && tablero[5][4]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");           
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
            }else if((tablero[1][0]=="O" && tablero[2][1]=="O" && tablero[3][2]=="O" && tablero[4][3]=="O") || (tablero[2][1]=="O" && tablero[3][2]=="O" && tablero[4][3]=="O" && tablero[5][4]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");        
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
              }else if((tablero[0][0]=="X" && tablero[1][1]=="X" && tablero[2][2]=="X" && tablero[3][3]=="X") || (tablero[1][1]=="X" && tablero[2][2]=="X" && tablero[3][3]=="X" && tablero[4][4]=="X") || (tablero[2][2]=="X" && tablero[3][3]=="X" && tablero[4][4]=="X" && tablero[5][5]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");   
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                }else if((tablero[0][0]=="O" && tablero[1][1]=="O" && tablero[2][2]=="O" && tablero[3][3]=="O") || (tablero[1][1]=="O" && tablero[2][2]=="O" && tablero[3][3]=="O" && tablero[4][4]=="O") || (tablero[2][2]=="O" && tablero[3][3]=="O" && tablero[4][4]=="O" && tablero[5][5]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");    
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                  }else if((tablero[0][1]=="X" && tablero[1][2]=="X" && tablero[2][3]=="X" && tablero[3][4]=="X") || (tablero[1][2]=="X" && tablero[2][3]=="X" && tablero[3][4]=="X" && tablero[4][5]=="X") || (tablero[2][3]=="X" && tablero[3][4]=="X" && tablero[4][5]=="X" && tablero[5][6]=="X")){
                         System.out.println("--------------------------------------------------------------------");
                         System.out.println(" ");  
                         System.out.println("Felicidades " + turno + " es el GANADOR!!");
                         i++;
                        return true;
                    }else  if((tablero[0][1]=="O" && tablero[1][2]=="O" && tablero[2][3]=="O" && tablero[3][4]=="O") || (tablero[1][2]=="O" && tablero[2][3]=="O" && tablero[3][4]=="O" && tablero[4][5]=="O") || (tablero[2][3]=="O" && tablero[3][4]=="O" && tablero[4][5]=="O" && tablero[5][6]=="O")){
                        System.out.println("-------------------------------------------------------------------- ");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[0][2]=="X" && tablero[1][3]=="X" && tablero[2][4]=="X" && tablero[3][5]=="X") || (tablero[1][3]=="X" && tablero[2][4]=="X" && tablero[3][5]=="X" && tablero[5][6]=="X")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[0][2]=="O" && tablero[1][3]=="O" && tablero[2][4]=="O" && tablero[3][5]=="O") || (tablero[1][3]=="O" && tablero[2][4]=="O" && tablero[3][5]=="O" && tablero[5][6]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }else if((tablero[0][3]=="X" && tablero[1][4]=="X" && tablero[2][5]=="X" && tablero[3][6]=="X") || (tablero[0][3]=="O" && tablero[1][4]=="O" && tablero[2][5]=="O" && tablero[3][6]=="O")){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Felicidades " + turno + " es el GANADOR!!");
                        i++;
                        return true;
                    }
              i++;
         }
         return false;
     }
     
     public void limpiarPantalla(){
         int x = 0;
         while(x<100){
             System.out.println(" ");
             x++;
         }
     }
     
     //asinga valor a los null de la matriz
     public void llenarTablero(String tablero[][]){
         for(int x=0; x<6; x++){
             for(int y=0; y<7; y++){
                 if(tablero[x][y] == null){
                     tablero[x][y] = "°";
                 }
             }
         }
     }
       

     public void imprimirTablero(String tablero[][]){
        
        System.out.println(" ");
         System.out.println("\t"+"   " +"0" + "\t" +"   " + "1" + "\t" +"   " + "2"+ "\t" +"   " + "3" + "\t" +"   " + "4" + "\t" +"   " + "5" + "\t" +"   " + "6");
        
             for(int f=0; f<6; f++){
                 System.out.println();
                 //System.out.print( f  );
                 System.out.print("\t");
                 for(int c=0; c<7; c++){
                     System.out.print("| " + tablero[f][c] + "\t");
                 }
                 System.out.print(" |\n");
                 
             }
    }
     
    public static void main(String[] args) {
        int seguir = 1; //Se juega mientras sea 1
        while(seguir == 1){
            Scanner teclado = new Scanner(System.in);
            CuatroEnLinea iniciar = new CuatroEnLinea();
            String tablero[][] = new String[6][7];
            String Jugador1 , Jugador2;
            System.out.println("--------------- 4 EN LINEA ---------------");
            System.out.println(" ");
            System.out.println(" 4 en linea se juega de a dos jugadores sobre un tablero de siete columnas y seis filas." +" \n "+
                                "El objetivo es alinear cuatro fichas de un mismo jugador, horizontalmente, verticalmente o en diagonal.");
            System.out.println(" ");
            System.out.println("Ingresar nombre del Jugador 1: ");
            Jugador1 = teclado.next();
            System.out.println(" ");
            System.out.println("Ingresar nombre del Jugador 2: ");
            Jugador2 = teclado.next();
            
            iniciar.llenarTablero(tablero);
            iniciar.imprimirTablero(tablero);
            
            iniciar.jugadas(Jugador1, Jugador2, tablero);
            System.out.println(" ");
            System.out.println("-------------------------------------------------------------------- ");
            System.out.println(" ");
            System.out.println("Presione 1 para seguir jugando");
            System.out.println("Presione 0 para finalizar");
            seguir = teclado.nextInt();
        }
    }
    
}
