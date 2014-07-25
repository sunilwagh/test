package src.main.java.com.nbcuni.news.taxonomy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.nbcuni.news.taxonomy.responses.GetVersionResponse;

@Controller
@RequestMapping("/version")
public class VersionController {

    final static Logger logger = LoggerFactory
            .getLogger(VersionController.class);
    private GetVersionResponse getVersionResponse = null;

    /**
     * 
     * @return -
     */
    public final GetVersionResponse getGetVersionResponse() {
        return getVersionResponse;
    }

    /**
     * 
     * @param getVersionResponse
     *            The object which contains the version and date.
     */
    @Autowired
    public final void setGetVersionResponse(
            GetVersionResponse getVersionResponse) {
        this.getVersionResponse = getVersionResponse;
    }

    /**
     * @param request
     *            The request from the browser or client
     * @return -
     */
    @RequestMapping("/**")
    @ResponseBody
    public final String unmappedRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String response = "";
        FileInputStream fisTargetFile = null;
        try {
            // fisTargetFile = new FileInputStream(new
            // File(VersionController.class.getClassLoader().getResource("version.json").getFile()));

            /*
             * int content; while ((content = fisTargetFile.read()) != -1) { //
             * convert to char and display it System.out.println((char)
             * content); }
             */
            File f = new File(VersionController.class.getClassLoader()
                    .getResource("version.json").getFile());
            response = readFile(f);
        } catch (Exception ex) {
            logger.error("Exception:" + ex.getMessage(), ex);
        } finally {
            try {
                if (fisTargetFile != null) {
                    fisTargetFile.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return response;

    }

    /**
     * 
     * @param file
     *            The 'version.json' file which contains the 'build' and 'date'
     * @return -
     * @throws IOException
     *             Can't find the version.json in the classpath
     */
    private String readFile(File file) throws IOException {

        // File files = new File(file);
        // logger.error("Files Canonical Path"+files.getCanonicalPath());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        // String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            // stringBuilder.append( ls );
        }

        return stringBuilder.toString();
    }

}