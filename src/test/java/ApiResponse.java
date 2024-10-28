import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("total")
    private int total;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("data")  // This maps to the list of Page objects
    private List<Page> data;



    // Getters and setters for each field
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getPerPage() { return perPage; }
    public void setPerPage(int perPage) { this.perPage = perPage; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }

    public List<Page> getData() {
        return data;
    }

    public void setData(List<Page> data) {
        this.data = data;
    }
}
