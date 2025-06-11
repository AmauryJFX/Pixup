package org.torresgranadosamaury.pixup.gui.ventana;

import org.torresgranadosamaury.pixup.dao.DiscoDao;
import org.torresgranadosamaury.pixup.dao.impl.DiscoDaoImpl;
import org.torresgranadosamaury.pixup.model.Disco;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DiscoPanel extends JPanel {

    private final DiscoDao dao = DiscoDaoImpl.getInstance();
    private final DefaultListModel<Disco> modelo = new DefaultListModel<>();
    private final JList<Disco> listaDiscos = new JList<>(modelo);

    public DiscoPanel(Runnable onRegresar) {
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel botones = new JPanel(new GridLayout(1, 5, 5, 5));
        botones.add(crearBoton("Agregar", this::agregarDisco));
        botones.add(crearBoton("Editar", this::editarDisco));
        botones.add(crearBoton("Eliminar", this::eliminarDisco));
        botones.add(crearBoton("Actualizar", this::actualizarLista));
        botones.add(crearBoton("Regresar", onRegresar));

        add(new JScrollPane(listaDiscos), BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

        actualizarLista();
    }

    private JButton crearBoton(String texto, Runnable onClick) {
        JButton b = new JButton(texto);
        b.addActionListener(e -> onClick.run());
        return b;
    }

    private void actualizarLista() {
        modelo.clear();
        List<Disco> discos = dao.findAll();
        discos.forEach(modelo::addElement);
    }

    private void agregarDisco() {
        String titulo = JOptionPane.showInputDialog(this, "Título del disco:");
        if (titulo != null && !titulo.isBlank()) {
            Disco disco = new Disco();
            disco.setTitulo(titulo);
            // puedes establecer más campos si lo deseas, aquí solo usamos 'titulo'
            dao.save(disco);
            actualizarLista();
        }
    }

    private void editarDisco() {
        Disco seleccionado = listaDiscos.getSelectedValue();
        if (seleccionado == null) return;

        String nuevoTitulo = JOptionPane.showInputDialog(this, "Nuevo título:", seleccionado.getTitulo());
        if (nuevoTitulo != null && !nuevoTitulo.isBlank()) {
            seleccionado.setTitulo(nuevoTitulo);
            dao.update(seleccionado);
            actualizarLista();
        }
    }

    private void eliminarDisco() {
        Disco seleccionado = listaDiscos.getSelectedValue();
        if (seleccionado != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar disco?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dao.delete(seleccionado);
                actualizarLista();
            }
        }
    }
}
