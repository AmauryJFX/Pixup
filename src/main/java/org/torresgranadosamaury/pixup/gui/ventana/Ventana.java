package org.torresgranadosamaury.pixup.gui.ventana;

import javax.swing.*;
import java.awt.*;

/**
 * GUI básica con CardLayout.
 *  • Menú Catálogos → Estados, Municipios, Colonias, Disco
 *  • Sub-menú Disco → Disco, Artista, Canción, Disquera, Género Musical
 */
public class Ventana extends JFrame {

    private final CardLayout cards      = new CardLayout();
    private final JPanel     contenedor = new JPanel(cards);

    private static final String TAG_MENU_CATALOGOS = "menuCatalogos";
    private static final String TAG_MENU_DISCO     = "menuDisco";

    public Ventana() {
        super("PixUp · GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 290);
        setLocationRelativeTo(null);

        contenedor.add(crearPanelCatalogos(), TAG_MENU_CATALOGOS);
        contenedor.add(crearPanelDisco(),     TAG_MENU_DISCO);

        add(contenedor);
        cards.show(contenedor, TAG_MENU_CATALOGOS);
    }

    /* ---------- menú catálogos ---------- */
    private JPanel crearPanelCatalogos() {
        JPanel p = new JPanel(new GridLayout(5, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));

        p.add(boton("Estados",     () -> noImplementado()));
        p.add(boton("Municipios",  () -> noImplementado()));
        p.add(boton("Colonias",    () -> noImplementado()));
        p.add(boton("Disco",       () -> cards.show(contenedor, TAG_MENU_DISCO)));
        p.add(boton("Salir",       this::dispose));
        return p;
    }

    /* ---------- sub-menú Disco ---------- */
    private JPanel crearPanelDisco() {
        JPanel p = new JPanel(new GridLayout(6, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));

        p.add(boton("Disco",          () -> noImplementado()));
        p.add(boton("Artista",        () -> noImplementado()));
        p.add(boton("Canción",        () -> noImplementado()));
        p.add(boton("Disquera",       () -> noImplementado()));
        p.add(boton("Género Musical", () -> noImplementado()));
        p.add(boton("Regresar",       () -> cards.show(contenedor, TAG_MENU_CATALOGOS)));
        return p;
    }

    /* ---------- helper para crear botones ---------- */
    private JButton boton(String texto, Runnable onClick) {
        JButton b = new JButton(texto);
        b.addActionListener(e -> onClick.run());
        return b;
    }

    /* ---------- placeholder ---------- */
    private void noImplementado() {
        JOptionPane.showMessageDialog(this, "Función no implementada todavía.");
    }

    /* ---------- main ---------- */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }
}
