package sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SalesDAO {
    
    // 싱글톤 디자인패턴
    private static SalesDAO instance = new SalesDAO();
    private SalesDAO() {}
    public static SalesDAO getInstance() {
        return instance;
    }
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    // 금일 매출 리턴
    public String salesToday() {
        con = getConnection();
        String todaySum = "";
        try {
            String sql = "SELECT SUM(price) \n" + 
                    "FROM sales_history\n" + 
                    "WHERE DATE_FORMAT(sales_date,\"%Y-%m-%d\") = curdate()";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                todaySum = rs.getString("SUM(price)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null)try {rs.close();} catch(Exception e){}
            if(pstmt != null)try {pstmt.close();} catch(Exception e){}
            if(con != null)try {con.close();} catch(Exception e){}
        }
        
        return todaySum;
    }
    
    // 금일 매출 내역
    public String[][] salesSelect() {
        con = getConnection();
        String[][] data = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            String sql = "SELECT s.kind, s.price, c.last_name, c.first_name, DATE_FORMAT(s.sales_date,\"%r\") AS date\n" + 
                         "FROM sales_history s join customer c\n" + 
                         "ON s.id = c.id\n" + 
                         "WHERE DATE_FORMAT(s.sales_date,\"%Y-%m-%d\") = CURDATE()";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new String[] {rs.getString("kind"), rs.getString("price"),
                          rs.getString("last_name"), rs.getString("first_name"), rs.getString("date")});
                
            }
            data = new String[list.size()][5];
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null)try {rs.close();} catch(Exception e){}
            if(pstmt != null)try {pstmt.close();} catch(Exception e){}
            if(con != null)try {con.close();} catch(Exception e){}
        }
        
        return list.toArray(data);
    }
    
    // 판매내역 등록
    public void salesInsert(SalesDTO dto) {
        
        con = getConnection();
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        try {
            String sql = "INSERT INTO sales_history VALUES(0,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getKind());
            pstmt.setString(2, dto.getPrice());
            pstmt.setInt(3, dto.getId());
            pstmt.setTimestamp(4, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null)try {pstmt.close();} catch(Exception e){}
            if(con != null)try {con.close();} catch(Exception e){}
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
