import java.io.IOException; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.net.Authenticator;
import java.util.*; 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


@WebServlet("/mainservlet")
@MultipartConfig(location="C://TEMP")
public class mainservlet extends HttpServlet {
   mainservlet javaEmail=null;
 public void init() throws ServletException {}
     public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
       {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
           String toMail = request.getParameter("email");
         

          try {
           mainservlet javaEmail = new mainservlet();

         javaEmail.sendEmail(toMail);
           }
            
            out.println("Process Completed\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name="event registered successfully";
        response.getWriter().write(name);
         RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
        rd.include(request, response); 

    }

        public static void sendEmail(String to)
{
final String username = "divyadharshini.g@kggroup.com";
final String password = "dd.nayagam";
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "false");
props.put("mail.smtp.host", "webmail.kggroup.com");
props.put("mail.smtp.port", "25");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("divyadharshini.g@kggroup.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(to));
message.setSubject("A testing mail header !!!");
message.setText("registerd successfully!");


Transport.send(message);
System.out.println("Done");


}
catch (MessagingException e)
{
throw new RuntimeException(e);

}
}

}