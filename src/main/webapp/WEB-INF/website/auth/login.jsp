<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Connexion</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
        <link rel="stylesheet" href="<c:url value="/css/loginCss.css" />">
    </head>
    <body>
    <c:if test="${ !empty param.login }" >
        <div id="messageBox" class="alert alert-danger">
            <span id="control" onclick="hideMessageBox()" title="fermer">x</span>
            Echec de l'authentification : login et/ou mot de passe incorrect
        </div>
    </c:if>
    <form  method="post" action="<c:url value="/login" /> ">
        <h1>Se connecter</h1>
        <div class="social-media">
            <p><i class="fab fa-google"></i></p>
            <p><i class="fab fa-youtube"></i></p>
            <p><i class="fab fa-facebook-f"></i></p>
            <p><i class="fab fa-twitter"></i></p>
        </div>
        <p class="choose-email">ou utiliser mon username :</p>

        <div class="inputs">
            <input type="text" name="username" placeholder="Username" />
            <input type="password" name="pass" placeholder="Mot de passe">
        </div>

        <p class="inscription">Je n'ai pas de <span>compte</span>. Je m'en <span><a href="<c:url value="/incription" />">Créer</a></span> un.</p>
        <div align="center">
            <button type="submit">Se connecter</button>
        </div>
    </form>
    </body>
</html>
