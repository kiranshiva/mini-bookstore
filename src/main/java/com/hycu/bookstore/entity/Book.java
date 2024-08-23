package com.hycu.bookstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String description;
    private String author;
    private String publisher;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private String genre;
    private String format;
    private int pages;
    private String language;
    private int inventoryQty;
    private float price;
    private String coverImage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Book() {
    }

    public Book(Long bookId, String title, String description, String author, String publisher, Date publicationDate, String genre, String format, int pages, String language, int inventoryQty, float price, String coverImage, Date createdDate, Date updatedDate) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.format = format;
        this.pages = pages;
        this.language = language;
        this.inventoryQty = inventoryQty;
        this.price = price;
        this.coverImage = coverImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getInventoryQty() {
        return inventoryQty;
    }

    public void setInventoryQty(int inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
