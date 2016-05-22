package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NewsFeedService;
import service.product.ProducerService;
import service.product.ProductService;
import service.product.ProductsAndProducers;
import service.user.LoginService;
import service.user.PermissionService;
import service.user.UserService;

import java.util.List;

/**
 * Created by tolgacaner on 11/04/16.
 */
@RestController
public class FoodCoopRestController {
    //Services which will do all data retrieval/manipulation work
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @Autowired
    ProductService productService;
    @Autowired
    ProducerService producerService;
    @Autowired
    NewsFeedService newsFeedService;
    @Autowired
    PermissionService permissionService;


    //-------------------Users---------------------------------------------------------------------
    //-------------------Users---------------------------------------------------------------------
    //-------------------Users---------------------------------------------------------------------

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

        userService.updateUser(user);
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

    //-------------------Users---------------------------------------------------------------------
    //-------------------Users---------------------------------------------------------------------
    //-------------------Users---------------------------------------------------------------------

    //-------------------Login---------------------------------------------------------------------
    //-------------------Login---------------------------------------------------------------------
    //-------------------Login---------------------------------------------------------------------

    //-------------------Login Trial--------------------------------------------------------

    @RequestMapping(value = "/login/email={email}&password={password}", method = RequestMethod.GET)
    public ResponseEntity<Member> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        Member member = loginService.login(email,password);

        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    //-------------------Login---------------------------------------------------------------------
    //-------------------Login---------------------------------------------------------------------
    //-------------------Login---------------------------------------------------------------------

    //-------------------Product---------------------------------------------------------------------
    //-------------------Product---------------------------------------------------------------------
    //-------------------Product---------------------------------------------------------------------

    //-------------------Retrieve All Products--------------------------------------------------------
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<ProductsAndProducers> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<Producer> producers = producerService.getAllProducers();
        ProductsAndProducers items = new ProductsAndProducers(products,producers);
        if (products.isEmpty()) {
            return new ResponseEntity<ProductsAndProducers>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<ProductsAndProducers>(items, HttpStatus.OK);
    }

    //-------------------Retrieve Single Product--------------------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Product with id " + id);
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }



    //-------------------Create a Product--------------------------------------------------------

    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getProductName());

        if (productService.isProductExist(product)) {
            System.out.println("A Product with name " + product.getProductName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        productService.saveProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //------------------- Update a Product --------------------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);

        Product currentProduct = productService.findById(id);

        if (currentProduct==null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.updateProduct(product);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }



    //------------------- Delete a Product --------------------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Product with id " + id);

        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }



    //------------------- Delete All Products --------------------------------------------------------

    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() {
        System.out.println("Deleting All Products");

        productService.deleteAllProducts();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    //-------------------Product---------------------------------------------------------------------
    //-------------------Product---------------------------------------------------------------------
    //-------------------Product---------------------------------------------------------------------



    //-------------------NewsFeed---------------------------------------------------------------------
    //-------------------NewsFeed---------------------------------------------------------------------
    //-------------------NewsFeed---------------------------------------------------------------------

    @RequestMapping(value = "/news/", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getAllNews() {
        List<News> news = newsFeedService.getAllNews();
        if(news.isEmpty()){
            return new ResponseEntity<List<News>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<News>>(news, HttpStatus.OK);
    }

    //-------------------NewsFeed---------------------------------------------------------------------
    //-------------------NewsFeed---------------------------------------------------------------------
    //-------------------NewsFeed---------------------------------------------------------------------

}
