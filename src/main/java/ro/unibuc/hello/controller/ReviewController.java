package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.dto.ProductDTO;
import ro.unibuc.hello.dto.ReviewDTO;
import ro.unibuc.hello.service.ProductService;
import ro.unibuc.hello.service.ReviewService;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/product/{productId}/reviews")
    @ResponseBody
    public List<ReviewDTO> getProductReviews(@PathVariable Long productId) {
        return reviewService.getProductReviews(productId);
    }

    @PostMapping("/product/{productId}/reviews")
    @ResponseBody
    public String addProductReview(@PathVariable String sku, @RequestBody ReviewDTO reviewDTO)
    {
            productService.addProductReview(sku, reviewDTO) ;
             return "Success";
    }

}
