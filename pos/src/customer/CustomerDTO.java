package customer;

import java.sql.Timestamp;

public class CustomerDTO {
    
    /*
     데이터베이스 정보
    'id','int','NO','PRI',NULL,'auto_increment'
    'last_name','varchar(20)','NO','',NULL,''
    'first_name','varchar(20)','NO','',NULL,''
    'zip_code','varchar(20)','NO','',NULL,''
    'address1','varchar(50)','NO','',NULL,''
    'address2','varchar(50)','NO','',NULL,''
    'email','varchar(30)','NO','',NULL,''
    'phone','varchar(20)','NO','',NULL,''
    'gender','varchar(10)','NO','',NULL,''
    'birth','varchar(20)','NO','',NULL,''
    'date','datetime','NO','',NULL,''

    */
    
   
    private int id;
    private String lastName;
    private String firstName;
    private String zipCode;
    private String address1;
    private String address2;
    private String email;
    private String phone;
    private String gender;
    private String birth;
    private Timestamp date;
    
    public CustomerDTO() {}
    public CustomerDTO(int id, String lastName, String firstName, String zipCode, String address1, String address2,
            String email, String phone, String gender, String birth, Timestamp date) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birth = birth;
        this.date = date;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    

    
}
