$(document).on("click", "#btnagregar", function(){
    $("#txtnombrecliente").val("");
    $("#txtapellidocliente").val("");
    $("#hddidcliente").val("0");
    $("#modalcliente").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtnombrecliente").val($(this).attr("data-nombrecliente"));
    $("#txtapellidocliente").val($(this).attr("data-apellidocliente"));
    $("#hddidcliente").val($(this).attr("data-idcliente"));
    $("#modalcliente").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/cliente/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idcliente: $("#hddidcliente").val(),
            nombrecliente: $("#txtnombrecliente").val(),
            apellidocliente: $("#txtapellidocliente").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarClientes();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcliente").modal("hide");
});

function listarClientes(){
    $.ajax({
        type: "GET",
        url: "/cliente/list",
        dataType: "json",
        success: function(resultado){
            $("#tblcliente > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcliente > tbody").append(`<tr>`+
                `<td>${value.idcliente}</td>`+
                `<td>${value.nombrecliente}</td>`+
                `<td>${value.apellidocliente}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-idcliente="${value.idcliente}" `+
                    `data-nombrecliente="${value.nombrecliente}" `+
                    `data-apellidocliente="${value.apellidocliente}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}