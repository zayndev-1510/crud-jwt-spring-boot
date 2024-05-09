package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.request.BlogRequest;
import com.restapijwt.crudjwt.response.DataResponse;
import com.restapijwt.crudjwt.response.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BlogInterface {
    ResponseEntity<DataResponse> showBlog(Integer a,Integer b);
    ResponseEntity<ResponseApi> createBlog(BlogRequest blogRequest, MultipartFile multipartFile);
    ResponseEntity<ResponseApi> updateBlog(BlogRequest blogRequest,MultipartFile multipartFile,Integer id);
    ResponseEntity<ResponseApi> deleteBlog(Integer id);

}
