
let agrega = document.querySelector('.botonAgrega');

agrega.addEventListener('click', function(evento){
    evento.target.closest('.botonAgrega');
    agrega.innerText = "¡Ya agregado!"
});