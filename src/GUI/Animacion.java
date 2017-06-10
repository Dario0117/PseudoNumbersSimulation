/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGICA.Cliente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Animacion extends JPanel {

    private static ArrayList<Cliente> personas;
    private static final int SIZE_WIDTH = 800,
            SIZE_HEIGHT = 600;
    private static int time = 0;

    public static void main(String[] args) {

        personas = new ArrayList();          // pan   bebida
        personas.add(new Cliente(1, 5, 10, 'M', true, true));
        personas.add(new Cliente(1, 1, 2, 'H', true, true));
        personas.add(new Cliente(2, 4, 7, 'M', false, false));
        personas.add(new Cliente(3, 5, 7, 'H', true, true));
        personas.add(new Cliente(5, 8, 12, 'H', false, true));
        personas.add(new Cliente(6, 8, 14, 'M', true, false));
        personas.add(new Cliente(7, 9, 11, 'H', false, true));
        personas.add(new Cliente(10, 10, 14, 'M', true, true));

        JFrame v = new JFrame();
        Animacion panel = new Animacion();
        JLabel anuncio_tiempo = new JLabel("Tiempo: ");
        JLabel tiempo = new JLabel();
        JLabel anuncio_llegada = new JLabel("Recien llegados y en espera");
        JLabel anuncio_atencion = new JLabel("Siendo atendidos");

        anuncio_tiempo.setBounds(SIZE_WIDTH - 100, 10, 100, 30);
        tiempo.setBounds(SIZE_WIDTH - 50, 10, 100, 30);
        anuncio_llegada.setBounds(SIZE_WIDTH - 400, 10, 200, 30);
        anuncio_atencion.setBounds(10, 10, 100, 30);

        v.getContentPane().add(anuncio_tiempo);
        v.getContentPane().add(tiempo);
        v.getContentPane().add(anuncio_llegada);
        v.getContentPane().add(anuncio_atencion);
        v.getContentPane().add(panel);
        v.pack();
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setVisible(true);

        while (time <= 15) {
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
        for (int i = 0; i < personas.size(); i++) {
            Cliente client = personas.get(i);
            if (client.getStatus() == 0 && client.getHora_llegada() <= time) {
                g.setColor(client.getColor());
                g.fillOval(client.getX(), client.getY(), 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        client.getSexo() + "",
                        client.getX() + 19,
                        client.getY() + 29);
            }
        }
    }

    private void serve(Graphics g) {
        for (int i = 0; i < personas.size(); i++) {
            Cliente client = personas.get(i);
            if (client.getStatus() <= 1 && client.getHora_espera() <= time) {
                personas.get(i).setColor(Color.YELLOW);
                client.setX(100);
                personas.get(i).setStatus(1);
                g.setColor(client.getColor());
                g.fillOval(client.getX(), client.getY(), 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        client.getSexo() + "",
                        client.getX() + 19,
                        client.getY() + 29);
            }
        }
    }

    private void out(Graphics g) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getStatus() == 1
                    && personas.get(i).getHora_salida() <= time) {

                personas.get(i).setColor(Color.GREEN);
                personas.get(i).setX(200);
                personas.get(i).setY(140);
                personas.get(i).setStatus(2);
                // Color de relleno de la bolita
                g.setColor(personas.get(i).getColor());
                g.fillOval(personas.get(i).getX(),
                        personas.get(i).getY(), 50, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                g.drawString(
                        personas.get(i).getSexo() + "",
                        personas.get(i).getX() + 19,
                        personas.get(i).getY() + 29);
                g.setFont(new Font("TimesRoman", Font.BOLD, 12));
                if (personas.get(i).hasPan()) {
                    g.drawString(
                            "p",
                            personas.get(i).getX() + 32,
                            personas.get(i).getY() + 18);
                }
                if (personas.get(i).hasBebida()) {
                    g.drawString(
                            "b",
                            personas.get(i).getX() + 32,
                            personas.get(i).getY() + 32);
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
