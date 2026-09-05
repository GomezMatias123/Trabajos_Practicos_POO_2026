import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Clase creada para probar la clase JPanel de la libreria de java para crear un panel dinamico
 * para la clase CreadorFiguras.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class PanelDibujo extends JPanel 
{
    private ArrayList<Circulo> circulos;
    private ArrayList<Rectangulo> rectangulos;

    public PanelDibujo(ArrayList<Circulo> circulos, ArrayList<Rectangulo> rectangulos) {
        this.circulos = circulos;
        this.rectangulos = rectangulos;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        int origenX = anchoPanel / 2;
        int origenY = altoPanel / 2;

        // Ejes cartesianos
        g2.setColor(Color.BLACK);
        g2.drawLine(0, origenY, anchoPanel, origenY); // eje X
        g2.drawLine(origenX, 0, origenX, altoPanel);  // eje Y
        int intervalo = 50; // cada cuántos píxeles poner un número

        // Marcas en el eje X
        for (int i = -origenX; i < anchoPanel - origenX; i += intervalo) {
            if (i == 0) continue; // no repetir el 0
            int x = origenX + i;
            g2.drawLine(x, origenY - 3, x, origenY + 3); // marquita vertical
            g2.drawString(String.valueOf(i), x - 8, origenY + 15);
        }
        
        // Marcas en el eje Y
        for (int j = -origenY; j < altoPanel - origenY; j += intervalo) {
            if (j == 0) continue;
            int y = origenY - j; 
            g2.drawLine(origenX - 3, y, origenX + 3, y);
            g2.drawString(String.valueOf(j), origenX + 6, y + 4);
        }
        
        // El "0" en el origen
        g2.drawString("0", origenX + 6, origenY + 15);
        
        // Círculos
        for (int i = 0; i < circulos.size(); i++) {
            Circulo c = circulos.get(i);
            int px = origenX + (int) c.getCentro().getX();
            int py = origenY - (int) c.getCentro().getY(); 
            int r = (int) c.getRadio();
            
            g2.setColor(Color.BLACK);
            g2.fillOval(px - 3, py - 3, 6, 6);
            
            
            g2.setColor(Color.BLUE);
            g2.drawOval(px - r, py - r, r * 2, r * 2);
        }
        
        //Rectangulos
        for (int i = 0; i < rectangulos.size(); i++) {
            Rectangulo r = rectangulos.get(i);
            
            double ox = r.getOrigen().getX();
            double oy = r.getOrigen().getY();
            double ancho = r.getAncho();
            double alto = r.getAlto();
        
            int px = origenX + (int) ox;
            int py = origenY - (int) (oy + alto);
        
            int origenScreenX = origenX + (int) ox;
            int origenScreenY = origenY - (int) oy;
            g2.setColor(Color.BLACK);
            g2.fillOval(origenScreenX - 3, origenScreenY - 3, 6, 6);
        
            g2.setColor(Color.RED);
            g2.drawRect(px, py, (int) ancho, (int) alto);
        }
    }
}