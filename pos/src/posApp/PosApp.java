package posApp;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import page.Customer;
import page.Login;
import page.Order;
import page.Receipt;
import page.Reservation;
import page.Sales;

public class PosApp {
    
    public static JFrame frame;
    public static JPanel loginPanel = new JPanel();
    public static JPanel receiptPanel = new JPanel();
    public static JPanel reservationPanel= new JPanel();
    public static JPanel customerPanel= new JPanel();
    public static JPanel salesPanel= new JPanel();
    public static JPanel orderPanel = new JPanel();
    private final Rectangle frameSize = new Rectangle(300, 100, 800, 600);
    public final static Rectangle panelSize = new Rectangle(0, 0, 800, 578);
    // 접수 과정에서 저장할 변수
    public static int customerId = 0;
    public static int sum = 0;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PosApp window = new PosApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public PosApp() {
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        // 각 패널의 구성요소를 생성
        Login login = new Login(loginPanel);
        Receipt receipt = new Receipt(receiptPanel);
        Reservation reservation = new Reservation(reservationPanel);
        Customer customer = new Customer(customerPanel);
        Sales sales = new Sales(salesPanel);
        Order order = new Order(orderPanel);
        
        loginPanel.setVisible(true);
    }

}
