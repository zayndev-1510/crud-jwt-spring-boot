package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.entity.Blogs;
import com.restapijwt.crudjwt.mapper.BlogMapper;
import com.restapijwt.crudjwt.repository.BlogRepository;
import com.restapijwt.crudjwt.repository.UserRepository;
import com.restapijwt.crudjwt.request.BlogRequest;
import com.restapijwt.crudjwt.response.BlogResponse;
import com.restapijwt.crudjwt.response.DataResponse;
import com.restapijwt.crudjwt.response.ResponseApi;
import com.restapijwt.crudjwt.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BlogService implements BlogInterface {

    private final BlogRepository blogRepository;

    @Override
    public ResponseEntity<DataResponse> showBlog(Integer a, Integer b) {
        Pageable pageable= PageRequest.of(a,b, Sort.by(Sort.Direction.DESC,"id"));
        Page<Blogs> data=blogRepository.findAll(pageable);
        List<BlogResponse> list=new ArrayList<>();
        for(Blogs blog:data){
            BlogResponse blogResponse=new BlogResponse();
            blogResponse.setId(blog.getId());
            blogResponse.setTitle(blog.getTitle());
            blogResponse.setContent(blog.getContent());
            blogResponse.setCreated(blog.getCreatedAt());
            blogResponse.setUpdated(blog.getUpdatedAt());
            blogResponse.setAuthor(blog.getAuthor());
            blogResponse.setViews(blog.getViews());
            blogResponse.setLikes(blog.getLikes());
            blogResponse.setCategory(blog.getCategory());
            blogResponse.setCommentars(blog.getComments());
            blogResponse.setFavorites(blog.getFavorites());
            UserResponse userResponse=new UserResponse();
            userResponse.setId(blog.getUsers().getId());
            userResponse.setFirstname(blog.getUsers().getFirstname());
            userResponse.setLastname(blog.getUsers().getLastname());
            userResponse.setEmail(blog.getUsers().getEmail());
            userResponse.setUsername(blog.getUsers().getUsername());
            blogResponse.setUser(userResponse);
            list.add(blogResponse);
        }
        return new ResponseEntity<>(new DataResponse("success",true,list), HttpStatus.OK);
    }

    @SneakyThrows
    private String uploadTheFile(MultipartFile foto) {
        // Create directory if it doesn't exist
        String UPLOAD_FOLDER = "./uploads/";
        File uploadDir = new File(UPLOAD_FOLDER);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        // Save the file to the specified folder
        LocalDateTime currentDateTime = LocalDateTime.now();
        String extension = Objects.requireNonNull(foto.getContentType()).split("/")[1];
        String fileName=currentDateTime+"."+extension;
        Path path = Paths.get(UPLOAD_FOLDER + File.separator + fileName);
        Files.copy(foto.getInputStream(), path);
        return fileName;
    }

    @SneakyThrows
    @Override
    public ResponseEntity<ResponseApi> createBlog(BlogRequest blogRequest, MultipartFile file) {
        String filename=null;
        // check its real image
        if (!file.isEmpty()) {
            if (ImageIO.read(file.getInputStream()) == null) {
                return new ResponseEntity<>(new ResponseApi("the file is not image",false),HttpStatus.OK);
            }
            filename=uploadTheFile(file);
        }
        blogRequest.setFoto(filename);
        Blogs blogs= BlogMapper.toBlogs(blogRequest);
        blogRepository.save(blogs);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi> updateBlog(BlogRequest blogRequest,MultipartFile multipartFile,Integer id) {
        if(blogRepository.existsById(id)){
            Blogs update=blogRepository.findById(id).get();
            BlogMapper.toBlogsUpdate(blogRequest,update);
            blogRepository.save(update);
            return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseApi("ID Invalid",false),HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ResponseApi> deleteBlog(Integer id) {
        if(blogRepository.existsById(id)){
            blogRepository.deleteById(id);
            return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseApi("ID invalid",false),HttpStatus.NOT_FOUND);
    }
}
