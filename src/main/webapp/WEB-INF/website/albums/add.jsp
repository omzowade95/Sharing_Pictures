
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
                        <form class="row g-3" method="post" action="<c:url value="/Albums/add" />" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label for="theme" class="form-label">Theme</label>
                                <input required class="form-control" id = "theme" list="datalistOptions" name="theme" placeholder="">
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
                                <input required type="text" class="form-control" id="formGroupExampleInput" name="nomAlbum" placeholder="nom album">
                            </div>

                            <label class="form-control-label col-md-3 px-3">Status :<span class="text-danger"> *</span></label>
                            <div class="col-12">
                                <div class="form-check">
                                    <input class="form-check-input" name="statue" type="checkbox" id="private"  name="statue" value="PRIVATE" placeholder="" onclick="myFun(this)">
                                    <label class="form-check-label" for="private">
                                        private
                                    </label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="public" value="PUBLIC" name="statue" placeholder="" onclick="myFun(this)">
                                    <label class="form-check-label" for="public">
                                        public
                                    </label>
                                </div>
                            </div>

                            <div class="input-group mb-3">
                                <div class="form-inline col-md-9 ">
                                    <div class="form-group albumInfo" id="input">
                                        <label for="">Image: <sup class="text text-danger">*</sup></label> &nbsp;
                                        <div class="row">
                                            <div class="col ">
                                                <input  type="file" name="images[files][]" accept="image/*" class="elem">
                                            </div>
                                            <div class="col">
                                                <input required type="text" name="images[titles][]" id="" placeholder="Entrez le titre de l'image">
                                            </div>
                                            <div class="col-6">
                                                <textarea type="text"  required placeholder="Renseignez la description" name="images[descriptions][]" class="form-control form-control-md col-md-6 elem" value=""></textarea> &nbsp; &nbsp;
                                            </div>
                                        </div>

                                    </div>
                                    <br/><br/>
                                    <button type="button" style="background-color: green; color: white" class="btn btn-warning" id="addImages">Ajouter <i class="fa fa-plus"></i></button>
                                    <button type="button" style="" class=" btn-danger" id="remove">Retirer <i class="fa fa-minus"></i></button>
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary">Ajouter album</button>
                            </div>

                        </form>

                        <div id="list">

                        </div>

                    </div>


</section>


<section class="footer">

    <div class="credit"> copyright @ 2021 by <span>ESP MASTER II TEAM</span> </div>

</section>


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


    })
</script>

</html>