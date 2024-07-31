package projet.karlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import projet.karlo.model.User;
import projet.karlo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    @Operation(summary="Création de l\'utilisateur")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        System.out.println(user.toString());
        return new ResponseEntity<>(userService.createUser(user) , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Modification")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    @Operation(summary="Liste de tout les voiture")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PutMapping("/activer/{id}")
    @Operation(summary="Activation de user")
    public ResponseEntity<User> activeUser(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(userService.active(id), HttpStatus.OK);
    }

    @PutMapping("/desactiver/{id}")
    @Operation(summary="Desactivation de user")
    public ResponseEntity<User> desactiveUser(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(userService.desactive(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.OK); // 204 No Content
    }
}
