$(document).on("click", "#btnagregar", function(){
    $("#txtnombreveterinario").val("");
    $("#txtapellidoveterinario").val("");
    $("#hddidveterinario").val("0");
    $("#modalveterinario").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtnombreveterinario").val($(this).attr("data-nombreveterinario"));
    $("#txtapellidoveterinario").val($(this).attr("data-apellidoveterinario"));
    $("#hddidveterinario").val($(this).attr("data-idveterinario"));
    $("#modalveterinario").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/veterinario/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idveterinario: $("#hddidveterinario").val(),
            nombreveterinario: $("#txtnombreveterinario").val(),
            apellidoveterinario: $("#txtapellidoveterinario").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarveterinarios();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalveterinario").modal("hide");
});

function listarveterinarios(){
    $.ajax({
        type: "GET",
        url: "/veterinario/list",
        dataType: "json",
        success: function(resultado){
            $("#tblveterinario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblveterinario > tbody").append(`<tr>`+
                `<td>${value.idveterinario}</td>`+
                `<td>${value.nombreveterinario}</td>`+
                `<td>${value.apellidoveterinario}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-idveterinario="${value.idveterinario}" `+
                    `data-nombreveterinario="${value.nombreveterinario}" `+
                    `data-apellidoveterinario="${value.apellidoveterinario}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}