/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.database;

import roadrevel.entities.Reports.Reports;
import com.itextpdf.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import roadrevel.entities.Reports.ServiceReports;

/**
 *
 * @author GAMING A15
 */
public class PDFReport {
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceReports r =new ServiceReports();
        List<Reports> list=r.afficher();    
        document.add(new Paragraph("La liste des Report :"));
        document.add(new Paragraph("     "));
         for(Reports u:list)
        {
            
        document.add(new Paragraph("Subject :"+u.getReport_Subject()));
        document.add(new Paragraph(" Description :"+u.getReport_Description()));
        document.add(new Paragraph("Invovment :"+u.getInvolvment()));
        document.add(new Paragraph("Type :"+u.getIncident_type()));
        document.add(new Paragraph("Location :"+u.getIncident_location()));
        document.add(new Paragraph("Date :"+u.getIncident_date()));


        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    
}
}
