
import React, { useState } from 'react';


const FizzBuzz: React.FC = () => {
    ;
    const [count, setCount] = useState<number>(0);



    const handleButtonClickPlus = () => {
        setCount(count + 1);
    };
    const handleButtonClickLess = () => {
        setCount(count - 1);
    };

    const isFizzBuzz = (num: number) => {
        if (num % 15 === 0 && num !== 0) {
            return 'FizzBuzz';
        } else if (num % 3 === 0) {
            return 'Fizz';
        } else if (num % 5 === 0) {
            return 'Buzz';
        } else {
            return num.toString();
        }
    };

    return (
        <>
        <div className="container position-relative mx-auto rounded-circle bg bg-primary w-50 h-50">
            <div className ="position-absolute mt-3 text-center">{isFizzBuzz(count)}</div>
        </div>
        <div className="text-center">
            <button onClick={handleButtonClickLess} className="position-absolute bg bg-primary  opacity-50 text-white  rounded-circle">-</button>
            <button onClick={handleButtonClickPlus} className="position-absolute bg bg-primary  opacity-50 text-white  rounded-circle">+</button>
        </div>

        </>
    );
};

export default FizzBuzz;