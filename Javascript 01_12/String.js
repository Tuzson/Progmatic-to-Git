function UppercaseFirstChar(word) {
    let wordclone = word.toString();
    let firstChar = wordclone[0];
    let anotherChars = wordclone.substring(1);
    firstChar = firstChar.toUpperCase();
    return firstChar + anotherChars;
}


console.log(UppercaseFirstChar('valami'));

function SpamCheck(word, deniedWords) {

    for (let i = 0; i < deniedWords.length; i++) {
        if ((word.indexOf(deniedWords[i])) !== -1) {
            return true;
        }
    }
    return false;
}

let deniedWords = ['rossz', 'jobb', 'tiltott', 'valami'];


console.log(SpamCheck('ez,az,még,de,valami', deniedWords));