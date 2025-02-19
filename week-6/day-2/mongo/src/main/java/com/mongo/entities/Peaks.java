package com.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("peaks")
public class Peaks {

private String name;
private int height;
private List<String> location;
private Ascents ascents;
private int total;
}
