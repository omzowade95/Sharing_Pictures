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
        <form  method="post" action="<c:url value="/incription" />">
            <h1>Créer Un compte</h1>
            <div class="social-media">
                <p><i class="fab fa-google"></i></p>
                <p><i class="fab fa-youtube"></i></p>
                <p><i class="fab fa-facebook-f"></i></p>
                <p><i class="fab fa-twitter"></i></p>
            </div>

            <div class="inputs">
                <input type="text" name="prenom" placeholder="Prénom" />
                <input type="text" name="nom" placeholder="Nom">
                <input type="text" name="username" placeholder="Username" />
                <input type="password" name="pass" placeholder="Mot de passe">
                <input type="password" name="passConfirm" placeholder="Confirmation mot de passe">
                <div>
                    <select name="role" id="select-id" >
                        <option value="1">ADMIN</option>
                        <option value="2">USER</option>
                    </select>
                </div>
            </div>

            <div align="center">
                <button type="submit">Valider</button>
            </div>
        </form>
    </body>
</html>
