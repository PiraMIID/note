package com.noteapp.asset;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private UserRepository userRepository;
    private AssetRepository assetRepository;
    private AssetMapper assetMapper;

    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
        this.userRepository = userRepository;
    }

//    public List<AssetDto> getList(String userName) {
//        Optional<User> user = userRepository.findByUsername(userName);
//        return user.get().getAssets()
//                .stream()
//                .map(AssetMapper::toDto)
//                .collect(Collectors.toList());
//    }

//    public List<Asset> getListAssets() {
//        return assetRepository.findAll()
//    }
}
