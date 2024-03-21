/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.areadina.binarytreesocket.model;

import java.util.Random;

/**
 *
 * @author mejia
 */
public class Util {

    public static int GenerarRandom() {
        return new Random().nextInt(10,99);
    }

    public static boolean IsNumber(String texto) {
        try {
            Integer.parseInt(texto);
            return true; // Si no lanza una excepción, es un número
        } catch (NumberFormatException e) {
            return false; // Si lanza una excepción, no es un número
        }
    }
}
