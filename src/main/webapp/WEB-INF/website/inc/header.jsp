
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SP | Acceuil</title>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="<c:url value="/css/style.css" />">

</head>
<body>
<header>

    <a href="#" class="logo"><i class="fas fa-photo"></i> Photolab</a>

    <nav class="navbar">
        <a class="${ activeLogin == true ? 'active' : ''}" href="<c:url value="/"/>">Accueil</a>
        <a class="${ activeAlbum == true ? 'active' : ''}" href="<c:url value="/Albums"/>">Albums</a>
        <a class="${ activePhoto == true ? 'active' : ''}" href="<c:url value="/photos"/>">Photos</a>
        <a class="${ activeAbout == true ? 'active' : ''}" href="<c:url value="/About"/>">A propos de nous</a>
        <c:choose>
            <c:when test="${!empty user}">
                <a href="<c:url value="/Albums/myAlbum" />">Mes albums</a>
                <a href="<c:url value="/logout" />">Déconnexion</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/login" />">Connexion</a>
            </c:otherwise>
        </c:choose>
    </nav>

    <div class="icons">
        <i class="fas fa-" id="menu-bars"></i>
        <i class="fab fa-facebook-square"></i>
        <i class="fas fa-search" id="search-icon"></i>
        <a href="#" class="fas fa-heart"></a>
    </div>

</header>