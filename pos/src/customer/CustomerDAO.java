package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import posApp.PosApp;

public class CustomerDAO{
    
    // 싱글톤 디자인 패턴
    private static CustomerDAO dao = new CustomerDAO();
    private CustomerDAO() {}
    public static CustomerDAO getDao() {
        return dao;
    }
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    // 고객 이름 출력
    public String selectName(int customerId) {
        String customerName = "";

        con = getConnection();
        try {
            String sql = "SELECT last_name, first_name FROM customer WHERE id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                customerName += rs.getString("last_name") + " ";
                customerName += rs.getString("first_name");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(rs != null)try {rs.close();} catch (Exception e) {}
            if(pstmt != null)try {pstmt.close();} catch (Exception e) {}
            if(con != null)try {con.close();} catch (Exception e) {}
        }
        return customerName;
    }
    
    // 휴대폰 번호 뒷자리로 고객 검색
    public String[][] select(String phoneNum) {
        String[][] arr = null;
        ArrayList<String[]> list = new ArrayList<>();
        
        con = getConnection();
        
        try {
            String sql = "SELECT * FROM customer WHERE phone LIKE ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%"+phoneNum);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new String[] {rs.getString("id"), rs.getString("last_name"),rs.getString("first_name"),
                rs.getString("gender"),rs.getString("phone"),rs.getString("birth")
                });
                arr = new String[list.size()][5];
                
            }


        } catch (SQLException e) {
             System.out.println("예외 발생!" + e.getMessage());
        } finally {
            if(rs != null)try {rs.close();} catch (Exception e) {}
            if(pstmt != null)try {pstmt.close();} catch (Exception e) {}
            if(con != null)try {con.close();} catch (Exception e) {}
        }
        return list.toArray(arr);
    }
    
    // 신규 고객 등록
    public void insert(CustomerDTO dto) {
        
        con = getConnection();
        try {
            String sql = "INSERT INTO customer VALUES(0,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getLastName());
            pstmt.setString(2, dto.getFirstName());
            pstmt.setString(3, dto.getZipCode());
            pstmt.setString(4, dto.getAddress1());
            pstmt.setString(5, dto.getAddress2());
            pstmt.setString(6, dto.getEmail());
            pstmt.setString(7, dto.getPhone());
            pstmt.setString(8, dto.getGender());
            pstmt.setString(9, dto.getBirth());
            pstmt.setTimestamp(10, dto.getDate());
            pstmt.executeUpdate();
            
            System.out.println("회원 생성 완료!");
            
        } catch (SQLException e) {
             System.out.println("예외 발생!" + e.getMessage());
        } finally {
            if(pstmt != null)try {pstmt.close();} catch (Exception e) {}
            if(con != null)try {con.close();} catch (Exception e) {}
        }
        
    }
    
    private Connection getConnection() {
        con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC";
        String user = "root";
        String password = "0000";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
             System.out.println("예외 발생!" + e.getMessage());
        } catch (SQLException e) {
             System.out.println("예외 발생!" + e.getMessage());
        } 
        
        return con;
    }
    
    
    
    
}