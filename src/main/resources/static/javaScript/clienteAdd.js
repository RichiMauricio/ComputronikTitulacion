/**
 * Created by Mauricio on 09/02/2017.
 */

function pathCli(pagina) {
    'use strict';
    var txtcliId = document.getElementById('cliId')
    var cliId = txtcliId.value;
    pagina = pagina + cliId
    //location.href=pagina;
    console.log(pagina);
}