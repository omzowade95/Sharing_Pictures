<c:set var="APP_ROOT" value="/Sharing_Pictures"></c:set>


  <head>

    <link rel="stylesheet" href="${APP_ROOT}/css/sidebar.css">
    <!-- Boxiocns CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="sidebar close">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">Photolab</span>
    </div>
    <ul class="nav-links">
      <li>
        <a href="#">
          <i class='bx bx-grid-alt' ></i>
          <span class="link_name">Tableau de bord</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="#">Album</a></li>
        </ul>
      </li>
      <li>
        <div class="iocn-link">
          <a href="#">
            <i class='bx bx-collection' ></i>
            <span class="link_name">Album</span>
          </a>
          <i class='bx bxs-chevron-down arrow' ></i>
        </div>
        <ul class="sub-menu">
          <li><a class="link_name" href="#">Album</a></li>
          <li><a href="<c:url value="/Albums/add" />">Creer</a></li>
          <li><a href="<c:url value="/Albums" />">Voir Mes albums</a></li>
          <li><a href="#">Modifier mes albums</a></li>
        </ul>
      </li>
      <li>
        <div class="iocn-link">
          <a href="#">
            <i class='bx bx-book-alt' ></i>
            <span class="link_name">Photos</span>
          </a>
          <i class='bx bxs-chevron-down arrow' ></i>
        </div>
        <ul class="sub-menu">
          <li><a class="link_name" href="#">Photos</a></li>
          <li><a href="#">Ajouter photo</a></li>
          <li><a href="/photos">Voir Mes photos</a></li>
        </ul>
      </li>

      <li>
        <div class="iocn-link">
          <a href="#">
            <i class='bx bx-plug' ></i>
            <span class="link_name">Utilisateurs</span>
          </a>
          <i class='bx bxs-chevron-down arrow' ></i>
        </div>
        <ul class="sub-menu">
          <li><a class="link_name" href="#">Utilisateurs</a></li>
          <li><a href="#">Voir tous les Utilisateurs</a></li>
          <li><a href="#">Ajouter Utilisateur</a></li>
        </ul>
      </li>


</ul>
  </div>
  <section class="home-section">
    <div class="home-content">
      <i class='bx bx-menu' ></i>
      <span class="text">Drop Down Sidebar</span>
    </div>
  </section>

  <script src="${APP_ROOT}/js/sidebar.js"></script>

</body>

