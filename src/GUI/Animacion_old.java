/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGICA.Cliente_anim;
import LOGICA.anim_pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Animacion_old extends JPanel {

    private final int SIZE_WIDTH = 800,
            SIZE_HEIGHT = 600;
    private int time = 0;
    private ArrayList<Cliente_anim> datos;

    public Animacion_old(ArrayList<Cliente_anim> datos) {
        this.datos = datos;
    }

    private Image getScaledImage(String srcImg, int w, int h) {
        ImageIcon imageIcon = new ImageIcon(srcImg); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);

        return newimg;
    }

    public void animar() {

        JFrame v = new JFrame();
        JLabel anuncio_tiempo = new JLabel("Tiempo: ");
        JLabel tiempo = new JLabel();
        JLabel anuncio_llegada = new JLabel("Recien llegados y en espera");
        //JLabel anuncio_llegada = new JLabel("Recien llegados y en espera", new ImageIcon(getScaledImage("IMG/estante.gif", 50, 50)), JLabel.CENTER);
        JLabel anuncio_atencion = new JLabel("", new ImageIcon("IMG/estante.gif"), JLabel.CENTER);

        anuncio_tiempo.setBounds(SIZE_WIDTH - 100, 10, 100, 30);
        tiempo.setBounds(SIZE_WIDTH - 50, 10, 100, 30);
        anuncio_llegada.setBounds(SIZE_WIDTH - 400, 10, 200, 30);
        anuncio_atencion.setBounds(0, 1, 200, 300);

        v.getContentPane().add(anuncio_tiempo);
        v.getContentPane().add(tiempo);
        v.getContentPane().add(anuncio_llegada);
        v.getContentPane().add(anuncio_atencion);
        v.getContentPane().add(this);
        v.pack();
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setVisible(true);

        while (time <= 240) {
            time++;
            tiempo.setText("" + time);
            v.repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
        }
    }

    private void arrive(Graphics g) {
        for (int i = 0; i < datos.size(); i++) {
            Cliente_anim client = datos.get(i);
            if (client.getStatus() == 0 && client.getMinuto_llegada() <= time) {
                g.setColor(client.getColor());
                g.fillOval(client.getX(), client.getY(), 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        client.getSexo() + "",
                        client.getX() + 19,
                        client.getY() + 29);
                break;
            }
        }
    }

    private void serve(Graphics g) {
        for (int i = 0; i < datos.size(); i++) {
            Cliente_anim client = datos.get(i);
            if (client.getStatus() <= 1 && client.getMinuto_atencion()<= time) {
                datos.get(i).setColor(Color.YELLOW);
                client.setX(200);
                datos.get(i).setStatus(1);
                g.setColor(client.getColor());
                g.fillOval(client.getX(), client.getY(), 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        client.getSexo() + "",
                        client.getX() + 19,
                        client.getY() + 29);
                break;
            }
        }
    }

    private void out(Graphics g) {
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getStatus() == 1
                    && datos.get(i).getMinuto_salida()<= time) {

                datos.get(i).setColor(Color.GREEN);
                datos.get(i).setStatus(2);
                // Color de relleno de la bolita
                g.setColor(datos.get(i).getColor());
                g.fillOval(500,
                        500, 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        datos.get(i).getSexo() + "",
                        500 + 19,
                        500 + 29);
                g.setFont(new Font("TimesRoman", Font.BOLD, 12));
                if (datos.get(i).getBebida().size()>0) {
                     g.drawString(
                             "p",
                             500 + 32,
                             500 + 18);
                 }
                 if (datos.get(i).getBebida().size()>0) {
                     g.drawString(
                             "b",
                            500 + 32,
                            500 + 32);
                 }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        arrive(g);
        serve(g);
        out(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SIZE_WIDTH, SIZE_HEIGHT);
    }
}
