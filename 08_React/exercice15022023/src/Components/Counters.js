import {useEffect , useState} from "react";

export const Counter = () => {
    const [startValue , SetStartValue] = useState("0");



    useEffect(() => {
        console.log("useEffect");
        const myInterval =  setInterval(() => setCount((oldcount) => oldcount + 1) , 1000);
        return () => clearInterval(myInterval);
    },[]);
    return (
        <>
            <div className="my-2 d-flex justify-content-between align-items-center border border-info rounded p-2 px-4">
                <p className="w-100 text-center display-6">{count}</p>
                <button className="btn btn-danger" >Delete</button>
            </div>
        </>
    );
}
