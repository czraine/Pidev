/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.api;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Reports.Reports;
import roadrevel.entities.Events.ServicesEvents;

/**
 *
 * @author GAMING A15
 */
public class PDFEvent {
    
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServicesEvents r =new ServicesEvents();
        List<Events> list=r.afficher();    
        document.add(new Paragraph("La liste des Report :"));
        document.add(new Paragraph("     "));
         for(Events u:list)
        {
            
        document.add(new Paragraph("nom :"+u.getEvent_name()));
        document.add(new Paragraph(" City name :"+u.getCityName()));
        document.add(new Paragraph("description :"+u.getEvent_description()));
        document.add(new Paragraph("Price :"+u.getEventPrice()));
        document.add(new Paragraph("Poster :"+u.getEventPoster()));
        document.add(new Paragraph("photo :"+u.getEvent_pic2()));
        document.add(new Paragraph("Photo :"+u.getEvent_pic3()));


        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    
}
}
