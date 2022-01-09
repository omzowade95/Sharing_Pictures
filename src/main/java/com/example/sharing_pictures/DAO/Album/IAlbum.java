package com.example.sharing_pictures.DAO.Album;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Status;

import java.util.List;

public interface IAlbum {

    public void add(Album a);

    public boolean update(Album a);

    public boolean delete(int id);

    public List<Album> listeAlbum();

    public List<Album> getAlbumByStatus(Status status);

    public Album getAlbum(int id);
}
