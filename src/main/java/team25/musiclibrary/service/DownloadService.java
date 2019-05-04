package team25.musiclibrary.service;

import com.thoughtworks.xstream.XStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadService {

    public static void download(Object object, HttpServletResponse response, String fileName) {
        File file = new File(fileName);
        XStream stream = new XStream();
        stream.autodetectAnnotations(true);
        try {
            stream.toXML(object, new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + fileName);
        int read;
        try (InputStream inputStream = new FileInputStream(new File(fileName));
             OutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
