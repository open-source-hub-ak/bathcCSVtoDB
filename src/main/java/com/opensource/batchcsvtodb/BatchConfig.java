package com.opensource.batchcsvtodb;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.opensource.batchcsvtodb.model.Product;

@Configuration
public class BatchConfig {

	@Bean
	public ItemReader<Product> reader() {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("products.csv"));

		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "name", "description", "price");// bydefault it will use comma as delimiter

		BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Product.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		reader.setLineMapper(lineMapper);

		return reader;
	}
}
