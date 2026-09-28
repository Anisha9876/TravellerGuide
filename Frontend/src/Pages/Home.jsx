import "./Home.css";
import { Link } from "react-router-dom";
function Home() {
  return (
    <div className="home">

      <nav className="navbar">
  <h2 className="logo">✈ TravellerGuide</h2>

  <div className="nav-links">
    <Link to="/">Home</Link>
<Link to="/explore">Explore Trips</Link>
<Link to="/news">News</Link>
<Link to="/login">Login</Link>
    <Link to="/register" className="register-btn">Register</Link>
  </div>
</nav>

      <section className="hero">
        <div className="hero-content">
          <p className="small-title">EXPLORE • TRAVEL • EXPERIENCE</p>

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

      <section className="popular">
  <h2>Popular Destinations</h2>
  <p>Explore some amazing places</p>

  <div className="cards">

    <div className="card">
      <img
        src="https://images.unsplash.com/photo-1548013146-72479768bada?auto=format&fit=crop&w=800&q=80"
        alt="Manali"
      />
      <div className="card-content">
        <h3>Manali</h3>
        <p>Mountains • Adventure • Nature</p>
        <button>Explore Trip</button>
      </div>
    </div>

    <div className="card">
      <img
        src="https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?auto=format&fit=crop&w=800&q=80"
        alt="Goa"
      />
      <div className="card-content">
        <h3>Goa</h3>
        <p>Beaches • Sunsets • Relaxation</p>
        <button>Explore Trip</button>
      </div>
    </div>

    <div className="card">
      <img
        src="https://images.unsplash.com/photo-1477587458883-47145ed94245?auto=format&fit=crop&w=800&q=80"
        alt="Rajasthan"
      />
      <div className="card-content">
        <h3>Rajasthan</h3>
        <p>Culture • Heritage • History</p>
        <button>Explore Trip</button>
      </div>
    </div>

  </div>
</section>
    </div>
  );
}

export default Home;