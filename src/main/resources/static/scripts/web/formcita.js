$(document).on("click", "#btnagregar", function(){
    $("#txtfechahoracita").val("");
    $("#hddidcita").val("0");
    listarCboMascotaVeterinario(0, 0);
    $("#modalcita").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtfechahoracita").val($(this).attr("data-fechahoracita"));
    $("#hddidcita").val($(this).attr("data-idcita"));
    $("#cbomascota").empty();
    $("#cboveterinario").empty();
    listarCboMascotaVeterinario($(this).attr("data-citamascota")
        , $(this).attr("data-citaveterinario"));
    $("#modalcita").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/cita/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idcita: $("#hddidcita").val(),
            fechahoracita: $("#txtfechahoracita").val() + "-05:00",
            idmascota: $("#cbomascota").val(),
            idveterinario: $("#cboveterinario").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCitas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcita").modal("hide");
});

function listarCitas(){
    $.ajax({
        type: "GET",
        url: "/cita/list",
        dataType: "json",
        success: function(resultado){
            $("#tblcita > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcita > tbody").append(`<tr>`+
                `<td>${value.idcita}</td>`+
                `<td>${value.fechahoracita}</td>`+
                `<td>${value.mascota.nombremascota}</td>`+
                `<td>${value.veterinario.nombreveterinario}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-idcita="${value.idcita}" `+
                    `data-fechahoracita="${value.fechahoracita} + '+00:00'" `+
                    `data-citamascota="${value.mascota.idmascota}" `+
                    `data-citaveterinario="${value.veterinario.idveterinario}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboMascotaVeterinario(idmascota, idveterinario){
    $("#cbomascota").empty();
    $("#cboveterinario").empty();
    $.ajax({
        type: "GET",
        url: "/mascota/list",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbomascota").append(
                    `<option value="${value.idmascota}">${value.nombremascota}</option>`
                )
            });
            if(idmascota > 0){
                $("#cbomascota").val(idmascota);
            }
            $.ajax({
                    type: "GET",
                    url: "/veterinario/list",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cboveterinario").append(
                                `<option value="${value.idveterinario}">${value.nombreveterinario}</option>`
                            )
                        });
                        if(idveterinario > 0){
                            $("#cboveterinario").val(idveterinario);
                        }
                    }
            })
        }
    })
}