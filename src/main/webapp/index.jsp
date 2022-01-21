
<head>
    <title>SP | Acceuil</title>
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
<c:import url="WEB-INF/website/inc/header.jsp"/>

<!-- search form  -->

<form action="" id="search-form">
    <input type="search" placeholder="search here..." name="" id="search-box">
    <label for="search-box" class="fas fa-search"></label>
    <i class="fas fa-times" id="close"></i>
</form>

<!-- home section starts  -->

<section class="home" id="home">
    <div class="swiper-container home-slider">

        <div class="swiper-wrapper wrapper">

            <div class="swiper-slide slide">
                <div class="content">
                    <span>Partager vos meuilleur recettes</span>
                    <h3>spicy noodles</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit natus dolor cumque?</p>
                </div>
                <div class="image">
                    <img src="images/home-img-1.png" alt="">
                </div>
            </div>

            <div class="swiper-slide slide">
                <div class="content">
                    <span>Partager vos meuilleur plat</span>
                    <h3>fried chicken</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit natus dolor cumque?</p>
                </div>
                <div class="image">
                    <img src="images/home-img-2.png" alt="">
                </div>
            </div>

            <div class="swiper-slide slide">
                <div class="content">
                    <span>Partager vos meilleur moment</span>
                    <h3>hot pizza</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit natus dolor cumque?</p>
                </div>
                <div class="image">
                    <img src="images/home-img-3.png" alt="">
                </div>
            </div>

        </div>

        <div class="swiper-pagination"></div>

    </div>
</section>

<!-- home section ends -->

<!-- dishes section starts  -->
<c:choose>
    <c:when test="${!empty sessionScope.user}">
        <a class="btn" href="<c:url value="/Albums"/>">Voir les albums</a>
    </c:when>
    <c:otherwise>
        <section class="dishes" id="photos">

            <div class="box-container">

                <c:choose>
                    <c:when test="${!empty requestScope.listeImgpub}">
                        <c:forEach items="${requestScope.listeImgpub}"  var="album">
                            <div class="box">
                                <a id="idImage" href="#myModal" data-toggle="modal" data-target="#myModal" onclick=""/>
                                <img   id="photo" src="data:image/png;base64,${album.base64Image} " width="100px" height="100px" />
                                </a>
                            </div>
                        </c:forEach>

                    </c:when>
                    <c:otherwise>
                        <h1>No photo to show</h1>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${!empty requestScope.listeImgpub}">
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h5> class="modal-title">Information sur L'image</h5>
                                    </div>

                                    <div class="modal-body">
                                        <img id="photpop" src="data:image/png;base64,${requestScope.listeImgpub.get(index).base64Image} " width="100px" height="100px" />

                                        <div>
                                            Nom album :<a class="button" href="#popup1"><c:out value="${requestScope.listeImgpub.get(index).album.nom}"/></a>
                                            <br>
                                            Nom image : <a class="button" href="#popup2"><c:out value="${requestScope.listeImgpub.get(index).titre}"/></a>
                                        </div>

                                        <div id="popup1" class="overlay">
                                            <div class="popup">
                                                <h4>Album info</h4>
                                                <a class="close" href="#">&times;</a>
                                                <div class="content">
                                                    <h6>Nom : <c:out value="${requestScope.listeImgpub.get(index).album.nom}"/></h6>
                                                    <h6>Theme :<c:out value="${requestScope.listeImgpub.get(index).album.theme.libelle}"/></h6>
                                                    <h6>Status : <c:out value="${requestScope.listeImgpub.get(index).album.status}"/></h6>
                                                    <h6>Date creation : <c:out value="${requestScope.listeImgpub.get(index).album.date}"/></h6>
                                                    <h6> Proprietaire :<c:out value="${requestScope.listeImgpub.get(index).album.utilisateur.username}"/></h6>
                                                </div>
                                            </div>
                                        </div>

                                        <div id="popup2" class="overlay">
                                            <div class="popup">
                                                <h4>Image Info</h4>
                                                <a class="close" href="#">&times;</a>
                                                <div class="content">
                                                    <h6>Titre : <c:out value="${requestScope.listeImgpub.get(index).titre}"/></h6>
                                                    <h6>Description : <c:out value="${requestScope.listeImgpub.get(index).description}"/></h6>
                                                    <h6>Date Creation :  <c:out value="${requestScope.listeImgpub.get(index).dateCreation}"/></h6>
                                                    <h6>Largeur :  <c:out value="${requestScope.listeImgpub.get(index).largeur}"/>px</h6>
                                                    <h6>Hauteur : <c:out value="${requestScope.listeImgpub.get(index).hauteur}"/>px</h6>                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </c:when>
                </c:choose>
            </div>
        </section>

    </c:otherwise>
</c:choose>

<!-- dishes section ends -->
<!-- menu section starts  -->

<section class="about" id="about">

    <h3 class="sub-heading"> A Propos de Nous </h3>
    <h1 class="heading"> Qui Sommes Nous? </h1>

    <div class="row">

        <div class="image">
            <img src="images/about-img.png" alt="">
        </div>

        <div class="content">
            <h3>Application de partage d'albums photos</h3>
            <p> Cette plateforme permet de partager des photos entre amis!</p>

            <div class="icons-container">
                <div class="icons">
                    <i class="fas fa-shipping-fast"></i>
                    <span>Partage</span>
                </div>
                <div class="icons">
                    <i class="fas fa-dollar-sign"></i>
                    <span>Creativite</span>
                </div>
                <div class="icons">
                    <i class="fas fa-headset"></i>
                    <span>Innovation</span>
                </div>
            </div>
        </div>

    </div>

</section>

<!-- about section ends -->


<!-- review section starts  -->
<%--
<section class="review" id="review">

    <h3 class="sub-heading"> customer's review </h3>
    <h1 class="heading"> what they say </h1>

    <div class="swiper-container review-slider">

        <div class="swiper-wrapper">

            <div class="swiper-slide slide">
                <i class="fas fa-quote-right"></i>
                <div class="user">
                    <img src="images/pic-1.png" alt="">
                    <div class="user-info">
                        <h3>john deo</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit fugiat consequuntur repellendus aperiam deserunt nihil, corporis fugit voluptatibus voluptate totam neque illo placeat eius quis laborum aspernatur quibusdam. Ipsum, magni.</p>
            </div>

            <div class="swiper-slide slide">
                <i class="fas fa-quote-right"></i>
                <div class="user">
                    <img src="images/pic-2.png" alt="">
                    <div class="user-info">
                        <h3>john deo</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit fugiat consequuntur repellendus aperiam deserunt nihil, corporis fugit voluptatibus voluptate totam neque illo placeat eius quis laborum aspernatur quibusdam. Ipsum, magni.</p>
            </div>

            <div class="swiper-slide slide">
                <i class="fas fa-quote-right"></i>
                <div class="user">
                    <img src="images/pic-3.png" alt="">
                    <div class="user-info">
                        <h3>john deo</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit fugiat consequuntur repellendus aperiam deserunt nihil, corporis fugit voluptatibus voluptate totam neque illo placeat eius quis laborum aspernatur quibusdam. Ipsum, magni.</p>
            </div>

            <div class="swiper-slide slide">
                <i class="fas fa-quote-right"></i>
                <div class="user">
                    <img src="images/pic-4.png" alt="">
                    <div class="user-info">
                        <h3>john deo</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit fugiat consequuntur repellendus aperiam deserunt nihil, corporis fugit voluptatibus voluptate totam neque illo placeat eius quis laborum aspernatur quibusdam. Ipsum, magni.</p>
            </div>

        </div>

    </div>
    
</section>
--%>
<!-- review section ends -->

<!-- order section starts  -->
<%--
<section class="order" id="order">

    <h3 class="sub-heading"> order now </h3>
    <h1 class="heading"> free and fast </h1>

    <form action="">

        <div class="inputBox">
            <div class="input">
                <span>your name</span>
                <input type="text" placeholder="enter your name">
            </div>
            <div class="input">
                <span>your number</span>
                <input type="number" placeholder="enter your number">
            </div>
        </div>
        <div class="inputBox">
            <div class="input">
                <span>your order</span>
                <input type="text" placeholder="enter food name">
            </div>
            <div class="input">
                <span>additional food</span>
                <input type="test" placeholder="extra with food">
            </div>
        </div>
        <div class="inputBox">
            <div class="input">
                <span>how musch</span>
                <input type="number" placeholder="how many orders">
            </div>
            <div class="input">
                <span>date and time</span>
                <input type="datetime-local">
            </div>
        </div>
        <div class="inputBox">
            <div class="input">
                <span>your address</span>
                <textarea name="" placeholder="enter your address" cols="30" rows="10"></textarea>
            </div>
            <div class="input">
                <span>your message</span>
                <textarea name="" placeholder="enter your message" cols="30" rows="10"></textarea>
            </div>
        </div>

        <input type="submit" value="order now" class="btn">

    </form>

</section>
--%>
<!-- order section ends -->

<!-- footer section starts  -->

<section class="footer">

    <c:import url="WEB-INF/website/inc/footer.jsp"/>

</section>



<!-- loader part
<div class="loader-container">
    <img src="images/loader.gif" alt="">
</div>
-->




















<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>