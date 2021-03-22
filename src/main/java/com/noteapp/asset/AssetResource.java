package com.noteapp.asset;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{userName}")
public class AssetResource {

    private AssetService assetService;

    public AssetResource(AssetService assetService) {
        this.assetService = assetService;
    }


    @GetMapping("/asset/list")
    public List<AssetDto> assetDtoList(@PathVariable("userName") String userName) {
        return assetService.getList(userName);
    }

}
