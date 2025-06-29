package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosProductos;
import clases.Productos;


public class DialogProducto extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel lblMantenimientoProd;
    private JLabel lblCategoria;
    private JLabel lblProducto;
    private JLabel lblCdigo;
    private JLabel lblPrecio;
    private JTextField txtCodigo;
    private JTextField  txtPrecio;
    private JComboBox<String> cboCategoria;
    private JComboBox<String> cboProductos;
    private JScrollPane scr;
    private JButton btnAdicionar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTable tblProductos;
    private DefaultTableModel modeloProducto;
    private Map<String, String[]> productosPorCategoria;
    
    private ArreglosProductos ap = new ArreglosProductos();

    public static void main(String[] args) {
        try {
            DialogProducto dialog = new DialogProducto();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DialogProducto() {
        setTitle("Productos");
        setBounds(100, 100, 810, 625);
        getContentPane().setLayout(null);

        lblMantenimientoProd = new JLabel("MANTENIMIENTO PRODUCTOS");
        lblMantenimientoProd.setBounds(0, 0, 797, 34);
        lblMantenimientoProd.setOpaque(true);
        lblMantenimientoProd.setHorizontalAlignment(SwingConstants.CENTER);
        lblMantenimientoProd.setForeground(Color.WHITE);
        lblMantenimientoProd.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMantenimientoProd.setBackground(Color.BLACK);
        getContentPane().add(lblMantenimientoProd);

        cboCategoria = new JComboBox<>();
        cboCategoria.setBounds(160, 62, 214, 21);
        cboCategoria.addActionListener(this);
        getContentPane().add(cboCategoria);

        lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(39, 62, 93, 17);
        lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().add(lblCategoria);

        lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(39, 105, 93, 17);
        lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().add(lblProducto);

        cboProductos = new JComboBox<>();
        cboProductos.setBounds(160, 105, 176, 21);
        getContentPane().add(cboProductos);

        lblCdigo = new JLabel("Código:");
        lblCdigo.setBounds(472, 62, 93, 17);
        lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().add(lblCdigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(555, 62, 176, 19);
        getContentPane().add(txtCodigo);
        txtCodigo.setColumns(10);

        lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(472, 105, 93, 17);
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(555, 105, 176, 19);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);

        scr = new JScrollPane();
        scr.setBounds(22, 213, 749, 348);
        getContentPane().add(scr);



        btnAdicionar = new JButton("ADICIONAR");
        btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdicionar.setBounds(99, 163, 105, 21);
        btnAdicionar.addActionListener(this);
        getContentPane().add(btnAdicionar);

        btnModificar = new JButton("MODIFICAR");
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnModificar.setBounds(344, 163, 105, 21);
        btnModificar.addActionListener(this);
        getContentPane().add(btnModificar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEliminar.setBounds(576, 163, 98, 21);
        btnEliminar.addActionListener(this);
        getContentPane().add(btnEliminar);

        tblProductos = new JTable();
        tblProductos.setFillsViewportHeight(true);
        modeloProducto = new DefaultTableModel();
        modeloProducto.addColumn("Código");
        modeloProducto.addColumn("Categoria");
        modeloProducto.addColumn("Producto");
        modeloProducto.addColumn("Precio");
        tblProductos.setModel(modeloProducto);
        scr.setViewportView(tblProductos);

        tblProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblProductos.getSelectedRow() != -1) {
                int fila = tblProductos.getSelectedRow();
                txtCodigo.setText(tblProductos.getValueAt(fila, 0).toString());
                cboCategoria.setSelectedItem(tblProductos.getValueAt(fila, 1).toString());
                cboProductos.setSelectedItem(tblProductos.getValueAt(fila, 2).toString());
                txtPrecio.setText(tblProductos.getValueAt(fila, 3).toString());
            }
        });
        
        inicializarDatos();
        listar();
    }

    private void inicializarDatos() {
        productosPorCategoria = new HashMap<>();
        productosPorCategoria.put("Herramientas Electricas", new String[]{"Cortadoras", "Esmeril", "Hidrovaladoras", "Martillos", "Pistolas de calor", "Sierras", "Sopladoras", "Taladros", "Tronzadoras"});
        productosPorCategoria.put("Herramientas Inalámbricas", new String[]{"Atornilladores", "Llaves", "Taladro atornillador"});
        productosPorCategoria.put("Accesorios", new String[]{"Brocas", "Cinceles", "Discos"});

        for (String categoria : productosPorCategoria.keySet()) {
            cboCategoria.addItem(categoria);
        }
        actualizarProductos("Herramientas Inalámbricas");
    }

    private void actualizarProductos(String categoria) {
        cboProductos.removeAllItems();
        String[] productos = productosPorCategoria.get(categoria);
        if (productos != null) {
            for (String producto : productos) {
                cboProductos.addItem(producto);
            }
        }
    }

    private void listar() {
        modeloProducto.setRowCount(0);
        for (int i = 0; i < ap.tamanio(); i++) {
            Productos p = ap.obtener(i);
            Object[] fila = {p.getCodigo(), p.getCategoria(), p.getProducto(), p.getPrecio()};
            modeloProducto.addRow(fila);
        }
    }

    private void limpiar() {
        cboCategoria.setSelectedIndex(0);
        cboProductos.setSelectedIndex(0);
        txtCodigo.setText("");
        txtPrecio.setText("");
        txtCodigo.requestFocus();
    }

    private int leerCodigo() {
        return Integer.parseInt(txtCodigo.getText());
    }

    private String leerCategoria() {
        return cboCategoria.getSelectedItem().toString();
    }

    private String leerProducto() {
        return cboProductos.getSelectedItem().toString();
    }

    private double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
    }

    private void mensaje(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    protected void actionPerformedBtnModificar(ActionEvent e) {
        int fila = tblProductos.getSelectedRow();
        if (fila == -1) {
            mensaje("Seleccione una fila para modificar");
            return;
        }

        try {
            int codigo = leerCodigo();
            Productos x = ap.buscarProdcuto(codigo);
            if (x != null) {
                String categoria = leerCategoria();
                String producto = leerProducto();
                try {
                    double precio = leerPrecio();
                    x.setCategoria(categoria);
                    x.setProducto(producto);
                    x.setPrecio(precio);
                    ap.actualizarArchivo();
                    listar();
                    limpiar();
                    mensaje("Producto modificado correctamente");
                } catch (Exception ex) {
                    mensaje("Ingrese un precio válido");
                    txtPrecio.requestFocus();
                }
            } else {
                mensaje("El código ingresado no existe");
                txtCodigo.requestFocus();
            }
        } catch (Exception ex) {
            mensaje("Código inválido");
            txtCodigo.requestFocus();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cboCategoria) {
            actualizarProductos(cboCategoria.getSelectedItem().toString());
        } else if (e.getSource() == btnAdicionar) {
            Productos nuevo = new Productos(leerCodigo(), leerCategoria(), leerProducto(), leerPrecio());
            ap.adicionar(nuevo);
            listar();
            limpiar();
        } else if (e.getSource() == btnModificar) {
            actionPerformedBtnModificar(e);
        } else if (e.getSource() == btnEliminar) {
            int fila = tblProductos.getSelectedRow();
            if (fila == -1) {
                mensaje("Seleccione fila a eliminar");
                return;
            }
            int r = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                Productos p = ap.obtener(fila);
                ap.eliminar(p);
                listar();
                limpiar();
            }
        }
    }
}
