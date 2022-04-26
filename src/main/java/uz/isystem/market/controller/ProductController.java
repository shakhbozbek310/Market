package uz.isystem.market.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.dto.ProductDto;
import uz.isystem.market.service.ProductService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // |- Done: create function -|
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }


    // |- Done: getAll function -|
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }


    // |- DONE: getOne function -|
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productService.getOne(id));
    }


    // |- Done: update function -|
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable("id") Integer id,
                                    @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(id, productDto));
    }


    // |- DONE: delete function -|
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return ResponseEntity.ok("Ok, deleted!");
    }
}
