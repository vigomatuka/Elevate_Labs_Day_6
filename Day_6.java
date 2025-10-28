import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Day_6 {
    private DefaultListModel<String> taskModel;
    private JList<String> list;
    private JTextField text;

    public Day_6(){
        JFrame frame = new JFrame("Day_6_frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        text = new JTextField(15);
        JButton add = new JButton("Add task");
        JButton delete = new JButton("Delete task");

        topPanel.add(text);
        topPanel.add(add);
        topPanel.add(delete);

        taskModel = new DefaultListModel<>();
        list = new JList<>(taskModel);
        JScrollPane scroll = new JScrollPane(list); //scroll if there are too many tasks

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);

        add.addActionListener(e -> {
            String task = text.getText().trim();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                text.setText("");
            }else{
                JOptionPane.showMessageDialog(frame, "Enter a task.");
            }
        });
        delete.addActionListener((ActionEvent e) -> {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                taskModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete.");
            }
        });
        frame.setVisible(true);
    }

    static void main() {
        SwingUtilities.invokeLater(Day_6::new);
    }
}
