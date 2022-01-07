
<c:set var="APP_ROOT" value="/Sharing_Pictures"></c:set>


<head>
    <title>SP | Albums Ajouts</title>
    <link rel="stylesheet" href="${APP_ROOT}/css/formstyle.css">
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

    <div class="box-container">

        <div class="container-fluid px-1 py-5 mx-auto">
            <div class="row d-flex justify-content-center">
                <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
                    <div class="card">
                        <h3 class="txt">Ajouter un nouveau album</h3>
                        <form class="form-card"  method="post" action="${APP_ROOT}/Albums/add" onsubmit="event.preventDefault()">
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex">
                                    <label class="form-control-label px-3">Theme<span class="text-danger"> *</span></label> <input type="text"  name="theme" placeholder="Enter le theme" >
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex">
                                    <label class="form-control-label px-3">Nom de l'album <span class="text-danger"> *</span></label> <input type="text"  name="nomAlbum" placeholder="Enter le nom de l'album">
                                </div>
                            </div>
                            <div class="row justify-content-between text-left">
                                <div class="form-group col-sm-6 flex-column d-flex">
                                    <label class="form-control-label px-3">Status :<span class="text-danger"> *</span></label>
                                    <input type="checkbox" id="private" name="statue" placeholder="" onclick="myFun(this)"> <label>PRIVATE</label>
                                    <input type="checkbox" id="public" name="statue" placeholder="" onclick="myFun(this)"> <label>PUBLIC</label>
                                </div>
                                <div class="form-group col-sm-6 flex-column d-flex">
                                    <label class="form-control-label px-3">Image :<span class="text-danger"> *</span></label> <input type="file" id="img" name="image" multiple placeholder="Choisir les image de l'album" onchange="readFilesAndDisplayPreview(this.files);" >
                                </div>
                            </div>

                            <div class="row justify-content-end">
                                <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Ajouter album</button> </div>
                            </div>
                        </form>

                        <div id="list">

                        </div>

                    </div>
                </div>
            </div>
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
</html>