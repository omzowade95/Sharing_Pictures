
<head>
    <title>SP | Photos</title>
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
    <br><br><br>

    <h1 class="heading"> Liste des photos publiques</h1>
    <div class="box-container">
        
<c:choose>
    <c:when test="${!empty requestScope.imageList}">
         <c:forEach items="${requestScope.imageList}" var="img">
            <div class="box">
                <%--<a href="#" class="fas fa-heart"></a>--%>

                <img src="images/dish-1.png" alt="">
                <h3><c:out value="${img.titre}"></c:out></h3>
                <div class="stars">
                    <span><c:out value="${img.description}"></c:out></span>
                </div>
            </div>
         </c:forEach>
    </c:when>
    <c:otherwise>
        <h3>No photo available</h3>
    </c:otherwise>
</c:choose>
        
    </div>
    <a href="#" class="btn">Consulter toutes les photos</a>
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