package com.noteapp.notes;



import com.noteapp.exception.httpException.ApiRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/notes")
public class NotesController {

    private final NotesService notesService;


    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public List<NotesDto> getAll(@RequestParam(required = false) String text) {
        if (text != null)
            return notesService.findAllByNameOrDescription(text);
        else
            return notesService.findAll();
    }


    @PostMapping("/create")
    public ResponseEntity<NotesDto> addNotes(@RequestBody NotesDto notes) {
//        if (zxc) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Notes name can't be empty");
//        }
        NotesDto save = notesService.save(notes);
        if (save == null) {
//            throw new ApiRequestException("Notes cannot save with exceptions");
        }
        return ResponseEntity.ok(save);
    }

//    @PutMapping("/{id}/update")
//    public ResponseEntity<NotesDto> update(@PathVariable("id") Long id, @RequestBody NotesDto notesDto) throws ApiRequestException {
//        if (!id.equals(notesDto.getId())) {
//            ApiRequestException apiRequestException = new ApiRequestException("The update object need to have id same as id in path");
//            log.error(notesDto,apiRequestException);
//            throw  apiRequestException;
//        }


//    @DeleteMapping("/{id}")
//    public Long deleteNotes(@PathVariable("id") Long id) {
//        notesService.deleteNotes(id);
//        return id;
//    }


}



