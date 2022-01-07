package com.example.sharing_pictures.DAO.Theme;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Status;
import com.example.sharing_pictures.model.Theme;

import java.util.List;

public interface ITheme {
    public void add(Theme a);

    public boolean update(Theme a);

    public boolean delete(int id);

    public List<Theme> listeTheme();

    public Theme getTheme(String libelle);


}
