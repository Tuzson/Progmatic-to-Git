
function getHunWeekday(date){
    let dateCopy = new Date(date);
    let hunDays = ['Hétfő','Kedd','Szerda','Csütörtök','Péntek','Szombat','Vasárnap'];
    return hunDays[dateCopy.getDay()]
}
console.log(getHunWeekday('2021-01-13'));

function getPrevDate(date,dayAgo){
    let dateCopy = new Date(date);

    return new Date(dateCopy.getFullYear(), dateCopy.getMonth(), dateCopy.getDate() - dayAgo);

}
console.log(getPrevDate('2021-01-13',56));
