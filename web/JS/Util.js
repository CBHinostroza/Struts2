
function alerta()
{
    var opcion = confirm("¿Seguro que desea eliminar?");
    if (opcion) { //Si la opcion es aceptar retorna true
        return true; 
    } else {
       return false; //Si la opcion es cancelar retorna false
    }

}

function Limpiar() {
    document.getElementById("txtnombre").value = "";
    document.getElementById("txtpassword").value = "";
    document.getElementById("txtconfirm").value = "";
    document.getElementById("txtcorreo").value = "";
    document.getElementById("cbotipo").value = 0;
}
