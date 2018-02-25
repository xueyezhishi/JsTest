package com.test;

import java.awt.Color;    
import java.io.FileNotFoundException;    
import java.io.FileOutputStream;    
import java.io.IOException;    
   

import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.Cell;    
import com.lowagie.text.Document;    
import com.lowagie.text.DocumentException;    
import com.lowagie.text.Font;    
import com.lowagie.text.PageSize;    
import com.lowagie.text.Paragraph;    
import com.lowagie.text.Table;    
import com.lowagie.text.rtf.RtfWriter2;   

public class aaa {
	  public static void main(String[] args) {
		  System.out.println("start");
		  exportWord();
		  System.out.println("stop");
	  }
	    public static void exportWord() {
	        Document document=null;
	        try {
	            document = new Document(); 
	            RtfWriter2.getInstance(document, new FileOutputStream("E:/test/word.doc"));
	            document.open();
	            Paragraph title = new Paragraph("你好，Word！");
	            document.add(title);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }finally{
	            if(document!=null){
	                document.close();
	            }
	        }
	    }
}
