package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.user.UserService;

import java.util.List;

/**
 * Created by tolgacaner on 11/04/16.
 */
@RestController
public class FoodCoopRestController {
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work


    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Member>> listAllUsers() {
        List<Member> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Member>>(users, HttpStatus.OK);
    }



    //-------------------Retrieve Single User--------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Member user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Member>(user, HttpStatus.OK);
    }



    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Member user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getFirstName() + user.getLastName());

        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getFirstName() + user.getLastName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Member> updateUser(@PathVariable("id") long id, @RequestBody Member user) {
        System.out.println("Updating User " + id);

        Member currentUser = userService.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirstName(user.getFirstName());
        currentUser.setAddressLine1(user.getAddressLine1());
        currentUser.setAddressLine2(user.getAddressLine2());
        currentUser.setPhoneNumber(user.getPhoneNumber());

        userService.updateUser(currentUser);
        return new ResponseEntity<Member>(currentUser, HttpStatus.OK);
    }



    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Member> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Member user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }



    //------------------- Delete All Users --------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Member> deleteAllUsers() {
        System.out.println("Deleting All Users");

        userService.deleteAllUsers();
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }
}
