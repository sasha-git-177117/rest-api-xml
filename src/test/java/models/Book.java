package models;

import lombok.Data;

@Data
public class Book{
    private String id;
    private String author;
    private String title;
    private String genre;
    private Float price;
    private String publish_date;
    private String description;
}
