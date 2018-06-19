/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCrud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author attiac
 */
public class createFile {

    public void Open(String fileURL) throws IOException {
        String slashslahs = "\\";
        fileURL = fileURL.replace("\\", "/");
       
        fileURL = "file://localhost/"+fileURL;
         System.out.println(fileURL);
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(fileURL));
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

}
