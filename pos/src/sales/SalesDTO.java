package sales;

import java.sql.Timestamp;

public class SalesDTO {
    private int idx;
    private String kind;
    private String price;
    private int id;
    private Timestamp sales_date;
    /*
     데이터베이스 정보
    'idx','int','NO','PRI',NULL,'auto_increment'
    'kind','varchar(255)','NO','',NULL,''
    'price','varchar(10)','NO','',NULL,''
    'id','int','YES','MUL',NULL,''
    'sales_date','datetime','YES','',NULL,''
    */
    
    
    public SalesDTO(int idx, String kind, String price, int id, Timestamp sales_date) {
        super();
        this.idx = idx;
        this.kind = kind;
        this.price = price;
        this.id = id;
        this.sales_date = sales_date;
    }
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getSale_date() {
        return sales_date;
    }
    public void setSale_date(Timestamp sales_date) {
        this.sales_date = sales_date;
    }
    
    
}

