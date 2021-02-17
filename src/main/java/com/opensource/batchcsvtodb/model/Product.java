package com.opensource.batchcsvtodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Integer id;
	private String name;
	private String description;
	private Double price;

}
