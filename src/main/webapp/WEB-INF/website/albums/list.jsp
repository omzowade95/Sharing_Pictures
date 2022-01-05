
<c:set var="APP_ROOT" value="/Sharing_Pictures"></c:set>


<head>
    <title>SP | Albums</title>
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

<br/><br/><br/><br/>
<!-- dishes section starts  -->
<section class="dishes" id="photos">


    <h1 class="heading"> Liste des albums publiees</h1>
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

</section>

<!-- dishes section ends -->



<form method="post" action="${APP_ROOT}/Albums" enctype="multipart/form-data">
    Fichiers sélectionnés :
    <input type="file" name="multiPartServlet" accept="image/*" multiple
           onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
    <input type="submit" value="Upload" /> <br/>

    <div id="list"></div>
</form>

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



<!-- footer section starts  -->

<section class="footer">

    <div class="credit"> copyright @ 2021 by <span>ESP MASTER II TEAM</span> </div>

</section>

<!-- footer section ends -->


<!-- loader part  -->
<div class="loader-container">
    <img src="images/loader.gif" alt="">
</div>






















<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>