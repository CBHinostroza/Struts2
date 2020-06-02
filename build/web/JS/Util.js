
function msgconfirm()
{
    var opcion = confirm("¿Seguro que desea eliminar?");
    if (opcion) { //Si la opcion es aceptar retorna true
        return true;
    } else {
        return false; //Si la opcion es cancelar retorna false
    }

}

function EditarProducto(id) {
    $.ajax({
        url: "ActionProductoJson?codigo=" + id,
        type: "POST",
        dataType: "JSON",
        success: function (data) {
            alert(data.nombre);
        },
        error: function (data) {
            alert("No values found..!!");
        }

    });


}

//function Limpiar() {
//    document.getElementById("txtnombre").value = "";
//    document.getElementById("txtpassword").value = "";
//    document.getElementById("txtconfirm").value = "";
//    document.getElementById("txtcorreo").value = "";
//    document.getElementById("cbotipo").value = 0;
//}
