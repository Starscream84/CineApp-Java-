package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Room;

public class FrmAddRoom extends javax.swing.JFrame {

    private static final String[] TYPES = {"2D", "3D", "IMAX"};

    public FrmAddRoom() {
        initComponents();
        cmbType.setModel(new DefaultComboBoxModel<>(TYPES));
        cmbType.setSelectedIndex(-1);
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public String getNumberText() {
        return txtNumber.getText();
    }

    public String getCapacityText() {
        return txtCapacity.getText();
    }

    public String getTypeText() {
        Object item = cmbType.getSelectedItem();
        return item == null ? "" : item.toString();
    }

    public void fillForm(Room r) {
        txtNumber.setText(String.valueOf(r.getNumber()));
        txtCapacity.setText(String.valueOf(r.getCapacity()));
        cmbType.setSelectedItem(r.getType());
    }

    public void clearForm() {
        txtNumber.setText("");
        txtCapacity.setText("");
        cmbType.setSelectedIndex(-1);
        txtNumber.requestFocus();
    }

    public void setEditMode() {
        setTitle("EditRoom");
        lblTitle2.setText("Editar sala");
        btnSave.setText("ACTUALIZAR");
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

        jPanel1 = new javax.swing.JPanel();
        lblTitle1 = new java.awt.Label();
        lblTitle2 = new javax.swing.JLabel();
        lblNumber = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        lblCapacity = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AddRoom");

        jPanel1.setBackground(new java.awt.Color(30, 41, 59));

        lblTitle1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setAlignment(java.awt.Label.CENTER);
        lblTitle1.setText("Cine APP");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Agregar sala");

        lblNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblNumber.setText("Número");

        lblCapacity.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacity.setText("Capacidad (butacas)");

        lblType.setForeground(new java.awt.Color(255, 255, 255));
        lblType.setText("Tipo");

        btnSave.setBackground(new java.awt.Color(185, 216, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 51));
        btnSave.setText("GUARDAR");

        btnCancel.setBackground(new java.awt.Color(185, 216, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 0, 51));
        btnCancel.setText("CANCELAR");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblNumber;
    private java.awt.Label lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
