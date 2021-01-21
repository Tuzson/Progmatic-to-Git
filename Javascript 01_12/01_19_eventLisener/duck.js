document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('money').addEventListener('click', function () {

        let random = Math.ceil(Math.random() * 1000 + 1);
        let moneyText = 'Mr. Scrooge McDuck got ' + random + '$';
        let messageText = document.createElement('p');
        messageText.innerText = moneyText;
        document.getElementById('message').appendChild(messageText);

    });

    document.getElementById('pic').addEventListener('click', function () {

        if (document.getElementsByTagName('img').length > 0) {
            document.getElementsByTagName('img')[0].remove();
        }
        let random = Math.round((Math.random() * 5) + 1);
        let pic = document.createElement('img');
        switch (random) {
            case 1:
                pic.setAttribute('src', 'https://d1e00ek4ebabms.cloudfront.net/production/6b7c5fa6-b824-4430-b544-2102ad555fd1.jpg');
                break;
            case 2:
                pic.setAttribute('src', 'https://blog.bestbuy.ca/wp-content/uploads/2020/06/Project-Cars-3-rain.jpg');
                break;
            case 3:
                pic.setAttribute('src', 'https://static01.nyt.com/images/2020/07/03/business/02wheels1-print/merlin_174089445_157a3e69-ad82-46dc-8991-c7b1f51d90d2-mobileMasterAt3x.jpg');
                break;
            case 4:
                pic.setAttribute('src', 'https://www.cars-on-line.com/images/1969%20Camaro%20Pro%20Street.jpg');
                break;
            case 5:
                pic.setAttribute('src', 'https://cdn.lifestyleasia.com/wp-content/uploads/sites/7/2019/07/29194350/FH2_Dodge_Charger_FFE-e1564481686306-1-1576x900.jpg');
                break;
        }
        pic.style.width = '300px';
        pic.style.height = '300px';
        let br = document.createElement('br');
        let x = document.getElementById('par');
        if (document.getElementsByTagName('br').length === 0) {
            document.getElementById('par').insertBefore(br, x.childNodes[0])
        }
        x.insertBefore(pic, x.childNodes[0]);

    });
});