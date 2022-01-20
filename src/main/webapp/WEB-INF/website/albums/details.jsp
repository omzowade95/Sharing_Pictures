
<c:set var="APP_ROOT" value="/Sharing_Pictures"></c:set>


<head>
    <title>SP | Albums details</title>
    <link rel="stylesheet" href="<c:url value="/css/popup.css" />">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<!-- header section starts      -->
<c:import url="/WEB-INF/website/inc/header.jsp"/>
<!-- header section ends-->

<!-- search form  -->

<form action="" id="search-form">
    <input type="search" placeholder="search here..." name="" id="search-box">
    <label for="search-box" class="fas fa-search"></label>
    <i class="fas fa-times" id="close"></i>
</form>

<br/><br/><br/><br/><br/><br/><br/><br/>
<!-- dishes section starts  -->
<section class="dishes" id="photos">

    <div class="box-container">
        <c:choose>
            <c:when test="${!empty requestScope.listeImg}">
                <c:forEach items="${requestScope.listeImg}"  var="album">
                    <div class="box">
                        <a id="idImage" href="#myModal" data-toggle="modal" data-target="#myModal" onclick=""/>
                            <img   id="photo" src="data:image/png;base64,${album.base64Image} " width="100px" height="100px" />
                        </a>
                    </div>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <h1>No photo in this album </h1>
            </c:otherwise>
        </c:choose>


        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Information sur L'image</h4>
                    </div>

                    <div class="modal-body">
                        <img id="photpop" src="data:image/png;base64,${requestScope.listeImg.get(index).base64Image} " width="100px" height="100px" />

                        <div>
                            Nom album :<a class="button" href="#popup1"><c:out value="${requestScope.listeImg.get(index).album.nom}"/></a>
                            <br>
                            Nom image : <a class="button" href="#popup2"><c:out value="${requestScope.listeImg.get(index).titre}"/></a>
                        </div>

                        <div id="popup1" class="overlay">
                            <div class="popup">
                                <h3>Album info</h3>
                                <a class="close" href="#">&times;</a>
                                <div class="content">
                                    Nom : <h4><c:out value="${requestScope.listeImg.get(index).album.nom}"/></h4><br>
                                    Theme : <h4><c:out value="${requestScope.listeImg.get(index).album.theme.libelle}"/></h4><br>
                                    Status : <h4><c:out value="${requestScope.listeImg.get(index).album.status}"/></h4><br>
                                    Date creation : <h4><c:out value="${requestScope.listeImg.get(index).album.date}"/></h4><br>
                                    Proprietaire :<h4><c:out value="${requestScope.listeImg.get(index).album.utilisateur.username}"/></h4>
                                </div>
                            </div>
                        </div>

                        <div id="popup2" class="overlay">
                            <div class="popup">
                                <h3>Image Info</h3>
                                <a class="close" href="#">&times;</a>
                                <div class="content">
                                    Titre : <h4><c:out value="${requestScope.listeImg.get(index).titre}"/></h4><br>
                                    Description : <h4><c:out value="${requestScope.listeImg.get(index).description}"/></h4><br>
                                    Date Creation :  <h4><c:out value="${requestScope.listeImg.get(index).dateCreation}"/></h4><br>
                                    Largeur :  <h4><c:out value="${requestScope.listeImg.get(index).largeur}"/></h4><br>
                                    Hauteur : <h4><c:out value="${requestScope.listeImg.get(index).hauteur}"/></h4>                                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>



    </div>

</section>

<!-- dishes section ends -->



<!-- about section starts  -->

<!-- about section ends -->



<!-- footer section starts  -->

<section class="footer">

    <div class="credit"> copyright @ 2021 by <span>ESP MASTER II TEAM</span> </div>

</section>

<!-- footer section ends -->

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>


</body>
</html>