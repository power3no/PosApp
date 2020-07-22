package page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import customer.CustomerDAO;
import customer.CustomerDTO;
import posApp.PosApp;
import posinterface.BasicInterface;

public class Customer extends BasicInterface{
    private JTextField lastNameTxt;
    private JTextField firstNameTxt;
    private JTextField zipCodeTxt;
    private JTextField addressTxt1;
    private JTextField addressTxt2;
    private JTextField phoneTxt1;
    private JTextField phoneTxt2;
    private JTextField phoneTxt3;
    private JTextField birthYearTxt;
    private JTextField birthMonthTxt;
    private JTextField birthDayTxt;
    private JTextField emailTxt;
    JRadioButton maleRadio = new JRadioButton("남성");
    JRadioButton femaleRadio = new JRadioButton("여성");
    
    public Customer(JPanel panel) {
        super(panel);
        panelSet(panel);
        
        JLabel lblNewLabel = new JLabel("성");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(25, 73, 149, 53);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("우편번호");
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(25, 138, 103, 53);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("주소2");
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(25, 268, 149, 53);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("전화번호");
        lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(25, 333, 149, 53);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("생년월일");
        lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(25, 398, 103, 53);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_7 = new JLabel("성별");
        lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(409, 333, 69, 53);
        panel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_9 = new JLabel("주소1");
        lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(25, 203, 69, 53);
        panel.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("이메일");
        lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_10.setBounds(409, 268, 69, 53);
        panel.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("이름");
        lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_11.setBounds(409, 73, 69, 53);
        panel.add(lblNewLabel_11);
        
        lastNameTxt = new JTextField("");
        lastNameTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lastNameTxt.setBounds(140, 75, 242, 55);
        panel.add(lastNameTxt);
        lastNameTxt.setColumns(10);

        firstNameTxt = new JTextField("");
        firstNameTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        firstNameTxt.setColumns(10);
        firstNameTxt.setBounds(482, 71, 242, 55);
        panel.add(firstNameTxt);
        
        zipCodeTxt = new JTextField("");
        zipCodeTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        zipCodeTxt.setColumns(10);
        zipCodeTxt.setBounds(140, 138, 242, 55);
        panel.add(zipCodeTxt);
        
        addressTxt1 = new JTextField("");
        addressTxt1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        addressTxt1.setColumns(10);
        addressTxt1.setBounds(140, 201, 584, 55);
        panel.add(addressTxt1);
        
        addressTxt2 = new JTextField("");
        addressTxt2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        addressTxt2.setColumns(10);
        addressTxt2.setBounds(140, 268, 242, 55);
        panel.add(addressTxt2);
        
        emailTxt = new JTextField("");
        emailTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        emailTxt.setColumns(10);
        emailTxt.setBounds(482, 267, 242, 55);
        panel.add(emailTxt);
        
        phoneTxt1 = new JTextField("");
        phoneTxt1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        phoneTxt1.setColumns(10);
        phoneTxt1.setBounds(140, 333, 77, 55);
        panel.add(phoneTxt1);
        
        phoneTxt2 = new JTextField("");
        phoneTxt2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        phoneTxt2.setColumns(10);
        phoneTxt2.setBounds(222, 333, 77, 55);
        panel.add(phoneTxt2);
        
        phoneTxt3 = new JTextField("");
        phoneTxt3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        phoneTxt3.setColumns(10);
        phoneTxt3.setBounds(305, 333, 77, 55);
        panel.add(phoneTxt3);
        
        birthYearTxt = new JTextField("");
        birthYearTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        birthYearTxt.setColumns(10);
        birthYearTxt.setBounds(140, 398, 77, 55);
        panel.add(birthYearTxt);
        
        birthMonthTxt = new JTextField("");
        birthMonthTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        birthMonthTxt.setColumns(10);
        birthMonthTxt.setBounds(222, 398, 77, 55);
        panel.add(birthMonthTxt);
        
        birthDayTxt = new JTextField("");
        birthDayTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        birthDayTxt.setColumns(10);
        birthDayTxt.setBounds(305, 398, 77, 55);
        panel.add(birthDayTxt);
        
        maleRadio.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        maleRadio.setBounds(482, 333, 118, 53);
        maleRadio.setSelected(true);
        panel.add(maleRadio);
        
        femaleRadio.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        femaleRadio.setBounds(601, 333, 118, 53);
        panel.add(femaleRadio);
        
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);
        
        JButton resetBtn = new JButton("초기화");
        resetBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        resetBtn.setBounds(409, 398, 180, 53);
        panel.add(resetBtn);
        
        JButton submitBtn = new JButton("고객 등록");
        submitBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        submitBtn.setBounds(601, 398, 180, 53);
        panel.add(submitBtn);
        
        JButton searchAddressBtn = new JButton("주소 검색");
        searchAddressBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        searchAddressBtn.setBounds(409, 138, 180, 53);
        panel.add(searchAddressBtn);
        
        // 전체 리셋
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });     
        // 고객 정보 저장
        submitBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lastNameTxt.getText().equals("") || firstNameTxt.getText().equals("") || 
                        zipCodeTxt.getText().equals("") || addressTxt1.getText().equals("") || 
                        addressTxt2.getText().equals("") ||  emailTxt.getText().equals("")||
                        phoneTxt1.getText().equals("") ||  phoneTxt2.getText().equals("")|| 
                        phoneTxt3.getText().equals("") || birthYearTxt.getText().equals("")||
                        birthMonthTxt.getText().equals("") || birthDayTxt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "고객 정보를 전부 기입해주세요!");
                }
                else {
                    String phone = phoneTxt1.getText() + "-" + phoneTxt2.getText() + "-" + phoneTxt3.getText();
                    String gender = "";
                    if(maleRadio.isSelected()) {
                        gender = "male";
                    } else if(femaleRadio.isSelected()){
                        gender = "female";
                    }
                    String birth = birthYearTxt.getText() + "/" + birthMonthTxt.getText() + "/" + birthDayTxt.getText();
                    LocalDateTime localDateTime = LocalDateTime.now();
                    Timestamp date = Timestamp.valueOf(localDateTime);
                    
                    CustomerDTO dto = new CustomerDTO(0,lastNameTxt.getText(),firstNameTxt.getText(),
                            zipCodeTxt.getText(),addressTxt1.getText(),addressTxt2.getText(),
                            emailTxt.getText(),phone,gender,birth,date);
                    
                    CustomerDAO.getDao().insert(dto);
                    JOptionPane.showInternalMessageDialog(null, "신규 고객을 등록하였습니다!");
                    reset();
                }
            }
        });
        
    }

    public void reset() {
        lastNameTxt.setText("");
        firstNameTxt.setText("");
        zipCodeTxt.setText("");
        addressTxt1.setText("");
        addressTxt2.setText("");
        phoneTxt1.setText("");
        phoneTxt2.setText("");
        phoneTxt3.setText("");
        birthYearTxt.setText("");
        birthMonthTxt.setText("");
        birthDayTxt.setText("");
        emailTxt.setText("");
        maleRadio.setSelected(true);
        femaleRadio.setSelected(false);
    }
}
