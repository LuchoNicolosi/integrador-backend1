function listarOdontologosDisponibles() {
  return fetch('http://localhost:8080/odontologo')
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      if (data.length > 0) {
        const listarOdontologos = document.querySelector('#odontologo-list');
        listarOdontologos.innerHTML = data.map((d) => {
          return `
        <option id=${d.id}>${d.nombre} ${d.apellido}</option>
        `;
        });
      }
    });
}

listarOdontologosDisponibles();

console.log(localStorage.getItem('userId'));
