
import React from "react";
import { Link } from "react-router-dom";
import "./Explore.css";
import axios from "axios";

function Explore() {
  return (
    <div className="explore-page">

      {/* Header */}
      <div className="explore-header">
        <h1>Explore Trips 🌍</h1>
        <p>Find your perfect trip and create unforgettable memories.</p>
      </div>

      {/* Search */}
      <div className="trip-search">
        <input
          type="text"
          placeholder="Search destination..."
        />

        <select>
          <option>Travel Type</option>
          <option>Solo</option>
          <option>Group</option>
          <option>Family</option>
          <option>Couple</option>
        </select>

        <button>Search</button>
      </div>

      {/* Trips */}
      <div className="trip-section">

        <div className="trip-card">
          <img
            src="https://images.unsplash.com/photo-1548013146-72479768bada?auto=format&fit=crop&w=800&q=80"
            alt="Manali"
          />

          <div className="trip-info">
            <h2>Manali Adventure</h2>
            <p>📍 Manali, Himachal Pradesh</p>
            <p>🏔️ Mountains • Adventure • Nature</p>

            <div className="trip-bottom">
              <span>₹8,999</span>
              <Link to="/trip-details/manali" className="view-button">
  View Details
</Link>
            </div>
          </div>
        </div>


        <div className="trip-card">
          <img
            src="https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?auto=format&fit=crop&w=800&q=80"
            alt="Goa"
          />

          <div className="trip-info">
            <h2>Goa Beach Escape</h2>
            <p>📍 Goa</p>
            <p>🏖️ Beaches • Sunsets • Relaxation</p>

            <div className="trip-bottom">
              <span>₹6,499</span>
             <Link to="/trip-details/goa" className="view-button">
  View Details
</Link>
            </div>
          </div>
        </div>


        <div className="trip-card">
          <img
            src="https://images.unsplash.com/photo-1477587458883-47145ed94245?auto=format&fit=crop&w=800&q=80"
            alt="Rajasthan"
          />

          <div className="trip-info">
            <h2>Royal Rajasthan</h2>
            <p>📍 Rajasthan</p>
            <p>🏰 Culture • Heritage • History</p>

            <div className="trip-bottom">
              <span>₹9,499</span>
              <Link to="/trip-details/rajasthan" className="view-button">
  View Details
</Link>
            </div>
          </div>
        </div>

      </div>

    </div>
  );
}

export default Explore;

