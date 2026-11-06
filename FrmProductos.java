/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicio1;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADM
 */
public class FrmProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(
                    FrmProductos.class.getName());

        // PASO 1:Servicio que administra el CRUD con ArrayList
    private final IProductoServicio servicio =
            new ProductoServicio();
    
    
    
    
    public FrmProductos() {
    initComponents();
    actualizarTabla();

    txtBuscarNombre.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltros();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltros();
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltros();
            }
        }
    );
}
    
    private void mostrarResultados(List<Producto> lista) {
    DefaultTableModel modelo =
            (DefaultTableModel) tblProductos.getModel();
    modelo.setRowCount(0);
    for (Producto p : lista) {
        modelo.addRow(new Object[]{
            p.codigo, p.nombre, p.precio, p.stock
        });
    }
}
    
    
    private void aplicarFiltros() {
    // Protección ante eventos durante initComponents().
    if (txtBuscarNombre == null || chkInvertir == null
            || tblProductos == null || cboOrdenar == null) {
        return;
    }

    String opcion = (String) cboOrdenar.getSelectedItem();
    if (opcion == null) {
        return;
    }

    List<Producto> lista = switch (opcion) {
        case "Precio descendente" -> servicio.ordenarPorPrecio(false);
        case "Nombre A-Z" -> servicio.ordenarPorNombre();
        default -> servicio.ordenarPorPrecio(true);
    };

    String texto = txtBuscarNombre.getText()
            .trim().toLowerCase(Locale.ROOT);
    lista.removeIf(p -> !p.nombre.toLowerCase(Locale.ROOT)
            .contains(texto));

    if (chkInvertir.isSelected()) {
        lista = new ArrayList<>(lista.reversed());
    }
    mostrarResultados(lista);
}
    
    
    

    // PASO 2: ACTUALIZAR LA TABLA
    private void actualizarTabla() {

    javax.swing.table.DefaultTableModel modelo =
        (javax.swing.table.DefaultTableModel)
        tblProductos.getModel();

    modelo.setRowCount(0);

    for (Producto p : servicio.listar()) {

        modelo.addRow(new Object[]{
            p.codigo,
            p.nombre,
            p.precio,
            p.stock
        });
        }
    }

    private void prepararPaginacion() {
    cboFilasPagina.setSelectedItem("5");
    paginador.establecerFilasPorPagina(5);
}

// SEMANA 13: CARGAR PRODUCTOS
private void cargarEnPaginador(java.util.List<Producto> lista) {
    paginador.establecerDatos(lista);
    mostrarPagina();
}

// SEMANA 13: MOSTRAR PÁGINA ACTUAL
private void mostrarPagina() {

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel)
            tblProductos.getModel();

    modelo.setRowCount(0);

    for (Producto p : paginador.obtenerPagina()) {
        modelo.addRow(new Object[]{
            p.codigo,
            p.nombre,
            p.precio,
            p.stock
        });
    }

    lblPaginaActual.setText("Página "
            + paginador.getPaginaActual()
            + " de " + paginador.getTotalPaginas());

    lblTotalRegistros.setText("Total: "
            + paginador.getTotalRegistros()
            + " productos");

    btnPaginaPrimera.setEnabled(
            paginador.hayAnterior());

    btnPaginaAnterior.setEnabled(
            paginador.hayAnterior());

    btnPaginaSiguiente.setEnabled(
            paginador.haySiguiente());

    btnPaginaUltima.setEnabled(
            paginador.haySiguiente());
}

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDatosProducto = new javax.swing.JLabel();
        lblResultados = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        pnlColecciones = new javax.swing.JPanel();
        lblBuscarNombre = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        lblOrdenar = new javax.swing.JLabel();
        cboOrdenar = new javax.swing.JComboBox<>();
        chkInvertir = new javax.swing.JCheckBox();
        btnPrimero = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnRecorrer = new javax.swing.JButton();
        pnlPaginacion = new javax.swing.JPanel();
        lblFilasPagina = new javax.swing.JLabel();
        cboFilasPagina = new javax.swing.JComboBox<>();
        btnPaginaPrimera = new javax.swing.JButton();
        btnPaginaAnterior = new javax.swing.JButton();
        btnPaginaSiguiente = new javax.swing.JButton();
        btnPaginaUltima = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        lblPaginaActual = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO - Semana 12 | Iterator, Comparator y SequencedCollection");

        lblCodigo.setText("Código");

        lblPrecio.setText("Precio");

        lblNombre.setText("Nombre");

        lblStock.setText("Stock");

        lblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("REGISTRO DE PRODUCTOS");
        lblTitulo.setOpaque(true);

        lblDatosProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatosProducto.setText("Datos del producto");

        lblResultados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblResultados.setText("Tabla de resultados");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProductos);

        pnlColecciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas de colección ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        lblBuscarNombre.setText("Buscar por nombre");

        lblOrdenar.setText("Ordenar por");

        cboOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Precio ascendente", "Precio descendente", "Nombre A-Z" }));
        cboOrdenar.addActionListener(this::cboOrdenarActionPerformed);

        chkInvertir.setText("Invertir lista");
        chkInvertir.addActionListener(this::chkInvertirActionPerformed);

        btnPrimero.setText("« Primero");
        btnPrimero.addActionListener(this::btnPrimeroActionPerformed);

        btnUltimo.setText("Último »");
        btnUltimo.addActionListener(this::btnUltimoActionPerformed);

        btnRecorrer.setText("Iterator");
        btnRecorrer.addActionListener(this::btnRecorrerActionPerformed);

        javax.swing.GroupLayout pnlColeccionesLayout = new javax.swing.GroupLayout(pnlColecciones);
        pnlColecciones.setLayout(pnlColeccionesLayout);
        pnlColeccionesLayout.setHorizontalGroup(
            pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColeccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBuscarNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(54, 54, 54)
                .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlColeccionesLayout.createSequentialGroup()
                        .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUltimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboOrdenar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkInvertir, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(btnRecorrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlColeccionesLayout.setVerticalGroup(
            pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColeccionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarNombre)
                    .addComponent(lblOrdenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkInvertir))
                .addGap(30, 30, 30)
                .addGroup(pnlColeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero)
                    .addComponent(btnUltimo)
                    .addComponent(btnRecorrer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPaginacion.setBackground(new java.awt.Color(255, 255, 0));
        pnlPaginacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Páginación genérica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        lblFilasPagina.setForeground(new java.awt.Color(0, 0, 0));
        lblFilasPagina.setText("Filas por página");

        cboFilasPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "20" }));
        cboFilasPagina.addActionListener(this::cboFilasPaginaActionPerformed);

        btnPaginaPrimera.setText("|< Primera");
        btnPaginaPrimera.addActionListener(this::btnPaginaPrimeraActionPerformed);

        btnPaginaAnterior.setText("< Anterior");
        btnPaginaAnterior.addActionListener(this::btnPaginaAnteriorActionPerformed);

        btnPaginaSiguiente.setText("Siguiente >");
        btnPaginaSiguiente.addActionListener(this::btnPaginaSiguienteActionPerformed);

        btnPaginaUltima.setText("Última >|");
        btnPaginaUltima.addActionListener(this::btnPaginaUltimaActionPerformed);

        lblTotalRegistros.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalRegistros.setText("Total: 0 productos");

        lblPaginaActual.setForeground(new java.awt.Color(0, 0, 0));
        lblPaginaActual.setText("Página 0 de 0");

        javax.swing.GroupLayout pnlPaginacionLayout = new javax.swing.GroupLayout(pnlPaginacion);
        pnlPaginacion.setLayout(pnlPaginacionLayout);
        pnlPaginacionLayout.setHorizontalGroup(
            pnlPaginacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginacionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblFilasPagina)
                .addGap(67, 67, 67)
                .addComponent(cboFilasPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(52, 52, 52))
            .addGroup(pnlPaginacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPaginaPrimera)
                .addGap(60, 60, 60)
                .addComponent(btnPaginaAnterior)
                .addGap(51, 51, 51)
                .addComponent(btnPaginaSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPaginaUltima)
                .addGap(23, 23, 23))
            .addGroup(pnlPaginacionLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(lblPaginaActual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPaginacionLayout.setVerticalGroup(
            pnlPaginacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginacionLayout.createSequentialGroup()
                .addGroup(pnlPaginacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaginacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFilasPagina))
                    .addGroup(pnlPaginacionLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlPaginacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFilasPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalRegistros))))
                .addGap(45, 45, 45)
                .addGroup(pnlPaginacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPaginaPrimera)
                    .addComponent(btnPaginaAnterior)
                    .addComponent(btnPaginaSiguiente)
                    .addComponent(btnPaginaUltima))
                .addGap(18, 18, 18)
                .addComponent(lblPaginaActual)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlPaginacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56))))
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDatosProducto)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(pnlColecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pnlPaginacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // PASO 4: LISTAS
        
        actualizarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // PASO 3: BOTON REGSITRAR
        
        try {

    String codigo = txtCodigo.getText().trim();
    String nombre = txtNombre.getText().trim();

    double precio = Double.parseDouble(
        txtPrecio.getText().trim()
    );

    int stock = Integer.parseInt(
        txtStock.getText().trim()
    );

    if (codigo.isEmpty() || nombre.isEmpty()
            || !Double.isFinite(precio)
            || precio <= 0 || stock < 0) {

        javax.swing.JOptionPane.showMessageDialog(
            this, "Verifique los datos ingresados"
        );
        return;
    }

    Producto producto = new Producto(
        codigo, nombre, precio, stock
    );

    if (servicio.registrar(producto)) {

        javax.swing.JOptionPane.showMessageDialog(
            this, "Producto registrado correctamente"
        );

        actualizarTabla();
        prepararPaginacion();
        aplicarFiltros();

    } else {

        javax.swing.JOptionPane.showMessageDialog(
            this, "El código ya está registrado"
        );
    }

} catch (NumberFormatException ex) {

    javax.swing.JOptionPane.showMessageDialog(
        this, "Ingrese un precio y stock válidos"
    );
    }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        String codigo = txtCodigo.getText().trim();

if (codigo.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Ingrese un código para buscar");
    return;
}

Producto p = servicio.buscar(codigo);

if (p != null) {
    txtCodigo.setText(p.codigo);
    txtNombre.setText(p.nombre);
    txtPrecio.setText(String.valueOf(p.precio));
    txtStock.setText(String.valueOf(p.stock));

    javax.swing.JOptionPane.showMessageDialog(
            this, "Producto encontrado");
} else {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Producto no encontrado");
}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        try {
    String codigo = txtCodigo.getText().trim();
    String nombre = txtNombre.getText().trim();

    double precio = Double.parseDouble(
            txtPrecio.getText().trim());

    int stock = Integer.parseInt(
            txtStock.getText().trim());

    if (codigo.isEmpty() || nombre.isEmpty()
            || !Double.isFinite(precio)
            || precio <= 0 || stock < 0) {

        javax.swing.JOptionPane.showMessageDialog(
                this, "Datos inválidos");
        return;
    }

    Producto p = new Producto(
            codigo, nombre, precio, stock);

    if (servicio.actualizar(p)) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Producto actualizado correctamente");

        actualizarTabla();
        aplicarFiltros();
    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Producto no encontrado");
    }

} catch (NumberFormatException ex) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Precio o stock incorrecto");
}
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        String codigo = txtCodigo.getText().trim();

if (codigo.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Ingrese el código a eliminar");
    return;
}

int respuesta = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "¿Desea eliminar el producto " + codigo + "?",
        "Confirmar eliminación",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (respuesta == javax.swing.JOptionPane.YES_OPTION) {

    if (servicio.eliminar(codigo)) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Producto eliminado correctamente");

        actualizarTabla();
        aplicarFiltros();

        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");

    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Producto no encontrado");
    }
}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");

        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrdenarActionPerformed
        // TODO add your handling code here:
        aplicarFiltros();
        
    }//GEN-LAST:event_cboOrdenarActionPerformed

    private void chkInvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkInvertirActionPerformed
        // TODO add your handling code here:
        aplicarFiltros();
        
    }//GEN-LAST:event_chkInvertirActionPerformed

    private void btnRecorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorrerActionPerformed
        // TODO add your handling code here:
        List<Producto> lista = servicio.recorrerConIterator();
        mostrarResultados(lista);
        JOptionPane.showMessageDialog(this,
        "Recorrido con Iterator completado.\n"
        + "Total de productos: " + lista.size());
        
    }//GEN-LAST:event_btnRecorrerActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        // TODO add your handling code here:
        Producto p = servicio.obtenerPrimero();
if (p == null) {
    JOptionPane.showMessageDialog(this,
            "No existen productos registrados.");
    return;
}
JOptionPane.showMessageDialog(this,
        "PRIMER PRODUCTO\n"
        + "Código: " + p.codigo + "\n"
        + "Nombre: " + p.nombre + "\n"
        + "Precio: S/ " + p.precio);
        
        
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        Producto p = servicio.obtenerUltimo();
if (p == null) {
    JOptionPane.showMessageDialog(this,
            "No existen productos registrados.");
    return;
}
JOptionPane.showMessageDialog(this,
        "ÚLTIMO PRODUCTO\n"
        + "Código: " + p.codigo + "\n"
        + "Nombre: " + p.nombre + "\n"
        + "Precio: S/ " + p.precio);
        
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void cboFilasPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFilasPaginaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboFilasPaginaActionPerformed

    private void btnPaginaPrimeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaginaPrimeraActionPerformed
        // TODO add your handling code here:
        paginador.primera();
        mostrarPagina();

    }//GEN-LAST:event_btnPaginaPrimeraActionPerformed

    private void btnPaginaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaginaAnteriorActionPerformed
        // TODO add your handling code here:
        paginador.anterior();
        mostrarPagina();

    }//GEN-LAST:event_btnPaginaAnteriorActionPerformed

    private void btnPaginaSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaginaSiguienteActionPerformed
        // TODO add your handling code here:
        paginador.siguiente();
    }//GEN-LAST:event_btnPaginaSiguienteActionPerformed

    private void btnPaginaUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaginaUltimaActionPerformed
        // TODO add your handling code here:
        paginador.ultima();
        mostrarPagina();
    }//GEN-LAST:event_btnPaginaUltimaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmProductos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPaginaAnterior;
    private javax.swing.JButton btnPaginaPrimera;
    private javax.swing.JButton btnPaginaSiguiente;
    private javax.swing.JButton btnPaginaUltima;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnRecorrer;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cboFilasPagina;
    private javax.swing.JComboBox<String> cboOrdenar;
    private javax.swing.JCheckBox chkInvertir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBuscarNombre;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDatosProducto;
    private javax.swing.JLabel lblFilasPagina;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JLabel lblPaginaActual;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JPanel pnlColecciones;
    private javax.swing.JPanel pnlPaginacion;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
