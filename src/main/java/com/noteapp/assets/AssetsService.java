package com.noteapp.assets;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetsService {

    private UserRepository userRepository;
    private AssetsRepository assetsRepository;
    private AssetsMapper assetsMapper;

    public AssetsService(AssetsRepository assetsRepository, AssetsMapper assetsMapper, UserRepository userRepository) {
        this.assetsRepository = assetsRepository;
        this.assetsMapper = assetsMapper;
        this.userRepository = userRepository;
    }



    public List<AssetsDto> getList() {
//        Long userId = userRepository.findUserIdByUsername(userName);
        System.out.println("wszytko :" + assetsRepository.findAll());
        System.out.println(assetsRepository.findAll()
                .stream()
                .map(AssetsMapper::toDto)
                .collect(Collectors.toList()));
//        return assetsRepository.findAllByUserId(userId)
//                .stream()
//                .map(AssetsMapper::toDto)
//                .collect(Collectors.toList());
        return assetsRepository.findAll()
                .stream()
                .map(AssetsMapper::toDto)
                .collect(Collectors.toList());
    }

    public User getUser(String userName) {
        return userRepository.findByUsername(userName).get();
    }

//    public List<Asset> getListAssets() {
//        return assetRepository.findAll()
//    }
}
