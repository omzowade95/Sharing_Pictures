
<!-- header section starts      -->
<c:import url="WEB-INF/website/inc/header.jsp"/>

<!-- header section ends-->

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
                    <span>PhotoLab la vision du monde</span>
                    <h3>Bienvenue sur PhotoLab.</h3>
                    <p>PhotoLab est une plateforme de partage de photos en ligne</p>
                    <a href="#" class="btn">Debutez maintenant</a>
                </div>
                <div class="image">
                    <img src="images/presentattion1.jpg" alt="">
                </div>
            </div>

            <div class="swiper-slide slide">
                <div class="content">
                    <span>Voir le monde autrement.</span>
                    <h3>PhotoLab.</h3>
                    <p>Voyagez avec vos amis en partageant en temps reel vos albums et photos</p>
                    <a href="#" class="btn">Debutez maintenant</a>
                </div>
                <div class="image">
                    <img src="images/presentattion1.jpg" alt="">
                </div>
            </div>



        </div>

        <div class="swiper-pagination"></div>

    </div>

</section>

<!-- home section ends -->

<!-- dishes section starts  -->
<section class="dishes" id="photos">

    <h3 class="sub-heading"> PHOTOS </h3>
    <h1 class="heading"> photos recentes publiees</h1>

    <div class="box-container">

        <div class="box">
            <%--<a href="#" class="fas fa-heart"></a>--%>

            <img src="images/dish-1.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">

                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>

        <div class="box">
            <img src="images/dish-2.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">

                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>

        <div class="box">
            <img src="images/dish-3.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">

                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>

        <div class="box">
            <img src="images/dish-4.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">

                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>

        <div class="box">
            <img src="images/dish-5.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">

                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>

        <div class="box">
            <img src="images/dish-6.png" alt="">
            <h3>tasty food</h3>
            <div class="stars">
                <span>Date photo</span>
            </div>
            <a href="#" class="btn">Consulter</a>
        </div>


    </div>
    <a href="<c:url value="/photos"/> " class="btn">Consulter toutes les photos</a>
</section>

<!-- dishes section ends -->
<!-- menu section starts  -->

<section class="menu" id="albums">

    <h3 class="sub-heading"> ALBUMS </h3>
    <h1 class="heading"> Les Albums recents </h1>

    <div class="box-container">

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="images/menu-1.jpg" alt="">
            </div>
            <div class="content">
                <div class="stars">

                </div>
                <h3>ALbum Titre</h3>
                <p>description album.</p>
                <a href="#" class="btn">Consulter</a>

            </div>
        </div>





    </div>
    <a href="<c:url value="/albums"/> " class="btn">Consulter tous les albums</a>
</section>

<!-- menu section ends -->

<!-- about section starts  -->

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

<<<<<<< HEAD
=======
<!-- footer section ends -->
>>>>>>> 0a15b3aeb55d7020cd5920309150d44cb05f09c8


<!-- loader part  -->
<div class="loader-container">
    <img src="images/loader.gif" alt="">
</div>





















<<<<<<< HEAD
=======

>>>>>>> 0a15b3aeb55d7020cd5920309150d44cb05f09c8
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>