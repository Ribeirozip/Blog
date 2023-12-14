const obj = new Date();

const objDate = {
    date: [obj.getFullYear(), obj.getUTCMonth() + 1, obj.getDate()].join('-'),
    time: [obj.getHours(), obj.getMinutes(), obj.getSeconds()].join(':')
}

fetch('http://localhost:8080/paginaInicial', {
    headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
    },
    method: 'POST',
    body: JSON.stringify({
        'titulo_Post': 'vee pelucia',
        'image_Post': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5IEIOxBunYz5lHlJhpZaoYmleEkAgtbL3JQ&usqp=CAU',
        'conteudo_Post': 'Deussss',
        'data_Post': objDate.date

    })})