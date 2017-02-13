/**
 * Created by Mauricio on 07/02/2017.
 */

function buscarTexto(pagina, parametro) {
    'use strict';
    var txtCliCedula = document.getElementById('cliCedula');
    var cliCedula = txtCliCedula.value;
    if (cliCedula===""){
        console.log("Texto requerido")
    }else {
        pasarVariable(pagina,cliCedula, parametro)
    }
};

function pasarVariable(pagina, nombres, parametro) {
    'use strict';
    pagina +="?";
    pagina += parametro + "=" + nombres + "&";
    pagina = pagina.substring(0,pagina.length-1);
    location.href=pagina;
}