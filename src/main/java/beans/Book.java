package beans;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private Integer release;
    private Double price;
    private String picture;
    private Integer publisherId;
    private Integer categoryId;

    public Book() {
    }

    public Book(String bookId, String title, String author, Integer release, Double price, String picture, Integer publisherId, Integer categoryId) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.release = release;
        this.price = price;
        this.picture = picture;
        this.publisherId = publisherId;
        this.categoryId = categoryId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRelease() {
        return release;
    }

    public void setRelease(Integer release) {
        this.release = release;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}