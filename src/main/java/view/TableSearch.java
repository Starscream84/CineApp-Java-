package view;

import java.text.Normalizer;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Adds a search box to a table: while the user types, the table only shows
 * the rows that contain the text in any column.
 * <p>
 * The search ignores upper/lower case and accents, so "accion" also finds
 * "Acción". The data in the table model is never modified: the filter only
 * changes which rows are visible.
 *
 * @author Matias Rosas
 * @author Camila Larsen
 * @author Matias Nerli
 * @version 1.0
 */
final class TableSearch {

    private TableSearch() {
    }

    /**
     * Connects a text field to a table so that it works as a search box.
     *
     * @param table the table to filter
     * @param field the text field where the user types the search
     */
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
