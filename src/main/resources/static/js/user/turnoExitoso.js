const root = document.querySelector("#datosTurno")
const odontologoId = sessionStorage.getItem("odontologoId")
const url = `http://localhost:8080/odontologo/buscar?id=${odontologoId}`
const nombrePaciente = sessionStorage.getItem("userName")
const apellidoPaciente = sessionStorage.getItem("userLastName")
const fechaTurno = sessionStorage.getItem("fechaTurno")


fetch(url)
.then(response => response.json())
.then(data => {
    root.innerHTML = `
    <h1>los datos de su turno son</h1>
    <ul>
    <li>nombre completo: ${nombrePaciente} ${apellidoPaciente}</li>
    <li>Doctor: ${data.nombre} ${data.apellido}</li>
    <li>fecha y horario: ${fechaTurno}</li>
    </ul>
    `
})

setTimeout(()=>{
    sessionStorage.clear();
},5000)