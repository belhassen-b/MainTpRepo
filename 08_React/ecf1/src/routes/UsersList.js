import { useSelector } from "react-redux"


const UsersDisplayList =  ({userId}) => {
    const user = useSelector(state => state.users.users).find(f => f.id === userId)



    return (
        <div className="container">
            <div className="row">
                <div className="col-12">

                    {user.id}<br/>
                    {user.name}<br/>
                    {user.weight}Kg<br/>
                    {user.height}Cm <br/>
                    {user.age}ans

                </div>
            </div>
        </div>
    )
}
export default UsersDisplayList