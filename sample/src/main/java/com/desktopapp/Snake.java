package com.desktopapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Snake {
    private final ObservableList<Rectangle> body;
    private final int size; // Tamanho de cada segmento da cobra

    public Snake(int segmentSize) {
        this.body = FXCollections.observableArrayList();
        this.size = segmentSize;

        // Posição inicial da cobra (pode ser ajustada)
        for (int i = 0; i < 5; i++) { // Cria 5 segmentos iniciais
            Rectangle segment = new Rectangle(size, size, Color.GREEN);
            segment.setX(i * size); // Posição X inicial
            segment.setY(0); // Posição Y inicial
            body.add(segment);
        }
    }

    public ObservableList<Rectangle> getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }
}
