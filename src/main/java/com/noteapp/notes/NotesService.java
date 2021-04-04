package com.noteapp.notes;

import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesService {

    private UserRepository userRepository;
    private NotesRepository notesRepository;
    private NotesMapper notesMapper;

    public NotesService(NotesRepository notesRepository, NotesMapper notesMapper, UserRepository userRepository) {
        this.notesRepository = notesRepository;
        this.notesMapper = notesMapper;
        this.userRepository = userRepository;
    }



    public List<NotesDto> getList() {
//        Long userId = userRepository.findUserIdByUsername(userName);
//        System.out.println("wszytko :" + notesRepository.findAll());
//        System.out.println(notesRepository.findAll()
//                .stream()
//                .map(NotesMapper::toDto)
//                .collect(Collectors.toList()));
//        return assetsRepository.findAllByUserId(userId)
//                .stream()
//                .map(AssetsMapper::toDto)
//                .collect(Collectors.toList());
        return notesRepository.findAll()
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }

//    public User getUser(String userName) {
//        return userRepository.findByUsername(userName).get();
//    }

//    public List<Asset> getListAssets() {
//        return assetRepository.findAll()
//    }
}
