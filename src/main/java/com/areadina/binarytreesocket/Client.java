/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.areadina.binarytreesocket;

import com.areadina.binarytreesocket.model.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author mejia
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            Socket socket = new Socket("localhost", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("¡Bienvenido!");

            for (int i = 0; i < 30; i++) {
                int randomNumber = Util.GenerarRandom();
                System.out.println("Cliente: el numero enviado es " + randomNumber);
                out.println(randomNumber);
            }
            
            out.println("Finalizar"); 

            String response = in.readLine(); 

            System.out.println("Programa finalizado" );

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
