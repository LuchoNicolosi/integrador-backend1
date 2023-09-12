const crearOdontologoForm = document.querySelector('#crearOdontologoForm');
crearOdontologoForm.addEventListener('submit', (e) => {
  e.preventDefault();

  const payload = {
    nombre: document.querySelector('#inputNombre').value,
    apellido: document.querySelector('#inputApellido').value,
    matricula: document.querySelector('#inputMatricula').value,
  };
  const settings = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(payload),
  };

  fetch('http://localhost:8080/odontologo/registrar', settings)
    .then((response) => response.json())
    .then((data) => {
      if (data) {
        listarOdontologos();
      }
    })
    .catch((err) => console.log(err));

  alert('odontologo registrado con exito');
  crearOdontologoForm.reset();
});

listarOdontologos();

function listarOdontologos() {
  return fetch('http://localhost:8080/odontologo')
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
            <h1>Lista de Odontologos</h1>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Matricula</th>
                    </tr>
                </thead>
                <tbody>
                    ${data.map(
                    (d) =>
                        `<tr><td>${d.nombre}</td><td>${d.apellido}</td><td>${d.matricula}</td></tr>`
                    )}
                </tbody>
            </table>`;
      }
    });
}
