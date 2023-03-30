import express from "express"
import { Data } from "./classes/data.js"
import LineByline from "n-readlines"




const data = new Data()

const app = express()

app.use(express.json())

app.get('/contacts',(req,res) => {
    const lineReader = new LineByline("data.csv")
    let lines = []
    let line = lineReader.next()
    while(line){
        lines.push(line.toString())
        line = lineReader.next()
    }
    res.json(lines)
})



app.get('/contacts/:id',(req,res) => {
    const contact = data.recupContact(req.params.id)
    if(contact != undefined) {
        // get contact from csv file by id
        res.json(contact)
    }else {
        res.json({message : "aucun contact avec cet id"})
    }
})

app.put('/contacts/:id',(req,res) => {
    const {nom, prenom, telephone,email} = req.body
    if(data.modifierContact(req.params.id,nom, prenom, telephone,email)) {
        res.json({message : "contact modifié"})
    }else {
        res.json({message : "erreur modification"})
    }

})

app.post('/contacts',(req,res) => {
    const {nom, prenom, telephone,email} = req.body
    data.ajouterContact(nom, prenom, telephone,email)
    res.json({message : "contact ajouté"})
})

app.delete('/contacts/:id',(req,res) => {
    if(data.supprimerContact(req.params.id)) {
        res.json({message : "contact supprimé"})
    }else {
        res.json({message : "erreur"})
    }
})

app.listen(5000, () => {
    data.lireContacts()
    console.log("go")
})
