package src.main.java.com.nbcuni.news.taxonomy.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.nbcuni.news.taxonomy.csv.CSVReader;
import src.main.java.com.nbcuni.news.taxonomy.exception.UnknownResourceException;
import src.main.java.com.nbcuni.news.taxonomy.pojos.TaxonomyResponse;
import src.main.java.com.nbcuni.news.taxonomy.requests.GetUnifiedTaxonomyRequest;
import src.main.java.com.nbcuni.news.taxonomy.responses.GetUnifiedTaxonomyResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/taxonomy")
public class TaxonomyController {

    final static Logger logger = LoggerFactory
            .getLogger(TaxonomyController.class);
    private CSVReader csvreader = null;
    private HashMap<String, TaxonomyResponse> hashMap = new HashMap<String, TaxonomyResponse>();

    /**
     * 
     * @return -
     */
    public final CSVReader getCsvreader() {
        return csvreader;
    }

    /**
     * 
     * @param csvreader
     *            The class which has the object which contains the name value
     *            pairs from the test file.
     */
    @Autowired
    public final void setCsvreader(CSVReader csvreader) {
        this.csvreader = csvreader;
    }

    /**
     * @param request
     *            The request from the browser or client
     */
    @RequestMapping("/**")
    public final void unmappedRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        System.out.println(uri);
        throw new UnknownResourceException("There is no resource for path "
                + uri);
    }

    /**
     * 
     * @param request
     *            The request from the browser or client
     * @param taxonomy
     *            The request body which contains the taxonomy terms
     * @return -
     */
    @RequestMapping(value = "/UnifiedTaxonomy", method = POST, consumes = "application/json")
    @ResponseBody
    public final GetUnifiedTaxonomyResponse getUnifiedTaxonomy(
            HttpServletRequest request,
            @RequestBody GetUnifiedTaxonomyRequest taxonomy) {

        logger.info("Start:TaxonomyController::getUnifiedTaxonomy()");
        GetUnifiedTaxonomyResponse getUnifiedTaxonomyResponse = new GetUnifiedTaxonomyResponse();
        List inputList = null;
        String uri = request.getRequestURI();
        logger.debug(uri);

        if (taxonomy != null && taxonomy.getUnifiedTaxonomyRequest() != null) {
            inputList = (ArrayList) taxonomy.getUnifiedTaxonomyRequest();
        } else {
            throw new UnknownResourceException("There is no input " + uri);
        }

        hashMap = getCsvreader().getHashMap();

        if (hashMap != null) {

            List<TaxonomyResponse> list = new ArrayList<TaxonomyResponse>();
            List keyList = new ArrayList(hashMap.keySet());

            for (int i = 0; i < inputList.size(); i++) {
                String input = (String) inputList.get(i);
                if (keyList.contains(input)) {
                    TaxonomyResponse tr = (TaxonomyResponse) hashMap.get(input);
                    list.add(tr);

                } else {
                    TaxonomyResponse tr = populateANullTaxonomyResponse(input);
                    list.add(tr);
                }
            }

            getUnifiedTaxonomyResponse.setUnifiedTaxonomyResponse(list);
            logger.info("End:TaxonomyController::getUnifiedTaxonomy()");
        } else {
            throw new UnknownResourceException("Error reading the sample file "
                    + uri);
        }
        return getUnifiedTaxonomyResponse;

    }

    /**
     * 
     * @param input
     *            Old Taxonomy
     * @return -
     */
    private TaxonomyResponse populateANullTaxonomyResponse(String input) {
        TaxonomyResponse tr = new TaxonomyResponse();
        tr.setTaxonomy(input);
        tr.setLabel(null);
        tr.setSchema(null);
        tr.setName(null);
        return tr;
    }

}