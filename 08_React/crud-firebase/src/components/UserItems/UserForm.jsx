import {useRef} from "react"
export const UserForm = (props) => {

    const nameRef = useRef()
    const firstNameRef = useRef()
    const birthDateRef = useRef()
    const emailRef = useRef()
    const phoneRef = useRef()
    const imageRef = useRef()
    const ageRef = useRef()


    const addUser = (event) => {
        event.preventDefault()

        const name = nameRef.current.value
        const firstName = firstNameRef.current.value
        const birthDate = birthDateRef.current.value
        const email = emailRef.current.value
        const phone = phoneRef.current.value
        const image = imageRef.current.value
        const age = ageRef.current.value



        const newUser = {
            name ,
            firstName ,
            birthDate ,
            age ,
            email ,
            phone ,
            image ,
        }

        nameRef.current.value = ""
        firstNameRef.current.value = ""
        birthDateRef.current.value = ""
        emailRef.current.value = ""
        phoneRef.current.value = ""
        imageRef.current.value = ""
        ageRef.current.value = ""
        props.addUser(newUser)

    }


    const calculateAge = () => {
        const birthDate = birthDateRef.current.value
        const today = new Date()
        const birthDateDate = new Date(birthDate)
        let age = today.getFullYear() - birthDateDate.getFullYear()
        const m = today.getMonth() - birthDateDate.getMonth()
        if (m < 0 || (m === 0 && today.getDate() < birthDateDate.getDate())) {
            age--
        }
        ageRef.current.value = age
    }



    return (
        <>
            <h2>Ajouter un utilisateur</h2>
            <hr/>
            <form className= "bg bg-dark text-white  m-3 p-2" >
                <div className="form-group">
                    <label htmlFor="name">Nom</label>
                    <input type="text" className="form-control" id="name" ref={nameRef}/>
                </div>
                <div className="form-group">
                    <label htmlFor="firstName">Prénom</label>
                    <input type="text" className="form-control" id="firstName" ref={firstNameRef}/>
                </div>
                <div className="form-group">
                    <label htmlFor="birthDate">Date de naissance</label>
                    <input type="date" className="form-control" id="birthDate" ref={birthDateRef} onChange={calculateAge}/>
                </div>
                <div className="form-group">
                    <label htmlFor="age">Age</label>
                    <input type="number" className="form-control" id="age" ref={ageRef} disabled/>
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="text" className="form-control" id="email" ref={emailRef}/>
                </div>
                <div className="form-group">
                    <label htmlFor="phone">Téléphone</label>
                    <input type="text" className="form-control" id="phone" ref={phoneRef}/>
                </div>
                <div className="form-group  ">
                    <label htmlFor="image">Image Url </label>
                    <input type="url" className="form-control" id="image" ref={imageRef}/>
                </div>
                <button type="submit" className="btn btn-primary mt-3" onClick={addUser}>Ajouter</button>
            </form>
        </>
    )
}

