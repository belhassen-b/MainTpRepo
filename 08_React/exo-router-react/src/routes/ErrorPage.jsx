import { useRouteError } from "react-router-dom"

const ErrorPage = () => {
  const error = useRouteError() 
  return (
    <div className="d-flex flex-column justify-content-center align-items-center" style={{height: "100vh", width:"100vw"}}>
      <h1>Error {error.status}!</h1>
      <p>{error.data}</p>
    </div>
  )
}

export default ErrorPage