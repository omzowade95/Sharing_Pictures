package com.example.sharing_pictures.DAO.Image;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Status;

import java.util.List;

public interface IImage {

    public void add(Image a);

    public boolean update(Image a);

    public boolean delete(int id);

    public List<Image> listeImage();

    public  List<Image> listeImageFromAlbum(int idA);

    //public List<Image> ();

    //public List<Album> getAlbumByStatus(Status status);


    //public String getAlbum(int id);
}
