import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../Services/api";
import "./TripDetails.css";

function TripDetails() {

  const { id } = useParams();
  const [trip, setTrip] = useState(null);

  useEffect(() => {
    const fetchTrip = async () => {
      try {
        const response = await api.get(`/trip/id/${id}`);

        console.log("Trip details:", response.data);

        setTrip(response.data);
      } catch (error) {
        console.error("Error fetching trip:", error);
      }
    };

    fetchTrip();
  }, [id]);

  if (!trip) {
    return <h2>Loading trip...</h2>;
  }
  const handleBooking = async () => {
  try {
    const response = await api.post(`/booking/${id}`);

    console.log("Booking:", response.data);

    alert("Trip booked successfully!");

  } catch (error) {
    console.error("Booking error:", error.response?.data || error);
    alert("Booking failed!");
  }
};

  return (
    <div className="trip-details-page">

      <div className="trip-details-card">

        <h1>{trip.tripName}</h1>

        <p className="destination">
          📍 {trip.destination}
        </p>

        <div className="trip-info">

          <p>
            <strong>Pickup:</strong> {trip.pickUp}
          </p>

          <p>
            <strong>Drop Location:</strong> {trip.dropLocation}
          </p>

          <p>
            <strong>Duration:</strong> {trip.duration}
          </p>

          <p>
            <strong>Travel Type:</strong> {trip.travelType}
          </p>

          <p>
            <strong>Available Seats:</strong> {trip.availableSit}
          </p>

          <p>
            <strong>Contact:</strong> {trip.contact}
          </p>

          <h2 className="price">
            ₹{trip.price}
          </h2>

        </div>

        <button
  className="book-button"
  onClick={handleBooking}
>
  Book This Trip
</button>

      </div>

    </div>
  );
}

export default TripDetails; 