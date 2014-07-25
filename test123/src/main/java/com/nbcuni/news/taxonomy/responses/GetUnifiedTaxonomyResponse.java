package src.main.java.com.nbcuni.news.taxonomy.responses;

import java.util.List;

import src.main.java.com.nbcuni.news.taxonomy.pojos.TaxonomyResponse;

public final class GetUnifiedTaxonomyResponse {

    private List<TaxonomyResponse> unifiedTaxonomyResponse = null;

    /**
     * 
     * @return unifiedTaxonomyResponse
     */
    public List<TaxonomyResponse> getUnifiedTaxonomyResponse() {
        return unifiedTaxonomyResponse;
    }

    /**
     * 
     * @param unifiedTaxonomyResponse
     *            The list of unified taxonomy
     */
    public void setUnifiedTaxonomyResponse(
            List<TaxonomyResponse> unifiedTaxonomyResponse) {
        this.unifiedTaxonomyResponse = unifiedTaxonomyResponse;
    }

}
