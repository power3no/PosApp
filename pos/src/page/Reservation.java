package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import posApp.PosApp;
import posinterface.BasicInterface;

public class Reservation extends BasicInterface{
    
    String[][] data = {};
    String[] headers = {"담당자","10~11","11~12","12~13","13~14","14~15","15~16","16~17","17~18","18~19","19~20"};
    DefaultTableModel model;
    JTable table;
    JTextField employeeTxt;
    JTextField customerTxt;
    JComboBox comboBox;
    
    public Reservation(JPanel panel) {
        super(panel);
        panelSet(panel);
        
        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 60, 756, 345);
        panel.add(scrollPane);
        
        JButton insertBtn = new JButton("예약등록");
        insertBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        insertBtn.setBounds(639, 417, 142, 53);
        panel.add(insertBtn);
        
        JLabel employeeLabel = new JLabel("담당자");
        employeeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        employeeLabel.setBounds(25, 427, 90, 43);
        panel.add(employeeLabel);
        
        employeeTxt = new JTextField();
        employeeTxt.setBounds(84, 427, 138, 43);
        employeeTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        panel.add(employeeTxt);
        employeeTxt.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("고객명");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(248, 424, 90, 43);
        panel.add(lblNewLabel_1);
        
        customerTxt = new JTextField();
        customerTxt.setColumns(10);
        customerTxt.setBounds(308, 427, 169, 43);
        customerTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        panel.add(customerTxt);
        
        String[] times = {"10:00 ~ 11:00", "11:00 ~ 12:00", 
                "12:00 ~ 13:00", "13:00 ~ 14:00", "14:00 ~ 15:00", "15:00 ~ 16:00", 
                "16:00 ~ 17:00", "17:00 ~ 18:00", "18:00 ~ 19:00", "19:00 ~ 20:00"};
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(times));
        comboBox.setBounds(489, 427, 138, 43);
        panel.add(comboBox);
        
        insertBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean overlap = false;
                int row = 0;
                // 담당자 중복 체크
                for(int i = 0; i < model.getRowCount(); i++) {
                    if(employeeTxt.getText().equals(model.getValueAt(i, 0))) {
                        overlap = true;
                        row = i;
                    } 
                }
                
                if(overlap) {
                    model.setValueAt(customerTxt.getText(), row, comboBox.getSelectedIndex()+1);
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(employeeTxt.getText());
                    for(int i = 0; i < comboBox.getSelectedIndex(); i++) {
                        list.add("");
                    }
                    list.add(customerTxt.getText());
                    String[] rowData = list.toArray(new String[list.size()]);
                    model.addRow(rowData);
                }
                JOptionPane.showMessageDialog(panel, "예약 완료!");
                employeeTxt.setText("");
                customerTxt.setText("");
            }
        });
    }
}
