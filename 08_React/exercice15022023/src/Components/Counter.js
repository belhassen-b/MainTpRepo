import React , {useState , useEffect} from 'react';
import {Counter} from "./Counters";


export const MainComponent  = () => {
    const [count , setCount] = useState(0);

    const handleInput = () => {
        setCount(oldcount => oldcount + parseInt(startValue));

    }


    return (
        <>
            {/*<div className="container">*/}
            {/*    */}
            {/*</div>*/}
            <div className="container mx-auto w-50">
                <form className="bg-dark text-white ">
                    <h1>MainComponent</h1>
                    <hr/>
                        <h6 className="text-start">Start Value: </h6>
                        <input className=" form-control w-75 mb-2 ms-2 me-2" type={"number"} name={"inputValues"}
                               onChange={e => SetStartValue(e.target.value)}/>
                        <button className=" btn btn-outline-light" type={"button"}
                                onClick={() => handleInput()}>Add a Counter
                        </button>

                    <div>
                        <h5 className="float-start m-2">Counters</h5>
                        <hr/>
                        <span className="float-start ms-5 w-25 border border-2 border-light">{count}</span>
                        <button type="button" className="mb-2 btn btn-danger">Delete</button>
                    </div>
                    </form>
            </div>
        </>
    );
}
