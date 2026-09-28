import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../Services/api";
import "./Explore.css";

function Explore() {
  const [trips, setTrips] = useState([]);

  useEffect(() => {
    const fetchTrips = async () => {
      try {
        const response = await api.get("/trip/getAll");
        setTrips(response.data);
      } catch (error) {
        console.error("Error fetching trips:", error);
      }
    };

    fetchTrips();
  }, []);

  return (
    <div className="explore-page">

      <div className="explore-header">
        <h1>Explore Trips</h1>
        <p>Find the perfect trip for your next adventure</p>
      </div>

      <div className="explore-cards">

        {trips.map((trip) => (
          <div className="explore-card" key={trip.id}>

            <img
              src="https://images.unsplash.com/photo-1500534623283-312aade485b7?auto=format&fit=crop&w=800&q=80"
              alt={trip.destination}
            />

            <div className="explore-card-content">

              <h2>{trip.tripName}</h2>

              <p>📍 {trip.destination}</p>
              <p>🕒 {trip.duration}</p>
              <p>💰 ₹{trip.price}</p>
              <p>🎒 {trip.travelType}</p>

              <Link to={`/trip/${trip.id}`}>
                <button>View Details</button>
              </Link>

            </div>

          </div>
        ))}

      </div>

    </div>
  );
}

export default Explore;