import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    // Main method
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel for input and add button
        JPanel topPanel = new JPanel();
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");

        topPanel.add(taskField);
        topPanel.add(addButton);

        // Center: List of tasks
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel for delete button
        JPanel bottomPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Selected Task");
        bottomPanel.add(deleteButton);

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add Button Action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        // Make it visible
        frame.setVisible(true);
    }
}