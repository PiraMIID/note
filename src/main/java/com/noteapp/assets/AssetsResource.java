package com.noteapp.assets;

import com.noteapp.config.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetsResource {

    private AssetsService assetsService;

    public AssetsResource(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping("/{userName}/user")
    public User getUser(@PathVariable String userName) {
        return assetsService.getUser(userName);
    }

    @GetMapping("/assets")
    public List<AssetsDto> assetDtoList() {
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        System.out.println("esssa ziomek");
        return assetsService.getList();
    }

}
