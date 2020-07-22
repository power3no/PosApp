package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import posApp.PosApp;
import posinterface.BasicInterface;

public class Login {
    
    private JTextField idTxt;
    private JPasswordField passwordTxt;
    JButton loginBtn = new JButton("Login");
    
    private String id = "admin";
    private String password = "1234";
    
    public Login(JPanel panel) {
        
        BasicInterface.panelSet(panel);
        
        idTxt = new JTextField();
        idTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        idTxt.setBounds(275, 336, 280, 70);
        panel.add(idTxt);
        idTxt.setColumns(10);
        
        passwordTxt = new JPasswordField();
        passwordTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        passwordTxt.setBounds(275, 418, 280, 70);
        panel.add(passwordTxt);
        
        loginBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        loginBtn.setBounds(585, 382, 187, 70);
        loginBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(idTxt.getText().equals(id)) {
                    if(password.equals(new String(passwordTxt.getPassword()))) {
                        panel.setVisible(false);
                        PosApp.receiptPanel.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
                }
                
            }
        });
        panel.add(loginBtn);
        
        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        lblNewLabel.setBounds(223, 336, 40, 70);
        panel.add(lblNewLabel);
        
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        lblPassword.setBounds(102, 418, 161, 70);
        panel.add(lblPassword);
    }
}
