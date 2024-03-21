/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.areadina.binarytreesocket;

/**
 *
 * @author mejia
 */
public class BinaryTreeSocket {

    public static void main(String[] args) {
        BinaryTreeSocket.iniciarServidor();
        BinaryTreeSocket.iniciarCliente();
    }

    public static void iniciarServidor() {
        Thread serverThread = new Thread(() -> Server.main(null));
        serverThread.start();
    }

    public static void iniciarCliente() {
        Thread clientThread = new Thread(() -> Client.main(null));
        clientThread.start();
    }
}
