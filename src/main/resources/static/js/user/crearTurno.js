const crearTurnoForm = document.querySelector("#crearTurnoForm")
const pacienteId = localStorage.getItem('userId')

function listarOdontologosDisponibles() {
  return fetch('http://localhost:8080/odontologo')
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data.length > 0) {
        const listarOdontologos = document.querySelector('#odontologo-list');
        listarOdontologos.innerHTML = data.map((d) => {
          return `
        <option id=${d.id} value=${d.id}>${d.nombre} ${d.apellido}</option>
        `;
        });
      }
    });
}


listarOdontologosDisponibles();

crearTurnoForm.addEventListener("submit", (e) => {
e.preventDefault()

const fechaForm = document.querySelector("#fecha").value.replace("T", " ")
const selectOdontologo = document.querySelector("#odontologo-list").value


const payload = {
odontologoId: selectOdontologo,
pacienteId:pacienteId,
fecha: fechaForm
}
const settings = {
method:"POST",
headers: {
"Content-Type": "application/json"
},
body: JSON.stringify(payload)
}

fetch("http://localhost:8080/turno",settings)
.then(response => response.json())
.then(data => {
if(data){
alert("turno realizado con exito")
console.log(data)
}
})

})



