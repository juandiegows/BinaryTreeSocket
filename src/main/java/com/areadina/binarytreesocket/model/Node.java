/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.areadina.binarytreesocket.model;

/**
 *
 * @author mejia
 */
public class Node {

    private int valor;
    private Node left, right;

    public Node(int valor) {
        this.valor = valor;
        left = right = null;
    }

    public int getValue() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
