package com.hjk.shopboot.utils.files;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.net.URLDecoder;
import java.util.*;

import com.hjk.dto.UserResponseDto;

@Component("FileUtils")
public class FileUtils {


    public static void productUpload(MultipartHttpServletRequest request)throws Exception{
        String[] productnamelist=request.getParameterValues("productname");
        String productname=URLDecoder.decode(productnamelist[0],"UTF-8");
        
        File f = ResourceUtils.getFile("classpath:static");
        String folderpath = f.getAbsolutePath()+"/files/products/"+productname+"/";
        File file = new File(folderpath);

        if(!file.exists()) file.mkdirs();

        Iterator<String> iterator=request.getFileNames();
        MultipartFile multipartFile=null;

        while(iterator.hasNext()){
            multipartFile=request.getFile(iterator.next());

              if(!multipartFile.isEmpty()){
                String originalName=multipartFile.getOriginalFilename();
                String save_path=folderpath+originalName;
                file=new File(save_path);
                multipartFile.transferTo(file);
            }
        }
    }

    public static void profileUpload(MultipartHttpServletRequest request,UserResponseDto user)throws Exception{
        File f = ResourceUtils.getFile("classpath:static");
        String folderpath = f.getAbsolutePath()+"/files/users/"+user.getAccountId()+"("+ user.getId()+")"+"/";
        File file = new File(folderpath);

        if(!file.exists()) file.mkdirs();

        Iterator<String> iterator=request.getFileNames();
        MultipartFile multipartFile=null;

        while(iterator.hasNext()){
            multipartFile=request.getFile(iterator.next());

              if(!multipartFile.isEmpty()){
                String originalName=multipartFile.getOriginalFilename();
                String save_path=folderpath+originalName;
                file=new File(save_path);
                multipartFile.transferTo(file);
            }
        }
    }
}