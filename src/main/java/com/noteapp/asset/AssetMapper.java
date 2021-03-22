package com.noteapp.asset;

import org.springframework.stereotype.Service;

@Service
public class AssetMapper {



    public static AssetDto toDto(Asset asset) {
        AssetDto dto = new AssetDto();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setDescription(asset.getDescription());
        dto.setCategory(asset.getCategory());
        dto.setUser(asset.getUser());
        return dto;
    }

    public static Asset toEntity(AssetDto dto) {
        Asset asset = new Asset();
        asset.setId(dto.getId());
        asset.setName(dto.getName());
        asset.setDescription(dto.getDescription());
        asset.setCategory(dto.getCategory());
        asset.setUser(dto.getUser());
        return asset;
    }
}
