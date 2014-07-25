package src.main.java.com.nbcuni.news.taxonomy.requests;

import java.util.List;

public final class GetUnifiedTaxonomyRequest {

    private List<String> unifiedTaxonomyRequest = null;

    /**
     * 
     * @return unifiedTaxonomyRequest
     */
    public List<String> getUnifiedTaxonomyRequest() {
        return unifiedTaxonomyRequest;
    }

    /**
     * 
     * @param unifiedTaxonomyRequest
     *            Request from the browser or the client
     */
    public void setUnifiedTaxonomyRequest(List<String> unifiedTaxonomyRequest) {
        this.unifiedTaxonomyRequest = unifiedTaxonomyRequest;
    }

}
