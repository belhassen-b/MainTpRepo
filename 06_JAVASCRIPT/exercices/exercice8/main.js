// Declarations des vaiables
let mot, reverse,message;

mot = prompt("Veuillez saisir un mot : ");

reverse = mot.split('').reverse().join('');

console.log(reverse);

if(mot != reverse) {
    message="Ce mot n'est pas un palindrome";
}else {
    message="Ce mot est un palindrome";
}

alert(message);