package com.relato.msbookscatalogue.search;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "books")
public class BookDocument {

    @Id
    private String id;

    @Field(type = FieldType.Search_As_You_Type)
    private String title;

    @Field(type = FieldType.Text)
    private String author;

    @Field(type = FieldType.Text)
    private String synopsis;

    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Integer)
    private Integer rating;

    @Field(type = FieldType.Boolean)
    private Boolean visible;
}