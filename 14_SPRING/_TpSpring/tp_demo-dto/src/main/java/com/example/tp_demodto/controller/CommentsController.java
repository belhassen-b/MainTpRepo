package com.example.tp_demodto.controller;


import com.example.tp_demodto.dto.CommentCreateDto;
import com.example.tp_demodto.dto.CommentDto;
import com.example.tp_demodto.dto.PostDto;
import com.example.tp_demodto.service.CommentServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentsController {

    @Autowired
    private CommentServiceMapper commentService;

    @PostMapping("/created_comment_mapper")
    public ResponseEntity<CommentDto> post(@RequestBody CommentCreateDto commentCreateDto) {
        return ResponseEntity.ok(commentService.createComment(commentCreateDto));
    }


    @GetMapping("/getComment/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(commentService.readComment(id));

    }


@GetMapping("/getCommentByPost/{id}")
public ResponseEntity<CommentDto> getCommentByPost(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(commentService.readCommentByPost(id));

}


    @GetMapping("/getCommentByIdAndPost/{id}")
    public ResponseEntity<CommentDto> getCommentByIdAndPost(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(commentService.readComment(id));

    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("id") Integer id, @RequestBody CommentCreateDto  commentCreateDto) {

        return ResponseEntity.ok((CommentDto) commentService.updateComment(id, commentCreateDto));
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Integer id) {
        String message = "Comment deleted successfully";
        commentService.deleteComment(id);
        return ResponseEntity.ok(message);
    }



}




