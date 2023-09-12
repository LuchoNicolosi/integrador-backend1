const formPaciente = document.querySelector('#registrarPaciente');

//registrar paciente
formPaciente.addEventListener('submit', (event) => {
  event.preventDefault();

  const now = dayjs();
  const nowParsed = now.format('YYYY-MM-DD');
  const payload = {
    nombre: document.querySelector('#nombre').value,
    apellido: document.querySelector('#apellido').value,
    dni: document.querySelector('#dni').value,
    fechaAlta: nowParsed,
    domicilio: {
      calle: document.querySelector('#calle').value,
      numero: document.querySelector('#numero').value,
      localidad: document.querySelector('#localidad').value,
      provincia: document.querySelector('#provincia').value,
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
        alert('paciente registrado con exito: ' + data.nombre);
        localStorage.setItem('userId', data.id);
        window.location.replace('http://localhost:8080/user/crearTurno.html');
      }
    });

  form.reset();
});

