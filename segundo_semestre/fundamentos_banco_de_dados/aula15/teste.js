angular.extend(this, $controller('DynamicFormController', { $scope: $scope }));

$scope.clear = function () {
    $scope.resetForm();
};

$timeout(function () {
    $scope.clear();
    $scope.initialize('${formName}', $scope.${ formName }Form, '${pageName}').then(function () {

    });
});

// const formataDataSQL = (data, isInicio = true) => {
//   let dt = new Date(data);

//   let m = String(dt.getMonth() + 1);
//   m = m.padStart(2, "0");

//   let d = String(dt.getDate());
//   d = d.padStart(2, "0");

//   return `${dt.getFullYear()}-${m}-${d} ${isInicio ? "00:00:00" : "23:59:59"}`;
// };

const formataDataSQL = (data, isInicio = true) => {

    let mes = String(data.getMonth() + 1).padStart(2, "0");
    let dia = String(data.getDate()).padStart(2, "0");
    let ano = String(data.getFullYear());
    return `${ano}-${mes}-${dia} ${isInicio ? "00:00:00" : "23:59:59"}`;
}

const organizaAtendimentos = (lista) => {
    return lista.reduce((acc, cur) => {
        let esp = acc.find((e) => e.idEspecialidade === cur.idEspecialidade && e.idTipoServico === cur.idTipoServico);
        let horaAtendimento = cur.dtAtendimento.split(" ")[1];
        let periodoAtendimento;

        /*
            07 ~ 12 Manha
            12 ~ 17 Tarde
            17 ~ 20 Noite
        */
        if (horaAtendimento >= "07:00:00" && horaAtendimento <= "12:00:00") {
            periodoAtendimento = "M";
        } else if (horaAtendimento >= "12:00:01" && horaAtendimento <= "17:00:00") {
            periodoAtendimento = "T";
        } else {
            periodoAtendimento = "N";
        }

        if (esp) {
            esp.qtdAtendimentosTotais += 1;
            esp.qtdAtendimentosManha += periodoAtendimento === "M" ? 1 : 0;
            esp.qtdAtendimentosTarde += periodoAtendimento === "T" ? 1 : 0;
            esp.qtdAtendimentosNoite += periodoAtendimento === "N" ? 1 : 0;
            if (cur.idSecretaria !== -1) {
                let sec = esp.secretarias.find((s) => s.idSecretaria === cur.idSecretaria);
                if (sec) {
                    sec.qtdAtendimentosTotais += 1;
                }
            }
        } else {
            let secs = $scope.listaSecretarias.map((s) => {
                return { idSecretaria: s.idSecretaria, nomeSecretaria: s.nomeSecretaria, qtdAtendimentosTotais: 0 };
            });

            let sec = secs.find((s) => s.idSecretaria === cur.idSecretaria);
            if (sec) {
                sec.qtdAtendimentosTotais += 1;
            }
            acc.push({
                idEspecialidade: cur.idEspecialidade,
                nomeEspecialidade: cur.nomeEspecialidade,
                idTipoServico: cur.idTipoServico,
                tipoServico: cur.tipoServico,
                qtdAtendimentosTotais: 1,
                qtdAtendimentosManha: periodoAtendimento === "M" ? 1 : 0,
                qtdAtendimentosTarde: periodoAtendimento === "T" ? 1 : 0,
                qtdAtendimentosNoite: periodoAtendimento === "N" ? 1 : 0,
                secretarias: secs,
            });
        }
        return acc;
    }, []);
};


$scope.buscaSecretarias = async () => {
    $scope.listaSecretarias = await Tb_atendimentoRepository.listaSecretarias();
};

function geraPdf(dados) {
    $scope.$applyAsync();
    let doc = new jspdf.jsPDF({
        orientation: 'l',
        unit: 'mm',
        format: 'a4',
    });


    doc.text("Relat\u{F3}rio especialidades", 10, 10);

    //   let body = [];

    //   for (let i = 0; i < dados.length; i++) {
    //     let row = [];
    //     row.push(dados[i].nomeEspecialidade, dados[i].qtdAtendimentosManha, dados[i].qtdAtendimentosTarde, dados[i].qtdAtendimentosNoite, dados[i].qtdAtendimentosTotais);
    //     body.push(row);
    //   }

    doc.autoTable({
        headStyles: { fillColor: [41, 128, 185], textColor: 255, fontStyle: 'bold' },
        startY: 20,
        head: [
            [
                {
                    content: "P\u{D3}RTICO - RELAT\u{D3}RIO ESTAT\u{CD}STICO CONSOLIDADO DE ATENDIMENTOS",
                    colSpan: 5,
                },
            ],
            [
                {
                    content: "Per\u{ED}odo",
                    colSpan: 1,
                },
                {
                    content: "N\u{FA}mero de atendimentos",
                    colSpan: 4,
                },
            ],
            [
                {
                    content: `01-11-2022 / 09-11-2022`,
                    colSpan: 1
                },
                {
                    content: 'M'
                },
                {
                    content: 'T'
                },
                {
                    content: 'N'
                },
                {
                    content: 'TOTAL'
                }
            ]
        ],
        // body: body,
        theme: 'grid',
    })
    doc.save('relatorio.pdf');
}

$scope.teste = () => {
    geraPdf();
}

$scope.buscaAtendimentos = async () => {
    const params = new Object();
    params.dtInicio = formataDataSQL($scope.data_inicio, true);
    params.dtFim = formataDataSQL($scope.data_fim, false);
    console.log(params);

    await $scope.buscaSecretarias();
    let data = await Tb_atendimentoRepository.infoRelatorio(params);
    const response = organizaAtendimentos(data);
    // return geraPdf(response);
};