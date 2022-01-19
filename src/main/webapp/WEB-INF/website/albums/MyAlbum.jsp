
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

<br/><br/><br/><br/><br/><br/><br/><br/>
<!-- dishes section starts  -->
<section class="dishes" id="photos">

    <div class="box-container">
        <c:choose>
            <c:when test="${!empty requestScope.listeAlbumUser}">
                <c:forEach items="${requestScope.listeAlbumUser}"  var="album">
                    <div class="box">
                        <!--<img id="photo" src="data:image/png;base64," width="50px" height="50px" /> -->
                        <h3>Par : <c:out value="${album.utilisateur.nom}"></c:out></h3>
                        <h4><c:out value="${album.theme.libelle}"></c:out></h4>
                        <h5><c:out value="${album.date}"></c:out></h5>
                        <div class="stars">
                            <span><c:out value="${album.nom}"></c:out></span>
                        </div>
                        <a href="<c:url value="/Albums/details?id=${album.id}"/>" class="btn">Consulter</a>

                    </div>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <h3>No album available</h3>
            </c:otherwise>
        </c:choose>

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