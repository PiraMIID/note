package com.noteapp.user;

import com.noteapp.asset.Asset;
import com.noteapp.config.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class UserDaetis extends User {

    @OneToMany(mappedBy = "user")
    private List<Asset> assets;



}
