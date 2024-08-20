document.querySelectorAll('.dropdownButton').forEach(button => {
    button.addEventListener('click', function () {
        const icon = this.querySelector('i');
        icon.classList.toggle('bi-arrow-down-circle');
        icon.classList.toggle('bi-arrow-up-circle');
    });
});


document.querySelector('.search input').addEventListener('keypress', function (event) {
    if (event.key === 'Enter') {
        alert('Você pesquisou por: ' + this.value);
    }
});

const changeThemeButton = document.querySelector(".changeTheme");
changeThemeButton.addEventListener('click', () => {
    document.body.classList.toggle('dark-theme');

    const text = changeThemeButton.innerText.toLowerCase()
    changeThemeButton.innerText = text === "tema claro" ? "Tema escuro" : "Tema claro";
});