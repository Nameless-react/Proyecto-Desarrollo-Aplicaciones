function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}
function addCard(formulario) {
    var valor = formulario.elements[0].value;
    var url = '/carrito/agregar';
    url = url + '/' + valor;
    $("#resultsBlock").load(url);
}

const showEye = () => {
    const closeEye = document.querySelector(".eye");
    const password = document.querySelectorAll("#password")[1];
    if (closeEye.classList.contains("fa-eye-slash")) {
        closeEye.classList.replace("fa-eye-slash", "fa-eye");
        password.setAttribute("type", "text");
    } else {
        closeEye.classList.replace("fa-eye", "fa-eye-slash");
        password.setAttribute("type", "password");
    }
}