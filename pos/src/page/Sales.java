package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import posApp.PosApp;
import posinterface.BasicInterface;
import sales.SalesDAO;

public class Sales extends BasicInterface{
    JLabel salesLabel;
    JButton salesSearchBtn;
    String[][] data = {};
    String[] headers = {"종류", "가격", "성", "이름", "시간"};
    
    public Sales(JPanel panel) {
        super(panel);
        panelSet(panel);
        
        DefaultTableModel model = new DefaultTableModel(data,headers);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 78, 538, 325);
        panel.add(scrollPane);
        
        salesLabel = new JLabel("금일매출");
        salesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        salesLabel.setBounds(25, 415, 538, 53);
        panel.add(salesLabel);
        
        salesSearchBtn = new JButton("금일매출조회");
        salesSearchBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        salesSearchBtn.setBounds(584, 78, 197, 53);
        salesSearchBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                data = SalesDAO.getInstance().salesSelect();
                model.setDataVector(data, headers);
                String salesSum = SalesDAO.getInstance().salesToday();
                salesLabel.setText("금일매출 " + salesSum.substring(0, salesSum.length()-2)+ "원");
                // 소숫점 첫번째까지 출력되어 substring으로 해결
            }
        });
        panel.add(salesSearchBtn);
    }
}
