/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.areadina.binarytreesocket;

import com.areadina.binarytreesocket.model.Node;

/**
 *
 * @author mejia
 */
public class BinaryTree {
        private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void Insert(int value) {
        root = InsertRecord(root, value);
    }

    private Node InsertRecord(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.getValue()) {
            root.setLeft(InsertRecord(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(InsertRecord(root.getRight(), value));
        }
        return root;
    }
    
      public void inordern() {
        inordern(this.getRoot());
    }

    private void inordern(Node node) {
        if (node != null) {
            inordern(node.getLeft());
            System.out.print(node.getValue() + " ");
            inordern(node.getRight());
        }
    }
}
