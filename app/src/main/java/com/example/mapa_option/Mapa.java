package com.example.mapa_option;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private float x;
    private float y;
    private float width;
    private float height;
    private String name;

    public Mapa(float x, float y, float width, float height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void draw(Canvas canvas, Paint paint) {
        // Dibujar el área del mapa (rectángulo)
        paint.setColor(Color.LTGRAY); // Color del rectángulo
        canvas.drawRect(x, y, x + width, y + height, paint);

        // Dibujar el nombre del área
        paint.setTextSize(40);
        paint.setColor(Color.RED); // Color del texto
        canvas.drawText(name, x + 20, y + 100, paint);
    }

    public List<PointF> getVertices() {
        List<PointF> vertices = new ArrayList<>();
        vertices.add(new PointF(x, y));
        vertices.add(new PointF(x + width, y));
        vertices.add(new PointF(x + width, y + height));
        vertices.add(new PointF(x, y + height));
        return vertices;
    }
}
