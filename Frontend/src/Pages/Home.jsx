import "./Home.css";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../Services/api";

function Home() {

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
    <div className="home">

      {/* Navbar */}
      <nav className="navbar">
        <h2 className="logo">✈ TravellerGuide</h2>

        <div className="nav-links">
          <Link to="/">Home</Link>
          <Link to="/explore">Explore Trips</Link>
          <Link to="/news">News</Link>
          <Link to="/my-bookings">My Bookings</Link>
          <Link to="/login">Login</Link>
          <Link to="/register" className="register-btn">
            Register
          </Link>
        </div>
      </nav>


      {/* Hero Section */}
      <section className="hero">
        <div className="hero-content">

          <p className="small-title">
            EXPLORE • TRAVEL • EXPERIENCE
          </p>

          <h1>
            Discover Your
            <span> Next Adventure</span>
          </h1>

          <p className="hero-text">
            Find amazing destinations, exciting trips and unforgettable
            experiences with TravellerGuide.
          </p>

          <div className="search-box">
            <input
              type="text"
              placeholder="Where do you want to go?"
            />
            <button>Search</button>
          </div>

        </div>
      </section>


      {/* Trips Section */}
      <section className="popular">

        <h2>Popular Trips</h2>

        <p>
          Explore amazing trips available on TravellerGuide
        </p>


        <div className="cards">

          {trips.length === 0 ? (

            <p>No trips available right now.</p>

          ) : (

            trips.map((trip) => (

              <div className="card" key={trip.id}>

                <img
                  src="https://images.unsplash.com/photo-1500534623283-312aade485b7?auto=format&fit=crop&w=800&q=80"
                  alt={trip.destination}
                />

                <div className="card-content">

                  <h3>{trip.tripName}</h3>

                  <p>
                    📍 {trip.destination}
                  </p>

                  <p>
                    🕒 {trip.duration}
                  </p>

                  <p>
                    💰 ₹{trip.price}
                  </p>

                  <p>
                    🎒 {trip.travelType}
                  </p>

                  <Link to={`/trip/${trip.id}`}>
  <button>Explore Trip</button>
</Link>

                </div>

              </div>

            ))

          )}

        </div>

      </section>


      {/* News Section */}
      <section className="news-section">

        <h2>Latest Travel News</h2>

        <p>
          Stay updated before you travel
        </p>

        <div className="news-cards">

          <div className="news-card">

            <h3>Top Places to Visit</h3>

            <p>
              Discover the latest travel updates and attractions.
            </p>

            <button>
              Read More
            </button>

          </div>


          <div className="news-card">

            <h3>Travel Updates</h3>

            <p>
              Know what's happening before planning your trip.
            </p>

            <button>
              Read More
            </button>

          </div>


          <div className="news-card">

            <h3>Explore Odisha</h3>

            <p>
              Discover new places and travel experiences.
            </p>

            <button>
              Read More
            </button>

          </div>

        </div>

      </section>


      {/* Footer */}
      <footer className="footer">

        <div>
          <h2>✈ TravellerGuide</h2>

          <p>
            Discover places. Plan trips. Create memories.
          </p>
        </div>


        <div className="footer-links">

          <Link to="/">Home</Link>

          <Link to="/explore">Trips</Link>

          <Link to="/news">News</Link>

          <Link to="/login">Login</Link>

        </div>


        <p className="copyright">
          © 2026 TravellerGuide. All rights reserved.
        </p>

      </footer>

    </div>
  );
}

export default Home;