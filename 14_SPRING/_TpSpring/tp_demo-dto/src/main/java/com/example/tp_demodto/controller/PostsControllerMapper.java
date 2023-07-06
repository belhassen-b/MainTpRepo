package com.example.tp_demodto.controller;


import com.example.tp_demodto.dto.PostCreateDto;
import com.example.tp_demodto.dto.PostDto;
import com.example.tp_demodto.service.PostServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostsControllerMapper {

    @Autowired
    private PostServiceMapper postService;


    @GetMapping("/getPost/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(postService.readPost(id));

    }

    @PostMapping("/created_post_mapper")
    public ResponseEntity<PostDto> post(@RequestBody PostCreateDto postCreateDto) {

        return new ResponseEntity<>(postService.createPost(postCreateDto), HttpStatus.CREATED);
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") Integer id, @RequestBody PostCreateDto postCreateDto) {

    return ResponseEntity.ok(postService.updatePost(id, postCreateDto));
}
@DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer id) {
        String message = "Post deleted successfully";
        postService.deletePost(id);
        return ResponseEntity.ok(message);
    }
}
