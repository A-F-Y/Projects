// import packages
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;
// java class QR code generator
public class QRGenerator {
    public static void main(String[] args) throws WriterException, IOException {
        // website that will display for QR code
        String data="www.google.com";
        String path="C:\\Users\\TTGDr\\Desktop\\qrcode.jpg"; // path where the QR code filename and image will generate

        BitMatrix matrix = new MultiFormatWriter()
                .encode(data, BarcodeFormat.QR_CODE, 500, 500); // creates size of QR code

        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path)); // writes the QR code jpg to the path

        System.out.println("QR code is successfully created"); // message to display the QR code has been generated
    }
}
