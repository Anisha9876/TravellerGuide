
import React from "react";
import { useParams, Link } from "react-router-dom";
import "./TripDetails.css";

function TripDetails() {

  const { destination } = useParams();

  const trips = {
    manali: {
      name: "Manali Adventure",
      location: "Manali, Himachal Pradesh",
      image:
        "https://images.unsplash.com/photo-1548013146-72479768bada?auto=format&fit=crop&w=1200&q=80",
      description:
        "Explore the beautiful mountains of Manali with adventure, nature and unforgettable experiences.",
      duration: "5 Days / 4 Nights",
      type: "Group",
      pickup: "Delhi",
      price: "₹8,999"
    },

    goa: {
      name: "Goa Beach Escape",
      location: "Goa",
      image:
        "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?auto=format&fit=crop&w=1200&q=80",
      description:
        "Enjoy beautiful beaches, amazing sunsets and a relaxing getaway in Goa.",
      duration: "4 Days / 3 Nights",
      type: "Group",
      pickup: "Bhubaneswar",
      price: "₹6,499"
    },

    rajasthan: {
      name: "Royal Rajasthan",
      location: "Rajasthan",
      image:
        "https://images.unsplash.com/photo-1477587458883-47145ed94245?auto=format&fit=crop&w=1200&q=80",
      description:
        "Experience the royal culture, magnificent forts and rich history of Rajasthan.",
      duration: "6 Days / 5 Nights",
      type: "Group",
      pickup: "Delhi",
      price: "₹9,499"
    }
  };

  const trip = trips[destination];

  if (!trip) {
    return <h1>Trip not found</h1>;
  }

  return (
    <div className="details-page">

      <Link to="/explore" className="back-link">
        ← Back to Explore
      </Link>

      <div className="details-card">

        <img src={trip.image} alt={trip.name} />

        <div className="details-content">

          <h1>{trip.name}</h1>

          <p className="location">
            📍 {trip.location}
          </p>

          <p>{trip.description}</p>

          <div className="trip-details">

            <div>
              <strong>Duration</strong>
              <span>{trip.duration}</span>
            </div>

            <div>
              <strong>Travel Type</strong>
              <span>{trip.type}</span>
            </div>

            <div>
              <strong>Pickup</strong>
              <span>{trip.pickup}</span>
            </div>

            <div>
              <strong>Price</strong>
              <span>{trip.price}</span>
            </div>

          </div>

          <button className="book-button">
            Book This Trip
          </button>

        </div>

      </div>

    </div>
  );
}

export default TripDetails;

