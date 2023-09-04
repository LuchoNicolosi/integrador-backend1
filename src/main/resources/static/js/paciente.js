const crearPacienteForm = document.querySelector('#crearPacienteForm');

crearPacienteForm.addEventListener('submit', (e) => {
  e.preventDefault();

  const payload = {
    nombre: document.querySelector('#inputNombre').value,
    apellido: document.querySelector('#inputApellido').value,
    dni: document.querySelector('#inputDni').value,
    fechaAlta: document.querySelector('#inputFechaAlta').value,
    domicilio: {
      calle: 'av san martin',
      numero: '190',
      localidad: 'ramos mejia',
      provincia: 'buenos aires',
    },
  };
  const settings = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(payload),
  };

  fetch('http://localhost:8080/paciente/registrar', settings)
    .then((response) => response.json())
    .then((data) => {
      if (data) {
        listarOdontologos();
      }
    })
    .catch((err) => console.log(err));

  crearPacienteForm.reset();
});

listarOdontologos();

function listarOdontologos() {
  return fetch('http://localhost:8080/paciente')
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data.length > 0) {
        const listaContenedor = document.querySelector('#lista-contenedor');
        listaContenedor.classList.add('container');
        listaContenedor.classList.add('lista');
        console.log(listaContenedor);
        const datosOdontologos = document.querySelector('#datos-odontologo');
          datosOdontologos.innerHTML = `
            <h1>Lista de Pacientes</h1>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha alta</th>
                    </tr>
                </thead>
                <tbody>
                    ${data.map(
                    (d) =>
                        `<tr>
                                <td>${d.nombre}</td>
                                <td>${d.apellido}</td>
                                <td>${d.fechaAlta}</td>
                            </tr>`
                    )}
                </tbody>
            </table>`;
      }
    });
}
