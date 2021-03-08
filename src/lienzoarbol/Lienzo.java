package lienzoarbol;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import javax.swing.JPanel;
import logica.Arbol;
import logica.Nodo;


public class Lienzo extends JPanel {
    private Arbol objArbol;
    public static final int DIAMETRO = 35;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 60;

    public void setObjArbol(Arbol objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        pintar(g, getWidth() / 2, 20, objArbol.getRaiz());
    }
    
    private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.getElemento().toString(), x + 15, y + 15);
            if (n.getIzquierda  ()!=null)
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            if (n.getDerecha    ()!=null)
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            pintar  (g, x - ANCHO - EXTRA, y + ANCHO, n.getIzquierda());
            pintar  (g, x + ANCHO + EXTRA, y + ANCHO, n.getDerecha());
        }
    }
}
