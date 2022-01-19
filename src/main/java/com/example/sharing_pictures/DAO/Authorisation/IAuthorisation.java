package com.example.sharing_pictures.DAO.Authorisation;



import com.example.sharing_pictures.model.Authorisation;

import java.util.List;

public interface IAuthorisation {

    public void add(Authorisation a);

    public boolean update(Authorisation a);

    public boolean delete(int id);


    List<Authorisation> listeAuth(int idUser);

    //public Album getAlbum(int id);
}
