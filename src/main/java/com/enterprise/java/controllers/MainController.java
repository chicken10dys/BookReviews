package com.enterprise.java.controllers;

import com.enterprise.java.models.Book;
import com.enterprise.java.models.Review;
import com.enterprise.java.services.BookService;
import com.enterprise.java.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	// Inject services
	@Autowired
    private BookService bookService;
	@Autowired
    private ReviewService reviewService;

	// Serve index. Index should show all books, add them to model
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    // Serve the add book form. Makes a new Book object and adds it to model 
    @GetMapping("/addbook")
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    // Add a new book to DB and redirect to root
    // The addbook form sends here
    @PostMapping("/addbook")
    public String postAddBook(@ModelAttribute("book") Book book) {
        bookService.createOrUpdateBook(book);
        return "redirect:/";
    }

    // Serve the add review form. Uses bookId in path to determine what book to review
    // Makes a new Review object and adds it to model
    @GetMapping("/addreview/{bookId}")
    public String getAddReview(@PathVariable int bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("review", new Review());
        return "addreview";
    }
    
    // Add a new review to DB and redirect to root
    // The addreview form sends here
    @PostMapping("/addreview")
    public String postAddReview(@ModelAttribute("review") Review review) {
        reviewService.createOrUpdateReview(review);
        return "redirect:/";
    }

}
