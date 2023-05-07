import { useRef } from "react"

export const SignForm = (props) => {
  const mode = props.mode

  const emailRef = useRef()
  const passwordRef = useRef()

  const submitFormHandler = (event) => {
    event.preventDefault()

    const email = emailRef.current.value
    const password = passwordRef.current.value

    const credentials = {
      email,
      password,
      returnSecureToken: true
    }

    emailRef.current.value = ""
    passwordRef.current.value = ""

    props.onSubmit(credentials)
  }

  return (
    <form onSubmit={submitFormHandler}>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">Email: </label>
        <input className="form-control" type="email" id="email" required ref={emailRef} />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">Password: </label>
        <input className="form-control" type="password" id="password" required ref={passwordRef} />
      </div>
      <div className="text-end">
        <button className={`btn btn-${mode === 'Sign In' ? 'primary' : 'secondary'}`}>{mode}</button>
      </div>
    </form>
  )
}

