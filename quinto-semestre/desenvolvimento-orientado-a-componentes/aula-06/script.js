async function fetchAddress(event) {
	event.preventDefault();

	const cep = document.querySelector("#cep").value;

	const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
	const address = await response.json();

	renderAddressInfo(address);
}

function renderAddressInfo(address = {}) {
	const dl = document.createElement("dl");

	const informations = Object.entries(address);
	informations.forEach(([key, value]) => {
		const dt = document.createElement("dt");
		dt.innerHTML = `<strong>${key}</strong>`;

		const dd = document.createElement("dd");
		dd.innerText = value.length > 0 ? value : "N/A";

		dl.appendChild(dt);
		dl.appendChild(dd);
	});

	document.querySelector("#root").appendChild(dl)
}

async function renderSearchCepForm() {
	const response = await fetch("./components/form.html");
	const form = await response.text();

	const temp = document.createElement("div");
	temp.innerHTML = form;
	document.querySelector("#root").append(temp);
}

renderSearchCepForm();
