package com.example.mapa_option;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MapaView extends View {
    private Paint paint;
    private Mapa[] mapas;

    public MapaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();

        // Definir algunas áreas en el mapa
        mapas = new Mapa[] {
                new Mapa(50, 1800, 600, 200, "Galería I"),
                new Mapa(50, 1300, 200, 500, "Galería II"),
                new Mapa(250, 1300, 400, 200, "Galería III"),
                new Mapa(800, 1500, 200, 500, "Galería IV"),
                new Mapa(800, 1300, 200, 200, "Galería V")
        };

        // Imprimir los vértices de cada polígono en el log
        for (Mapa mapa : mapas) {
            List<PointF> vertices = mapa.getVertices();
            StringBuilder verticesStr = new StringBuilder("Vértices de " + mapa.getName() + ": ");
            for (PointF vertex : vertices) {
                verticesStr.append("(").append(vertex.x).append(", ").append(vertex.y).append(") ");
            }
            Log.d("MapaView", verticesStr.toString());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibujar cada área del mapa
        for (Mapa mapa : mapas) {
            mapa.draw(canvas, paint);
        }
    }
}