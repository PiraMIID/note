package com.noteapp.asset;

import org.springframework.web.bind.annotation.RestController;

@RestController("api/asset/")
public class AssetResource {

    private AssetService assetService;

    public AssetResource(AssetService assetService) {
        this.assetService = assetService;
    }
}
