package dao;

import bean.Contact;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import persistence.ConnectionFactory;

/**
 *
 * @author marcella
 */
public class ContactDAO 
{
    private Connection conn;
    
    public ContactDAO()
    {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void setContact(Contact contact) throws SQLException
    {
        try
        {
            String sql = "insert into Contatos (nome, endereco, email, datanasc)"
                    + "values(?,?,?,?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getEmail());
            pstmt.setDate(4, new Date(contact.getBirthday().getTimeInMillis()));
            
            pstmt.executeQuery();
            pstmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Error: " + e);
        }finally{
            conn.close();
        }
    }
    
    public void setContact(Contact contact, int id) throws SQLException
    {
        try
        {
            String sql = "update Contatos set"
                    + "nome      =?"
                    + ",endereco =?"
                    + ",email    =?"
                    + ",datanasc =?"
                    + "where id=?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getEmail());
            pstmt.setDate(4, new Date(contact.getBirthday().getTimeInMillis()));
            pstmt.setLong(5, id);
            
            pstmt.executeQuery();
            pstmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Error: " + e);
        }finally{
            conn.close();
        }
    }
    
    public void setContact(int id) throws SQLException
    {
        try
        {
            String sql = "delete from Contatos "
                    + "where id=?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            
            pstmt.executeQuery();
            pstmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Error: " + e);
        }finally{
            conn.close();
        }
        
    }
    
    public Contact getContact(int id) throws SQLException
    {
        Contact contact = new Contact();
            
        try{
            String sql = "select * from Contatos where id=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) 
            {
                contact.setName(rs.getString("nome"));
                contact.setAddress(rs.getString("endereco"));
                contact.setEmail(rs.getString("email"));
                
                Calendar date = Calendar.getInstance();
                date.setTime(rs.getDate("datanasc"));
                contact.setBirthday(date);
            }
            
            rs.close();
            pstmt.close();
                    
        }catch(SQLException e)
        {
            throw new RuntimeException("Error: " + e);
        }finally{
            conn.close();
        }
        return contact;
    }
    
    public List<Contact> getContactList() throws SQLException
    {
        List<Contact> contactList = new ArrayList<Contact>();
            
        try{
            String sql = "select * from Contatos";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) 
            {
                Contact contact = new Contact();
                contact.setName(rs.getString("nome"));
                contact.setAddress(rs.getString("endereco"));
                contact.setEmail(rs.getString("email"));
                
                Calendar date = Calendar.getInstance();
                date.setTime(rs.getDate("datanasc"));
                contact.setBirthday(date);
                
                contactList.add(contact);
            }
            
            rs.close();
            pstmt.close();
                    
        }catch(SQLException e)
        {
            throw new RuntimeException("Error: " + e);
        }finally{
            conn.close();
        }
        return contactList;
    }
    
}
