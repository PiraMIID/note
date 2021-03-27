package com.noteapp.assets;

import org.springframework.stereotype.Service;

@Service
public class AssetsMapper {



    public static AssetsDto toDto(Assets assets) {
        AssetsDto dto = new AssetsDto();
        dto.setId(assets.getId());
        dto.setName(assets.getName());
        dto.setDescription(assets.getDescription());
        dto.setCategory(assets.getCategory());
//        dto.setUser(assets.getUser());
        return dto;
    }

    public static Assets toEntity(AssetsDto dto) {
        Assets assets = new Assets();
        assets.setId(dto.getId());
        assets.setName(dto.getName());
        assets.setDescription(dto.getDescription());
        assets.setCategory(dto.getCategory());
//        assets.setUser(dto.getUser());
        return assets;
    }
}
