package jayon.learning.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import jayon.learning.lambda.service.TransformImage;

@RestController
@RequestMapping("/")
public class UploadController {
    @Autowired
    private TransformImage _uploadS3;

    @PostMapping
    public ResponseEntity<String> add(@RequestPart("img") byte[] img) {
        System.out.println("img: " + img);
        return ResponseEntity.ok(_uploadS3.uploadImage(img));
    }

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hola");
    }

}
