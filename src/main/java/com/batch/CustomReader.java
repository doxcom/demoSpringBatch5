package com.batch;

import org.springframework.batch.item.ItemReader;



public class CustomReader implements ItemReader<String> {

    private String[] tokens = {"Java","Spring", "Springboot","Hibernate","SpringBootBatch", "Advanced Java"};

    private int index = 0;

    @Override
    public String read() throws Exception{
        if(index >= tokens.length){
            return null;
        }

        String data = index + " + " + tokens[index];
        index++;

        System.out.println("Reading data: " + data);
        return data;
    }
}