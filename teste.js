angular.module('lowcode', []).controller('mycontroller', function ($scope, $filter, $http, $sce) {
    $scope.onInit = function () {
        $.getJSON("./data/data.json", function (json) {
            $scope.iprev = json;
            $scope.dataByComparative = {
                processo_sei: "14/147-56",
                nome_servidor: "Lucas",
                orgao: "Secretaria de estado de justi\u{E7}a e cidadania do distrito federal",
                cargo: "Assistente social",
                num_matricula: "123456",
                data_calculo: new Date(),
                periodo_inicial: new Date("2001-07-02"),
                periodo_final: new Date("2001-12-31"),
            }
            function formatDateToGetSelic(date) {
                let day = date.getDate();
                let month = date.getMonth() + 1;
                const year = date.getFullYear();

                if (day <= 9) {
                    day = `0${day}`;
                }
                if (month <= 9) {
                    month = `0${month}`;
                }

                const newDate = [day, month, year].join('/');
                return newDate;
            }

            const initialDate = formatDateToGetSelic($scope.dataByComparative.periodo_inicial);
            const finalyDate = formatDateToGetSelic(new Date());

            $http({
                method: 'GET',
                url: `https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json&dataInicial=${initialDate}&dataFinal=${finalyDate}`
            }).then(function successCallback(response) {
                if (response.data) {
                    $scope.selic = response.data;
                }

                $scope.law394server = {
                    name: "lei_394",
                    type: "server",
                    initial_range: new Date("2001-07-01"),
                    final_range: new Date("2001-12-30"),
                    daily_selic: false,
                    month_selic: false,
                    observations: "INPC retirado do site do IBGE ",
                    observations_selic: "SELIC retirada do site do Banco Central ",
                    description: "Art. 1º Os valores expressos em moeda corrente na legislação do Distrito Federal, bem como os relativos a multas e acréscimos de qualquer natureza que, de acordo com a legislação vigente, seriam atualizados pela Unidade de Referência Fiscal – UFIR, deverão ser atualizados anualmente pelo Índice Nacional de Preços as Consumidor – INPC, apurado pelo Instituto Brasileiro de Geografia e Estatística – IBGE – ou, na sua ausência, por outro índice de preços de caráter nacional, que reflita a variação de preços ao consumidor, a ser divulgado em ato do Secretário de Fazenda e Planejamento Parágrafo único. A atualização a que se refere o caput será efetivada no primeiro dia útil do mês de março, de cada ano, considerando o índice acumulado referente ao período do mês de janeiro do ano anterior ao mesmo mês do ano corrente. Art.2º Sobre os débitos tributários pagos com o atraso acrescidos os juros moratórios equivalentes à taxa referencial do sistema Especial de Liquidação e Custódia – SELIC, nos termos da Lei Complementar nº 12, de 22 de julho de 1996, não se aplicando nenhum indexador.",
                    delay: "O início do atraso é considerado a partir do do 5º dia útil do mês subsequente à referência.",
                    reference: "INPC e Selic",
                }

                const laws = [
                    {
                        name: "lei_12",
                        type: "server",
                        initial_range: new Date("1996-07-01"),
                        final_range: new Date("2001-06-30"),
                        daily_selic: false,
                        month_selic: true,
                        observations: `Observações: SELIC retirada do site do Banco Central `,
                        title: "LEI COMPLEMENTAR Nº 12, DE 22 DE JULHO DE 1996",
                        description: `"Art. 1º - Os tributos arrecadados pelo Distrito Federal cujos fatos geradores vierem a ocorrer a partir da data de vigência desta Lei Complementar e que não forem pagos nos prazos estabelecidos, sem prejuízo da incidência de multas previstas na legislação tributária do Distrito Federal, serão acrescidos de juros de mora equivalentes à taxa referencial do Sistema Especial de Liquidação e Custódia - SELIC para títulos federais, acumulada mensalmente.
                        § 1º - Os juros de mora incidirão a partir do primeiro dia do mês subseqüente ao do vencimento.
                        § 2º - O percentual dos juros de mora relativo ao mês em que o pagamento estiver sendo efetuado será de 1 % (um por cento) ao mês."
                        `,
                        delay: "O início do atraso é considerado a partir do do 5º dia útil do mês subsequente à referência.",
                        reference: "Selic",
                        formatDateToCompareWithDateSelic(date) {
                            let day = date.getDate();
                            let month = date.getMonth() + 1;
                            const year = date.getFullYear();

                            if (day <= 9) {
                                day = `0${day}`;
                            }
                            if (month <= 9) {
                                month = `0${month}`;
                            }

                            const newDate = [day, month, year].join('/');
                            return newDate;
                        },
                        getValueSelic: function (params) {
                            const objParams = { ...params }
                            let { date, selicArray } = objParams;

                            let objDate = new Date(date);
                            const newDate = this.formatDateToCompareWithDateSelic(objDate);
                            const selic = $scope.selic.find(item => item.data === newDate);

                            return parseFloat(selic.valor);
                        },
                        handleStartDelay: function (handledDate) {
                            const date = new Date(handledDate);
                            return new Date(date.getFullYear(), date.getMonth() + 2, 0);
                        },
                        handleServerContribution: function (payed, debit) {
                            const payedValue = payed;
                            const debitValue = debit;
                            const serverContribution = payedValue - debitValue;

                            return serverContribution;
                        },
                        handleCorrectedContributionAmount: function (params) {
                            const objParams = { ...params }
                            const { date, selicArray, payed, debit } = objParams;

                            const valueSelic = this.getValueSelic({ date: date, selicArray: selicArray });
                            const serverContribution = payed - debit;
                            const correctedContributionAmount = serverContribution * valueSelic;

                            return correctedContributionAmount;
                        },
                        handleQntMonthsDelay: function (params) {
                            let { start, monthComparacion } = params;
                            const handleStart = new Date(start);
                            const handleInitialMonth = new Date(monthComparacion);

                            const monthsInOneYear = 12;
                            const startMonth = handleStart.getMonth();
                            const startYear = handleStart.getFullYear();

                            const endMonth = handleInitialMonth.getMonth();
                            const endYear = handleInitialMonth.getFullYear();

                            let qntMonths = (endYear - startYear) * monthsInOneYear + (endMonth - startMonth);
                            if (qntMonths < 0) {
                                qntMonths = Math.abs(qntMonths);
                            }

                            return qntMonths;
                        },
                        handleDefaultInterest: function (paramsCorrectedContribution, paramsqntDelayMonths) {
                            const correctedContributionAmount = this.handleCorrectedContributionAmount(paramsCorrectedContribution);
                            const qntDelayMonths = this.handleQntMonthsDelay(paramsqntDelayMonths);
                            const discountPercentage = 0.01

                            let defaultInterest = parseFloat(((correctedContributionAmount * discountPercentage) * qntDelayMonths).toFixed(2));
                            return defaultInterest
                        },
                        handlePenaltValue: function (params) {
                            const correctedServerContribution = this.handleCorrectedContributionAmount(params);
                            const penaltyPercentage = 0.1;

                            const penaltyValue = parseFloat((correctedServerContribution * penaltyPercentage).toFixed(2));
                            return penaltyValue;
                        },
                        handleTotalToBeCollected: function (paramsCorrectedContribution, paramsqntDelayMonths) {
                            const correctedContributionAmount = this.handleCorrectedContributionAmount(paramsCorrectedContribution);
                            const defaultInterest = this.handleDefaultInterest(paramsCorrectedContribution, paramsqntDelayMonths);
                            const penaltyValue = this.handlePenaltValue(paramsCorrectedContribution);

                            return correctedContributionAmount + defaultInterest + penaltyValue;
                        }
                    },
                    {
                        name: "lei_394",
                        type: "server",
                        initial_range: new Date("2001-07-01"),
                        final_range: new Date("2001-12-30"),
                        daily_selic: false,
                        month_selic: false,
                        observations: "INPC retirado do site do IBGE ",
                        observations_selic: "SELIC retirada do site do Banco Central ",
                        description: "Art. 1º Os valores expressos em moeda corrente na legislação do Distrito Federal, bem como os relativos a multas e acréscimos de qualquer natureza que, de acordo com a legislação vigente, seriam atualizados pela Unidade de Referência Fiscal – UFIR, deverão ser atualizados anualmente pelo Índice Nacional de Preços as Consumidor – INPC, apurado pelo Instituto Brasileiro de Geografia e Estatística – IBGE – ou, na sua ausência, por outro índice de preços de caráter nacional, que reflita a variação de preços ao consumidor, a ser divulgado em ato do Secretário de Fazenda e Planejamento Parágrafo único. A atualização a que se refere o caput será efetivada no primeiro dia útil do mês de março, de cada ano, considerando o índice acumulado referente ao período do mês de janeiro do ano anterior ao mesmo mês do ano corrente. Art.2º Sobre os débitos tributários pagos com o atraso acrescidos os juros moratórios equivalentes à taxa referencial do sistema Especial de Liquidação e Custódia – SELIC, nos termos da Lei Complementar nº 12, de 22 de julho de 1996, não se aplicando nenhum indexador.",
                        delay: "O início do atraso é considerado a partir do do 5º dia útil do mês subsequente à referência.",
                        reference: "INPC e Selic",
                        formatDateToCompareWithDateSelic(date) {
                            let day = "1";
                            let month = date.getMonth() + 1;
                            const year = date.getFullYear();

                            if (day <= 9) {
                                day = `0${day}`;
                            }
                            if (month <= 9) {
                                month = `0${month}`;
                            }

                            const newDate = [day, month, year].join('/');
                            return newDate;
                        },
                        handleStartDelay: function (handledDate) {
                            const date = new Date(handledDate);
                            return new Date(date.getFullYear(), date.getMonth() + 2, 0);
                        },
                        handleServerContribution: function (payed, debit) {
                            const payedValue = payed;
                            const debitValue = debit;
                            const serverContribution = payedValue - debitValue;

                            return serverContribution;
                        },
                        handleCorrectedContributionAmount: function (params) {
                            /*
                                O sistema irá multiplicar a Contribuição Servidor pelo INPC.
                                Referência: Planilha Fabio Felix Silveira Simulado – Aba Servidor (394).
                            */
                            const { date, payed, debit } = params;
                            const inpc = 0; //???
                            const serverContribution = payed - debit;

                            const correctedContributionAmount = serverContribution * inpc;
                            return correctedContributionAmount;
                        },
                        handleInpcValue: function (params) {
                            const { date, payed, debit } = params;

                            const correctedContributionAmount = this.handleCorrectedContributionAmount(params); //params ??
                            const serverContribution = this.handleServerContribution(payed, debit);

                            const inpcValue = correctedContributionAmount - serverContribution;
                            return inpcValue;
                        },
                        getValueSelic: function (params) {
                            //valor (selic / 100 + 1)
                            let { date, selicArray } = params;
                            const objDate = new Date(date);

                            const atualMonthDate = this.formatDateToCompareWithDateSelic(objDate);
                            let atualMonthSelic = $scope.selic.find(item => item.data === atualMonthDate);
                            atualMonthSelic = (atualMonthSelic / 100) + 1;

                            let subsequentMonth = new Date(this.handleStartDelay(date));
                            subsequentMonth = this.formatDateToCompareWithDateSelic(subsequentMonth);
                            let subsequentMonthSelic = $scope.selic.find(item => item.data === subsequentMonth);
                            subsequentMonthSelic = (subsequentMonthSelic / 100) + 1;

                            let selicValue = (atualMonthSelic * subsequentMonthSelic).toFixed(2);
                            console.log(selicValue);

                            return parseFloat(selicValue);
                        },
                        handleDefaultInterest: function (params) {
                            const correctedContributionAmount = this.handleCorrectedContributionAmount(params);
                            const selicValue = this.getValueSelic(params);
                            const resultDiscount = 1.00;
                            let defaultInterest = parseFloat(((correctedContributionAmount * selicValue) - resultDiscount).toFixed(2));
                            return defaultInterest
                        },
                        handlePenaltValue: function (params) {
                            const correctedServerContribution = this.handleCorrectedContributionAmount(params);
                            const penaltyPercentage = 0.10;

                            const penaltyValue = parseFloat((correctedServerContribution * penaltyPercentage).toFixed(2));
                            return penaltyValue;
                        },
                        handleTotalToBeCollected: function (params) {
                            const correctedContributionAmount = this.handleCorrectedContributionAmount(params);
                            const defaultInterest = this.handleDefaultInterest(params);
                            const penaltyValue = this.handlePenaltValue(params);

                            let totalToBeCollected = (correctedContributionAmount + defaultInterest + penaltyValue).toFixed(2);
                            return parseFloat(totalToBeCollected);
                        }
                    },
                    {
                        name: "lei_435",
                        type: "server",
                        initial_range: new Date("2002-01-01"),
                        final_range: new Date("2008-06-01"),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },
                    {
                        name: "lei_769",
                        type: "server",
                        initial_range: new Date("2008-07-01"),
                        final_range: new Date("2017-09-01"),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },
                    {
                        name: "lei_932",
                        type: "server",
                        initial_range: new Date("2017-10-01"),
                        final_range: new Date(),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },
                    {
                        name: "lei_435",
                        type: "employer",
                        initial_range: new Date("01-01-2002"),
                        final_range: new Date("01-06-2008"),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },
                    {
                        name: "lei_769",
                        type: "employer",
                        initial_range: new Date("01-07-2008"),
                        final_range: new Date("01-09-2017"),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },
                    {
                        name: "Lei 932",
                        type: "employer",
                        initial_range: new Date("01-10-2017"),
                        final_range: new Date(),
                        daily_selic: false,
                        month_selic: false,
                        calculation: () => {

                        }
                    },

                ];

                const selicArray = [...$scope.selic]; // Armazena o array selic em uma variável local
                const newArray = [];
                $scope.iprev.forEach((currentValue) => {
                    let correspondingLaw = laws.find((value) => (new Date(currentValue.month) >= value.initial_range) && (new Date(currentValue.month) <= value.final_range));

                    const params = {
                        payed: currentValue.valor_pago_servidor,
                        debit: currentValue.devido_servidor,
                        date: currentValue.month
                    }

                    const paramsToGetSelicValue = {
                        date: currentValue.month,
                        selicArray: selicArray
                    }

                    if (correspondingLaw) {
                        if (correspondingLaw.name === "lei_12" && correspondingLaw.type === "server") {
                            console.log(correspondingLaw.name);

                            const paramsToQntMonthsDelay = {
                                start: correspondingLaw.final_range,
                                monthComparacion: currentValue.month
                            }
                            newArray.push({
                                ...currentValue,
                                law: correspondingLaw,
                                startDelay: correspondingLaw.handleStartDelay(currentValue.month),
                                selic: correspondingLaw.getValueSelic({
                                    date: currentValue.month,
                                    selicArray: selicArray
                                }), // Usa a variável local em vez da global
                                qntMonthsDelay: correspondingLaw.handleQntMonthsDelay({
                                    start: correspondingLaw.final_range,
                                    monthComparacion: currentValue.month
                                }),
                                serverContribution: correspondingLaw.handleServerContribution(currentValue.valor_pago_servidor, currentValue.devido_servidor),
                                correctedContributionAmount: correspondingLaw.handleCorrectedContributionAmount(params),
                                defaultInterest: correspondingLaw.handleDefaultInterest(
                                    params,
                                    {
                                        start: correspondingLaw.initial_range,
                                        stop: correspondingLaw.final_range,
                                        monthComparacion: currentValue.month
                                    }
                                ),
                                penaltyValue: correspondingLaw.handlePenaltValue(params),
                                totalToBeCollected: correspondingLaw.handleTotalToBeCollected(
                                    params,
                                    {
                                        start: correspondingLaw.initial_range,
                                        stop: correspondingLaw.final_range,
                                        monthComparacion: currentValue.month
                                    }
                                )
                            })
                        }
                        if (correspondingLaw.name === "lei_394" && correspondingLaw.type === "server") {
                            const paramsPlusSelicArray = {
                                payed: currentValue.valor_pago_servidor,
                                debit: currentValue.devido_servidor,
                                date: currentValue.month,
                                selicArray: selicArray
                            }

                            newArray.push({
                                ...currentValue,
                                law: correspondingLaw,
                                startDelay: correspondingLaw.handleStartDelay(currentValue.month),
                                serverContribution: correspondingLaw.handleServerContribution(currentValue.valor_pago_servidor, currentValue.devido_servidor),
                                correctedContributionAmount: correspondingLaw.handleCorrectedContributionAmount(params),
                                inpcValue: correspondingLaw.handleInpcValue(params),
                                selic: correspondingLaw.getValueSelic(paramsToGetSelicValue),
                                defaultInterest: correspondingLaw.handleDefaultInterest(paramsPlusSelicArray),
                                penaltyValue: correspondingLaw.handlePenaltValue(params),
                                totalToBeCollected: correspondingLaw.handleTotalToBeCollected(params)
                            })
                        }
                    }
                });


                $scope.array = newArray;
                // console.log($scope.array);
                $scope.totalValue = $scope.array.reduce((accumulator, currentValue) => {
                    return parseFloat((accumulator += currentValue.totalToBeCollected).toFixed(2));
                }, 0);
            });
        });
    }
});
