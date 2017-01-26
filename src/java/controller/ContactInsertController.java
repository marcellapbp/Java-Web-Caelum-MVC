package controller;

import bean.Contact;
import dao.ContactDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 */
public class ContactInsertController implements IController
{
    private String JSPPage = "ContactInsert.jsp";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        Calendar birthdayNewFormat = null;
        try {
            try {
                
                Date date = new SimpleDateFormat("ddMMyyyy").parse(birthday);
                birthdayNewFormat = Calendar.getInstance();
                birthdayNewFormat.setTime(date);
            } catch (ParseException e) {
                throw new RuntimeException("Erro de conversão da data");
            }

            Contact contact = new Contact();

            contact.setName(name);
            contact.setEmail(email);
            contact.setAddress(address);
            contact.setBirthday(birthdayNewFormat);

            ContactDAO dao = new ContactDAO();
        
            dao.setContact(contact);
        
        } catch (SQLException ex) {
            Logger.getLogger(ContactInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return JSPPage;
    }
    
}
