import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../Services/api";
import "./MyBookings.css";

function MyBookings() {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    const fetchBookings = async () => {
      try {
        const response = await api.get("/booking/my");
        setBookings(response.data);
      } catch (error) {
        console.error("Error fetching bookings:", error);
      }
    };

    fetchBookings();
  }, []);

  const handleCancel = async (bookingId) => {
    try {
      await api.put(`/booking/cancel/${bookingId}`);

      alert("Booking cancelled successfully!");

      setBookings((previousBookings) =>
        previousBookings.map((booking) =>
          booking.id === bookingId
            ? { ...booking, bookingStatus: "CANCELLED" }
            : booking
        )
      );

    } catch (error) {
      console.error("Cancel booking error:", error);
      alert("Failed to cancel booking.");
    }
  };

  return (
    <div className="my-bookings">

      <h1>My Bookings</h1>

      {bookings.length === 0 ? (
        <p>You don't have any bookings yet.</p>
      ) : (
        <div className="booking-list">

          {bookings.map((booking) => (
            <div className="booking-card" key={booking.id}>

              <h2>{booking.trip?.tripName}</h2>

              <p>📍 {booking.trip?.destination}</p>

              <p>💰 ₹{booking.totalPrice}</p>

              <p>
                Status:
                <strong> {booking.bookingStatus}</strong>
              </p>

              <p>
                Booked on:{" "}
                {booking.createdAt
                  ? new Date(booking.createdAt).toLocaleDateString()
                  : "N/A"}
              </p>

              <button
                className="cancel-button"
                onClick={() => handleCancel(booking.id)}
                disabled={booking.bookingStatus === "CANCELLED"}
              >
                {booking.bookingStatus === "CANCELLED"
                  ? "Cancelled"
                  : "Cancel Booking"}
              </button>

              <Link to={`/review/${booking.trip?.id}`}>
                <button className="review-button">
                  Write Review
                </button>
              </Link>

            </div>
          ))}

        </div>
      )}

    </div>
  );
}

export default MyBookings;