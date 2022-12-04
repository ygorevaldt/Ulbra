function confirmChange(event, form) {
    event.preventDefault();
    swal({
        title: "Confirmar Alteração?",
        icon: "info",
        buttons: ["Cancelar", "Confirmar"]
    }).then((willConfirm) => {
        if (willConfirm) {
            form.submit();
        } else {
            swal("Cadastro cancelado!");
        }
    });
}

function confirmDelete(event, form) {
    event.preventDefault();
    swal({
        title: "Tem certeza?",
        text: "Você não poderá recuperar este registro após deletado.",
        icon: "warning",
        buttons: ["Cancelar", "Deletar"],
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            form.submit();
        } else {
            swal("Operação cancelada!");
        }
    });
}