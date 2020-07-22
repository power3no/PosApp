package posinterface;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import posApp.PosApp;

public class BasicInterface {

    JPanel panel;
    JButton receiptBtn = new JButton("접수");
    JButton reservationBtn = new JButton("예약");
    JButton customerBtn = new JButton("고객 등록");
    JButton salesBtn = new JButton("금일 매출");

    public BasicInterface(JPanel panel) {
        this.panel = panel;
        
        receiptBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        receiptBtn.setBounds(25, 482, 180, 90);
        receiptBtn.addActionListener(listener);
        panel.add(receiptBtn);
        
        reservationBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        reservationBtn.setBounds(217, 482, 180, 90);
        reservationBtn.addActionListener(listener);
        panel.add(reservationBtn);
        
        customerBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        customerBtn.setBounds(409, 482, 180, 90);
        customerBtn.addActionListener(listener);
        panel.add(customerBtn);
        
        salesBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        salesBtn.setBounds(601, 482, 180, 90);
        salesBtn.addActionListener(listener);
        panel.add(salesBtn);
        
        RealTime realtime = new RealTime();
        realtime.dateLabel.setBounds(584, 6, 197, 53);
        panel.add(realtime.dateLabel);
        realtime.start();
        
        JLabel thisLabel = new JLabel();
        if(panel == PosApp.receiptPanel) {
            thisLabel.setText("접수");
        }
        else if(panel == PosApp.reservationPanel) {
            thisLabel.setText("예약");
        }
        else if(panel == PosApp.customerPanel) {
            thisLabel.setText("고객 등록");
        }
        else if (panel == PosApp.salesPanel) {
            thisLabel.setText("금일 매출");
        }
        thisLabel.setBounds(217, 6, 180, 53);
        thisLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        panel.add(thisLabel);
        
    }
    
    ActionListener listener = new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == receiptBtn) {
                panel.setVisible(false);
                PosApp.receiptPanel.setVisible(true);
            }
            else if(e.getSource() == reservationBtn){
                panel.setVisible(false);
                PosApp.reservationPanel.setVisible(true);
            }
            else if(e.getSource() == customerBtn) {
                panel.setVisible(false);
                PosApp.customerPanel.setVisible(true);
            }
            else if(e.getSource() == salesBtn) {
                panel.setVisible(false);
                PosApp.salesPanel.setVisible(true);
            }
        }
    };
    
    public static void panelSet(JPanel panel) {
        panel.setBounds(PosApp.panelSize);
        panel.setLayout(null);
        PosApp.frame.getContentPane().add(panel);
        panel.setVisible(false);
    }
    
}

class RealTime extends Thread{
    public JLabel dateLabel = new JLabel();
    @Override
    public void run() {
        while(true) {
            String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            dateLabel.setText(localDateTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
