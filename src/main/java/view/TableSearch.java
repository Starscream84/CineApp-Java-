package view;

import java.text.Normalizer;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

final class TableSearch {

    private TableSearch() {
    }

    static void install(JTable table, JTextField field) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        // Sorting by clicking the column headers is disabled: only filtering is used
        for (int i = 0; i < table.getColumnCount(); i++) {
            sorter.setSortable(i, false);
        }
        table.setRowSorter(sorter);

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyFilter(sorter, field.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyFilter(sorter, field.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                applyFilter(sorter, field.getText());
            }
        });
    }

    private static void applyFilter(TableRowSorter<TableModel> sorter, String text) {
        String query = normalize(text.trim());
        if (query.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                for (int i = 0; i < entry.getValueCount(); i++) {
                    if (normalize(entry.getStringValue(i)).contains(query)) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // Converts to lower case and removes accents: "Acción" -> "accion"
    private static String normalize(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
