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

// const checkColumns = () => {
//     const deleteButtons = document.querySelectorAll(".delete-button");
//     let deleteButtonExist = false;
//     for (let i = 0; i < deleteButtons.length; i++) {
//         if (deleteButtons[i] == null) deleteButtonExist = true;
//     }
//     console.log(!deleteButtonExist)
//     if (!existElements(deleteButtons)) {
//         const employees = document.querySelectorAll(".employee");
//         const clients = document.querySelectorAll(".client");
//         if (existElements(employees)) employees.forEach(element => element.style = "grid-template-columns: 2fr 1fr 1fr 1fr")
//         else clients.forEach(element => element.style = "grid-template-columns: 2fr 1fr 1fr 1fr")
//     }
// }


// const existElements = (elements) => {
//     let deleteButtonsExist = false;
//     for (let i = 0; i < elements.length; i++) {
//         if (elements[i] != null) return true;
//     }
//     return deleteButtonsExist;
// }