package com.restapijwt.crudjwt.mapper;

import com.restapijwt.crudjwt.entity.Blogs;
import com.restapijwt.crudjwt.entity.Users;
import com.restapijwt.crudjwt.request.BlogRequest;

public class BlogMapper {

    public static Blogs toBlogs(BlogRequest blogRequest) {
        Blogs blogs = new Blogs();
        blogs.setAuthor(blogRequest.getAuthor());
        blogs.setTitle(blogRequest.getTitle());
        blogs.setContent(blogRequest.getContent());
        blogs.setCategory(blogs.getCategory());
        blogs.setImage(blogRequest.getFoto());
        blogs.setTags(blogRequest.getTags());
        blogs.setLikes(blogRequest.getLikes());
        blogs.setComments(blogRequest.getComments());
        blogs.setViews(blogRequest.getViews());
        blogs.setFavorites(blogRequest.getFavorites());
        blogs.setCategory(blogRequest.getCategory());
        Users user=new Users();
        user.setId(blogRequest.getUser());
        blogs.setUsers(user);
        return blogs;
    }

    public static void toBlogsUpdate(BlogRequest blogRequest, Blogs update) {
        update.setAuthor(blogRequest.getAuthor());
        update.setTitle(blogRequest.getTitle());
        update.setContent(blogRequest.getContent());
        update.setCategory(blogRequest.getCategory());
        update.setTags(blogRequest.getTags());
        update.setImage(blogRequest.getFoto());
        update.setLikes(blogRequest.getLikes());
        update.setComments(blogRequest.getComments());
        update.setViews(blogRequest.getViews());
        update.setFavorites(blogRequest.getFavorites());
        update.setCategory(blogRequest.getCategory());
        Users user=new Users();
        user.setId(blogRequest.getUser());
        update.setUsers(user);
        update.setUsers(user);
    }
}
