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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mejia
 */
public class Server {

    public static final int MAX_DESACIERTOS = 3;
    public static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String value;
                while ((value = in.readLine()) != null) { // Lee números del cliente hasta que reciba la señal de finalización
                    if (value.equalsIgnoreCase("Finalizar")) {
                        System.out.println("Cliente ha finalizado el envio de numeros");
                        System.out.println("-----------------------------------------");
                        System.out.println("----------- mostrar binario -------------");
                        System.out.println("-----------------------------------------");
                        Server.binaryTree.inordern();
                        out.println("¡Gracias por los números!"); // Envía una respuesta final al cliente
                        break;
                    } else if (!Util.IsNumber(value)) {
                        System.out.println("Servidor finaliza");
                        out.println("Finalizar");
                        break;
                    }

                    int num = Integer.parseInt(value);
                    binaryTree.Insert(num);
                    out.println("Recibido");
                }

                out.close();
                in.close();
                clientSocket.close();

                if (value.equalsIgnoreCase("Finalizar")) { // Sale del bucle principal si se recibe "Finalizar"
                    break;
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
