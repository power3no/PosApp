package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import customer.CustomerDAO;
import posApp.PosApp;
import posinterface.BasicInterface;

public class Receipt extends BasicInterface{
    
    private JTextField searchTxt;
    private JTable table;
    JButton searchBtn = new JButton("검색");
    
    public Receipt(JPanel panel) {
        super(panel);
        panelSet(panel);
        
        searchTxt = new JTextField();
        searchTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        searchTxt.setBounds(252, 84, 281, 65);
        panel.add(searchTxt);
        searchTxt.setColumns(10);
        
        searchBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        searchBtn.setBounds(561, 84, 155, 65);
        panel.add(searchBtn);
        
        String[][] data = {};
        String[] headers = {"회원번호", "성", "이름", "성별", "전화번호", "생년월일"}; 
        DefaultTableModel model = new DefaultTableModel(data,headers);
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setResizingAllowed(false); 
        
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(57, 161, 691, 295);
        panel.add(scrollpane);
        
        searchBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String phoneNum = searchTxt.getText();
                String[][] searchData = CustomerDAO.getDao().select(phoneNum);
                model.setDataVector(searchData, headers);
                
            }
        });
        
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                
                if(e.getClickCount()==2) {
                    PosApp.customerId = (Integer.parseInt((String)table.getModel().getValueAt(table.getSelectedRow(), 0)));
                    model.setRowCount (0);
                    searchTxt.setText("");
                    System.out.println(PosApp.customerId);
                    Order.customerNameLabel.setText("고객명 " + CustomerDAO.getDao().selectName(PosApp.customerId));
                    panel.setVisible(false);
                    PosApp.orderPanel.setVisible(true);
                }
            }
        });
    }
}
