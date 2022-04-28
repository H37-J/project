package com.hjk.shopboot.utils.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hjk.model.Cart;
import com.hjk.model.Product;

public class ConvertUtils<T> {

    //표시개수 DESC
    public static<T> List<T> convertDisplay(List<T> data,int count){
        List<T> list=new ArrayList<T>();
        int size=data.size();
        
        for(int i=size-1; i>=size-count; i--){
            if(i<0) break;
            list.add(data.get(i));
        }
        return list;
    }

    //카테고리 분리
    public static List<Product> convertCategory(List<Product> product,String category){
        return product.stream().filter(p ->  p.getCategory_main().equals(category)).collect(Collectors.toList());
    }

  
    
}
