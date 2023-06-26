/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventuser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class JTreeWithJTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create the tree nodes
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Node 1");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Node 2");

        rootNode.add(node1);
        rootNode.add(node2);

        // Create the table model
        String[] columnNames = {"Column 1", "Column 2"};
        Object[][] data = {
                {"Data 1", "Data 2"},
                {"Data 3", "Data 4"}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create the JTable component
        JTable table = new JTable(tableModel);

        // Create the tree cell renderer
        TreeCellRenderer renderer = new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                          boolean selected, boolean expanded,
                                                          boolean leaf, int row, boolean hasFocus) {
                Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

                if (component instanceof JLabel) {
                    JLabel label = (JLabel) component;

                    if (value instanceof DefaultMutableTreeNode) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                        Object userObject = node.getUserObject();

                        // Check if the user object is a String or a JTable
                        if (userObject instanceof String) {
                            label.setText((String) userObject);
                            label.setIcon(null);
                        } else if (userObject instanceof JTable) {
                            JTable table = (JTable) userObject;
                            return table; // Return the JTable component for the tree cell
                        }
                    }
                }

                return component;
            }
        };

        // Create the JTree with the custom cell renderer
        JTree tree = new JTree(rootNode);
        tree.setCellRenderer(renderer);

        // Create a scroll pane for the JTree
        JScrollPane treeScrollPane = new JScrollPane(tree);

        // Create a frame to display the components
        JFrame frame = new JFrame("JTree with JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(treeScrollPane, BorderLayout.WEST);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

