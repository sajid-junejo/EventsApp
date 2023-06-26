/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventuser;

/**
 *
 * @author sajid.ali
 */
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class JTreeSortingExample extends JFrame {
    private JTree tree;
    private DefaultTreeModel model;

    public JTreeSortingExample() {
        setTitle("JTree Sorting Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create tree nodes
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Node 1");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Node 2");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Node 3");

        // Add nodes to the tree
        root.add(node2);
        root.add(node3);
        root.add(node1);

        model = new DefaultTreeModel(root);

        // Create custom cell renderer
        TreeCellRenderer renderer = new ButtonTreeCellRenderer();

        tree = new JTree(model);
        tree.setCellRenderer(renderer);
        add(new JScrollPane(tree), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonTreeCellRenderer extends JPanel implements TreeCellRenderer {
        private JLabel sortAscendingLabel;
        private JLabel sortDescendingLabel;

        public ButtonTreeCellRenderer() {
            setLayout(new BorderLayout());
            sortAscendingLabel = new JLabel("Sort Ascending");
            sortDescendingLabel = new JLabel("Sort Descending");
            add(sortAscendingLabel, BorderLayout.WEST);
            add(sortDescendingLabel, BorderLayout.EAST);
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                      boolean expanded, boolean leaf, int row, boolean hasFocus) {
            removeAll();

            JLabel label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setBackground(selected ? tree.getBackground() : tree.getBackground());
            label.setForeground(selected ? tree.getBackground() : tree.getForeground());

            JPanel labelPanel = new JPanel(new BorderLayout());
            labelPanel.add(label, BorderLayout.CENTER);

            add(labelPanel, BorderLayout.CENTER);
            return this;
        }
    }

    // Sorting methods...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTreeSortingExample();
            }
        });
    }
}

