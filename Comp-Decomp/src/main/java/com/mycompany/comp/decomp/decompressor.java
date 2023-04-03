/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.comp.decomp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
/**
 *
 * @author venka
 */
public class decompressor {
    static int count=0;
    public decompressor(){
        count++;
    }
    /**
     * @param args the command line arguments
     */
    public static void method(File file) throws IOException{
        String filedirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(filedirectory+"/decompressedfile"+count+".txt");
        byte[]buffer=new byte[100000];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        File path=new File("C:/Users/venka/OneDrive/Desktop/testfile/loremipsum.txt");
        method(path);
    }
    
}
