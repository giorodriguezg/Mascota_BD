package co.grgiral.mascota;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    private EditText etNombre;//= (TextView) findViewById(R.id.tvNombre);
    private EditText etEmail;//l= (TextView) findViewById(R.id.tvEmail);
    private EditText etMensaje;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = findViewById(R.id.etNombre);
        etMensaje = findViewById(R.id.etMensaje);
        etEmail = findViewById(R.id.etEmail);
    }

    public void enviar(View v) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties props=new Properties();
        /*properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");*/

        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.EnableSSL.enable","true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        try {

            session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication((String) getResources().getString(R.string.email_from),(String) getResources().getString(R.string.email_pass));
                    //super.PasswordAuthentication(etEmail.getText().toString(), "3cs3ms321");
                }
            });

            if(session != null){
                Message message= new MimeMessage(session);
                message.setFrom(new InternetAddress((String) getResources().getString(R.string.email_from)));
                message.setSubject("Comentario Mascota");
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(etEmail.getText().toString()));
                message.setContent(etMensaje.getText().toString(),"text/html; charset=utf-8");
                Transport.send(message);
            }

            //GridLayoutManager gridLayoutManager= new GridLayoutManager(getCo, 3);



        } catch (Exception e){
            e.printStackTrace();
        }



    }

}
