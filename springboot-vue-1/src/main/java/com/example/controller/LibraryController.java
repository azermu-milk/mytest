package com.example.controller;

import com.example.bean.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Create by Administrator on 2020/1/2.
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    @CrossOrigin
    public List<Book> list(){
        return bookService.list();
    }
    @PostMapping("/api/books")
    @CrossOrigin
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    @CrossOrigin
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    @CrossOrigin
    public List<Book> listByCategory(@PathVariable("cid") int cid){
        if(0 != cid){
            return bookService.listByCategory(cid);
        }else{
            return list();
        }
    }

    public String getRandomString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < length; i++){
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }
    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file){
        String folder = "D:/word/img";
        File imgFolder = new File(folder);
        File f = new File(imgFolder, getRandomString(6) + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4));
        if(!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
