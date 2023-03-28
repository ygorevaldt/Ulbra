let months = [
    {
        "month": "2001-07-02T00:00:00.000Z",
        "valor_pago_servidor": 1100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:34",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    },
    {
        "month": "2001-08-02T00:00:00.000Z",
        "valor_pago_servidor": 1100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:35",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    },
    {
        "month": "2001-09-02T00:00:00.000Z",
        "valor_pago_servidor": 1100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:36",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    },
    {
        "month": "2001-10-02T00:00:00.000Z",
        "valor_pago_servidor": 1100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:37",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    },
    {
        "month": "2001-11-01T23:00:00.000Z",
        "valor_pago_servidor": 100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:38",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    },
    {
        "month": "2001-12-01T23:00:00.000Z",
        "valor_pago_servidor": 100,
        "valor_pago_diferenca_servidor": 0,
        "valor_pago_patronal": 0,
        "valor_pago_diferenca_patronal": 0,
        "server_pension_percentage": 0.11,
        "employer_pension_percentage": 0,
        "$$hashKey": "object:39",
        "sal_contribuinte": 10000,
        "devido_servidor": 1100,
        "devido_patronal": 0
    }
]

function addValuesOnFields(array, params) {
    let { initialDate, finishDate } = params;
    initialDate.setHours(0, 0, 0, 0);
    finishDate.setHours(0, 0, 0, 0);

    const newArray = [...array];

    newArray.forEach((item) => {
        item.month = new Date(item.month);
        item.month.setHours(0, 0, 0, 0);
        item = completeMonthObject(params, item);
    })
    return newArray

}

function completeMonthObject(params, month) {
    const item = { ...month };
    const { value, initialDate, finishDate, popUp } = params

    if (item.month >= setDayOne(initialDate) && item.month <= setDayOne(finishDate) && popUp === 'pop-up-salaries') {
        item.sal_contribuinte = value;
    } else if (item.month >= setDayOne(initialDate) && item.month <= setDayOne(finishDate) && popUp === 'pop-up-pag-server') {
        item.valor_pago_servidor = value;
    } else if (item.month >= setDayOne(initialDate) && item.month <= setDayOne(finishDate) && popUp === 'pop-up-pag-employer') {
        item.valor_pago_patronal = value;
    }
    return item;
}

function setDayOne(date) {
    const newDate = date.setDate(1);
    return newDate;
}

const params = {
    value: 26,
    initialDate: new Date("2001-07-02"),
    finishDate: new Date("2001-12-02"),
    popUp: 'pop-up-salaries'
}

months = addValuesOnFields(months, params);
console.log(months);
