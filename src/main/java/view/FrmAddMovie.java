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
        btnExit.addActionListener(e -> dispose());
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
        txtTitle = new javax.swing.JTextField();
        lblRating = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        lblDuration = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle1 = new java.awt.Label();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cmbRating = new javax.swing.JComboBox<>();
        cmbGenre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AddMovie");

        jPanel1.setBackground(new java.awt.Color(30, 41, 59));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));

        txtTitle.setToolTipText("");

        lblRating.setForeground(new java.awt.Color(255, 255, 255));
        lblRating.setText("Clasificación");

        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Título");

        lblDuration.setForeground(new java.awt.Color(255, 255, 255));
        lblDuration.setText("Duración");

        lblYear.setForeground(new java.awt.Color(255, 255, 255));
        lblYear.setText("Año");

        lblGenre.setForeground(new java.awt.Color(255, 255, 255));
        lblGenre.setText("Género");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Agregar pelicula");

        lblTitle1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Cine APP");

        btnSave.setBackground(new java.awt.Color(153, 255, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 51));
        btnSave.setText("GUARDAR");

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 51));
        btnExit.setText("Salir");

        cmbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblYear)
                            .addComponent(txtYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDuration)
                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblGenre)
                        .addGap(160, 160, 160)
                        .addComponent(lblRating))
                    .addComponent(txtTitle))
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblTitle2)
                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblTitle2)
                .addGap(40, 40, 40)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenre)
                    .addComponent(lblRating))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuration)
                    .addComponent(lblYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
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
