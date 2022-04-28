package com.hjk.shopboot.api;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpSession;
import com.hjk.dto.UserResponseDto;
import com.hjk.model.Product;
import com.hjk.shopboot.utils.files.FileUtils;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    @ApiOperation(value="상품업로드 API")
    @RequestMapping(value="/productUpload",method=RequestMethod.POST)
    public void productUpload(MultipartHttpServletRequest request) throws Exception{
        FileUtils.productUpload(request);
    }

    @ApiOperation(value="유저 프로파일 이미지 업로드 API")
    @RequestMapping(value="/ProfileImageUpload", method=RequestMethod.POST)
    public void profilieUpload(MultipartHttpServletRequest request,HttpSession session) throws Exception{
        FileUtils.profileUpload(request,(UserResponseDto)session.getAttribute("User"));
    }
}
