import { useRouteError } from "react-router-dom"


const ContactPage = () => {
    const error = useRouteError()

    function handleSubmit(e) {
        e.preventDefault()
        const FormValues = {
            email: e.target[0].value,
            subject: e.target[1].value,
            message: e.target[2].value
        }
        console.log(FormValues)
    }

    return (
        <main className="container">
            <div className="row my-3">
                <div className="col-10 offset-1 bg-dark rounded text-light p-3">
                    <div className="justify-content between">
        <form onSubmit={
            handleSubmit
        }>
            <h4 className="bg bg-dark text-start  text-white m-2">Contact Me</h4><hr/>
            <div className="mb-3 text-start">
                <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
                <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </input>
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div className="mb-3 text-start">
                <label htmlFor="subject" className="form-label">Subject</label>
                <input type="text" className="form-control" id="subject">
                </input>
            </div>
            <div className="mb-3 text-start">
                <label htmlFor="message" className="form-label">Message</label>
                <textarea className="form-control" id="message" rows="5">
                </textarea>
            </div>
            <button type="submit" className="float-end btn btn-outline-light "><i className = "bi bi-send"></i>Send</button>
        </form>
                    </div>
                </div>
            </div>
        </main>
    )
}


export  default  ContactPage