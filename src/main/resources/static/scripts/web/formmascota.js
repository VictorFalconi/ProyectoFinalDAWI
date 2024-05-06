$(document).on("click", "#btnagregar", function(){
    $("#txtnombremascota").val("");
    $("#txtedad").val("");
    $("#hddidmascota").val("0");
    listarCboCliente(0);
    $("#modalmascota").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtnombremascota").val($(this).attr("data-nombremascota"));
    $("#txtedad").val($(this).attr("data-edad"));
    $("#hddidmascota").val($(this).attr("data-idmascota"));
    $("#cbocliente").empty();
    listarCboCliente($(this).attr("data-mascotacliente"));
    $("#modalmascota").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/mascota/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idmascota: $("#hddidmascota").val(),
            nombremascota: $("#txtnombremascota").val(),
            edad: $("#txtedad").val(),
            idcliente: $("#cbocliente").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarMascotas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalmascota").modal("hide");
});

function listarMascotas(){
    $.ajax({
        type: "GET",
        url: "/mascota/list",
        dataType: "json",
        success: function(resultado){
            $("#tblmascota > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmascota > tbody").append(`<tr>`+
                `<td>${value.idmascota}</td>`+
                `<td>${value.nombremascota}</td>`+
                `<td>${value.edad}</td>`+
                `<td>${value.cliente.nombrecliente}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-idmascota="${value.idmascota}" `+
                    `data-nombremascota="${value.nombremascota}" `+
                    `data-edad="${value.edad}" `+
                    `data-mascotacliente="${value.cliente.idcliente}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboCliente(idcliente){
    $("#cbocliente").empty();
    $.ajax({
        type: "GET",
        url: "/cliente/list",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocliente").append(
                    `<option value="${value.idcliente}">${value.nombrecliente}</option>`
                )
            });
            if(idcliente > 0){
                $("#cbocliente").val(idcliente);
            }
        }
    })
}