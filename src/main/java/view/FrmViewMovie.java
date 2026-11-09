package view;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.Movie;

public class FrmViewMovie extends javax.swing.JFrame {

    public FrmViewMovie() {
        initComponents();
        TableSearch.install(tblMovies, txtSearch);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void showMovies(List<Movie> movies) {
        DefaultTableModel model = (DefaultTableModel) tblMovies.getModel();
        model.setRowCount(0);
        for (Movie m : movies) {
            model.addRow(new Object[]{
                m.getId(), m.getTitle(), m.getGenre(), m.getDuration(),
                m.getFilmRating(), m.getYear()
            });
        }
    }

    public boolean confirm(String message) {
        int option = JOptionPane.showConfirmDialog(this, message, "Confirmar", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    public Long getSelectedId() {
        int row = tblMovies.getSelectedRow();
        if (row == -1) {
            return null;
        }
        return (Long) tblMovies.getValueAt(row, 0);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitle1 = new java.awt.Label();
        lblTitle2 = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(30, 41, 59));

        lblTitle1.setAlignment(java.awt.Label.CENTER);
        lblTitle1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Cine APP");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Listado de películas");

        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Buscar:");

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Género", "Duración", "Clasificación", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(tblMovies);

        btnAdd.setBackground(new java.awt.Color(185, 216, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 51));
        btnAdd.setText("+ AGREGAR");

        btnEdit.setBackground(new java.awt.Color(185, 216, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 0, 51));
        btnEdit.setText("EDITAR");

        btnDelete.setBackground(new java.awt.Color(220, 53, 69));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("ELIMINAR");

        btnExit.setBackground(new java.awt.Color(185, 216, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 51));
        btnExit.setText("SALIR");
        btnExit.addActionListener(this::btnExitActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearch))
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblTitle2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblSearch;
    private java.awt.Label lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
