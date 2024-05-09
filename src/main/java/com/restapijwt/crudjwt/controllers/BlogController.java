package com.restapijwt.crudjwt.controllers;


import com.restapijwt.crudjwt.request.BlogRequest;
import com.restapijwt.crudjwt.response.DataResponse;
import com.restapijwt.crudjwt.response.ResponseApi;
import com.restapijwt.crudjwt.services.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    @GetMapping(value = "{a}/{b}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse> getBlog(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return blogService.showBlog(a,b);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> saveBlog(@Valid @RequestParam("image") MultipartFile foto, @ModelAttribute BlogRequest blogRequest){
        return blogService.createBlog(blogRequest,foto);
    }

    @PostMapping(value = "update/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseApi> updateBlog(
            @Valid @RequestParam("image") MultipartFile foto,
            @ModelAttribute BlogRequest blogRequest,@PathVariable("id") Integer id){
        return blogService.updateBlog(blogRequest,foto,id);
    }
    @DeleteMapping(value = "{a}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> deleteBlog(@PathVariable("a") Integer a){
        return blogService.deleteBlog(a);
    }
}
