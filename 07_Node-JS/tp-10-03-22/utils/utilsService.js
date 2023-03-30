import {readFileSync , writeFileSync} from "fs";


export function write(file, items){
    writeFileSync(file, JSON.stringify(items))
}

export function read(file) {
    return JSON.parse(readFileSync(file , "utf-8"));
}

//
// export function find(items, id){
//     return items.find(i => i.id == id);
// }
// export function show(items, id){
//     return items.find(i => i.id == id);
// }