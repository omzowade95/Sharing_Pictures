
<head>
    <title>SP | Albums Ajouts</title>
    <link rel="stylesheet" href="<c:url value="/css/formstyle.css" />">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

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

        <h3 class="txt">Ajouter un nouveau album</h3>
                    <div class="card">
                        <form class="form-card"  method="post" action="<c:url value="/Albums/add" />" onsubmit="event.preventDefault()">
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-md-6 flex-column d-flex">
                                    <label class="form-control-label col-md-3 px-3">Theme<span class="text-danger"> *</span></label>
                                    <input type="text"  name="theme" placeholder="Enter le theme" >
                                </div>
                                <div class="form-group col-md-6 flex-column d-flex">
                                    <label class="form-control-label col-md-3 px-3">Nom de l'album <span class="text-danger"> *</span></label>
                                    <input type="text"  name="nomAlbum" placeholder="Enter le nom de l'album">
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-md-6 flex-column d-flex">
                                    <label class="form-control-label col-md-3 px-3">Status :<span class="text-danger"> *</span></label>
                                    <input type="checkbox" id="private" value="private"  name="statue" placeholder="" onclick="myFun(this)"> <label>PRIVATE</label>
                                    <input type="checkbox" id="public"  name="statue" value="public" placeholder="" onclick="myFun(this)"> <label>PUBLIC</label>
                                    <div id="authorisationAlbum" class="collapse">
                                        <input id="searchInput" type="text" placeholder="Rechercher un ami à autoriser"/><button type="button" class="btn btn-success" id="searchUser">Ajouter</button>
                                        <br/>
                                        <hr/>
                                        <h6 id="userFound"></h6>
                                    </div>
                                </div>
                                <div class="form-inline col-md-9 ">
                                  <!--  <label class="form-control-label px-3">Image :<span class="text-danger"> *</span></label> <input type="file" id="img" name="image" multiple placeholder="Choisir les image de l'album" onchange="readFilesAndDisplayPreview(this.files);" >-->
                                    <div class="form-group albumInfo" id="input">
                                        <label for="">Image: <sup class="text text-danger">*</sup></label> &nbsp;
                                        <input type="file" name="images[files][]" class="elem">
                                        <input type="text" name="images[titles][]" id="" placeholder="Entrez le titre de l'image">
                                        <textarea type="text"  required placeholder="Renseignez la description" name="images[descriptions][]" class="form-control form-control-md col-md-6 elem" value=""></textarea> &nbsp; &nbsp;

                                    </div>
                                    <br/><br/>
                                    <button type="button" style="background-color: green; color: white" class="btn btn-warning" id="addImages">Ajouter <i class="fa fa-plus"></i></button>
                                    <button type="button" style="" class=" btn-danger" id="remove">Retirer <i class="fa fa-minus"></i></button>
                                </div>
                            </div>

                            <div class="row justify-content-end">
                                <div class="form-group col-sm-"></div>
                        </form>

                        <div id="list">

                            </div> <button type="submit" class="btn-block btn-primary">Ajouter album</button> </div>
                            </div>

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





















<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>


<!-- custom js file link  -->
<script src="/js/script.js"></script>
<script>

    function myFun(checkbox) {
        var checkboxes = document.getElementsByName('statue')
        checkboxes.forEach((item) => {
            if (item !== checkbox) item.checked =  false
        })}

    function readFilesAndDisplayPreview(files) {
        let imageList = document.querySelector('#list');
        imageList.innerHTML = "";

        for ( let file of files ) {
            let reader = new FileReader();

            reader.addEventListener( "load", function( event ) {
                let span = document.createElement('span');
                span.innerHTML = '<img height="20px" src="' + event.target.result + '" /><br/>';
                imageList.appendChild( span );
            });

            reader.readAsDataURL( file );
        }
    }
</script>

</body>
<script>
    $(document).ready(function(){
        $("#authorisationAlbum").hide();
        var id = 1;
        $('#addImages').on('click',function(){
            var numq3 = $('.albumInfo').length;
            var NewNumq3 = numq3 + 1;
            if(numq3 <= 5){
                var newElement3 = $('.albumInfo:last').clone().attr('id', 'input'  + NewNumq3);
                newElement3.children(':first').attr('id', 'elem' + NewNumq3).val(null);
                $('.albumInfo:last').after(newElement3);
                $('#remove').prop('disabled', false);
            }else{
                alert("l'album ne peut pas contenir plus de 5 photos")
            }

            // $('#partieq1').append('<br/><textarea type="text" required placeholder="Renseignez la partie" name="partie1" class="form-control form-control-md col-md-6" value=""></textarea> &nbsp; &nbsp;')
        })
        $('#remove').on('click', function(){
            var num = $('.albumInfo').length;
            $('#input' + num).remove();//retirer le dernier element
            //activer bouton "ajouter"
            $('#addImages').prop('disabled', false);
            //si seulemnt un elemnt reste , desactiver le bouton "retirer"

            if(num - 1 == 1){
                $('#remove').prop('disabled', true);
            }

        });

        //rechercher un utilisateur
        $("input[name=statue]").on("click", function () {
            if($("#private").is(":checked")){
                $("#authorisationAlbum").show();
            }else if($("#public").is(":checked")){
                $("#authorisationAlbum").hide();
            }
        })
        //lancer la recherche
        $("#searchUser").on("click", function(){
            var searchInput = $("#searchInput").val();

            $("#userFound").html(searchInput)
        })




    })
</script>

</html>