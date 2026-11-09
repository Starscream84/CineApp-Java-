package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Movie;

public class FrmAddMovie extends javax.swing.JFrame {

    private static final String[] GENRES = {
        "Acción", "Animación", "Aventura", "Ciencia ficción", "Comedia",
        "Documental", "Drama", "Fantasía", "Romance", "Suspenso", "Terror"
    };

    private static final String[] RATINGS = {"ATP", "+13", "+16", "+18"};

    public FrmAddMovie() {
        initComponents();
        cmbGenre.setModel(new DefaultComboBoxModel<>(GENRES));
        cmbRating.setModel(new DefaultComboBoxModel<>(RATINGS));
        cmbGenre.setSelectedIndex(-1);
        cmbRating.setSelectedIndex(-1);
        btnCancel.addActionListener(e -> dispose());
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public String getTitleText() {
        return txtTitle.getText();
    }

    public String getGenreText() {
        return selectedText(cmbGenre);
    }

    public String getDurationText() {
        return txtDuration.getText();
    }

    public String getRatingText() {
        return selectedText(cmbRating);
    }

    public String getYearText() {
        return txtYear.getText();
    }

    private String selectedText(JComboBox<String> combo) {
        Object item = combo.getSelectedItem();
        return item == null ? "" : item.toString();
    }

    public void clearForm() {
        txtTitle.setText("");
        cmbGenre.setSelectedIndex(-1);
        txtDuration.setText("");
        cmbRating.setSelectedIndex(-1);
        txtYear.setText("");
        txtTitle.requestFocus();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void fillForm(Movie m) {
        txtTitle.setText(m.getTitle());
        cmbGenre.setSelectedItem(m.getGenre());
        txtDuration.setText(String.valueOf(m.getDuration()));
        cmbRating.setSelectedItem(m.getFilmRating());
        txtYear.setText(String.valueOf(m.getYear()));
    }

    public void setEditMode() {
        setTitle("EditMovie");
        lblTitle2.setText("Editar pelicula");
        btnSave.setText("ACTUALIZAR");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle1 = new java.awt.Label();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblGenre = new javax.swing.JLabel();
        cmbGenre = new javax.swing.JComboBox<>();
        lblRating = new javax.swing.JLabel();
        cmbRating = new javax.swing.JComboBox<>();
        lblDuration = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AddMovie");

        jPanel1.setBackground(new java.awt.Color(30, 41, 59));

        lblTitle1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setAlignment(java.awt.Label.CENTER);
        lblTitle1.setText("Cine APP");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Agregar película");

        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Título");

        lblGenre.setForeground(new java.awt.Color(255, 255, 255));
        lblGenre.setText("Género");

        lblRating.setForeground(new java.awt.Color(255, 255, 255));
        lblRating.setText("Clasificación");

        lblDuration.setForeground(new java.awt.Color(255, 255, 255));
        lblDuration.setText("Duración (minutos)");

        lblYear.setForeground(new java.awt.Color(255, 255, 255));
        lblYear.setText("Año");

        btnSave.setBackground(new java.awt.Color(185, 216, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 51));
        btnSave.setText("GUARDAR");

        btnCancel.setBackground(new java.awt.Color(185, 216, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 0, 51));
        btnCancel.setText("CANCELAR");

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
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cmbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cmbRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbGenre;
    private javax.swing.JComboBox<String> cmbRating;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblTitle;
    private java.awt.Label lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
