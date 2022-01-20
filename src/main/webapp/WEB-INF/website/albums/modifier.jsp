
<head>
    <title>SP | Albums Ajouts</title>
    <link rel="stylesheet" href="<c:url value="/css/formstyle.css" />">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<!-- header section starts      -->
<c:import url="/WEB-INF/website/inc/header.jsp"/>


<!-- header section ends-->

<!-- search form  -->



<br/><br/><br/><br/><br/><br/><br/><br/>
<!-- dishes section starts  -->
<section class="dishes" id="photos">
    <h3 class="txt">Ajouter un nouveau album</h3>
    <div class="card">
        <c:choose>
            <c:when test="${!empty requestScope.al}">

                    <form name="formAlb" class="row g-3" novalidate method="post" action="<c:url value="/Albums/update" />" enctype="multipart/form-data">
                 <div class="mb-3">
                <label for="theme" class="form-label">Theme</label>
                <input required value="<c:out value="${a.theme.libelle}"/>" class="form-control" id = "theme" list="datalistOptions" name="theme" placeholder="">
                <datalist id="datalistOptions">
                    <option value="Voyage">
                    <option value="Vacance">
                    <option value="Soirée">
                    <option value="Mariage">
                    <option value="Meeting">
                </datalist>
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Nom de l'album</label>
                <input value ="<c:out value="${a.nom}"/>"required type="text" class="form-control" id="formGroupExampleInput" name="nomAlbum" placeholder="nom album">
            </div>


            <div class="col-12">
                <button name="loadAlbum" id="loadAlbum" type="submit" class="btn btn-primary">Modifier album</button>
            </div>


        </form>

            </c:when>
            <c:otherwise>
                    <h1>Nothing to do</h1>
            </c:otherwise>
        </c:choose>
    </div>
</section>


<section class="footer">

    <div class="credit"> copyright @ 2021 by <span>ESP MASTER II TEAM</span> </div>

</section>



<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- custom js file link  -->
<script src="/js/script.js"></script>




</body>





</html>