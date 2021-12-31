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
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<header>

    <a href="#" class="logo"><i class="fas fa-photo"></i> PhotoLab</a>

    <nav class="navbar">
        <a class="${ activeLogin == true ? 'active' : ''}" href="<c:url value="/"/>#home">Accueil</a>
        <a class="${ activeAlbum == true ? 'active' : ''}" href="<c:url value="/albums"/>#albums">Albums</a>
        <a class="${ activePhoto == true ? 'active' : ''}" href="<c:url value="/photos"/>#photos">Photos</a>
        <a href="#menu">Inscription</a>
        <a href="#review">Connexion</a>
        <a href="#about">A propos de nous</a>
    </nav>

    <div class="icons">
        <i class="fas fa-bars" id="menu-bars"></i>
        <i class="fas fa-search" id="search-icon"></i>
        <a href="#" class="fas fa-heart"></a>
        <a href="#" class="fas fa-shopping-cart"></a>
    </div>

</header>