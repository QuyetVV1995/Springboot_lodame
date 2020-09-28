package com.example.demo.Lesson13;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 *
 * Mọi Request ở trong method sẽ được gắn thêm prefix /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private List<todo> todoList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
        todoList.add(null);
    }

    @GetMapping("/todo")
    public List<todo> getTodoList(){
        return todoList;
    }
     /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/todo/{todoId}")
    public  todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }

    /*
    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    thành đối tượng Todo
     */
    @PutMapping("/todo/{todoId}")
    public todo editTodo(@PathVariable(name = "todoId") Integer todoId,
                         @RequestBody todo todo){
        todoList.set(todoId, todo);
        // Trả về đối tượng sau khi đã edit
        return todo;    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId){
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody todo todo) {
        todoList.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }
}
