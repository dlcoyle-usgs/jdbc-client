package dev.danvega.jdbcclient.post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/posts")
public class PostControllerV1 {

    private final PostService postService;

    public PostControllerV1(JdbcTemplatePostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Post> findById(@PathVariable String id) {
        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody Post post) {
        postService.create(post);
    }

    @PutMapping("/{id}")
    void update(@RequestBody Post post, @PathVariable String id) {
        postService.update(post, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        postService.delete(id);
    }

}
