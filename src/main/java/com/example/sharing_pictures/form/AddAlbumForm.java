package com.example.sharing_pictures.form;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Authorisation.AuthorisationDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.DAO.Theme.ThemeDAO;
import com.example.sharing_pictures.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class AddAlbumForm {

    private static final String CHAMP_THEME="theme";
    private static final String CHAMP_NOM="nomAlbum";
    private static final String CHAMP_STATUS="statue";
    private static final String CHAMP_IMAGE="image";

    private HttpServletRequest request;
    private HttpSession session;
    private Map<String, String> erreurs;
    private AlbumDAO albumDAO;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    private ThemeDAO themeDAO;
    private ImageDAO imageDAO;
    private AuthorisationDAO authorisationDAO;

    public AddAlbumForm(HttpServletRequest request, HttpSession session){
        this.erreurs = new HashMap<>();
        this.request= request;
        this.session = session;
    }

    public boolean add(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();
        albumDAO = new AlbumDAO(entityManager);
        themeDAO = new ThemeDAO(entityManager);
        imageDAO = new ImageDAO(entityManager);
        authorisationDAO = new AuthorisationDAO(entityManager);
        session = request.getSession();

        //String uploadPath="";
        String nom = getParameter(CHAMP_NOM);
        Theme theme = themeDAO.getTheme(CHAMP_THEME);
        if (theme == null){
            themeDAO.add(new Theme(CHAMP_THEME));
            theme = themeDAO.getTheme(CHAMP_THEME);
        }
        Status status = Status.valueOf(CHAMP_STATUS);
        List<Image> images = (List<Image>) request.getAttribute("images");

        Album a = new Album(nom,LocalDate.now().toString(),status,(Utilisateur)session.getAttribute("utilisateur"),theme);
        albumDAO.add(a);
        for (Image img: images) {
            img.setAlbum(a);
            img.setDateCreation(LocalDate.now().toString());
            img.setDateMAJ(LocalDate.now().toString());
            imageDAO.add(img);
        }

        if (status.equals("PRIVATE")){
            List<Utilisateur> autorise = (List<Utilisateur>) request.getAttribute("authorisation");
            for (Utilisateur u : autorise) {
                Authorisation at = new Authorisation(a,u);
                authorisationDAO.add(at);
            }
        }
        return false;
    }


    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }
    private void validerChamps(String ...champs){
        for (String champ : champs) {
            if (getParameter(champ) == null) {
                erreurs.put(champ, "Vous devez remplir ce champ");
            }
        }
    }

    private String getParameter(String parametre) {
        String valeur = request.getParameter(parametre);
        if (valeur == null || valeur.trim().isEmpty()) {
            return null;
        }
        return valeur ;
    }
}
