$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});

function confirmer(){
	var res = confirm("Etes-vous sûr de vouloir supprimer ?")
	if (res)
		return true;
	else
		return false;
}

$('#editEmployeeModal').on('show.bs.modal', function(e) {
	var id = $(e.relatedTarget).data('id');
	var nom = $(e.relatedTarget).data('nom');
	var prenom = $(e.relatedTarget).data('prenom');
	var username = $(e.relatedTarget).data('username');
	var role = $(e.relatedTarget).data('nom');

	$(e.currentTarget).find('input[name="idHide"]').val(id);
	$(e.currentTarget).find('input[name="nom"]').val(nom);
	$(e.currentTarget).find('input[name="prenom"]').val(prenom);
	$(e.currentTarget).find('input[name="username"]').val(username);
	$(e.currentTarget).find('select[name="role"]').val(role);

});