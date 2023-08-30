/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esquema.de.comunicación;

import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class PDFToBinaryConverter {
    public static void main(String[] args) {
        String pdfFilePath = "C:\\Users\\PC\\Desktop\\Computo.pdf"; // Ruta al archivo PDF
        try {
            // Cargar el archivo PDF
            File pdfFile = new File(pdfFilePath);
            FileInputStream inputStream = new FileInputStream(pdfFile);
            byte[] pdfBytes = new byte[(int) pdfFile.length()];
            inputStream.read(pdfBytes);
            inputStream.close();

            // Convertir bytes a cadena binaria y agregar a la pila con retraso
            Stack<String> binaryStack = new Stack<>();
            for (byte b : pdfBytes) {
                String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
                binaryStack.push(binaryString);

                // Pequeño retraso de 500 milisegundos (0.5 segundos)
                try {
                    Thread.sleep(500);
                                while (!binaryStack.isEmpty()) {
                System.out.println(binaryStack.pop());
            }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Mostrar los elementos de la pila

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
