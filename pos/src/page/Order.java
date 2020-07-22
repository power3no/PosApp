package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import posApp.PosApp;
import posinterface.BasicInterface;
import sales.SalesDAO;
import sales.SalesDTO;

public class Order extends BasicInterface{
    
    private JTable table;
    private DefaultTableModel model;
    private JButton cutBtn;
    private JButton dyeingBtn;
    private JButton permBtn;
    private JLabel sumLabel;
    private JTextField receiveTxt;
    private JLabel changeLabel;
    public static JLabel customerNameLabel;
    
    public Order(JPanel panel) {
        super(panel);
        panelSet(panel);
        
        cutBtn = new JButton("커트 30000");
        cutBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        cutBtn.setBounds(611, 71, 156, 70);
        panel.add(cutBtn);
        
        dyeingBtn = new JButton("염색 50000");
        dyeingBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        dyeingBtn.setBounds(611, 153, 156, 70);
        panel.add(dyeingBtn);
        
        permBtn = new JButton("파마 70000");
        permBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        permBtn.setBounds(611, 235, 156, 70);
        panel.add(permBtn);
        
        // 각 버튼 클릭시 table에 해당하는 종류와 금액 추가
        cutBtn.addActionListener(listener);
        dyeingBtn.addActionListener(listener);
        permBtn.addActionListener(listener);
        
        String[][] data = {};
        String[] headers = {"품목", "가격"};
        model = new DefaultTableModel(data,headers);
        table = new JTable(model);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(25, 71, 370, 234);
        panel.add(scrollpane);
        
        sumLabel = new JLabel("합계 0원");
        sumLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        sumLabel.setBounds(25, 304, 370, 39);
        panel.add(sumLabel);
        
        JLabel lblNewLabel_2_1 = new JLabel("받은금액");
        lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblNewLabel_2_1.setBounds(25, 340, 95, 39);
        panel.add(lblNewLabel_2_1);
        
        receiveTxt = new JTextField();
        receiveTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        receiveTxt.setBounds(132, 340, 156, 39);
        panel.add(receiveTxt);
        receiveTxt.setColumns(10);
        
        JButton calBtn = new JButton("계산");
        calBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        calBtn.setBounds(300, 340, 95, 39);
        // 거스름돈 계산
        calBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(receiveTxt.getText()) - PosApp.sum ;
                changeLabel.setText("거스름돈 " + value + "원");
                
            }
        });
        panel.add(calBtn);    
        
        changeLabel = new JLabel("거스름돈");
        changeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        changeLabel.setBounds(25, 378, 370, 39);
        panel.add(changeLabel);
        
        customerNameLabel = new JLabel();
        customerNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        customerNameLabel.setBounds(25, 416, 372, 39);
        panel.add(customerNameLabel);
        
        JButton resetBtn = new JButton("초기화");
        resetBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        resetBtn.setBounds(421, 370, 156, 70);
        resetBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
               reset();
                
            }
        });
        panel.add(resetBtn);
        
        JButton payBtn = new JButton("결제");
        payBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        payBtn.setBounds(611, 370, 156, 70);
        // 결제
        payBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String kind = "";
                for(int i = 0; i < model.getRowCount(); i++) {
                    kind += (String) table.getModel().getValueAt(i, 0) + " ";
                }
                SalesDTO dto = new SalesDTO(0, kind, PosApp.sum+"", PosApp.customerId, null);
                SalesDAO.getInstance().salesInsert(dto);
                JOptionPane.showMessageDialog(panel, "결제완료!");
                reset();
                panel.setVisible(false);
                PosApp.receiptPanel.setVisible(true);
            }
        });
        panel.add(payBtn);
    }
    
    ActionListener listener = new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int value = 0;
            
            if(e.getSource() == cutBtn) {
                model.insertRow(model.getRowCount(), new Object[] { "CUT", "30000" });
                value += 30000;
            } else if(e.getSource() == dyeingBtn) {
                model.insertRow(model.getRowCount(), new Object[] { "DYING", "50000" });
                value += 50000;
            } else if(e.getSource() == permBtn) {
                model.insertRow(model.getRowCount(), new Object[] { "PERM", "70000" });
                value += 70000;
            }
            PosApp.sum += value;
            sumLabel.setText("합계 " + PosApp.sum + "원");
            
        }
    };
    
    private void reset() {
        model.setRowCount(0);
        PosApp.sum = 0;
        receiveTxt.setText("");
        changeLabel.setText("거스름돈");
        sumLabel.setText("합계 " + PosApp.sum+ "원");
    }
    
}