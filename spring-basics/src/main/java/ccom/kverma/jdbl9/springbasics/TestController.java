package ccom.kverma.jdbl9.springbasics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class TestController {

    HashMap<Integer , User> userHashMap = new HashMap<>();

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getMapping(@PathVariable(value = "userId") int id){
        if (userHashMap.containsKey(id))
            return new ResponseEntity<>(userHashMap.get(id), HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        if (userHashMap.containsKey(user.getId()))
            return;
        userHashMap.put(user.getId(), user);
    }

    @GetMapping("/users")
    public HashMap<Integer, User> getAllUsers(){
        return userHashMap;
    }
}
