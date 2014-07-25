package src.main.java.com.nbcuni.news.taxonomy.pojos;

/**
 * @author 206440791
 *
 */

public final class TaxonomyResponse {

    private String label = null;
    private String taxonomy = null;
    private String name = null;
    private String schema = null;

    /**
     * 
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *            Unified Taxonomy label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return old taxonomy
     */
    public String getTaxonomy() {
        return taxonomy;
    }

    /**
     * 
     * @param taxonomy
     *            The taxonomy from input
     */
    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            Unified Taxonomy Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return unified schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * 
     * @param schema
     *            New Unified Schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

}
