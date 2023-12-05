import React, { useEffect, useState } from "react";
import welcomeCar from "../assets/welcome-car.jpg";
import redCar from "../assets/car-placeholder-red.jpeg";
import { WELCOME, VIEW_CARS} from "./PageNumbers.js";
import "./Pages.css";
import { InfoCell } from "./Pages";


export function WelcomePage({ page }) {
  const pageClass = page === WELCOME ? "" : "Hidden";

  return (
    <div className={pageClass}>
      <div className="Welcome Page">
        Welcome!
				<img className="center" src={welcomeCar} alt="Clipart of a red sports car with a teal background" />
      </div>
    </div>
  )
}

export function ViewCars({ page }) {
  const pageClass = page === VIEW_CARS ? "" : "Hidden";
  const [carList, setCarList] = useState([]);

	// only causes a CORS error when testing locally
  useEffect(() => {
    const getMsg = async () => {
      const data = await fetch("https://www.afkauto.com/api/cars", {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

			const msgJson = await data.json();
      setCarList(msgJson);
    }
    getMsg();
  }, []);

  const results = [];

  if (carList.length > 0) {
    for (const car of carList) {
      results.push(
        <div>
          <div className="CarPic">
            <img src={redCar} alt="A red 2020 Honda Accord" />
          </div>
          <div className="Car Card">
            <b>{`${car.carYear} ${car.manufacturer} ${car.model}`}</b>
            <InfoCell header={"VIN:"} value={`${car.vin}`} />
            <InfoCell header={"Status:"} value={`${car.status}`} />
            <InfoCell header={"Mileage:"} value={`${car.mileage}`} />
            <InfoCell header={"Price:"} value={`${car.price}`} />
            <InfoCell header={"Color:"} value={`${car.color}`} />
            <InfoCell header={"Trim:"} value={`${car.trim}`} />
          </div>
        </div>
      );
    }
  } else {
    results.push(<p>"No cars found!"</p>);
  }

  return (
    <div className={pageClass}>
      {results}
    </div>
  );
}
