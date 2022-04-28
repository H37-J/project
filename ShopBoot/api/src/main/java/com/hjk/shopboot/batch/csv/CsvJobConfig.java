package com.hjk.shopboot.batch.csv;

import javax.persistence.EntityManagerFactory;

import com.hjk.shopboot.batch.JpaQueryProvider;
import com.hjk.model.Product;
import com.hjk.model.User;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import java.io.IOException;
import java.io.Writer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CsvJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private final CsvJobListener csvBatchListener;

    private final Integer CHUNK_SIZE = 10;
    private final Integer PAGE_SIZE=10;

    // @Bean
    // public Job comingJob() {
    //     return jobBuilderFactory.get("comingJob").start(comingStep()).build();
    // }

    @Bean
    public Job ProductCsvJob() throws Exception{
        return jobBuilderFactory.get("productCsvJob").incrementer(new RunIdIncrementer()).listener(csvBatchListener)
                .start(csvProductStep()).next(csvUserStep()).build();
    }

    @Bean
    public Step comingStep() {
        return stepBuilderFactory.get("comingStep").tasklet(new CsvTasklet()).build();
    }

    @Bean
    @JobScope
    public Step csvProductStep() throws Exception{
        return stepBuilderFactory.get("csvProductStep")
            .<Product,Product>chunk(CHUNK_SIZE)
            .reader(csvProductReader())
            .writer(csvProductWriter())
            .build();
    }

    @Bean
    @JobScope
    public Step csvUserStep() throws Exception{
        return stepBuilderFactory.get("csvUserStep")
        .<User,User>chunk(CHUNK_SIZE)
        .reader(csvUserReader())
        .writer(csvUserWriter())
        .build();
    }

    public JpaPagingItemReader<User> csvUserReader() throws Exception {
        JpaPagingItemReader<User> jpaPagingItemReader = new JpaPagingItemReader<>();
        JpaQueryProvider<User> queryProvider = new JpaQueryProvider<>();
        JpaNativeQueryProvider<User> jpaNativeQueryProvider = queryProvider
                .getJpaNativeQueryProvider("select * from User", User.class);
        setJpaPagingItemReader(jpaPagingItemReader, jpaNativeQueryProvider);

        return jpaPagingItemReader;
    }
    
    public JpaPagingItemReader<Product> csvProductReader() throws Exception {
        JpaPagingItemReader<Product> jpaPagingItemReader = new JpaPagingItemReader<>();
        JpaQueryProvider<Product> queryProvider = new JpaQueryProvider<>();
        JpaNativeQueryProvider<Product> jpaNativeQueryProvider = queryProvider
                .getJpaNativeQueryProvider("select * from product", Product.class);
        setJpaPagingItemReader(jpaPagingItemReader, jpaNativeQueryProvider);

        return jpaPagingItemReader;
    }


    public FlatFileItemWriter<User> csvUserWriter() throws Exception{
        FlatFileItemWriter<User> flatFileItemWriter=new FlatFileItemWriter<>();
        flatFileItemWriter.setResource(new FileSystemResource("src/main/resources/User.csv"));
        flatFileItemWriter.setAppendAllowed(true);

        BeanWrapperFieldExtractor<User> extractor = new BeanWrapperFieldExtractor<>();

		extractor.setNames(new String[] {"id","createAt","accountId","name","email","point","role"});
		DelimitedLineAggregator<User> aggregator = new DelimitedLineAggregator<>();
		aggregator.setDelimiter(",");
        aggregator.setFieldExtractor(extractor);
        flatFileItemWriter.setAppendAllowed(false);
        flatFileItemWriter.setShouldDeleteIfExists(true);
        flatFileItemWriter.setHeaderCallback(new FlatFileHeaderCallback(){ 
            @Override
            public void writeHeader(Writer writer) throws IOException{
                writer.write("id,createAt,accountId,name,email,point,role");
            }
        });
        flatFileItemWriter.setLineAggregator(aggregator);
    

        return flatFileItemWriter;
    }

    public FlatFileItemWriter<Product> csvProductWriter() throws Exception{
        FlatFileItemWriter<Product> flatFileItemWriter=new FlatFileItemWriter<>();
        flatFileItemWriter.setResource(new FileSystemResource("src/main/resources/product.csv"));
        flatFileItemWriter.setAppendAllowed(true);

        BeanWrapperFieldExtractor<Product> extractor = new BeanWrapperFieldExtractor<>();

        //정의한 필드들만 추출
		extractor.setNames(new String[] {"id","createAt","title","content","price","stock","size","category_main","category_sub"});
		DelimitedLineAggregator<Product> aggregator = new DelimitedLineAggregator<>();
		aggregator.setDelimiter(",");
        aggregator.setFieldExtractor(extractor);
        flatFileItemWriter.setAppendAllowed(false);
        flatFileItemWriter.setShouldDeleteIfExists(true);
        flatFileItemWriter.setHeaderCallback(new FlatFileHeaderCallback(){ 
            @Override
            public void writeHeader(Writer writer) throws IOException{
                writer.write("id,title,content,price,stock,size,category_main,category_sub");
            }
        });
        flatFileItemWriter.setLineAggregator(aggregator);
    

        return flatFileItemWriter;
    }

    private void setJpaPagingItemReader(JpaPagingItemReader<?> jpaPagingItemReader, JpaNativeQueryProvider<?> jpaNativeQueryProvider) {
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryProvider(jpaNativeQueryProvider);
        jpaPagingItemReader.setPageSize(PAGE_SIZE);
    }

}

