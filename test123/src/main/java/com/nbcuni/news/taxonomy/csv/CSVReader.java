package src.main.java.com.nbcuni.news.taxonomy.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.HashMap;
import java.util.List;
import src.main.java.com.nbcuni.news.taxonomy.pojos.TaxonomyResponse;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVReader {

    final static Logger logger = LoggerFactory.getLogger(CSVReader.class);

    private String fileResource = null;
    private HashMap<String, TaxonomyResponse> hashMap = new HashMap<String, TaxonomyResponse>();

    /**
     * 
     */
    public final void readFromFile() {
        logger.info("Start:CSVReader::readFromFile()");
        CsvToBean<TaxonomyResponse> bean = new CsvToBean<TaxonomyResponse>();

        // Define strategy
        ColumnPositionMappingStrategy<TaxonomyResponse> strategy = new ColumnPositionMappingStrategy<TaxonomyResponse>();
        strategy.setType(TaxonomyResponse.class);
        strategy.setColumnMapping(new String[] { "taxonomy", "label", "schema",
                "name" });

        // Parse the CSV
        logger.debug("File Resource" + getFileResource());

        File f = new File(CSVReader.class.getClassLoader()
                .getResource(getFileResource()).getFile());

        try (final Reader reader = new FileReader(f)) {

            logger.debug("Reading the file");
            List<TaxonomyResponse> list = bean.parse(strategy, reader);

            for (int i = 0; i < list.size(); i++) {

                TaxonomyResponse txr = (TaxonomyResponse) list.get(i);
                hashMap.put(txr.getTaxonomy(), txr);
            }
        } catch (IOException ex) {
            logger.error("IOException" + ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

        logger.info("End:CSVReader::readFromFile()");

    }

    /**
     * 
     * @return -
     */
    public final HashMap<String, TaxonomyResponse> getHashMap() {
        return hashMap;
    }

    /**
     * 
     * @param hashMap
     *            Key: Old Taxonomy Value: Unified Taxonomy Object
     */
    public final void setHashMap(HashMap<String, TaxonomyResponse> hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * 
     * @return -
     */

    public final String getFileResource() {
        return fileResource;
    }

    /**
     * 
     * @param fileResource
     *            The sample file 'test.csv' which contains the old taxonomy and
     *            the name,schema and label for new taxonomy.
     */
    public final void setFileResource(String fileResource) {
        this.fileResource = fileResource;
    }

}
