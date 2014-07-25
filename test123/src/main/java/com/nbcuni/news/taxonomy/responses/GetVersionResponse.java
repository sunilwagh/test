package src.main.java.com.nbcuni.news.taxonomy.responses;

public final class GetVersionResponse {

    private String version = null;
    private String date = null;

    /**
     * 
     * @return version
     */
    public final String getVersion() {
        return version;
    }

    /**
     * @param version
     *            This would be the verion of the build
     * 
     */
    public final void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return date
     */
    public final String getDate() {
        return date;
    }

    /**
     * @param date
     *            This is the date on which the build was done by Maven
     * 
     */
    public final void setDate(String date) {
        this.date = date;
    }

}
