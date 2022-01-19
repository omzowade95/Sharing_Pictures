
<c:set var="APP_ROOT" value="/Sharing_Pictures"></c:set>


<head>
    <title>SP | Albums details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                        <img id="photo" src="data:image/png;base64,${album.base64Image} " width="50px" height="50px" />
                        <h3><c:out value="${album.titre}"/></h3>
                        <h4><c:out value="${album.description}"/></h4>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h1>No photo in this album </h1>
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